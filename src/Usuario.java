import java.util.*;

public class Usuario {
    private int cedula;
    private LinkedList<Recomendacion> recomendaciones = new LinkedList<Recomendacion>();
    private LinkedList<Vino> meGusta = new LinkedList<Vino>();
    private Queue<Vino> meRecomendaron = new LinkedList<Vino>();

    public int getCedula() {
        return cedula;
    }

    public LinkedList<Vino> getMeGusta() {
        return meGusta;
    }

    public Usuario(int cedula) {
        this.cedula = cedula;
    }

    public Queue<Vino> getMeRecomendaron() {
        return meRecomendaron;
    }
}
