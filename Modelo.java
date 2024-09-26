public class Modelo {
    private MatesDiscretas matesDiscretas;

    public Modelo(MatesDiscretas matesDiscretas) {
        this.matesDiscretas = matesDiscretas;
    }

    public String getEcuacion() {
        double[] coeficientes = matesDiscretas.getCoeficientes();
        StringBuilder ecuacion = new StringBuilder("La ecuación es: y = ");


        for (int i = coeficientes.length - 1; i >= 0; i--) {
            if (i == 0) {
                ecuacion.append(coeficientes[i]);
            } else if (i == 1) {
                ecuacion.append(coeficientes[i]).append("x + ");
            } else {
                ecuacion.append(coeficientes[i]).append("x^").append(i).append(" + ");
            }
        }

        return ecuacion.toString();
    }
}
