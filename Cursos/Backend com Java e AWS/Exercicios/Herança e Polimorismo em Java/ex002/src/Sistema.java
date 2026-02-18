import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Vendedor> vendedores;
    private List<Atendente> atendentes;

    public Sistema() {
        this.vendedores = new ArrayList<>();
        this.atendentes = new ArrayList<>();
    }
    public void adicionarVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public int getTotalVendas() {
        int total = 0;
        for (Vendedor vendedor : vendedores) {
            total += vendedor.quantidadeVendas;
        }
        return total;
    }

    public void adicionarAtendente(Atendente atendente){
        atendentes.add(atendente);
    }
    public List<Atendente> getAtendentes() {
        return atendentes;
    }
}
