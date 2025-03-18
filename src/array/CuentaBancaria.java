package array;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private int numeroCuenta;

    private static CuentaBancaria instancia;

    public static CuentaBancaria obtenerInstancia() {
        if (instancia == null) {
            instancia = new CuentaBancaria();
        }
        return instancia;
    }

    public CuentaBancaria(String titular, double saldo, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaBancaria() {

    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancariaa{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta=" + numeroCuenta +
                '}';
    }

    public void depositarDinero(double monto) {

        this.saldo += monto;

    }

    public void retirarDinero(double monto) {

        this.saldo -= monto;

    }

    public void mostrarInformacion() {

        System.out.println("el nombre del titular es " + titular);
        System.out.println("la cantidad del salgo es " + saldo);
        System.out.println("el nùmero de cuenta es " + numeroCuenta);
    }
}

