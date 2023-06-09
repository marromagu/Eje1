/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import java.util.Comparator;

/**
 *
 * @author DAM_T
 */
public class ordenarPorSalario implements Comparator<Empleado> {

    @Override
    public int compare(Empleado o1, Empleado o2) {
        if (o1.getSalario() > o2.getSalario()) {
            return 1;
        }
        if (o1.getSalario() < o2.getSalario()) {
            return -1;
        }
        return 0;
    }

}
