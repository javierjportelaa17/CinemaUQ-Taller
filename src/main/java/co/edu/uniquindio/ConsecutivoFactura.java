package co.edu.uniquindio;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class ConsecutivoFactura {

    private final AtomicInteger ultimo = new AtomicInteger(0);

    private ConsecutivoFactura() { }

    private static class Holder {
        private static final ConsecutivoFactura INSTANCIA = new ConsecutivoFactura();
    }

    public static ConsecutivoFactura getInstancia() {
        return Holder.INSTANCIA;
    }

    public int siguiente() {
        return ultimo.incrementAndGet();
    }
}