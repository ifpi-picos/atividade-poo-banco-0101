package banco;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;


public class Email implements Notificacao {

    LocalDate data = LocalDate.now();
    DateTimeFormatter dataNoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalTime hora = LocalTime.now();
    DateTimeFormatter horaNoFormato = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    
    
    


    @Override
    public void mandarNotificacao(String operacaoFeita, double valor) {
        JOptionPane.showMessageDialog(null, "Um Gmail acaba de chegar pra você: \n" + operacaoFeita + "no valor de R$" + valor + " no dia " + data.format(dataNoFormato) + " ás " +hora.format(horaNoFormato) );
        
    }
    
}
