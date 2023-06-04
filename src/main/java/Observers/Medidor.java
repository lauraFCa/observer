package Observers;

import Dados.GrauAlerta;

import java.text.DecimalFormat;
import java.util.Observable;


public class Medidor extends Observable {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private float pressao;
    private Integer codigoSetor;
    private GrauAlerta grauAlerta;
    private float pressaoLimite;

    public Medidor(float pressao, Integer codigoSetor, GrauAlerta grauAlerta) {
        this.pressao = pressao;
        this.codigoSetor = codigoSetor;
        this.grauAlerta = grauAlerta;
        pressaoLimite = 4200f;
    }

    public void dispararAviso(){
        setChanged();
        notifyObservers();
    }

    public void setPressaoLimite(float pressaoLimite){
        this.pressaoLimite = pressaoLimite;
    }

    public String calcPorcentagem(){
        float res = (this.pressao - this.pressaoLimite) * 100/this.pressaoLimite;
        return df.format(res);
    }

    @Override
    public String toString(){
        return "Alerta: " + this.grauAlerta.toString() + "\nSetor: " + this.codigoSetor + " | Pressao: " + this.pressao + "\nPorcentagem acima do esperado: " + calcPorcentagem() + "%";
    }
}
