/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi;
import java.util.Random;
/**
 *
 * @author AlanMichael
 */
public class EserciziAlgoritmi {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r= new Random();
        int[] array=new int[20];
        for(int i=0; i<20; i++){
            array[i]= r.nextInt(101);
        }
        for(int j:array){
            System.out.print(j+", ");
        }
        System.out.println("");
        insertionSort(array);
        for(int j:array){
            System.out.print(j+", ");
        }
        System.out.println("");
        insertionSort(array);
        for(int j:array){
            System.out.print(j+", ");
        }
        System.out.println("");
    }
    
    /**
     * Ordina un array di interi usando l'agoritmo insertion sort
     * 
     * Input
     * @param array array di interi da ordinare
     * 
     * Output
     * L'array viene ordinato in loco
     * 
     **/
    private static void insertionSort(int[] array){
        if(array.length<2){
            return; //array vuoto o di un elemento
        }
        int key,i;
        for(int j=1; j<array.length;j++){
            key=array[j]; //memorizzo valore attuale
            i=j-1; //indice per scorrere all'indietro
            while(i>=0 && array[i]>key){
                //c'è un elemento alla sua sinistra che è più grande di key
                array[i+1]=array[i]; //sposto a dx l'elemento più grande
                i=i-1; //vado a sx per cercarne altri
            }
            array[i+1]=key;
        }
        return;
    }
    
    /**
     * Ordina un array di interi in senso decrescente usando l'agoritmo insertion sort
     * 
     * Input
     * @param array array di interi da ordinare
     * 
     * Output
     * L'array viene ordinato in senso decrescente in loco
     * 
     * Esercizio 1.1.2 pag 5
     **/
    private static void insertionSortRev(int[] array){
        if(array.length<2){
            return; //array vuoto o di un elemento
        }
        int key,i;
        for(int j=1; j<array.length;j++){
            key=array[j]; //memorizzo valore attuale
            i=j-1; //indice per scorrere all'indietro
            while(i>=0 && array[i]<key){
                //c'è un elemento alla sua sinistra che è più piccolo di key
                array[i+1]=array[i]; //sposto a dx l'elemento più piccolo
                i=i-1; //vado a sx per cercarne altri
            }
            array[i+1]=key;
        }
        return;
    }
    
    private void heapify(Node[] array, int i){
        Node left=array[i].getLeft();
        Node right=array[i].getRight();
        
    }
}
