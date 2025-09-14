import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da sua compra: ");
        String valorCompra = scanner.nextLine();
        System.out.println(calcularDesconto(valorCompra));
    }
    public static String calcularDesconto(String valorCompra) {
        //BigDecimal -> variavel do tipo utilizada para contas monetarias
        BigDecimal valor = new BigDecimal(valorCompra);
        BigDecimal descontoPercentual;

        /*TODO: Verifique se o valor é menor que 50,00:
        TODO: se o valor for menor, retorna '-1'
        TODO: se for igual, retorna 0
        TODO: se for maior, retorna 1
        */
        if(valor.compareTo(new BigDecimal("50.00")) < 0){
            descontoPercentual= new BigDecimal("0.00");
        }
        //TODO: Verifique se o valor é entre 50.00 e 100.00 (inclusive):
        else if(valor.compareTo(new BigDecimal("100.00")) <= 0){
            descontoPercentual = new BigDecimal("0.10");
        }
        //TODO: Caso contrário, o valor é maior que 100,00:
        else {
            descontoPercentual = new BigDecimal("0.20");
        }

        BigDecimal valorComDesconto = valor.subtract(valor.multiply(descontoPercentual));

        //TODO: Retorne a string formatada com o desconto aplicado, conforme exigido no desafio:
        return "Valor original: R$ " + valor.setScale(2) +
                " | Desconto: " + descontoPercentual.multiply(new BigDecimal("100")).intValue() + "%" +
                " | Valor final (com desconto): R$ " + valorComDesconto.setScale(2);

    }
}
