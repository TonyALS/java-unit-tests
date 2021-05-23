package br.com.alura.tdd.service;

import br.com.alura.tdd.exceptions.NaoElegivelParaBonusException;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.time.LocalDate;

import static br.com.alura.tdd.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private final BonusService bonusService = new BonusService();

    @Test
    @DisplayName("Deve retornar BONUS_NAO_PERMITIDO_EXCEPTION se o valor do bonus for acima de 1000")
    void deveRetornarExceptionCasoValorCalculadoSupereMilReais() {
        //  Given
        var funcionario = new Funcionario("Any name",
                LocalDate.of(2021, 1, 1), SALARIO_ONZE_MIL_REAIS);

        //  When / Then
        var exception = assertThrows(NaoElegivelParaBonusException.class,
                () -> bonusService.calcularBonus(funcionario));
        assertEquals(BONUS_NAO_PERMITIDO_EXCEPTION, exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar o valor do bonus caso seja abaixo de 1000")
    void deveRetornarValorBonusCasoSejaInferiorAMilReais() {
        //  Given
        var funcionario = new Funcionario("Any name",
                LocalDate.of(2021, 1, 1), SALARIO_MIL_REAIS);

        //  When
        var valorRetornado = bonusService.calcularBonus(funcionario);

        //  Then
        assertEquals(SALARIO_MIL_REAIS.multiply(PORCENTAGEM_DO_BONUS)
                .setScale(2, RoundingMode.HALF_UP), valorRetornado);
    }

    @Test
    @DisplayName("Deve retornar o valor do bonus caso seja igual a 1000")
    void deveRetornarValorBonusCasoSejaIgualAMilReais() {
        //  Given
        var funcionario = new Funcionario("Any name",
                LocalDate.of(2021, 1, 1), SALARIO_DEZ_MIL_REAIS);

        //  When
        var valorRetornado = bonusService.calcularBonus(funcionario);

        //  Then
        assertEquals(SALARIO_DEZ_MIL_REAIS.multiply(PORCENTAGEM_DO_BONUS)
                        .setScale(2, RoundingMode.HALF_UP), valorRetornado);
    }
}
