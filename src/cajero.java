import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class cajero {

    private static final String MOVIMIENTOS_FILE = "movimientos.txt";

    public static void main(String[] args) {
        //Vamos a crear la primera parte del proyecto

        Scanner sc = new Scanner(System.in);

        //atributos
        boolean salir = false;
        double cantidad = 1000.00;

        if (!verificarArchivoExiste()) {
            System.out.println("Error: No se pudo crear o abrir el archivo.");
            return;
        }

        while(salir == false){

            System.out.println("Tienes un par de opciones, que quieres hacer");
            System.out.println("1. Retirar fondos");
            System.out.println("2. Ingresar fondos");
            System.out.println("3- Consulta de movimientos");
            System.out.println("4. Salir");
            int opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Dime cuánto quieres retirar");
                    double retirar = sc.nextDouble();
                    if (retirar <= cantidad) {
                        cantidad -= retirar;
                        registrarMovimiento("Retiro", retirar);
                    } else {
                        System.out.println("No tienes suficientes fondos para retirar esa cantidad.");
                    }
                    break;
                case 2:
                    System.out.println("Dime cuánto quieres ingresar");
                    double anadir = sc.nextDouble();
                    sc.nextLine();
                    cantidad += anadir;
                    registrarMovimiento("Ingreso", anadir);
                    break;
                case 3:
                    consultarMovimientos();
                    break;
                case 4 :
                    System.out.println("Adios");
                    salir = true;
                    break;
                default:
                    System.out.println("No has introducido un numero correctamente");
            }
        }
    }

    private static void registrarMovimiento(String tipoMovimiento, double cantidad) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MOVIMIENTOS_FILE, true))) {
            writer.write(tipoMovimiento + ": " + cantidad + "\n");
            System.out.println("Movimiento registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al registrar el movimiento en el archivo.");
            e.printStackTrace();
        }
    }

    private static void consultarMovimientos() {
        System.out.println("----- Movimientos -----");
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIMIENTOS_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer los movimientos del archivo");
        }
        System.out.println("------------------------");
    }

    private static boolean verificarArchivoExiste() {
        File file = new File(MOVIMIENTOS_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Archivo creado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo.");
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
