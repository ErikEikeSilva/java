package ATIVIDADE1;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para o dia da semana (1=Domingo, 2=Segunda, ...): ");
        int numeroDoDia = scanner.nextInt();

        String nomeDoDia;

        switch (numeroDoDia) {
            case 1:
                nomeDoDia = "Domingo";
                break;
            default:
                nomeDoDia = "Número inválido";
        }

        System.out.println("O dia da semana é: " + nomeDoDia);
    }
}