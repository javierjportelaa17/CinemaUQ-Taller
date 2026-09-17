package co.edu.uniquindio;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class MainFactura{
public static void main(String[] args) throws InterruptedException {


    ConsecutivoFactura a = ConsecutivoFactura.getInstancia();
    ConsecutivoFactura b = ConsecutivoFactura.getInstancia();
    System.out.println("a == b -> " + (a == b));



    Set<Integer> numerosGenerados = ConcurrentHashMap.newKeySet();
    Runnable tarea = () -> {
        for (int i = 0; i < 100; i++) {
            int numero = ConsecutivoFactura.getInstancia().siguiente();
            if (!numerosGenerados.add(numero)) {
                System.out.println("¡NÚMERO REPETIDO! -> " + numero);
            }
        }
    };

    Thread[] hilos = new Thread[10];
    for (int i = 0; i < 10; i++) {
        hilos[i] = new Thread(tarea);
        hilos[i].start();
    }
    for (Thread hilo : hilos) {
        hilo.join();
    }

    System.out.println("Total de números generados: " + numerosGenerados.size());
    System.out.println("¿Hay repetidos? -> " + (numerosGenerados.size() != 1000));
}
}
