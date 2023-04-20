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
        TuVinoImpl vinoPruebitas2 = new TuVinoImpl();
        try {
            vinoPruebitas2.crearVino("faisan","alguna","uruguay",23);
            vinoPruebitas2.agregarVinoQueGusta(23,"faisan");
        }catch (EntidadNoExiste e){
            System.out.println("El vino no esta amigo");
        } catch (EntidadYaExiste e) {
            System.out.println("El vino ya esta creado");;
        }
    }

    @Test
    public void agregarRecomendación() {
        TuVinoImpl vinoPruebitas3= new TuVinoImpl();
        try {
            Usuario matias = new Usuario(234);
            vinoPruebitas3.crearVino("faisan","alguna","uruguay",23);
            vinoPruebitas3.agregarRecomendación();
        } catch (EntidadYaExiste e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void obtenerProximaRecomendación() {
    }
}