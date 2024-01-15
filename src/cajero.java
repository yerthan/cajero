import java.util.Scanner;

public class cajero {

    public static void main(String[] args) {
        //Vamos a crear la primera parte del proyecto

        Scanner sc = new Scanner(System.in);

        //atributos
        boolean salir = false;
        double cantidad = 1000.00;


        while(salir == false){

            System.out.println("tienes un par de opciones, que quieres hacer");
            System.out.println("1. Retirar fondos");
            System.out.println("2. Ingresar fondos");
            System.out.println("3- Consulta de movimientos");
            System.out.println("4. Salir");
            int opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Dime cuantos quieres retirar");
                    System.out.println("Tienes " + cantidad);
                    break;
                case 2:
                    System.out.println("Dime cuanto quieres ingresar");
                    double anadir = sc.nextDouble();
                    System.out.println("Vas a añadir, " + anadir);
                    cantidad += anadir;
                    System.out.println("Tienes en total " + cantidad);
                    break;
                case 3:
                    System.out.println("Mostrando todos los movimientos");
                case 4 :
                    System.out.println("Adios");
                    salir = true;
                    break;
                default:
                    System.out.println("No has introducido un numero correctamente");
            }
        }
    }
}
