public class RegresionCuadratica {

    public int grado = 2;
    private double[][] sumatorias;

    public int N;

    public double[] X ;
    public double[] Y;


    public RegresionCuadratica(double[] X, double[] Y) {
        this.X= X;
        this.Y= Y;
        this.N= X.length;
    }

    public void calcularSumatorias() {



        sumatorias = new double[grado + 1][grado + 2];
        for (int i = 0; i <= grado; i++) {
            for (int j = 0; j <= grado + 1; j++) {
                double suma = 0;
                for (int k = 0; k < N; k++) {
                    double xPow = Math.pow(X[k], i + j);
                    if (j == grado + 1) {
                        suma += Y[k] * Math.pow(X[k], i);
                    } else {
                        suma += xPow;
                    }
                }
                sumatorias[i][j] = suma;
            }
        }
    }

    public double calcularPrediccion(double x) {
        MatesDiscretas matesDiscretas = new MatesDiscretas(this);
        matesDiscretas.operaciones();

        double[] coeficientes = matesDiscretas.getCoeficientes();
        double b0 = coeficientes[0];
        double b1 = coeficientes[1];
        double b2 = coeficientes[2];


        return b0 + b1 * x + b2 * Math.pow(x, 2);
    }



    public double[][] getSumatorias() {
        return sumatorias;
    }
}
