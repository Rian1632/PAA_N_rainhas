public class testeNrainhas {

    private final int n;
    private final int[] tabuleiro; // tabuleiro[linha] = coluna
    private long contagemSolucoes;

    /**
     * Construtor que inicializa o resolvedor para um tabuleiro de tamanho N.
     * @param n O tamanho do tabuleiro e o número de rainhas.
     */
    public testeNrainhas(int n) {
        this.n = n;
        this.tabuleiro = new int[n];
        // Inicializa o tabuleiro. O valor -1 indica uma coluna vazia.
        for (int i = 0; i < n; i++) {
            this.tabuleiro[i] = -1;
        }
        this.contagemSolucoes = 0;
    }

    /**
     * Método público que inicia o processo de resolução a partir da primeira linha.
     */
    public void resolver() {
        resolverRecursivo(0);
    }

    /**
     * Método recursivo privado que implementa o backtracking.
     * @param linha A linha atual na qual estamos tentando posicionar uma rainha.
     */
    private void resolverRecursivo(int linha) {
        // --- Caso Base da Recursão ---
        // Se o número da linha for igual a N, significa que conseguimos posicionar
        // todas as N rainhas com sucesso. Encontramos uma solução.
        if (linha == n) {
            contagemSolucoes++;
            return;
        }

        // --- Passo Recursivo ---
        // Itera por todas as colunas da linha atual.
        for (int coluna = 0; coluna < n; coluna++) {
            // Verifica se é seguro posicionar a rainha em (linha, coluna).
            if (eSeguro(linha, coluna)) {
                // Se for seguro, posiciona a rainha (realiza a "jogada").
                tabuleiro[linha] = coluna;

                // Faz a chamada recursiva para a próxima linha.
                resolverRecursivo(linha + 1);

                // --- O Backtracking acontece aqui ---
                // Remove a rainha da posição atual para "voltar atrás" e testar
                // a próxima coluna na mesma linha. Essencial para explorar todas as possibilidades.
                tabuleiro[linha] = -1;
            }
        }
    }

    /**
     * Verifica se é seguro posicionar uma rainha em uma dada linha e coluna,
     * analisando as rainhas já posicionadas nas linhas anteriores.
     * @param linha A linha da nova rainha.
     * @param coluna A coluna da nova rainha.
     * @return true se a posição for segura, false caso contrário.
     */
    private boolean eSeguro(int linha, int coluna) {
        // Verifica as linhas anteriores em busca de conflitos.
        for (int linhaAnterior = 0; linhaAnterior < linha; linhaAnterior++) {
            int colunaAnterior = tabuleiro[linhaAnterior];

            // 1. Conflito na mesma coluna.
            if (colunaAnterior == coluna) {
                return false;
            }

            // 2. Conflito nas diagonais.
            // Se a distância horizontal for igual à distância vertical,
            // elas estão na mesma diagonal.
            int distanciaLinhas = linha - linhaAnterior;
            int distanciaColunas = Math.abs(coluna - colunaAnterior);
            if (distanciaLinhas == distanciaColunas) {
                return false;
            }
        }
        return true;
    }
    
    public long getContagemSolucoes() {
        return contagemSolucoes;
    }
}