/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author DAM_T
 */
public class Empleado implements Comparable<Empleado>, Serializable {

    //COD FECHANAC FECHAING SALARIO NUMHIJ NOMBRE
    private int cod;
    private Fecha fechaNac;
    private Fecha fechaIng;
    private int salario;
    private int numHij;
    private String nombre;
    private String apellido;

    public Empleado(int cod, Fecha fechaNac, Fecha fechaIng, int salario, int numHij, String nombre, String apellido) {
        this.cod = cod;
        this.fechaNac = fechaNac;
        this.fechaIng = fechaIng;
        this.salario = salario;
        this.numHij = numHij;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(String linea) {
        Scanner s = new Scanner(linea).useDelimiter("#");
        this.cod = s.nextInt();
        this.fechaNac = new Fecha(s.nextInt(), s.nextInt(), s.nextInt());
        this.fechaIng = new Fecha(s.nextInt(), s.nextInt(), s.nextInt());
        this.salario = s.nextInt();
        this.numHij = s.nextInt();
        this.nombre = s.next();
        
        /*Scanner c = new Scanner(nombre).useDelimiter(", ");
        this.apellido = c.next();
        this.nombre = c.next();*/
        
        /*this.apellido = nombre.substring(0, nombre.indexOf(","));
        this.nombre = nombre.substring(nombre.indexOf(",") + 2);*/
        
        String[] nombreCompleto = nombre.split(", ");
        this.apellido = nombreCompleto[0];
        this.nombre = nombreCompleto[1];
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Fecha getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Fecha fechaIng) {
        this.fechaIng = fechaIng;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getNumHij() {
        return numHij;
    }

    public void setNumHij(int numHij) {
        this.numHij = numHij;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cod);
        sb.append(" ").append(fechaNac);
        sb.append(" ").append(fechaIng);
        sb.append(" ").append(salario);
        sb.append(" ").append(numHij);
        sb.append(" ").append(nombre);
        sb.append(" ").append(apellido);
        return sb.toString();
    }

    @Override
    public int compareTo(Empleado o) {
        if (this.cod > o.getCod()) {
            return 1;
        }
        if (this.cod < o.getCod()) {
            return -1;
        }
        return 0;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
