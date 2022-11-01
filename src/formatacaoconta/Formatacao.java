package formatacaoconta;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatacao {
    static NumberFormat formato = new DecimalFormat("R$ #,#00.00");

    public static String coversao(double real){
        return formato.format(real);
    }
}