package Observers;


import java.util.Observable;
import java.util.Observer;

public class Central implements Observer {
    private String notificacao;

    public Central(){
    }

    public String getNotificacao(){
        return this.notificacao;
    }

    // conectar medidor a central
    public void conectar(Medidor medidor){
        medidor.addObserver(this);
    }

    public void update(Observable medidor, Object arg1){
        this.notificacao = medidor.toString();
    }
}
