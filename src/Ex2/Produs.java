package Ex2;

import java.time.LocalDate;

public class Produs {
    private static double incasari = 0;

    private String nume;
    private double pret;
    private int cantitate;
    private LocalDate dataExp;

    public Produs(String nume, double pret, int cantitate, LocalDate dataExp){
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExp = dataExp;
    }

    public String getNume(){return nume;}
    public double getPret(){return pret;}
    public int getCantitate(){return cantitate;}
    public LocalDate getDataExp(){return dataExp;}
    public static double getIncasari() { return incasari; }

    public void setNume(String nume){
        this.nume = nume;
    }
    public void setPret(double pret){
        this.pret = pret;
    }
    public void setCantitate(int cantitate){
        this.cantitate = cantitate;
    }
    public void setDataExp(LocalDate dataExp){
        this.dataExp = dataExp;
    }

    public boolean vinde(int cant){
        if(cant <= 0 || cant > cantitate) return false;
        cantitate -= cant;
        incasari += pret * cant;
        return true;
    }

    public boolean esteExp(){
        return dataExp.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return nume + ", pret: " + pret + ", cantitate: " + cantitate  + ", expira: " + dataExp;
    }

    public String toCsv() {
        return nume + "," + pret + "," + cantitate + "," + dataExp;
    }
}
