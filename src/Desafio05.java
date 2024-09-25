/*
5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser
previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */

import java.util.Scanner;

public class Desafio05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário para inserir uma string
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();

        //Array de caracteres para a string
        char[] caracteres = new char[input.length()];

        // Preencher o array de caracteres com os caracteres da string
        for (int i = 0; i < input.length(); i++) {
            caracteres[i] = input.charAt(i);
        }

        // Inverter os caracteres
        StringBuilder stringInvertida = new StringBuilder();
        for (int i = caracteres.length - 1; i >= 0; i--) {
            stringInvertida.append(caracteres[i]);
        }

        System.out.println("String invertida: " + stringInvertida.toString());

        scanner.close();
    }
}