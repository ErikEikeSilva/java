package app; // 1. Define o pacote da classe

import java.util.ArrayList; // 2. Importa classe para listas
import java.util.List;
import java.util.Scanner; // 2. Importa classe para leitura de dados

// 3. Declara a classe principal do aplicativo
public class Menuapp {

    // 4. Método principal, ponto de partida da aplicação
    public static void main(String[] args) {

        // 5. Cria objeto para capturar dados digitados
        Scanner scanner = new Scanner(System.in);

        // 6. Instancia o serviço para gerenciar usuários
        UsuarioService usuarioService = new UsuarioService();

        // 7. Declarando variável que armazena a escolha do menu
        int opcao;

        // 8. Início do laço de repetição do menu
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Remover usuário");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // 9. Lê a opção de escolha
            opcao = scanner.nextInt();

            // 10. Limpa o buffer do teclado
            scanner.nextLine();

            // 11. Inicia estrutura de decisão baseada na opção
            switch (opcao) {
                // 12. Se usuário escolher opção 1
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    usuarioService.cadastrarUsuario(nome);
                    break;
                // 13. Se escolher 2, lista usuários
                case 2:
                    usuarioService.listarUsuarios();
                    break;
                // 14. Se escolher 3, remove usuário
                case 3:
                    System.out.print("Digite o nome do usuário a remover: ");
                    String nomeRemover = scanner.nextLine();
                    usuarioService.removerUsuario(nomeRemover);
                    break;
                // 15. Se escolher 4, encerra
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                // 16. Qualquer outra opção
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        // 17. Repete enquanto a opção for diferente de 4
        } while (opcao != 4);

        // 18. Encerra o scanner
        scanner.close();
    }
}

// 19. Classe de serviço para manipular lista de usuários
class UsuarioService {
    private List<String> usuarios = new ArrayList<>(); // lista para armazenar nomes

    // Método para cadastrar usuário
    public void cadastrarUsuario(String nome) {
        usuarios.add(nome);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Método para listar usuários
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Lista de usuários:");
            for (String nome : usuarios) {
                System.out.println("- " + nome);
            }
        }
    }

    // Método para remover usuário pelo nome
    public void removerUsuario(String nome) {
        if (usuarios.remove(nome)) {
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
