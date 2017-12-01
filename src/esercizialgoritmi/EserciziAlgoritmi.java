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
        //array di 20 interi
        
        int[] array=buildArray(20,101);
        printArray(array);
        
        //insertionsort
        insertionSort(array);
        for(int j:array){
            System.out.print(j+", ");
        }
        System.out.println("");
        
        //insertionsort reverse
        insertionSortRev(array);
        for(int j:array){
            System.out.print(j+", ");
        }
        System.out.println("");
        
        //somma due numeri binari
        int[] a=buildArray(7,1);
        int[] b=buildArray(7,1);
        System.out.println("Somma di due numeri binari:");
        printArray(a);
        printArray(b);
        int[] c=sommaBin(a,b);
        printArray(c);
    }
    
    /**
     * Metodo che crea un array di interi in un certo range della lunghezza voluta
     * 
     * @param l lunghezza dell'array
     * @param r il valore massimo che può avere ogni elemento
     * 
     * @return l'array conforme alle specifiche
     */
    private static int[] buildArray(int l, int range){
        ++range;
        Random r= new Random();
        int[] a=new int[l];
        for(int i=0;i<l;i++){
            a[i]=r.nextInt(range);
        }
        return a;
    }
    
    /*
    * Metodo che stampa un array di interi
    *
    * @param a, l'array da stampare
    */
    private static void printArray(int[] a){
        int l=a.length,i=0;
        for(; i<(l-1); i++){
            System.out.print(a[i]+", ");
        }
        System.out.println(a[i]);
        return;
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
    
    /**
     * 
     * Somma due array di interi che rappresentano un numero binario
     * 
     * @param a il primo addendo (binario)
     * @param b il secondo addendo (binario)
     *
     * @return la somma dei due numeri (binario)
     * 
     * Attenzione: si suppone codifica corretta e lunghezza array uguale
     */
    private static int[] sommaBin(int[] a, int[] b){
        int l=((a.length>b.length)?a.length :b.length)+1; //la lunghezza della somma è lunghezza massimo + 1
        int [] c= new int[l]; //creo array risultato
        
        //da aggiornare per gestire lunghezze diverse
        int r=0,i=0; //bit di riporto
        for(; i<(l-1); i++){
            if(r==0){ //non c'è riporto
                if(a[i]==b[i] && a[i]==1){ //sommo due 1
                    c[i]=0;
                    r=1;
                }else{
                    c[i]=a[i]+b[i]; //sommo i due numeri binari
                }
            }else{//c'è riporto
                if(a[i]==b[i]){//sono uguali
                    if(a[i]==1){//entrambi 1
                        c[i]=1;
                    }else{//entrambi 0
                        c[i]=1;
                        r=0;
                    }
                }else{
                    //sono diversi
                    c[i]=0;
                }
            }
            
        }
        //cifra più significativa
        if(r==1){
            c[i]=1;
        }else{
            c[i]=0;
        }
        return c;
    }
    private static void heapify(Node[] array, int i){
        Node left=array[i].getLeft();
        Node right=array[i].getRight();
        
    }
}
