import java.util.LinkedList;

public class Usuario {
    private int cedula;
    private LinkedList<Recomendacion> recomendaciones = new LinkedList<Recomendacion>();
    private LinkedList<Vino> meGusta = new LinkedList<Vino>();
    private LinkedList<Vino> meRecomendaron = new LinkedList<Vino>();

    public int getCedula() {
        return cedula;
    }

    public LinkedList<Vino> getMeGusta() {
        return meGusta;
    }

    public Usuario(int cedula, LinkedList<Recomendacion> recomendaciones, LinkedList<Vino> meGusta, LinkedList<Vino> meRecomendaron) {
        this.cedula = cedula;
        this.recomendaciones = recomendaciones;
        this.meGusta = meGusta;
        this.meRecomendaron = meRecomendaron;
    }
}
