package br.com.andrecabalo.geradorJson;

import br.com.andrecabalo.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorJson {

    public void salvaJson(Endereco endereco) throws IOException {
        System.out.println("Gerando Json...");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(endereco, System.out);

        FileWriter nomeArquivoAEscrever =new FileWriter(endereco.cep() + ".json");
        nomeArquivoAEscrever.write(gson.toJson(endereco));
        nomeArquivoAEscrever.close();
    }
}
