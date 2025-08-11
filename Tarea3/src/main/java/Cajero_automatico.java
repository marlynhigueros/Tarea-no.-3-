import java.util.ArrayList;
import java.util.Scanner;

public class Cajero_automatico {

    // P M M
    public static void mostrarMenu() {
        System.out.println("\n1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("\nOpción: ");
    }

    // P M S
    public static void consultarSaldo(double saldo, ArrayList<String> historial) {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo);
        historial.add("Consulta de saldo");
    }

    // P R D
    public static void depositarDinero(double[] saldo, ArrayList<String> historial, Scanner sc) {
        System.out.print("Ingrese el monto a depositar: Q");
        double deposito = sc.nextDouble();
        if (deposito > 0) {
            saldo[0] += deposito;
            System.out.printf("Depósito exitoso. Nuevo saldo: Q%.2f\n", saldo[0]);
            historial.add("Depósito de Q" + String.format("%.2f", deposito));
        } else {
            System.out.println("Monto inválido.");
        }
    }

    // P R R
    public static void retirarDinero(double[] saldo, ArrayList<String> historial, Scanner sc) {
        System.out.print("Ingrese el monto a retirar: Q");
        double retiro = sc.nextDouble();
        if (retiro > 0 && retiro <= saldo[0]) {
            saldo[0] -= retiro;
            System.out.printf("Retiro exitoso. Nuevo saldo: Q%.2f\n", saldo[0]);
            historial.add("Retiro de Q" + String.format("%.2f", retiro));
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    // P P C F P
    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        double[] saldo = {1500.00};
        ArrayList<String> historial = new ArrayList<>();
        int opcion;

        System.out.println("Bienvenido al Cajero Automático");

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo[0], historial);
                    break;
                case 2:
                    depositarDinero(saldo, historial, sc);
                    break;
                case 3:
                    retirarDinero(saldo, historial, sc);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        // M H T
        System.out.println("\n--- Historial de transacciones ---");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }

        sc.close();
    }

    // Método main
    public static void main(String[] args) {
        iniciarSesion();
    }
}