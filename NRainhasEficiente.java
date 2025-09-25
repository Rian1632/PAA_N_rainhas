public class NRainhasEficiente {

    private final int n;
    private long contagemSolucoes;

    private boolean[] colunas;
    private boolean[] diagPrincipal;
    private boolean[] diagSecundaria;

    public NRainhasEficiente(int n) {
        this.n = n;
        this.contagemSolucoes = 0;
        this.colunas = new boolean[n];
        this.diagPrincipal = new boolean[2 * n - 1];
        this.diagSecundaria = new boolean[2 * n - 1];
    }

    public void resolver() {
        resolverRecursivo(0);
    }

    private void resolverRecursivo(int linha) {
        if (linha == n) {
            contagemSolucoes++;
            return;
        }

        for (int coluna = 0; coluna < n; coluna++) {
            if (!colunas[coluna] && 
                !diagPrincipal[linha - coluna + n - 1] &&
                !diagSecundaria[linha + coluna]) {

                // Marca ocupações
                colunas[coluna] = true;
                diagPrincipal[linha - coluna + n - 1] = true;
                diagSecundaria[linha + coluna] = true;

                resolverRecursivo(linha + 1);

                // Desmarca (backtracking)
                colunas[coluna] = false;
                diagPrincipal[linha - coluna + n - 1] = false;
                diagSecundaria[linha + coluna] = false;
            }
        }
    }

    public long getContagemSolucoes() {
        return contagemSolucoes;
    }

    public static void main(String[] args) {
        NRainhasEficiente jogo = new NRainhasEficiente(8);
        jogo.resolver();
        System.out.println("Total de soluções: " + jogo.getContagemSolucoes());
    }
}
