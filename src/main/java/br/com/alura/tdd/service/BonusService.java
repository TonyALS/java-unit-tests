package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.exceptions.NaoElegivelParaBonusException;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	private static final String BONUS_NAO_PERMITIDO_EXCEPTION = "Bonus superiores a mil reais não são permitidos";

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new NaoElegivelParaBonusException(BONUS_NAO_PERMITIDO_EXCEPTION);
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}
