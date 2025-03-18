package array;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int op;
        double monto;
        boolean estado = true;

        // Lista para almacenar las cuentas bancarias
        List<CuentaBancaria> lstBanco = new ArrayList<>();

        // Se obtiene una instancia de CuentaBancaria
        CuentaBancaria cl1 = CuentaBancaria.obtenerInstancia();
        do {
            System.out.println("""
                    1. CREAR CLIENTE
                    2. MOSTRAR CLIENTES
                    3. MOSTRAR INFORMACION DE CUENTA ESPECIFICA
                    4. DEPOSITAR DINERO
                    5. RETIRAR DINERO
                    6. SALIR""");
            op = teclado.nextInt();

            switch (op) {
                case 1 -> {
                    // Solicitar datos del cliente y crear la cuenta bancaria
                    System.out.println("INGRESE NOMBRE DEL TITULAR");
                    cl1.setTitular(teclado.next());
                    System.out.println("INGRESE SALDO DE LA CUENTA");
                    cl1.setSaldo(teclado.nextDouble());
                    System.out.println("INGRESE EL NUMERO DE CUENTA");
                    cl1.setNumeroCuenta(teclado.nextInt());

                    lstBanco.add(new CuentaBancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta()));
                }
                case 2 -> {
                    // Mostrar la información de todas las cuentas bancarias
                    for (CuentaBancaria cu : lstBanco) {
                        System.out.println(lstBanco);
                    }
                }
                case 3 -> {
                    // Buscar una cuenta específica por el nombre del titular
                    String Ncuenta;
                    System.out.println("INGRESE TITULAR DE CUENTA");
                    Ncuenta = teclado.next();
                    for (int i = 0; i < lstBanco.size(); i++) {
                        if (lstBanco.get(i).getTitular().equalsIgnoreCase(Ncuenta)) {
                            System.out.println(lstBanco.get(i));
                        }
                    }
                }
                case 4 -> {
                    // Realizar un depósito en una cuenta específica // se agrego un condicional
                    System.out.println("DEPOSITAR DINERO");
                    System.out.println("EL MÁXIMO A DEPOSITAR ES DE 500000 PESOS");
                    System.out.println("SELECCIONA EL NUMERO DE CUENTA A LA QUE QUIERES DEPOSITAR DINERO");

                    int numeroCuenta = teclado.nextInt();

                    boolean cuentaEncontrada = false;
                    for (CuentaBancaria cuenta : lstBanco) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {
                            cuentaEncontrada = true;
                            System.out.println("CUENTA ENCONTRADA: " + cuenta);
                            System.out.println("INGRESE LA CANTIDAD A DEPOSITAR:");
                            double deposito = teclado.nextDouble();
                            if (deposito < 500000 && deposito > 0) {
                                cuenta.setSaldo(cuenta.getSaldo() + deposito);
                                System.out.println("DEPÓSITO REALIZADO");
                                break;
                            } else {
                                System.out.println("EL DEPÓSITO EXCEDE EL MÁXIMO PERMITIDO O ES INVÁLIDO");
                            }
                        }
                    }
                    if (!cuentaEncontrada) {
                        System.out.println("CUENTA NO ENCONTRADA.");
                    }
                }
                case 5 -> {
                    // Realizar un retiro de una cuenta específica // otro condicional para en el caso de no encontrar la cuenta
                    System.out.println("RETIRAR DINERO");
                    System.out.println("SELECCIONA EL NUMERO DE CUENTA DE LA QUE QUIERES RETIRAR DINERO");

                    int numeroCuenta = teclado.nextInt();

                    boolean cuentaEncontrada = false;
                    for (CuentaBancaria cuenta : lstBanco) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {
                            cuentaEncontrada = true;
                            System.out.println("CUENTA ENCONTRADA: " + cuenta);
                            System.out.println("INGRESE LA CANTIDAD A RETIRAR:");
                            double retiro = teclado.nextDouble();
                            if (retiro < cuenta.getSaldo() && retiro > 0) {
                                cuenta.setSaldo(cuenta.getSaldo() - retiro);
                                System.out.println("RETIRO REALIZADO");
                                break;
                            } else {
                                System.out.println("EL RETIRO NO PUEDE SER REALIZADO");
                            }
                        }
                    }
                    if (!cuentaEncontrada) {
                        System.out.println("CUENTA NO ENCONTRADA.");
                    }
                }
                case 6 -> {
                    // Finalizar el programa
                    System.out.println("SALIENDO...");
                    estado = false;
                }
            }
        } while (estado);
    }
}
