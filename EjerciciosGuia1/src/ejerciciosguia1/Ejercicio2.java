/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosguia1;

/**
 *
 * @author diego
 */
public class Ejercicio2 {
    public String notas(int[] notas){
        int mayores = 0, menores = 0;
        for(int i = 0; i < notas.length; i++){
            if (notas[i] >= 7){
                mayores++;
            }else{
                menores++;
            }    
        }
        
        return String.format("Hay %s notas mayores o iguales a 7, y %s notas menores a 7\n",
                mayores, menores);
    }
}
