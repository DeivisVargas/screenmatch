package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal
{
    //escaneia a entrada do termial
    private Scanner leitura = new Scanner(System.in);

    //final para dizer que nao vamos modificalar
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY  = "&apikey=6585022c";

    private ConsumoApi consumoapi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json =  consumoapi.obterDados(ENDERECO + nomeSerie.replace(" " , "+" ) + API_KEY );
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for(int i = 1 ;  i <= dados.totalTemporadas(); i++){
			json =  consumoapi.obterDados(ENDERECO + nomeSerie.replace(" " , "+" )+"&season="+ i + API_KEY );
			DadosTemporada dadosTemporada = conversor.obterDados(json , DadosTemporada.class);

			temporadas.add(dadosTemporada);

		}
		temporadas.forEach(System.out::println);


    }
}
