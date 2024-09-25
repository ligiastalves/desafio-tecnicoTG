/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Desafio03 {

    public static void main(String[] args) {
        try {
            // Ler o arquivo XML
            File inputFile = new File("faturamento.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Pegar todos os elementos <dia>
            NodeList nodeList = doc.getElementsByTagName("dia");

            List<Double> faturamentos = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                    // Ignorar dias com faturamento 0
                    if (valor > 0) {
                        faturamentos.add(valor);
                    }
                }
            }

            // Encontrar o menor e maior valor de faturamento
            double menorFaturamento = faturamentos.stream().min(Double::compare).get();
            double maiorFaturamento = faturamentos.stream().max(Double::compare).get();

            // Calcular a média de faturamento
            double somaFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
            double mediaMensal = somaFaturamento / faturamentos.size();

            // Contar dias com faturamento acima da média
            long diasAcimaDaMedia = faturamentos.stream().filter(f -> f > mediaMensal).count();

            System.out.println("Menor faturamento: R$ " + menorFaturamento);
            System.out.println("Maior faturamento: R$ " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

