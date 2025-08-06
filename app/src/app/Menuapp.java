package app; // 1. Define o pacote da classe

import java.util.Scanner; 
/* 2. Importar classe para leitura de dados, lendo as entradas */

/* 3. Declarando a classe principal do aplicativo */
public class Menuapp {

    /* 4. Método principal, ponto de partida da aplicação */
    public static void main(String[] args) {
        /* 5. Cria objeto para capturar dados digitados */
        Scanner scanner = new Scanner(System.in);

        /* 6. Instancia o serviço para gerenciar usuários */
        UsuarioService usuarioService = new UsuarioService();

        /* 7. Declarando variável que armazena a escolha do menu */
        int opcao;

        /* 8. Início do laço de repetição do menu */
        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            /* 9. Le a opção de escolha */
            opcao = scanner.nextInt();
            /* 10. Limpa o buffer do teclado */
            scanner.nextLine();

            /* 11. Inicia estrutura de decisão baseada na opção */
            switch (opcao) {
                /* 12. Se usuário escolher opção 1 */
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    usuarioService.cadastrarUsuario(nome);
                    break;
                case 2:
                    usuarioService.listarUsuarios();
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        /* 13. Repete enquanto a opção for diferente de 3 */
        } while (opcao != 3);

        /* 14. Encerra o scanner */
        scanner.close();
    }
}
