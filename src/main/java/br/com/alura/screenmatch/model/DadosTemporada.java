package br.com.alura.screenmatch.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//para ignorar tudo que não estiver mapeado pois ele temta mapear todos
@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosTemporada(@JsonAlias("Season") Integer numero ,
                             @JsonAlias("Episodes")  List<DadosEpisodio> episodios) {
}
