package co.edu.uniquindio;

public class Funcion {
    private final String pelicula;
    private final String sala;
    private final String horario;

    public Funcion(String pelicula, String sala, String horario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return pelicula + " - Sala " + sala + " - " + horario;
    }
}