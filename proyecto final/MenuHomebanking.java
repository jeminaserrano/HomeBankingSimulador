import java.util.Scanner;

public class MenuHomebanking {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        // Datos del usuario
        String nombre = "Jemina";
        String DNI = "1234567890";
        String estadoCivil = "Soltera";

        // Banco
        double saldo = 350000; 
        double luz = 2500; 
        double gas = 8300;
        double agua = 1500;
        double internet = 12000;

        do {
            System.out.println("\nMenú principal:");
            System.out.println("1. Datos del usuario");
            System.out.println("2. Saldo");
            System.out.println("3. Transferencia");
            System.out.println("4. Pago online");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = teclado.nextInt();
            teclado.nextLine(); // Limpia buffer

            switch (opcion) { 
                case 1: // Datos personales
                    System.out.println("\nDatos del usuario:");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("DNI: " + DNI);
                    System.out.println("Estado Civil: " + estadoCivil);

                    System.out.println("¿Deseas volver al menú principal (1) o salir del homebanking (2)?");
                    int respuesta1 = teclado.nextInt();
                    teclado.nextLine();

                    if (respuesta1 == 2) {
                        salir = true;
                    }
                    break;

                case 2: // Saldo disponible
                    System.out.println("\nSaldo disponible: $" + saldo);

                    System.out.println("¿Deseas volver al menú principal (1) o salir del homebanking (2)?");
                    int respuesta2 = teclado.nextInt();
                    teclado.nextLine();

                    if (respuesta2 == 2) {
                        salir = true;
                    }
                    break;    

                case 3: // Transferencia
                    System.out.println("\nIngresa un CBU o ALIAS:");
                    String numeroCuentaIngresado = teclado.nextLine();
                    System.out.println("El CBU ingresado es: " + numeroCuentaIngresado);
                    System.out.print("Ingresa el monto a transferir: ");
                    double montoTransferencia = teclado.nextDouble();
                    teclado.nextLine();

                    if (montoTransferencia > 0 && montoTransferencia <= saldo) {
                        saldo -= montoTransferencia;
                        System.out.println("Transferencia exitosa.");
                        System.out.println("Tu saldo actual es: $" + saldo);
                    } else {
                        System.out.println("Monto no válido o saldo insuficiente.");
                    }

                    System.out.println("¿Deseas volver al menú principal (1) o salir del homebanking (2)?");
                    int respuesta3 = teclado.nextInt();
                    teclado.nextLine();

                    if (respuesta3 == 2) {
                        salir = true;
                    }
                    break;

                case 4: // Pago online
                    boolean pagoSalir = false;
                    do {
                        System.out.println("\n¿Qué servicio desea pagar?");
                        System.out.println("1. Luz $2500");
                        System.out.println("2. Gas $8300");
                        System.out.println("3. Agua $1500");
                        System.out.println("4. Internet $12000");
                        System.out.print("Ingrese una opción: ");
                        int pagoDeServicio = teclado.nextInt();
                        teclado.nextLine();

                        double montoAPagar = 0;

                        switch (pagoDeServicio) {
                            case 1: montoAPagar = luz; break;
                            case 2: montoAPagar = gas; break;
                            case 3: montoAPagar = agua; break;
                            case 4: montoAPagar = internet; break;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                                continue;
                        }

                        if (montoAPagar > 0 && saldo >= montoAPagar) {
                            saldo -= montoAPagar;
                            System.out.println("Pago realizado con éxito.");
                            System.out.println("Saldo actual: $" + saldo);
                        } else {
                            System.out.println("Monto no válido o saldo insuficiente.");
                        }

                        System.out.println("¿Desea realizar otro pago? (1: Sí / 2: No)");
                        int respuestaPago = teclado.nextInt();
                        teclado.nextLine();

                        if (respuestaPago != 1) {
                            pagoSalir = true;
                        }

                    } while (!pagoSalir);

                    System.out.println("¿Deseas volver al menú principal? (1: Sí / 2: No)");
                    int respuestaPagoPrincipal = teclado.nextInt();
                    teclado.nextLine();

                    if (respuestaPagoPrincipal != 1) {
                        salir = true;
                    }
                    break;

                case 5: // Salir
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (!salir);

        System.out.println("¡Gracias por usar el homebanking!");
        teclado.close();
    }
}
