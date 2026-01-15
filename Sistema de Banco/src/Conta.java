abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public void mostrarDados() {
        System.out.println("Titular: " + titular + " | Saldo: " + saldo);
    }
}

class ContaCorrente extends Conta {
    private int saquesRealizados = 0;

    public static int totalSaques = 0;
    public static final int MAX_SAQUES = 3;
    public static final double TAXA_SAQUE = 2.5;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (saquesRealizados >= MAX_SAQUES) {
            System.out.println("Limite de saques atingido para " + titular);
            return;
        }

        double valorTotal = valor + TAXA_SAQUE;
        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            saquesRealizados++;
            totalSaques++;
            System.out.println("Saque de " + valor + " realizado. Taxa: " + TAXA_SAQUE);
        } else {
            System.out.println("Saldo insuficiente para saque de " + valor);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado.");
    }
}

