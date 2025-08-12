package app;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Deletar Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    if (nome.isEmpty() || email.isEmpty()) {
                        System.out.println("Nome e email não podem ser vazios!");
                        break;
                    }

                    dao.inserir(new Cliente(nome, email));
                    break;

                case 2:
                    List<Cliente> clientes = dao.listarClientes();
                    System.out.println("\n--- Lista de Clientes ---");
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.print("ID do cliente para atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine(); // Limpar buffer
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    if (novoNome.isEmpty() || novoEmail.isEmpty()) {
                        System.out.println("Nome e email não podem ser vazios!");
                        break;
                    }

                    dao.atualizar(new Cliente(idAtualizar, novoNome, novoEmail));
                    break;

                case 4:
                    System.out.print("ID do cliente para deletar: ");
                    int idDeletar = sc.nextInt();
                    dao.deletar(idDeletar);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}