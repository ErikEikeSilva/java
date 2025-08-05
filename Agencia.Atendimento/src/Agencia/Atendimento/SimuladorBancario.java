package Agencia.Atendimento;

import java.util.Scanner;

public class SimuladorBancario {


	    public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);
	        double saldo = 500.00; 
	        boolean executando = true;

	        while (executando) {
	            System.out.println("\n╔════════════════════════════╗");
	            System.out.println("║ BEM-VINDO AO BANCO DIGITAL   ║");
	            System.out.println("╠══════════════════════════════╣");
	            System.out.println("║ 1 - Consultar Saldo          ║");
	            System.out.println("║ 2 - Depositar Valor          ║");
	            System.out.println("║ 3 - Sacar Valor              ║");
	            System.out.println("║ 4 - Encerrar Atendimento     ║");
	            System.out.println("╚══════════════════════════════╝");
	            System.out.print("Digite a opção desejada: ");

	            int opcao = entrada.nextInt();

	            switch (opcao) {
	                case 1: 
	                    System.out.printf("\n Seu saldo atual é: R$ %.2f\n", saldo);
	                    break;

	                case 2:
	                    System.out.print("\n💰 Valor para depósito: R$ ");
	                    double valorDeposito = entrada.nextDouble();
	                    if (valorDeposito > 0) {
	                        saldo += valorDeposito;
	                        System.out.printf(" Depósito de R$ %.2f efetuado com sucesso!\n", valorDeposito);
	                    } else {
	                        System.out.println(" Valor inválido. Tente novamente.");
	                    }
	                    break;

	                case 3:
	                    System.out.print("\n Valor para saque: R$ ");
	                    double valorSaque = entrada.nextDouble();
	                    if (valorSaque > 0 && valorSaque <= saldo) {
	                        saldo -= valorSaque;
	                        System.out.printf(" Saque de R$ %.2f realizado com sucesso!\n", valorSaque);
	                    } else if (valorSaque > saldo) {
	                        System.out.println(" Saldo insuficiente.");
	                    } else {
	                        System.out.println(" Valor inválido.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("\n Obrigado por utilizar nosso sistema. Até logo!");
	                    executando = false;
	                    break;

	                default:
	                    System.out.println("Opção inválida. Escolha entre 1 e 4.");
	            }
	        }

	        entrada.close();
	    }
	}