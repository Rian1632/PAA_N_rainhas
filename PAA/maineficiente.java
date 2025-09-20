
 public static void main(String[] args) {
    int n = 15; // pode trocar aqui para 4, 5, 6, etc
    NRainhasEficiente jogo = new NRainhasEficiente(n);

    long inicio = System.currentTimeMillis();
    jogo.resolver();
    long fim = System.currentTimeMillis();

    System.out.println("Total de soluções para N=" + n + ": " + jogo.getContagemSolucoes());
    System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
}
