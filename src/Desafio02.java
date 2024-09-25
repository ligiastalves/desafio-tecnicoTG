/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores
anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde,
informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número
informado pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou
pode ser previamente definido no código;
*/

import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita que o usuário informe um número
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        int a = 0, b = 1, fibonacci = 0;

        // Caso para verificar se o número é 0 ou 1, que pertencem à sequência
        if (num == 0 || num == 1) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
        } else {
            // Calcular a sequência até que o valor seja igual ou maior ao número informado
            while (fibonacci < num) {
                fibonacci = a + b;
                a = b;
                b = fibonacci;
            }
            // Verifica se o número informado pertence à sequência
            if (fibonacci == num) {
                System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + num + " NÃO pertence à sequência de Fibonacci. "
                        + "O próximo número na sequência seria " + fibonacci + ".");
            }
        }
        // Fechar o Scanner
        scanner.close();
    }
}