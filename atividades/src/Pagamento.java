interface Pagamento {

    public void processarPagamento(double valor);
}

abstract class Entregador {
    private String nome;
    private double valorEntrega;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public Entregador(String nome, double valorEntrega) {
        this.nome = nome;
        this.valorEntrega = valorEntrega;
    }

    abstract double calcularTaxas();

    abstract void mostrarDados();
}

class Motoboy extends Entregador implements Pagamento {

    public Motoboy(String nome, double valorEntrega) {
        super(nome, valorEntrega);
    }


    @Override
    double calcularTaxas() {
        if (getValorEntrega() > 0) {
            return getValorEntrega() * 0.05;
        }
        else {
            return getValorEntrega() * 0;
        }
    }

    @Override
    public void processarPagamento(double valor) {
        calcularTaxas(valor);
        System.out.println("Pagamento processado no valor de: " + getValorEntrega());
    }

    private void calcularTaxas(double valor) {
    }

    @Override
    void mostrarDados() {
        System.out.println("o nome do Motoboy é: " + getNome() + "e o valor da entrega é: " + getValorEntrega());
    }
}