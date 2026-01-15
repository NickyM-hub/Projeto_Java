class Main {
    public static void main(String[] args) {
        // Criando entregadores
        Motoboy m = new Motoboy("Carlos", 100.0);
        Caminhoneiro c = new Caminhoneiro("João", 500.0);

        m.mostrarDados();
        c.mostrarDados();

        System.out.println("Taxa do Motoboy: " + m.calcularTaxas());
        System.out.println("Taxa do Caminhoneiro: " + c.calcularTaxas());

        m.processarPagamento(m.getValorEntrega());
        c.processarPagamento(c.getValorEntrega());
    }
}

