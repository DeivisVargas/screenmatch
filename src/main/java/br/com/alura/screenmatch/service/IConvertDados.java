package br.com.alura.screenmatch.service;

public interface IConvertDados {

    //define um tipo de retorno genérico
    <T> T obterDados(String json , Class<T> classe);
}
