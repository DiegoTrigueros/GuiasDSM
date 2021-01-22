/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosguia1;
import ejerciciosguia1.Ejercicio1;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class EjerciciosGuia1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n_ejercicio;
        System.out.print("Ingrese el número de ejercicio que desea ver: ");
        n_ejercicio = kb.nextInt();
        switch(n_ejercicio){
            case 1:
                Ejercicio1 ej1 = new Ejercicio1();
                int n1, n2;
                System.out.print("Ingrese el primer número: ");
                n1 = kb.nextInt();
                System.out.print("Ingrese el segundo número: ");
                n2 = kb.nextInt();
                System.out.print(ej1.divisibles(n1, n2));
        }
    }
    
}
