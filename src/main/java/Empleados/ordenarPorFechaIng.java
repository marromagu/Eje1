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
public class ordenarPorFechaIng implements Comparator<Empleado>{

    @Override
    public int compare(Empleado o1, Empleado o2) {
        return o1.getFechaIng().compareTo(o2.getFechaIng());
    }
    
}
