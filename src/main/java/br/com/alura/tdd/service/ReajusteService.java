package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoFuncionario;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	public void calcularReajuste(DesempenhoFuncionario desempenhoFuncionario, Funcionario funcionario) {

		var valorReajuste = funcionario.getSalario()
				.multiply(desempenhoFuncionario.getPorcentagemReajuste());

		funcionario.reajustarSalario(valorReajuste);
	}
}
