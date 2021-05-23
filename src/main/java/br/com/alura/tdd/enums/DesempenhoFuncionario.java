package br.com.alura.tdd.enums;

import java.math.BigDecimal;

public enum DesempenhoFuncionario {
    A_DESEJAR {
        @Override
        public BigDecimal getPorcentagemReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal getPorcentagemReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal getPorcentagemReajuste() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal getPorcentagemReajuste();
}
