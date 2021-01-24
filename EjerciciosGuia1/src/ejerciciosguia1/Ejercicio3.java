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
public class Ejercicio3 {
    public String countPares(int[] numeros){
        int pares = 0, impares = 0;
        for(int i = 0; i < numeros.length; i++){
            if (numeros[i] %2 == 0){
                pares++;
            }else{
                impares++;
            }    
        }
        
        return String.format("Hay %s números pares, y %s números impares\n",
                pares, impares);
    }
}
