public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando a análise experimental do Problema das N-Rainhas em Java...");
        System.out.println("-".repeat(70));
  
        System.out.printf("%-5s | %-25s | %-25s%n", "N", "Tempo (s)", "Soluções Encontradas");
        System.out.println("-".repeat(70));

    
        for (int n = 1; n <= 15; n++) {
            testeNrainhas resolvedor = new testeNrainhas(n);

           
            long tempoInicial = System.nanoTime();
            resolvedor.resolver();
            long tempoFinal = System.nanoTime();

          
            double tempoDecorridoEmSegundos = (tempoFinal - tempoInicial) / 1_000_000_000.0;

            System.out.printf("%-5d | %-25.6f | %-25d%n",
                n,
                tempoDecorridoEmSegundos,
                resolvedor.getContagemSolucoes()
            );
        }
    }
}