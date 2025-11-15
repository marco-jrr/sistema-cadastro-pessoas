package br.com.marco.sistemadecadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> listaPessoas = new ArrayList<>();

        int idPessoa = 1;

        while (true){
            System.out.println("""
                    \n======= SISTEMA DE CADASTRO =======
                    1 - Cadastrar Pessoa
                    2 - Listar Pessoas
                    3 - Excluir Pessoa
                    4 - Atualizar Pessoa
                    5 - Sair""");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nEscreva o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("\nEscreva o email: ");
                    String email = scanner.nextLine();

                    Pessoa novaPessoa = new Pessoa(idPessoa, nome, email);
                    listaPessoas.add(novaPessoa);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    idPessoa++;
                    break;

                case 2:
                    System.out.println("\nLista de Pessoas:");
                    for (Pessoa pessoa : listaPessoas) {        //For-each: percorre cada Pessoa na lista.
                        System.out.println(pessoa.getId() +
                                " - " + pessoa.getNome() +
                                "(" + pessoa.getEmail() + ")");
                    }
                    break;

                case 3:
                    System.out.print("\nInforme o ID: ");
                    int idExcluir = scanner.nextInt();

                    Pessoa pessoaExcluida = null;               //Variável para guardar a referência da pessoa a ser excluída

                   for (Pessoa pessoa : listaPessoas){          //Percorre a lista para encontrar a pessoa com o ID informado.
                       if (pessoa.getId() == idExcluir){        //Se o id da pessoa corrente for igual ao idExcluir, encontramos o alvo.
                           pessoaExcluida = pessoa;             //Guarda a referência da pessoa encontrada.
                           break;
                       }
                   }

                   if (pessoaExcluida != null) {                //Verifica se encontrou alguém com aquele id.
                       listaPessoas.remove(pessoaExcluida);     //Se sim, remove essa instância da lista.
                       System.out.println("Pessoa excluída com sucesso.");
                   } else {
                       System.out.println("ID não encontrado.");
                   }
                   break;

                case 4:
                    System.out.println("Informe o ID: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    Pessoa pessoaUpdate = null;

                    for (Pessoa pessoa : listaPessoas) {
                        if (pessoa.getId() == idAtualizar) {
                            pessoaUpdate = pessoa;
                            break;
                        }
                    }

                    if (pessoaUpdate != null) {
                        System.out.print("\nNome Atual: "+pessoaUpdate.getNome());
                        System.out.print("Email Atual: "+pessoaUpdate.getEmail());

                        System.out.print("\nDigite o novo nome ou aperte (enter) para prosseguir com o mesmo: ");
                        String nomeUpdate = scanner.nextLine();
                        if (!nomeUpdate.isBlank()) {         // Só altera se a pessoa digitou algo
                            pessoaUpdate.setNome(nomeUpdate);
                        }

                        System.out.println("\nDigite o novo email ou aperte (enter) para prosseguir com o mesmo: ");
                        String emailUpdate = scanner.nextLine();
                        if (!emailUpdate.isBlank()) {       //// Só altera se a pessoa digitou algo
                            pessoaUpdate.setEmail(emailUpdate);
                        }

                        System.out.println("\nCadastro atualizado com sucesso.");
                    } else {
                        System.out.println("\nID não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");

            }
        }
    }
}
