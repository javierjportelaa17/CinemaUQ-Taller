package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private final Cliente cliente;
    private final Funcion funcion;
    private final List<String> asientos;
    private final Combo combo;
    private final int puntosRedimidos;
    private final boolean esCortesia;

    private Compra(Builder b) {
        this.cliente = b.cliente;
        this.funcion = b.funcion;
        this.asientos = b.asientos;
        this.combo = b.combo;
        this.puntosRedimidos = b.puntosRedimidos;
        this.esCortesia = b.esCortesia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public List<String> getAsientos() {
        return asientos;
    }

    public Combo getCombo() {
        return combo;
    }

    public int getPuntosRedimidos() {
        return puntosRedimidos;
    }

    public boolean isEsCortesia() {
        return esCortesia;
    }

    @Override
    public String toString() {
        return "Compra{cliente=" + cliente
                + ", funcion=" + funcion
                + ", asientos=" + asientos
                + ", combo=" + combo
                + ", puntosRedimidos=" + puntosRedimidos
                + ", esCortesia=" + esCortesia + "}";
    }

    public static class Builder {

        private Cliente cliente;
        private Funcion funcion;
        private List<String> asientos = new ArrayList<>();
        private Combo combo;
        private int puntosRedimidos = 0;
        private boolean esCortesia = false;

        public Builder conCliente(Cliente c) {
            this.cliente = c;
            return this;
        }

        public Builder conFuncion(Funcion f) {
            this.funcion = f;
            return this;
        }

        public Builder conAsiento(String asiento) {
            this.asientos.add(asiento);
            return this;
        }

        public Builder conCombo(Combo c) {
            this.combo = c;
            return this;
        }

        public Builder conPuntos(int puntos) {
            this.puntosRedimidos = puntos;
            return this;
        }

        public Builder conCortesia(boolean esCortesia) {
            this.esCortesia = esCortesia;
            return this;
        }

        public Compra build() {
            if (cliente == null || funcion == null) {
                throw new IllegalStateException(
                        "Cliente y función son obligatorios para completar la compra");
            }

            if (asientos.isEmpty()) {
                throw new IllegalStateException(
                        "Debe seleccionar al menos un asiento");
            }

            return new Compra(this);
        }
    }
    }
