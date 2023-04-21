package src;

import java.util.LinkedList;
import java.util.Queue;

public class TuVinoImpl implements TuVinoMgt  {
    public LinkedList<Vino> getVinosRegistrados() {
        return vinosRegistrados;
    }

    private LinkedList<Vino> vinosRegistrados= new LinkedList<Vino>();

    public LinkedList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    private LinkedList<Usuario> usuariosRegistrados = new LinkedList<Usuario>();

    @Override
    public void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste {
        for (int i = 0; i < vinosRegistrados.size(); i++) {
            if (vinosRegistrados.get(i).getNombre().equals(nombre)) {
                throw new EntidadYaExiste("algo");
            }
        }
        Vino nuevoVino = new Vino(nombre, variedad, pais, cosecha);
        vinosRegistrados.add(nuevoVino);
    }

    @Override
    public void agregarVinoQueGusta(int cedula, String nombreVino) throws EntidadNoExiste {
        boolean esta_vino= false;
        boolean esta_usuario =false;
        for (int i =0; i<vinosRegistrados.size();i++){
            if(vinosRegistrados.get(i).getNombre().equals(nombreVino)){
                esta_vino=true;
                for(int q=0; q<usuariosRegistrados.size();q++){
                    if(usuariosRegistrados.get(q).getCedula()==cedula){
                        usuariosRegistrados.get(q).getMeGusta().add(vinosRegistrados.get(i));
                        esta_usuario=true;
                    }
                }
                if(!esta_usuario){
                    Usuario nuevoPibe = new Usuario(cedula);
                    nuevoPibe.getMeGusta().add(vinosRegistrados.get(i));
                    usuariosRegistrados.add(nuevoPibe);
                }
        }}
        if(!esta_vino){
            throw new EntidadNoExiste("No esta maquina.");
        }

    }

    @Override
    public void agregarRecomendación(int cedula, int cedulaARecomendar, String nombreVino) throws EntidadNoExiste{// lo entendi mal tnegoque usar el cedula a recomendar y de ahi ir entre los q le gustan a ese para encontrar el vino.
        boolean esta_usuario=false;
        boolean esta_vino=false;
        Vino elRecomendado= null;
        for(int i =0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedula){
                esta_usuario=true;
                for(int q=0; q<usuariosRegistrados.get(i).getMeGusta().size();q++){
                    if(usuariosRegistrados.get(i).getMeGusta().get(q).getNombre().equals(nombreVino)){
                        esta_vino=true;
                        elRecomendado =usuariosRegistrados.get(i).getMeGusta().get(q);
            }}
        }
    }
        for (int i = 0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedulaARecomendar){
                usuariosRegistrados.get(i).getMeRecomendaron().add(elRecomendado);
            }
        }
        if(!esta_vino || !esta_usuario){
            throw  new EntidadNoExiste("No esta o el usuario o el vino.");
        }
    }

    @Override
    public Vino obtenerProximaRecomendación(int cedula) {
        Vino salida=null;
        for(int i=0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedula){
                 salida = usuariosRegistrados.get(i).getMeRecomendaron().peek();
                usuariosRegistrados.get(i).getMeRecomendaron().toArray();
            }
        }
    return salida;
    }

    @Override
    public void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste {
        Queue<Vino> queueADevolver = new LinkedList<>();
        Vino vino1= null;
        Vino vino2= null;
        boolean personaEsta =false;
        boolean vino1Esta =false;
        boolean vino2Esta =false;
        for(int t = 0; t<vinosRegistrados.size();t++){
            if(vinosRegistrados.get(t).getNombre().equals(nombreVino1)){
                vino1 =vinosRegistrados.get(t);
                vino1Esta =true;
            }
            else if(vinosRegistrados.get(t).getNombre().equals(nombreVino2)){
                vino2 = vinosRegistrados.get(t);
                vino2Esta=true;
            }
        }
        for(int i=0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedula){
                personaEsta = true;
                for(Vino vinos:usuariosRegistrados.get(i).getMeRecomendaron()){
                    if(vinos.getNombre().equals(nombreVino1)){
                        queueADevolver.add(vino2);
                    }
                    else if(vinos.getNombre().equals(nombreVino2)){
                        queueADevolver.add(vino1);
                    }
                    else{
                        queueADevolver.add(vinos);
                    }
                }
                usuariosRegistrados.get(i).setMeRecomendaron(queueADevolver);}
        }
    if (!personaEsta || !vino1Esta || !vino2Esta){
    throw new EntidadNoExiste("O el vino no esta o la persona no esta.");}
    }

    @Override
    public void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste {
        Queue<Vino> queueADevolver= new LinkedList<>();
        for(int i = 0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedula){
                for(Vino vinos:usuariosRegistrados.get(i).getMeRecomendaron()){
                    if(!queueADevolver.contains(vinos)){
                        queueADevolver.add(vinos);
                    }
                }
                if(usuariosRegistrados.get(i).getMeRecomendaron().size()==queueADevolver.size()){
                    throw new EntidadNoExiste("No esta el vino mas de una vez o no esta");
                }
                usuariosRegistrados.get(i).setMeRecomendaron(queueADevolver);
            }
        }

    }
}
