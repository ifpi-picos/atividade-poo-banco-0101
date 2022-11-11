package formatacao;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Numformata {

    static NumberFormat formatarValores = new DecimalFormat("R$ #,##0.00");

    public static String doubletoString(Double valor) {
        return formatarValores.format(valor);
    }

    
    
}