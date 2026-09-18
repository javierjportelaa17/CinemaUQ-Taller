package co.edu.uniquindio;

public class MainCompra {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Ana Torres", "1000123456");
        Cliente cliente2 = new Cliente("Luis Pérez", "1000987654");

        Funcion funcion1 = new Funcion("Interestelar", "3", "19:30");
        Funcion funcion2 = new Funcion("Dune 2", "1", "21:00");

        Combo comboGrande = new Combo("Combo Grande", 25000);

        Compra compraMinima = new Compra.Builder()
                .conCliente(cliente1)
                .conFuncion(funcion1)
                .conAsiento("F5")
                .build();

        Compra compraCompleta = new Compra.Builder()
                .conCliente(cliente2)
                .conFuncion(funcion2)
                .conAsiento("A1")
                .conAsiento("A2")
                .conCombo(comboGrande)
                .conPuntos(150)
                .conCortesia(false)
                .build();

        System.out.println("Compra mínima:   " + compraMinima);
        System.out.println("Compra completa: " + compraCompleta);

        try {
            new Compra.Builder()
                    .conFuncion(funcion1)
                    .conAsiento("B1")
                    .build();
            System.out.println("ERROR: no debería haber llegado aquí");
        } catch (IllegalStateException e) {
            System.out.println("OK, lanzó excepción esperada: " + e.getMessage());
        }
    }
}
