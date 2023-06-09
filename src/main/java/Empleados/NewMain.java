/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Empleados;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author CFGS_M
 */
public class NewMain {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner r = new Scanner(System.in);

        int opcion = menu();
        int cod, op;
        Empresa miEmpresa = cargarFichero();
        if (miEmpresa == null) {
            miEmpresa = new Empresa();
        }
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    miEmpresa.cargarDatos();
                    break;
                case 2:
                    miEmpresa.verDatos();
                    break;
                case 3:
                    op = menu2();
                    while (op != 6) {
                        switch (op) {
                            case 1 -> {
                                miEmpresa.ordenarLista(new ordenarPorCod());
                            }
                            case 2 -> {
                                miEmpresa.ordenarLista(new ordenarPorFechaIng());
                            }
                            case 3 -> {
                                miEmpresa.ordenarLista(new ordenarPorFechaNac());
                            }
                            case 4 -> {
                                miEmpresa.ordenarLista(new ordenarPorNombre());
                            }
                            case 5 -> {
                                //miEmpresa.ordenarLista(new ordenarPorSalario());
                                //Ordenar al reves
                                miEmpresa.ordenarLista(Collections.reverseOrder(new ordenarPorSalario()));

                            }
                        }
                        op = menu2();
                    }

                    break;
                case 4:
                    System.out.println("Escribe el codigo del empleado a borrar:");
                    cod = r.nextInt();
                    miEmpresa.borrarEmpleado(cod);
                    break;
                case 5:
                    System.out.println("Escribe el codigo del empleado a modificar:");
                    cod = r.nextInt();
                    System.out.println("¿Que dato quiere modificar?");
                    op = menu3();
                    int valor,
                     dia,
                     mes,
                     año;
                    String valor2;
                    Fecha nuevaFecha;
                    while (op != 6) {
                        switch (op) {
                            case 1 -> {
                                System.out.println("Escriba el nuevo Salario");
                                valor = r.nextInt();
                                miEmpresa.modificarEmpleadoSalario(cod, valor);
                            }
                            case 2 -> {
                                System.out.println("Escriba la nueva Fecha de Ingreso");
                                System.out.println("Dia:");
                                dia = r.nextInt();
                                System.out.println("Mes:");
                                mes = r.nextInt();
                                System.out.println("Año:");
                                año = r.nextInt();
                                nuevaFecha = new Fecha(dia, mes, año);
                                miEmpresa.modificarEmpleadoFechaIng(cod, nuevaFecha);
                            }
                            case 3 -> {
                                System.out.println("Escriba la nueva Fecha de Nacimiento");
                                System.out.println("Dia:");
                                dia = r.nextInt();
                                System.out.println("Mes:");
                                mes = r.nextInt();
                                System.out.println("Año:");
                                año = r.nextInt();
                                nuevaFecha = new Fecha(dia, mes, año);
                                miEmpresa.modificarEmpleadoFechaNac(cod, nuevaFecha);

                            }
                            case 4 -> {
                                System.out.println("Escriba el nuevo nombre");
                                valor2 = r.nextLine();
                                miEmpresa.modificarEmpleadoNombre(cod, valor2);
                            }
                            case 5 -> {
                                System.out.println("Escriba el nuevo numero de hijos");
                                valor = r.nextInt();
                                miEmpresa.modificarEmpleadoNumeroHijos(cod, valor);
                            }
                        }
                        op = menu3();
                    }
                    break;

                default:
            }
            opcion = menu();
        }
        miEmpresa.guardarFichero();

    }

    public static int menu() {
        Scanner r = new Scanner(System.in);
        int op;
        System.out.println("");
        System.out.println("1.- Cargar Datos.");
        System.out.println("2.- Ver Datos.");
        System.out.println("3.- Ordenar Datos.");
        System.out.println("4.- Borrar Empleado.");
        System.out.println("5.- Modificar Datos Empleados.");
        System.out.println("0.- Salir.");
        op = r.nextInt();

        return op;
    }

    public static int menu2() {
        Scanner r = new Scanner(System.in);
        int op;
        System.out.println("");
        System.out.println("1.- Por Codigo.");
        System.out.println("2.- Por Fecha Ingreso.");
        System.out.println("3.- Por Fecha Nacimiento.");
        System.out.println("4.- Por Nombre.");
        System.out.println("5.- Por Salario.");
        System.out.println("6.- Salir.");
        op = r.nextInt();

        return op;
    }

    public static int menu3() {
        Scanner r = new Scanner(System.in);
        int op;
        System.out.println("");
        System.out.println("1.- Modificar Salario.");
        System.out.println("2.- Modificar Fecha Ingreso.");
        System.out.println("3.- Modificar Fecha Nacimiento.");
        System.out.println("4.- Modificar Nombre.");
        System.out.println("5.- Modificar Numero de Hijos.");
        System.out.println("6.- Salir.");
        op = r.nextInt();

        return op;
    }

    public static Empresa cargarFichero() {
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;
        Empresa miEmpresa = null;
        try {
            fichero = new FileInputStream("Empleados.dat");
            entrada = new ObjectInputStream(fichero);
            miEmpresa = (Empresa) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el fichero Empleados.dat");
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            }
        }
        return miEmpresa;
    }
}
