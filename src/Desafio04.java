/*
4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
• SP – R$67.836,43
• RJ – R$36.678,66
• MG – R$29.229,88
• ES – R$27.165,48
• Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação que
 cada estado teve dentro do valor total mensal da distribuidora.
 */

public class Desafio04 {

    public static void main(String[] args) {

        String[] estados = {"SP", "RJ", "MG", "ES", "Outros"};
        double[] faturamentos = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};

        double faturamentoTotal = 0;
        for (double faturamento : faturamentos) {
            faturamentoTotal += faturamento;
        }

        System.out.println("Percentual de representação por estado:");
        for (int i = 0; i < estados.length; i++) {
            double percentual = (faturamentos[i] / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estados[i], percentual);
        }
    }
}