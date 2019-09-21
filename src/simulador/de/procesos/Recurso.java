package simulador.de.procesos;


public class Recurso {

   //Atributos
    int PID;
    int TA;
    int Tam;
    int CPU1;
    int ES1;
    int CPU2;
    int ES2;
    boolean libre;

    public int getES1() {
        return ES1;
    }

    public void setES1(int ES1) {
        this.ES1 = ES1;
    }

    public int getES2() {
        return ES2;
    }

    public void setES2(int ES2) {
        this.ES2 = ES2;
    }

    public int getCPU3() {
        return CPU3;
    }

    public void setCPU3(int CPU3) {
        this.CPU3 = CPU3;
    }
    int CPU3; 

    public Recurso(int PID, int TA, int Tam, int CPU1, int ES1, int CPU2, int ES2, int CPU3,boolean libre) {
        this.PID = PID;
        this.TA = TA;
        this.Tam = Tam;
        this.CPU1 = CPU1;
        this.ES1 = ES1;
        this.CPU2 = CPU2;
        this.ES1 = ES2;
        this.CPU2 = CPU3;
        this.libre = libre;
    }
    
    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getTA() {
        return TA;
    }

    public void setTA(int TA) {
        this.TA = TA;
    }

    public int getTam() {
        return Tam;
    }

    public void setTam(int Tam) {
        this.Tam = Tam;
    }

    public int getCPU1() {
        return CPU1;
    }

    public void setCPU1(int CPU1) {
        this.CPU1 = CPU1;
    }

    public int getCPU2() {
        return CPU2;
    }

    public void setCPU2(int CPU2) {
        this.CPU2 = CPU2;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
