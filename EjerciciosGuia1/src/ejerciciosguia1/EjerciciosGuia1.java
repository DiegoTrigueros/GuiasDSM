/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosguia1;
import ejerciciosguia1.Ejercicio1;
import ejerciciosguia1.Ejercicio2;
import ejerciciosguia1.Ejercicio3;
import ejerciciosguia1.Ejercicio4;
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
                break;
            case 2:
                Ejercicio2 ej2 = new Ejercicio2();
                int[] notas = new int[10];
                int n = 0;
                for (int i = 0; i < 10; i++){
                    System.out.print("Ingrese el siguiente número: ");
                    n = kb.nextInt();
                    notas[i] = n;
                }
                System.out.print(ej2.notas(notas));
            case 3:
                int n_numeros = 0;
                System.out.print("Número de números a ingresar: ");
                n_numeros = kb.nextInt();
                int[] numeros = new int[n_numeros];
                Ejercicio3 ej3 = new Ejercicio3();
                for (int i = 0; i < n_numeros; i++){
                    System.out.print("Ingrese el siguiente número: ");
                    n = kb.nextInt();
                    numeros[i] = n;
                }
                System.out.print(ej3.countPares(numeros));
            case 4:
                int x, y;
                System.out.print("Ingrese la coordenada x: ");
                x = kb.nextInt();
                System.out.print("Ingrese la coordenada y: ");
                y = kb.nextInt();
                Ejercicio4 ej4 = new Ejercicio4();
                System.out.print(ej4.cuadrante(x, y));
        }
    }
    
}
