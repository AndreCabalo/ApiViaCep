package br.com.andrecabalo.consultaCep;

import br.com.andrecabalo.model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscarEnderecoPorCep(String cep) throws IOException, InterruptedException {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Endereco.class);

        }catch (Exception e){

            System.out.println("Erro ao buscar o endereço: " + e.getMessage());

            throw  new RuntimeException("Não consegui obeter o enderço do CEP informado");
        }
    }
}
