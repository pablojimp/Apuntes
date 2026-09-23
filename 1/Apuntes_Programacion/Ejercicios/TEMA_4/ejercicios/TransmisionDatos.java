package ejercicios;

import java.util.Scanner;

public class TransmisionDatos {
    
    // Constante: Velocidad de propagación en medio físico (aproximadamente 2/3 de la velocidad de la luz)
    
    private Scanner scanner;
    private ConversorUnidades conversor;
    
    public TransmisionDatos() {
        scanner = new Scanner(System.in);
        conversor = new ConversorUnidades();
    }
    
    /**
     * Método principal que ejecuta el programa
     */
    public static void main(String[] args) {
        TransmisionDatos programa = new TransmisionDatos();
        programa.ejecutar();
    }
    
    /**
     * Ejecuta el menú principal del programa
     */
    public void ejecutar() {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opción: ");
            
            switch(opcion) {
                case 1:
                    resolverProblemaTransmision();
                    break;
                case 2:
                    convertirUnidades();
                    break;
                case 3:
                    mostrarExplicacionTeorica();
                    break;
                case 4:
                    resolverEjemploGuiado();
                    break;
                case 0:
                    System.out.println("\n¡Hasta pronto!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intenta de nuevo.");
            }
            
            if(opcion != 0) {
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();
            }
            
        } while(opcion != 0);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal
     */
    private void mostrarMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    CALCULADORA DE TRANSMISIÓN DE DATOS EN REDES");
        System.out.println("=".repeat(60));
        System.out.println("1. Resolver problema de transmisión");
        System.out.println("2. Conversor de unidades");
        System.out.println("3. Explicación teórica");
        System.out.println("4. Resolver ejemplo guiado");
        System.out.println("0. Salir");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Resuelve un problema completo de transmisión
     */
    private void resolverProblemaTransmision() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RESOLVER PROBLEMA DE TRANSMISIÓN");
        System.out.println("=".repeat(60));
        
        // Recoger datos del usuario
        double tamañoArchivo = leerDouble("Tamaño del archivo (bytes): ");
        double tamañoPaquete = leerDouble("Tamaño del paquete de datos (bytes): ");
        double tamañoCabecera = leerDouble("Tamaño de la cabecera (bytes): ");
        double velocidadEnlace = leerDouble("Velocidad del enlace (Mbps): ");
        double distancia = leerDouble("Distancia entre torres (Km): ");
        
        // Calcular y mostrar resultados
        CalculadoraTransmision calc = new CalculadoraTransmision(
            tamañoArchivo, tamañoPaquete, tamañoCabecera, 
            velocidadEnlace, distancia
        );
        
        calc.mostrarResultadosCompletos();
    }
    
    /**
     * Función de conversión de unidades
     */
    private void convertirUnidades() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("CONVERSOR DE UNIDADES");
        System.out.println("=".repeat(60));
        System.out.println("1. Convertir velocidad (Mbps, Gbps, bps)");
        System.out.println("2. Convertir tamaño de datos (bytes, KB, MB, GB)");
        System.out.println("3. Convertir distancia (m, Km)");
        System.out.println("4. Convertir tiempo (s, ms, µs, ns)");
        
        int opcion = leerEntero("Selecciona tipo de conversión: ");
        
        switch(opcion) {
            case 1:
                conversor.convertirVelocidad();
                break;
            case 2:
                conversor.convertirTamañoDatos();
                break;
            case 3:
                conversor.convertirDistancia();
                break;
            case 4:
                conversor.convertirTiempo();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
    
    /**
     * Muestra la explicación teórica de los conceptos
     */
    private void mostrarExplicacionTeorica() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EXPLICACIÓN TEÓRICA");
        System.out.println("=".repeat(60));
        
        System.out.println("\n📚 CONCEPTOS FUNDAMENTALES:\n");
        
        System.out.println("1. TIEMPO DE TRANSMISIÓN (Tt):");
        System.out.println("   Es el tiempo que tarda en 'salir' todo el paquete del emisor.");
        System.out.println("   Fórmula: Tt = Tamaño_Paquete / Velocidad_Enlace");
        System.out.println("   Depende del tamaño del paquete y la velocidad del enlace.\n");
        
        System.out.println("2. TIEMPO DE PROPAGACIÓN (Tp):");
        System.out.println("   Es el tiempo que tarda la señal en viajar por el medio físico.");
        System.out.println("   Fórmula: Tp = Distancia / Velocidad_Propagación");
        System.out.println("   La velocidad típica es ~200,000 km/s (2/3 de la luz).\n");
        
        System.out.println("3. TIEMPO TOTAL DE IDA (T_ida):");
        System.out.println("   Tiempo desde que empieza a transmitir hasta que llega completo.");
        System.out.println("   Fórmula: T_ida = Tt + Tp\n");
        
        System.out.println("4. TIEMPO DE CONFIRMACIÓN (ACK):");
        System.out.println("   El receptor envía un paquete pequeño de confirmación (ACK).");
        System.out.println("   Este ACK también tiene tiempo de transmisión y propagación.\n");
        
        System.out.println("5. TIEMPO ROUND-TRIP (RTT):");
        System.out.println("   Tiempo completo: envío + espera + confirmación recibida.");
        System.out.println("   RTT = Tt_datos + Tp + Tt_ACK + Tp\n");
        
        System.out.println("6. PAQUETES MÚLTIPLES:");
        System.out.println("   Si el archivo es mayor que el paquete, se divide en varios.");
        System.out.println("   Número de paquetes = ⌈Tamaño_Archivo / Tamaño_Datos⌉");
        System.out.println("   Cada paquete necesita su propia confirmación.\n");
        
        System.out.println("7. RELACIÓN CON TEMPORIZADORES:");
        System.out.println("   Los temporizadores (timeouts) deben ser > RTT para evitar");
        System.out.println("   retransmisiones innecesarias. Típicamente: Timeout ≈ 2×RTT\n");
        
        System.out.println("=".repeat(60));
    }
    
    /**
     * Resuelve un ejemplo paso a paso
     */
    private void resolverEjemploGuiado() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EJEMPLO GUIADO - PASO A PASO");
        System.out.println("=".repeat(60));
        
        System.out.println("\nEJEMPLO:");
        System.out.println("Archivo de 2000 bytes, paquetes de 1000 bytes,");
        System.out.println("cabecera de 50 bytes, enlace de 120 Mbps, distancia 15 Km\n");
        
        CalculadoraTransmision calc = new CalculadoraTransmision(
            2000, 1000, 50, 120, 15
        );
        
        calc.mostrarResultadosDetallados();
    }
    
    /**
     * Lee un número entero del usuario
     */
    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while(!scanner.hasNextInt()) {
            System.out.print("Por favor, introduce un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
    
    /**
     * Lee un número decimal del usuario
     */
    private double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while(!scanner.hasNextDouble()) {
            System.out.print("Por favor, introduce un número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
}


/**
 * Clase que realiza los cálculos de transmisión
 */
class CalculadoraTransmision {
    private double tamañoArchivo;      // En bytes
    private double tamañoPaquete;      // En bytes (solo datos)
    private double tamañoCabecera;     // En bytes
    private double velocidadEnlace;    // En Mbps
    private double distancia;          // En Km
    
    private static final double VELOCIDAD_PROPAGACION = 2.0e8; // m/s
    
    public CalculadoraTransmision(double tamañoArchivo, double tamañoPaquete, 
                                  double tamañoCabecera, double velocidadEnlace, 
                                  double distancia) {
        this.tamañoArchivo = tamañoArchivo;
        this.tamañoPaquete = tamañoPaquete;
        this.tamañoCabecera = tamañoCabecera;
        this.velocidadEnlace = velocidadEnlace;
        this.distancia = distancia;
    }
    
    /**
     * Calcula el número de paquetes necesarios
     */
    private int calcularNumeroPaquetes() {
        return (int) Math.ceil(tamañoArchivo / tamañoPaquete);
    }
    
    /**
     * Calcula el tiempo de transmisión de un paquete completo (datos + cabecera)
     */
    private double calcularTiempoTransmisionPaquete() {
        double tamañoTotal = tamañoPaquete + tamañoCabecera; // En bytes
        double tamañoBits = tamañoTotal * 8; // Convertir a bits
        double velocidadBps = velocidadEnlace * 1e6; // Convertir Mbps a bps
        return tamañoBits / velocidadBps; // En segundos
    }
    
    /**
     * Calcula el tiempo de transmisión del ACK (confirmación)
     */
    private double calcularTiempoTransmisionACK() {
        double tamañoBits = tamañoCabecera * 8; // Solo cabecera
        double velocidadBps = velocidadEnlace * 1e6;
        return tamañoBits / velocidadBps;
    }
    
    /**
     * Calcula el tiempo de propagación
     */
    private double calcularTiempoPropagacion() {
        double distanciaMetros = distancia * 1000; // Convertir Km a metros
        return distanciaMetros / VELOCIDAD_PROPAGACION; // En segundos
    }
    
    /**
     * Calcula el tiempo total hasta recibir el primer paquete
     */
    private double calcularTiempoPrimerPaquete() {
        return calcularTiempoTransmisionPaquete() + calcularTiempoPropagacion();
    }
    
    /**
     * Calcula el RTT (Round Trip Time) para un paquete
     */
    private double calcularRTT() {
        double Tt_datos = calcularTiempoTransmisionPaquete();
        double Tp = calcularTiempoPropagacion();
        double Tt_ACK = calcularTiempoTransmisionACK();
        
        return Tt_datos + Tp + Tt_ACK + Tp;
    }
    
    /**
     * Calcula el tiempo total para confirmar todos los paquetes
     */
    private double calcularTiempoTotalConfirmacion() {
        int numPaquetes = calcularNumeroPaquetes();
        double RTT = calcularRTT();
        
        // Tiempo total = RTT de cada paquete (enviados secuencialmente)
        return numPaquetes * RTT;
    }
    
    /**
     * Muestra todos los resultados de forma completa
     */
    public void mostrarResultadosCompletos() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RESULTADOS DEL CÁLCULO");
        System.out.println("=".repeat(60));
        
        int numPaquetes = calcularNumeroPaquetes();
        double Tt_paquete = calcularTiempoTransmisionPaquete();
        double Tp = calcularTiempoPropagacion();
        double Tt_ACK = calcularTiempoTransmisionACK();
        double tiempoPrimerPaquete = calcularTiempoPrimerPaquete();
        double RTT = calcularRTT();
        double tiempoTotal = calcularTiempoTotalConfirmacion();
        
        System.out.println("\n📊 DATOS DE ENTRADA:");
        System.out.println("   - Tamaño del archivo: " + tamañoArchivo + " bytes");
        System.out.println("   - Tamaño de datos por paquete: " + tamañoPaquete + " bytes");
        System.out.println("   - Tamaño de cabecera: " + tamañoCabecera + " bytes");
        System.out.println("   - Velocidad del enlace: " + velocidadEnlace + " Mbps");
        System.out.println("   - Distancia: " + distancia + " Km");
        
        System.out.println("\n📦 DIVISIÓN EN PAQUETES:");
        System.out.println("   - Número de paquetes necesarios: " + numPaquetes);
        System.out.println("   - Tamaño total por paquete: " + (tamañoPaquete + tamañoCabecera) + " bytes");
        
        System.out.println("\n⏱️  TIEMPOS CALCULADOS:");
        System.out.println("   - Tiempo de transmisión (paquete): " + formatearTiempo(Tt_paquete));
        System.out.println("   - Tiempo de propagación: " + formatearTiempo(Tp));
        System.out.println("   - Tiempo de transmisión (ACK): " + formatearTiempo(Tt_ACK));
        
        System.out.println("\n✅ RESPUESTAS:");
        System.out.println("   1. Tiempo en enviar el PRIMER PAQUETE:");
        System.out.println("      " + formatearTiempo(tiempoPrimerPaquete));
        System.out.println("      (Tiempo transmisión + Tiempo propagación)");
        
        System.out.println("\n   2. Tiempo ROUND-TRIP (RTT) de un paquete:");
        System.out.println("      " + formatearTiempo(RTT));
        System.out.println("      (Envío completo + recepción de confirmación)");
        
        System.out.println("\n   3. Tiempo TOTAL para confirmar TODOS los paquetes:");
        System.out.println("      " + formatearTiempo(tiempoTotal));
        System.out.println("      (" + numPaquetes + " paquetes × RTT)");
        
        System.out.println("\n💡 NOTA SOBRE TEMPORIZADORES:");
        double timeoutRecomendado = RTT * 2;
        System.out.println("   El timeout recomendado debería ser al menos:");
        System.out.println("   " + formatearTiempo(timeoutRecomendado) + " (2 × RTT)");
        
        System.out.println("\n" + "=".repeat(60));
    }
    
    /**
     * Muestra los resultados con explicación paso a paso
     */
    public void mostrarResultadosDetallados() {
        System.out.println("\n📋 PASO 1: Calcular número de paquetes");
        int numPaquetes = calcularNumeroPaquetes();
        System.out.println("   Paquetes = ⌈" + tamañoArchivo + " / " + tamañoPaquete + "⌉ = " + numPaquetes);
        
        System.out.println("\n📋 PASO 2: Tiempo de transmisión del paquete");
        double Tt_paquete = calcularTiempoTransmisionPaquete();
        double tamañoTotal = tamañoPaquete + tamañoCabecera;
        System.out.println("   Tamaño total = " + tamañoPaquete + " + " + tamañoCabecera + " = " + tamañoTotal + " bytes");
        System.out.println("   En bits = " + tamañoTotal + " × 8 = " + (tamañoTotal * 8) + " bits");
        System.out.println("   Velocidad = " + velocidadEnlace + " Mbps = " + (velocidadEnlace * 1e6) + " bps");
        System.out.println("   Tt = " + (tamañoTotal * 8) + " / " + (velocidadEnlace * 1e6) + " = " + formatearTiempo(Tt_paquete));
        
        System.out.println("\n📋 PASO 3: Tiempo de propagación");
        double Tp = calcularTiempoPropagacion();
        System.out.println("   Distancia = " + distancia + " Km = " + (distancia * 1000) + " m");
        System.out.println("   Velocidad propagación = 200,000 km/s = 2×10⁸ m/s");
        System.out.println("   Tp = " + (distancia * 1000) + " / 2×10⁸ = " + formatearTiempo(Tp));
        
        System.out.println("\n📋 PASO 4: Tiempo primer paquete llega al destino");
        double tiempoPrimerPaquete = calcularTiempoPrimerPaquete();
        System.out.println("   T_llegada = Tt + Tp = " + formatearTiempo(Tt_paquete) + " + " + formatearTiempo(Tp));
        System.out.println("   T_llegada = " + formatearTiempo(tiempoPrimerPaquete));
        
        System.out.println("\n📋 PASO 5: Tiempo de transmisión del ACK");
        double Tt_ACK = calcularTiempoTransmisionACK();
        System.out.println("   ACK solo tiene cabecera: " + tamañoCabecera + " bytes = " + (tamañoCabecera * 8) + " bits");
        System.out.println("   Tt_ACK = " + (tamañoCabecera * 8) + " / " + (velocidadEnlace * 1e6) + " = " + formatearTiempo(Tt_ACK));
        
        System.out.println("\n📋 PASO 6: Round-Trip Time (RTT)");
        double RTT = calcularRTT();
        System.out.println("   RTT = Tt_datos + Tp + Tt_ACK + Tp");
        System.out.println("   RTT = " + formatearTiempo(Tt_paquete) + " + " + formatearTiempo(Tp) + " + " + 
                          formatearTiempo(Tt_ACK) + " + " + formatearTiempo(Tp));
        System.out.println("   RTT = " + formatearTiempo(RTT));
        
        System.out.println("\n📋 PASO 7: Tiempo total para todos los paquetes");
        double tiempoTotal = calcularTiempoTotalConfirmacion();
        System.out.println("   Tiempo total = " + numPaquetes + " paquetes × RTT");
        System.out.println("   Tiempo total = " + numPaquetes + " × " + formatearTiempo(RTT));
        System.out.println("   Tiempo total = " + formatearTiempo(tiempoTotal));
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ RESPUESTAS FINALES:");
        System.out.println("   • Tiempo primer paquete: " + formatearTiempo(tiempoPrimerPaquete));
        System.out.println("   • Tiempo total confirmación: " + formatearTiempo(tiempoTotal));
        System.out.println("=".repeat(60));
    }
    
    /**
     * Formatea el tiempo en la unidad más apropiada
     */
    private String formatearTiempo(double segundos) {
        if (segundos >= 1) {
            return String.format("%.6f s", segundos);
        } else if (segundos >= 1e-3) {
            return String.format("%.6f ms (%.9f s)", segundos * 1e3, segundos);
        } else if (segundos >= 1e-6) {
            return String.format("%.6f µs (%.9f s)", segundos * 1e6, segundos);
        } else {
            return String.format("%.6f ns (%.12f s)", segundos * 1e9, segundos);
        }
    }
}


/**
 * Clase para convertir entre diferentes unidades
 */
class ConversorUnidades {
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Convierte velocidades de transmisión
     */
    public void convertirVelocidad() {
        System.out.println("\n--- CONVERSIÓN DE VELOCIDAD ---");
        System.out.println("1. bps → Mbps / Gbps");
        System.out.println("2. Mbps → bps / Gbps");
        System.out.println("3. Gbps → bps / Mbps");
        
        int opcion = leerEntero("Selecciona: ");
        double valor = leerDouble("Introduce el valor: ");
        
        switch(opcion) {
            case 1: // bps
                System.out.println("\nResultados:");
                System.out.println("  " + valor + " bps");
                System.out.println("  " + (valor / 1e6) + " Mbps");
                System.out.println("  " + (valor / 1e9) + " Gbps");
                break;
            case 2: // Mbps
                System.out.println("\nResultados:");
                System.out.println("  " + (valor * 1e6) + " bps");
                System.out.println("  " + valor + " Mbps");
                System.out.println("  " + (valor / 1e3) + " Gbps");
                break;
            case 3: // Gbps
                System.out.println("\nResultados:");
                System.out.println("  " + (valor * 1e9) + " bps");
                System.out.println("  " + (valor * 1e3) + " Mbps");
                System.out.println("  " + valor + " Gbps");
                break;
        }
    }
    
    /**
     * Convierte tamaños de datos
     */
    public void convertirTamañoDatos() {
        System.out.println("\n--- CONVERSIÓN DE TAMAÑO DE DATOS ---");
        System.out.println("1. bytes → KB / MB / GB");
        System.out.println("2. KB → bytes / MB / GB");
        System.out.println("3. MB → bytes / KB / GB");
        System.out.println("4. bits → bytes");
        System.out.println("5. bytes → bits");
        
        int opcion = leerEntero("Selecciona: ");
        double valor = leerDouble("Introduce el valor: ");
        
        switch(opcion) {
            case 1: // bytes
                System.out.println("\nResultados:");
                System.out.println("  " + valor + " bytes");
                System.out.println("  " + (valor / 1024) + " KB");
                System.out.println("  " + (valor / 1024 / 1024) + " MB");
                System.out.println("  " + (valor / 1024 / 1024 / 1024) + " GB");
                break;
            case 2: // KB
                System.out.println("\nResultados:");
                System.out.println("  " + (valor * 1024) + " bytes");
                System.out.println("  " + valor + " KB");
                System.out.println("  " + (valor / 1024) + " MB");
                System.out.println("  " + (valor / 1024 / 1024) + " GB");
                break;
            case 3: // MB
                System.out.println("\nResultados:");
                System.out.println("  " + (valor * 1024 * 1024) + " bytes");
                System.out.println("  " + (valor * 1024) + " KB");
                System.out.println("  " + valor + " MB");
                System.out.println("  " + (valor / 1024) + " GB");
                break;
            case 4: // bits a bytes
                System.out.println("\nResultado: " + (valor / 8) + " bytes");
                break;
            case 5: // bytes a bits
                System.out.println("\nResultado: " + (valor * 8) + " bits");
                break;
        }
    }
    
    /**
     * Convierte distancias
     */
    public void convertirDistancia() {
        System.out.println("\n--- CONVERSIÓN DE DISTANCIA ---");
        double valor = leerDouble("Introduce distancia en Km: ");
        
        System.out.println("\nResultados:");
        System.out.println("  " + valor + " Km");
        System.out.println("  " + (valor * 1000) + " m");
    }
    
    /**
     * Convierte tiempos
     */
    public void convertirTiempo() {
        System.out.println("\n--- CONVERSIÓN DE TIEMPO ---");
        System.out.println("1. segundos → ms / µs / ns");
        System.out.println("2. milisegundos → s / µs / ns");
        System.out.println("3. microsegundos → s / ms / ns");
        
        int opcion = leerEntero("Selecciona: ");
        double valor = leerDouble("Introduce el valor: ");
        
        switch(opcion) {
            case 1: // segundos
                System.out.println("\nResultados:");
                System.out.println("  " + valor + " s");
                System.out.println("  " + (valor * 1e3) + " ms");
                System.out.println("  " + (valor * 1e6) + " µs");
                System.out.println("  " + (valor * 1e9) + " ns");
                break;
            case 2: // milisegundos
                System.out.println("\nResultados:");
                System.out.println("  " + (valor / 1e3) + " s");
                System.out.println("  " + valor + " ms");
                System.out.println("  " + (valor * 1e3) + " µs");
                System.out.println("  " + (valor * 1e6) + " ns");
                break;
            case 3: // microsegundos
                System.out.println("\nResultados:");
                System.out.println("  " + (valor / 1e6) + " s");
                System.out.println("  " + (valor / 1e3) + " ms");
                System.out.println("  " + valor + " µs");
                System.out.println("  " + (valor * 1e3) + " ns");
                break;
        }
    }
    
    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while(!scanner.hasNextInt()) {
            System.out.print("Número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    
    private double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while(!scanner.hasNextDouble()) {
            System.out.print("Número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}