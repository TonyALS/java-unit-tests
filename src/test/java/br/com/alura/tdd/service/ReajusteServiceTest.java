package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoFuncionario;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.alura.tdd.Constantes.SALARIO_MIL_REAIS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private final ReajusteService reajusteService = new ReajusteService();

    //  Given
    private final Funcionario funcionario = new Funcionario("Any name",
            LocalDate.of(2021, 1, 1), SALARIO_MIL_REAIS);

    @Test
    @DisplayName("Deve retornar 1030 quando salario é 1000 e desempenho é A DESEJAR")
    void garanteQueDesempenhoADesejarTenhaTresPorCentoReajuste() {
        //  When
        reajusteService.calcularReajuste(DesempenhoFuncionario.A_DESEJAR, funcionario);

        //  Then
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Deve retornar 1150 quando salario é 1000 e desempenho é BOM")
    void garanteQueDesempenhoBomTenhaQuinzePorCentoReajuste() {
        //  When
        reajusteService.calcularReajuste(DesempenhoFuncionario.BOM, funcionario);

        //  Then
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Deve retornar 1200 quando salario é 1000 e desempenho é OTIMO")
    void garanteQueDesempenhoOtimoTenhaVintePorCentoReajuste() {
        //  When
        reajusteService.calcularReajuste(DesempenhoFuncionario.OTIMO, funcionario);

        //  Then
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
