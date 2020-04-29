package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import DAO.ProdutoDAO;

public class Main {

    public static void main(String[] args) throws IOException {

       try {
           ProdutoDAO produtoDAO =  null;
           produtoDAO = new ProdutoDAO("produto.bin"); 
           Produto produto = new Produto();
//           Scanner entrada = new Scanner(System.in);
           
//           System.out.println("Digite o id do produto: ");
//           produto.setId(entrada.nextInt());
//           System.out.println("Digite o nome do produto: ");
//           produto.setNomeProduto("dshfshs");
//           System.out.println("Digite a data de cadastro do produto: ");
//           produto.setDataCadastro("dshfshs");
//           System.out.println("Digite a descrição do seu produto: ");
//           produto.setDescricaoProduto("dshfshs");
//           System.out.println("Digite a categoria do seu produto: ");
//           produto.setCategoriaProduto("dshfshs");
//           System.out.println("Digite seu estado: ");
//           produto.setEstadoProduto("dshfshs");
//           System.out.println("Digite a cidade: ");
//           produto.setCidadeProduto("dshfshs");
//           System.out.println("Digite um telefone de contato: ");
//           produto.setTelefoneContato("dshfshs");
//           System.out.println("Digite o preço do produto: ");
//           produto.setPrecoProduto(entrada.nextDouble());
           
           
           produto.setId(1);
           produto.setNomeProduto("Shulambs");
           produto.setDataCadastro("lalalal");
           produto.setDescricaoProduto("Heloisa Unicornio");
           produto.setCategoriaProduto("Lala");
           produto.setEstadoProduto("hajsdhasd");
           produto.setCidadeProduto("asbdhasd");
           produto.setTelefoneContato("asdhbajsdh");
           produto.setPrecoProduto(1);
           
           produtoDAO.update(produto);
           
//           produtoDAO.add(produto);
//
           List<Produto> listaDeProdutos;
//
           listaDeProdutos = produtoDAO.getAll();
           for (Produto user : listaDeProdutos) {
               System.out.println(user.getId());
               System.out.println(user.getNomeProduto());
               System.out.println(user.getDataCadastro());
               System.out.println(user.getDescricaoProduto());
               System.out.println(user.getCategoriaProduto());
               System.out.println(user.getEstadoProduto());
               System.out.println(user.getCidadeProduto());
               System.out.println(user.getTelefoneContato());
               System.out.println(user.getPrecoProduto());
           }
           
           
//           entrada.close();

       } catch (Exception e) {
           System.out.println(e);
       }
       
    }
}
