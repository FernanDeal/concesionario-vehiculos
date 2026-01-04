package concesionario;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
    private Semaphore semaforo;
    private String nombreCliente;
    private static int contadorVehiculos = 0;
    private static final Object lock = new Object();
    
    public Cliente(String nombre, Semaphore semaforo) {
        this.nombreCliente = nombre;
        this.semaforo = semaforo;
    }
    
    @Override
    public void run() {
        try {
            semaforo.acquire();
            
            int numeroVehiculo;
            synchronized(lock) {
                contadorVehiculos++;
                numeroVehiculo = ((contadorVehiculos - 1) % 4) + 1;
            }
            
            System.out.println(nombreCliente + " ... probando vehículo ... " + numeroVehiculo);
            Thread.sleep((long)(2000 + Math.random() * 2000));
            System.out.println(nombreCliente + " ... terminó de probar el vehículo ... " + numeroVehiculo);
            
            semaforo.release();
            
        } catch (InterruptedException e) {
            System.err.println("Error en " + nombreCliente + ": " + e.getMessage());
        }
    }
}
