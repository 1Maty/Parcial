public interface TuVinoMgt {
    void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste;
    void agregarVinoQueGusta(int	cedula,	String	nombreVino) throws EntidadNoExiste;
    void	agregarRecomendación(int	cedula,	int	cedulaARecomendar,	String	nombreVino);
    Vino obtenerProximaRecomendación(int cedula);
}
