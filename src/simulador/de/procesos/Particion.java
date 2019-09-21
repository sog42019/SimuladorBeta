package simulador.de.procesos;

public class Particion {
   int NroPart;
   int ProCargado;
   int TamPart;
   boolean libre;

    public Particion(int NroPart, int ProCargado, int TamPart, boolean libre) {
        this.NroPart = NroPart;
        this.ProCargado = ProCargado;
        this.TamPart = TamPart;
        this.libre = libre;
    }

    public int getProCargado() {
        return ProCargado;
    }

    public void setProCargado(int ProCargado) {
        this.ProCargado = ProCargado;
    }
   
    public int getNroPart() {
        return NroPart;
    }

    public void setNroPart(int NroPart) {
        this.NroPart = NroPart;
    }

    public int getTamPart() {
        return TamPart;
    }

    public void setTamPart(int TamPart) {
        this.TamPart = TamPart;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
   
   
}
