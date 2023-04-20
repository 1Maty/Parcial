import java.util.LinkedList;

public class TuVinoImpl implements TuVinoMgt  {
    public LinkedList<Vino> getVinosRegistrados() {
        return vinosRegistrados;
    }

    private LinkedList<Vino> vinosRegistrados= new LinkedList<Vino>();
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
            if(vinosRegistrados.get(i).getNombre()==nombreVino){
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
        for(int i =0; i<usuariosRegistrados.size();i++){
            if(usuariosRegistrados.get(i).getCedula()==cedula){
                esta_usuario=true;
                for(int q=0; i<vinosRegistrados.size();q++){
                    if(vinosRegistrados.get(q).getNombre().equals(nombreVino)){
                        esta_usuario=true;
                        usuariosRegistrados.get(i).getMeRecomendaron().add(vinosRegistrados.get(q));
            }}
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
            }
        }
    return salida;
    }
}
