public class MainEficiente{ 
    public static void main(String[] args) {
    // Defina o limite máximo de N que você quer testar
    int limite = 20;

    System.out.println("=== Problema das N-Rainhas (versão eficiente) ===");
    System.out.println("Mostrando número de soluções e tempo de execução para cada N:\n");

    for (int n = 4; n <= limite; n++) {
        NRainhasEficiente jogo = new NRainhasEficiente(n);

        long inicio = System.currentTimeMillis();
        jogo.resolver();
        long fim = System.currentTimeMillis();

        double tempoSegundos = (fim - inicio) / 1000.0;

        System.out.printf("N = %-2d | Soluções: %-12d | Tempo: %.4f s%n",
                          n, jogo.getContagemSolucoes(), tempoSegundos);
    }
}
}