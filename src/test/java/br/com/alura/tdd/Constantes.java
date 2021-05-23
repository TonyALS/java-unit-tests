package br.com.alura.tdd;

import java.math.BigDecimal;

public interface Constantes {
    BigDecimal SALARIO_ONZE_MIL_REAIS = new BigDecimal("11000");
    BigDecimal SALARIO_MIL_REAIS = new BigDecimal("1000");
    BigDecimal SALARIO_DEZ_MIL_REAIS = new BigDecimal("10000");
    BigDecimal PORCENTAGEM_DO_BONUS = new BigDecimal("0.1");
    String BONUS_NAO_PERMITIDO_EXCEPTION = "Bonus superiores a mil reais não são permitidos";
}
