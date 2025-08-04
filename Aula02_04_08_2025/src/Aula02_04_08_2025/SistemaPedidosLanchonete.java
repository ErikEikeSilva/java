package Aula02_04_08_2025;

import java.util.Scanner;

public class SistemaPedidosLanchonete {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] produtos = { "X-Burger", "X-Salada", "Refrigerante", "Batata Frita", "Suco Natural", "Cheeseburger",
				"Milkshake", "Nuggets", "Água" };
		double[] precos = { 12.00, 14.00, 6.00, 8.00, 7.00, 13.00, 10.00, 9.00, 4.00 };
		int[] quantidades = new int[produtos.length];

		System.out.println("============================================");
		System.out.println("         🍟 LANCHONETE SABOR 🍔         ");
		System.out.println("============================================");
		System.out.println("\n📋 CARDÁPIO DISPONÍVEL:\n");

		for (int i = 0; i < produtos.length; i++) {
			System.out.printf("%2d - %-20s R$ %5.2f%n", i + 1, produtos[i], precos[i]);
		}

		System.out.println("\n🛒 FAÇA SEU PEDIDO:\n");

		for (int i = 0; i < produtos.length; i++) {
			int qtd;
			do {
				System.out.printf("Quantos deseja de %-20s: ", produtos[i]);
				qtd = scanner.nextInt();
				if (qtd < 0) {
					System.out.println("❌ Quantidade inválida. Digite novamente.");
				}
			} while (qtd < 0);
			quantidades[i] = qtd;
		}

		scanner.close();

		System.out.println("\n🧾 RESUMO DO PEDIDO:");
		double total = 0.0;

		for (int i = 0; i < produtos.length; i++) {
			if (quantidades[i] > 0) {
				double subtotal = quantidades[i] * precos[i];
				System.out.printf("%-20s x %2d = R$ %6.2f%n", produtos[i], quantidades[i], subtotal);
				total += subtotal;
			}
		}

		System.out.printf("\n💰 TOTAL A PAGAR: R$ %.2f%n", total);
		System.out.println("============================================");
		System.out.println("     ✅ Obrigado por escolher a Lanchonete Java Sabor!");
		System.out.println("============================================");
	}
}