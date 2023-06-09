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
public class ordenarPorNombre implements Comparator<Empleado>{

    @Override
    public int compare(Empleado o1, Empleado o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
