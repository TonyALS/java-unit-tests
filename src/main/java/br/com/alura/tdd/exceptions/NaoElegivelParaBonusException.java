package br.com.alura.tdd.exceptions;

public class NaoElegivelParaBonusException extends RuntimeException {
    public NaoElegivelParaBonusException(String message) {
        super(message);
    }
}
