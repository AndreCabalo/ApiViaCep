package br.com.andrecabalo.main;

import br.com.andrecabalo.consultaCep.ConsultaCep;
import br.com.andrecabalo.geradorJson.GeradorJson;
import br.com.andrecabalo.model.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite o CEP: ");
        String numeroCep = scanner.nextLine();

        try{
            Endereco endereco = consultaCep.buscarEnderecoPorCep(numeroCep);
            System.out.println(endereco);
            GeradorJson geradorJson = new GeradorJson();
            geradorJson.salvaJson(endereco);
        }catch (RuntimeException e){
            System.out.println("Erro ao buscar o endereço: " + e.getMessage());
        }finally {
            System.out.println("\nFim da execução deste programa, testando branch");
        }


    }
}
