package src;

import java.util.LinkedList;

public class Vino {
    private String nombre;
    private String variedad;
    private String pais;
    private int cosecha;

    public String getNombre() {
        return nombre;
    }

    public Vino(String nombre, String variedad, String pais, int cosecha) {
        this.nombre = nombre;
        this.variedad = variedad;
        this.pais = pais;
        this.cosecha = cosecha;
    }
}
