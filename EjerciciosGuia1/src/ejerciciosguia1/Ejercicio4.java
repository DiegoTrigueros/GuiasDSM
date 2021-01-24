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
public class Ejercicio4 {
    public String cuadrante(int x, int y){
        if((x > 0) && (y > 0)){
            return "Primer cuadrante\n";
        }else if((x < 0) && (y > 0)){
            return "Segundo cuadrante\n";
        }else if((x < 0) && (y < 0)){
            return "Tercer cuadrante\n";
        }
        
        return "Cuarto cuadrante\n";
    }
}
