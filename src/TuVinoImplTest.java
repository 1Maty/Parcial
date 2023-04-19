import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TuVinoImplTest {

    @Test
    public void crearVino() {
        TuVinoImpl vinoPruebitas = new TuVinoImpl();
        try{
            vinoPruebitas.crearVino("hola","hola2","hola3",14);
            assertEquals(1,vinoPruebitas.getVinosRegistrados().size());
            vinoPruebitas.crearVino("hola","hola2","hola3",14);
        }catch(EntidadYaExiste e){
            System.out.println("pone otro master." + e.getMessage());
        }
    }

    @Test
    public void agregarVinoQueGusta() {
    }

    @Test
    public void agregarRecomendación() {
    }

    @Test
    public void obtenerProximaRecomendación() {
    }
}