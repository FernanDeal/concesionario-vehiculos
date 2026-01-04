🚗 Control de Acceso a Vehículos - Concesionario
Trabajo de Enfoque - Programación de Servicios y Procesos
Técnico Superior en Desarrollo de Aplicaciones Multiplataforma
MEDAC - Enero 2026

📋 Descripción del Problema
Simulación de un concesionario de coches donde 9 clientes desean probar 4 vehículos de manera simultánea. El programa debe controlar el acceso concurrente para garantizar que nunca haya más de 4 clientes probando vehículos al mismo tiempo.

Este problema clásico de programación concurrente demuestra el uso de:

🧵 Multithreading (hilos)

🚦 Semáforos (control de acceso)

🔒 Sincronización (exclusión mutua)

🛠️ Tecnologías Utilizadas
Java SE 8+

java.util.concurrent.Semaphore - Control de recursos limitados

Thread - Programación multihilo

synchronized - Sincronización de datos compartidos

📁 Estructura del Proyecto
text
concesionario/
├── Cliente.java          # Clase Thread que representa cada cliente
└── Concesionario.java    # Clase principal con método main()
Cliente.java
Extiende Thread. Cada instancia representa un cliente que:

Intenta adquirir un permiso del semáforo (acquire())

Si no hay vehículos disponibles, se bloquea automáticamente

Asigna un número de vehículo (1-4) de forma sincronizada

Simula la prueba del vehículo (2-4 segundos)

Libera el permiso (release()) para el siguiente cliente

Concesionario.java
Clase principal que:

Crea un Semaphore con 4 permisos (4 vehículos)

Inicializa 9 hilos de clientes

Los ejecuta concurrentemente

Espera a que todos terminen (join())

🔧 Conceptos Implementados
Semáforos
java
Semaphore semaforoVehiculos = new Semaphore(4);
Limita el acceso concurrente a máximo 4 hilos simultáneos, representando los 4 vehículos disponibles.

Sincronización
java
synchronized(lock) {
    contadorVehiculos++;
    numeroVehiculo = ((contadorVehiculos - 1) % 4) + 1;
}
Protege la sección crítica para evitar condiciones de carrera en la asignación de vehículos.

Comunicación entre Hilos
java
clientes[i].join();
El hilo principal espera a que todos los clientes terminen antes de finalizar.

🚀 Compilación y Ejecución
Con package (estructura recomendada):
bash
# Compilar
javac concesionario/*.java

# Ejecutar
java concesionario.Concesionario
Sin package (alternativa):
bash
# Compilar
javac Cliente.java Concesionario.java

# Ejecutar
java Concesionario
📊 Ejemplo de Salida
text
=== SIMULACIÓN CONCESIONARIO ===
4 vehículos disponibles para 9 clientes

Cliente1 ... probando vehículo ... 1
Cliente2 ... probando vehículo ... 2
Cliente3 ... probando vehículo ... 3
Cliente4 ... probando vehículo ... 4
Cliente1 ... terminó de probar el vehículo ... 1
Cliente5 ... probando vehículo ... 1
Cliente3 ... terminó de probar el vehículo ... 3
Cliente6 ... probando vehículo ... 3
Cliente2 ... terminó de probar el vehículo ... 2
Cliente7 ... probando vehículo ... 2
Cliente4 ... terminó de probar el vehículo ... 4
Cliente8 ... probando vehículo ... 4
Cliente5 ... terminó de probar el vehículo ... 1
Cliente9 ... probando vehículo ... 1
Cliente6 ... terminó de probar el vehículo ... 3
Cliente7 ... terminó de probar el vehículo ... 2
Cliente8 ... terminó de probar el vehículo ... 4
Cliente9 ... terminó de probar el vehículo ... 1

=== TODOS LOS CLIENTES HAN PROBADO LOS VEHÍCULOS ===
Observación: El orden de ejecución varía en cada ejecución debido a la naturaleza concurrente del programa y las políticas de planificación del sistema operativo.

✅ Validación del Funcionamiento
El programa garantiza:

✓ Los 9 clientes prueban un vehículo

✓ Nunca hay más de 4 clientes probando simultáneamente

✓ Los 5 clientes restantes esperan bloqueados hasta que se libere un vehículo

✓ No hay condiciones de carrera en la asignación de vehículos

✓ Todos los recursos se liberan correctamente

🎓 Objetivos de Aprendizaje Cumplidos
Criterio	Descripción	Estado
RA 2. CE a)	Identificar situaciones útiles para varios hilos	✅
RA 1. CE c)	Reconocer características de programación concurrente	✅
RA 2. CE c)	Programar aplicaciones que implementen varios hilos	✅
RA 2. CE h)	Depurar y documentar los programas desarrollados	✅
🐛 Problemas Encontrados y Soluciones
1. Condición de Carrera
Problema: Sin sincronización, varios clientes podían obtener el mismo número de vehículo.
Solución: Bloque synchronized(lock) protege la asignación.

2. Orden No Determinista
Problema: Cada ejecución produce secuencias diferentes.
Solución: Es comportamiento esperado en concurrencia. No requiere corrección.

3. Gestión de Excepciones
Problema: InterruptedException debe capturarse adecuadamente.
Solución: Try-catch en método run() y main().

👤 Autor
Fernando Rueda García
Estudiante de Desarrollo de Aplicaciones Multiplataforma
MEDAC - 2026

📚 Referencias
Oracle Java Docs: Semaphore

Oracle Java Docs: Thread

Material didáctico: Programación de Servicios y Procesos - MEDAC

📄 Licencia
Proyecto académico - MEDAC 2026
