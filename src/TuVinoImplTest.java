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
            Usuario pedro = new Usuario(245);
            vinoPruebitas3.getUsuariosRegistrados().add(matias);
            vinoPruebitas3.getUsuariosRegistrados().add(pedro);
            vinoPruebitas3.crearVino("faisan","alguna","uruguay",23);
            vinoPruebitas3.agregarVinoQueGusta(234,"faisan");
            vinoPruebitas3.agregarRecomendación(234,245,"faisan");
            assertEquals(pedro.getMeRecomendaron().size(),1);
        } catch (EntidadYaExiste e) {
            System.out.println(e);
        } catch (EntidadNoExiste e) {
            System.out.println(e);
        }

    }

    @Test
    public void obtenerProximaRecomendación() {
        TuVinoImpl pruebitaVino4 = new TuVinoImpl();
        try{
            Usuario matias= new Usuario(23);
            Vino vinacho = new Vino("faisan","alguna","uruguay",44);
            pruebitaVino4.crearVino("faisan","alguna","uruguay",44);
            pruebitaVino4.getUsuariosRegistrados().add(matias);
            matias.getMeRecomendaron().add(vinacho);
            assertEquals(pruebitaVino4.obtenerProximaRecomendación(23),vinacho);
        } catch (EntidadYaExiste e) {
            System.out.println(e);
        }
    }
}