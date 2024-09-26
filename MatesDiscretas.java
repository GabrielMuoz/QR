public class MatesDiscretas {
    private RegresionCuadratica regresion;
    private double[] coeficientes;

    public MatesDiscretas(RegresionCuadratica regresion) {
        this.regresion = regresion;
        this.coeficientes = new double[regresion.getSumatorias().length];
    }

    public void operaciones() {
        double[][] matriz = regresion.getSumatorias();
        resolverMatriz(matriz);
    }

    private void resolverMatriz(double[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            double diag = matriz[i][i];
            for (int j = 0; j < n + 1; j++) {
                matriz[i][j] /= diag;
            }

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double factor = matriz[j][i];
                    for (int k = 0; k < n + 1; k++) {
                        matriz[j][k] -= factor * matriz[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            coeficientes[i] = matriz[i][n];
        }
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }
}
