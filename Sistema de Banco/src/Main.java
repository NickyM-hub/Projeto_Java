public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("Nicole", 100.0);

        conta.mostrarDados();

        // Depósitos
        conta.depositar(50.0);
        conta.depositar(30.0);

        // Saques até atingir o limite
        conta.sacar(20.0);
        conta.sacar(30.0);
        conta.sacar(40.0);
        conta.sacar(10.0); // este deve falhar (limite atingido)

        // Mostrar saldo final
        conta.mostrarDados();

        // Mostrar total de saques realizados no sistema
        System.out.println("Total de saques realizados no banco: " + ContaCorrente.totalSaques);
    }
}

