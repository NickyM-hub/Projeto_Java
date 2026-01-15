interface Pagamento {
    void processarPagamento(double valor);
}

abstract class Entregador {
    private String nome;
    private double valorEntrega;

    public Entregador(String nome, double valorEntrega) {
        this.nome = nome;
        this.valorEntrega = valorEntrega;
    }

    public String getNome() {
        return nome;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    abstract double calcularTaxas();

    public void mostrarDados() {
        System.out.println("Nome: " + nome + " Valor da entrega: " + valorEntrega);
    }
}

class Motoboy extends Entregador implements Pagamento {

    public Motoboy(String nome, double valorEntrega) {
        super(nome, valorEntrega);
    }

    @Override
    double calcularTaxas() {
        return getValorEntrega() * 0.05;
    }

    @Override
    public void processarPagamento(double valor) {
        setValorEntrega(valor);
        System.out.println("Pagamento do Motoboy: " + (getValorEntrega() - calcularTaxas()));
    }
}

class Caminhoneiro extends Entregador implements Pagamento {

    public Caminhoneiro(String nome, double valorEntrega) {
        super(nome, valorEntrega);
    }

    @Override
    double calcularTaxas() {
        return getValorEntrega() * 0.15; // 15%
    }

    @Override
    public void processarPagamento(double valor) {
        setValorEntrega(valor);
        System.out.println("Pagamento do Caminhoneiro: " + (getValorEntrega() - calcularTaxas()));
    }
}