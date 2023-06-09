/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author DAM_T
 */
public class Empresa {

    private String nombreE;
    private HashMap<Integer, Empleado> miEmpresa;

    public Empresa() {
        this.nombreE = "Mario Romero S.A";
        this.miEmpresa = new HashMap<>();
    }

    public void cargarDatos() {
        FileReader fichero = null;
        BufferedReader br = null;
        Empleado miEmpleado;
        try {
            fichero = new FileReader("empleados.txt");
            br = new BufferedReader(fichero);
            String linea;
            linea = br.readLine();
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                miEmpleado = new Empleado(linea);
                añadirDatos(miEmpleado);
                linea = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
    }

    public void añadirDatos(Empleado miEmpleado) {
        miEmpresa.put(miEmpleado.getCod(), miEmpleado);

    }

    public void verDatos() {
        System.out.println(toString());
        System.out.println("KEY | COD | FECHANAC | FECHAING | SALARIO | NUMHIJ | NOMBRE | APELLIDOS\n");
        for (Integer value : miEmpresa.keySet()) {
            System.out.println(value+" "+miEmpresa.get(value));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre de la Empresa: ").append(nombreE);
        return sb.toString();
    }

    public void ordenarLista(Comparator criterio) {
        ArrayList<Empleado> miEmpresaArray = new ArrayList<>(miEmpresa.values());
        Collections.sort(miEmpresaArray, criterio);
        for (Empleado empleado : miEmpresaArray) {
            System.out.println(empleado);
        }
    }

    public void borrarEmpleado(int cod) {
        if (miEmpresa.remove(cod) != null) {
            System.out.println("Empleado Eliminado.");
        } else {
            System.out.println("No se ha podido borrar...");
        }
    }

    public void modificarEmpleadoSalario(int cod, int nuevoSalario) {
        miEmpresa.get(cod).setSalario(nuevoSalario);
        System.out.println("Empleado modificado: " + miEmpresa.get(cod).toString());
    }

    public void modificarEmpleadoNombre(int cod, String nuevoNombre) {
        miEmpresa.get(cod).setNombre(nuevoNombre);
        System.out.println("Empleado modificado: " + miEmpresa.get(cod).toString());
    }

    public void modificarEmpleadoNumeroHijos(int cod, int numeroHijos) {
        miEmpresa.get(cod).setNumHij(numeroHijos);
        System.out.println("Empleado modificado: " + miEmpresa.get(cod).toString());
    }

    public void modificarEmpleadoFechaIng(int cod, Fecha nuevaFecha) {
        miEmpresa.get(cod).setFechaIng(nuevaFecha);
        System.out.println("Empleado modificado: " + miEmpresa.get(cod).toString());
    }

    public void modificarEmpleadoFechaNac(int cod, Fecha nuevaFecha) {
        miEmpresa.get(cod).setFechaNac(nuevaFecha);
        System.out.println("Empleado modificado: " + miEmpresa.get(cod).toString());
    }

}
