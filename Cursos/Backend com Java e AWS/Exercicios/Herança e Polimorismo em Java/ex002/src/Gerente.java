public class Gerente extends Funcionario {

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public void consultarVendas(Sistema sistema) {
        for (Vendedor vendedor : sistema.getVendedores()) {
            System.out.println("Vendedor: " + vendedor.getNome() +
                    " |  Vendas: " + vendedor.getQuantidadeVendas());
        }
    }

    public void gerarRelatorioFinanceiro(Sistema sistema, double valorPorVenda) {
        double faturamento = sistema.getTotalVendas() * valorPorVenda;
        System.out.println("Faturamento total: R$ " + faturamento);

    }
}
