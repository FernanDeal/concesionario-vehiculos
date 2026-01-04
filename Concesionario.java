package concesionario;

import java.util.concurrent.Semaphore;

public class Concesionario {
    public static void main(String[] args) {
        Semaphore semaforoVehiculos = new Semaphore(4);
        
        System.out.println("=== SIMULACIÓN CONCESIONARIO ===");
        System.out.println("4 vehículos disponibles para 9 clientes\n");
        
        Cliente[] clientes = new Cliente[9];
        
        for (int i = 0; i < 9; i++) {
            clientes[i] = new Cliente("Cliente" + (i + 1), semaforoVehiculos);
            clientes[i].start();
        }
        
        for (int i = 0; i < 9; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n=== TODOS LOS CLIENTES HAN PROBADO LOS VEHÍCULOS ===");
    }
}
