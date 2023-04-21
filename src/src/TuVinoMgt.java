package src;

public interface TuVinoMgt {
    void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste;
    void agregarVinoQueGusta(int	cedula,	String	nombreVino) throws EntidadNoExiste;
    void	agregarRecomendación(int	cedula,	int	cedulaARecomendar,	String	nombreVino) throws EntidadNoExiste;
    Vino obtenerProximaRecomendación(int cedula);
    void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste;
    void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste;
}
