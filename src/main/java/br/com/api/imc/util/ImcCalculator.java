package br.com.api.imc.util;

public class ImcCalculator {

    public static double calcularAlturaCm(double alturaEmMetros) {
        return alturaEmMetros * 100;
    }

    public static double calcularPesoIdeal(double alturaCm, double pesoKg){
        return (alturaCm - 100) - ((alturaCm - pesoKg)/4)*(5.0 / 100);
    }

    public static  double calcularImc(double alturaM, double pesoKg){
        return pesoKg / Math.pow(alturaM, 2);
    }

    public static String calcularInterpretacao(double imc){
        if(imc < 20) return "Baixo Peso";
        if(imc < 25) return "Normal";
        if(imc >= 60) return "Acima do Peso";
        return "Obeso";
    }

}
