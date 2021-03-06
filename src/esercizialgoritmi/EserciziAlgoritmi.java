/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi;
import esercizialgoritmi.rb.Node;
import esercizialgoritmi.rb.RBNode;
import esercizialgoritmi.rb.UtilityRBTree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import javafx.util.Pair;

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
        
//        int[] array=buildArray(20,101);
//        printArray(array);
//        
//        //insertionsort
//        insertionSort(array);
//        printArray(array);
//        
//        //insertionsort reverse
//        selectionSort(array);
//        printArray(array);
//        
//        //somma due numeri binari
//        int[] a=buildArray(7,1);
//        int[] b=buildArray(7,1);
//        System.out.println("Somma di due numeri binari:");
//        printArray(a);
//        printArray(b);
//        int[] c=sommaBin(a,b);
//        printArray(c);
//        
//        //valutare un polinomio
//        int [] p=buildArray(3,4);
//        System.out.print("Polinomio: ");
//        printArray(p);
//        System.out.println("Il polinomio valutato in 0: "+polinomio(p,0));
//        System.out.println("Il polinomio valutato in 1: "+polinomio(p,1));
//        System.out.println("Il polinomio valutato in 2: "+polinomio(p,2));
//        System.out.println("Il polinomio valutato in 0: "+polinomioHorner(p,0));
//        System.out.println("Il polinomio valutato in 1: "+polinomioHorner(p,1));
//        System.out.println("Il polinomio valutato in 2: "+polinomioHorner(p,2));
        
        //int height = 3;
        //RBNode root = UtilityRBTree.buildRandomRBTree(null, 20, false, height, null);
        //HashMap<RBNode,Integer> values = new HashMap<>();
        //values = UtilityRBTree.loadRBTree(root, height, values);
        //UtilityRBTree.printRBTree(height, values);
        
        /**
        //
        //      Prova stampa albero
        //
        Node root1=new Node(null,0,null,null);
        Node node1=new Node(root1,1,null,null);
        Node node2=new Node(root1,2,null,null);
        root1.setLeft(node1);
        root1.setRight(node2);
        Node node3=new Node(node1,3,null,null);
        Node node4=new Node(node1,4,null,null);
        node1.setLeft(node3);
        node1.setRight(node4);
        Node node5=new Node(node2,5,null,null);
        node2.setLeft(node5);
        Node node6=new Node(node5,6,null,null);
        node5.setLeft(node6);
        Node node7=new Node(node6,7,null,null);
        node6.setRight(node7);
        Node node8=new Node(node7,8,null,null);
        node7.setLeft(node8);
        Node node9=new Node(node4,9,null,null);
        node4.setRight(node9);
        //root1.print(0);
        */
        
        //ricerca
        /**
        int key=2;
        Node find=root1.search(key);
        if(find==null){
            System.out.println("L'albero non conteneva "+key);
        }else{
            System.out.println("L'albero conteneva "+key);
        }
        find=new Node(null,2,null,null);
        */
        
        //inserimento
        /**
        Node.insert(root1,find);
        root1.print(0);
        */
        
        /**
        //eliminazione
        System.out.println("Elimino nodo 9");
        root1=Node.delete(root1, node9);
        root1.print(0);
        System.out.println("Elimino nodo 7");
        root1=Node.delete(root1, node7);
        root1.print(0);
        System.out.println("Elimino nodo 5");
        root1=Node.delete(root1, node5);
        root1.print(0);
        System.out.println("Elimino nodo 2");
        root1=Node.delete(root1, node2);
        root1.print(0);
        System.out.println("Il minimo è "+root1.min());
        System.out.println("Il massimo è "+root1.max());
        System.out.println("Il successore di 1 è "+node1.successore());
        System.out.println("Elimino radice!");
        root1=Node.delete(root1, root1);
        root1.print(0);
        */
        
        
        
        //RBAlberi
        RBNode rbRoot=new RBNode(0,null,11,null,null);
        rbRoot=RBNode.insert(null, rbRoot);
        rbRoot=RBNode.insert(rbRoot,new RBNode(1,null,2,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(0,null,14,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(0,null,1,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(1,null,15,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(0,null,7,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(1,null,8,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(1,null,5,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(0,null,4,null,null));
        rbRoot=RBNode.insert(rbRoot,new RBNode(0,null,3,null,null));
        
        /** Eliminazione
        //prova eliminazione
        System.out.println("Albero iniziale");
        rbRoot.print(0);
        System.out.println("Elimino nodi rossi");
        //elimino nodo rosso senza figli
        System.out.println("elimino un nodo rosso senza figli: 3");
        rbRoot=RBNode.delete(rbRoot, rbRoot.getRBLeft().getRBRight().getRBLeft());
        rbRoot.print(0);
        System.out.println("Albero inziale");
        RBNode rbRoot2=new RBNode(0,null,4,null,null);
        RBNode left=new RBNode(1,rbRoot2,2,null,null);
        rbRoot2.setLeft(left);
        RBNode son=new RBNode(0,left,1,null,null);
        left.setLeft(son);
        rbRoot2.print(0);
        System.out.println("elimino un nodo rosso con un figlio: 2");
        rbRoot2=RBNode.delete(rbRoot2, rbRoot2.getRBLeft());
        rbRoot2.print(0);
        System.out.println("Albero iniziale");
        rbRoot.print(0);
        System.out.println("elimino un nodo rosso con due figli: 2");
        rbRoot=RBNode.delete(rbRoot, rbRoot.getRBLeft());
        rbRoot.print(0);
        */
        rbRoot.print(0);
        System.out.println("Il rank della radice è: "+rbRoot.rank(rbRoot));
        System.out.println("Il rank dell'ultimo nodo è: "+rbRoot.rank(rbRoot.getRight().getRight().getRight()));
        System.out.println("Il rank dell penultimo nodo è: "+rbRoot.rank(rbRoot.getRight().getRight()));
        System.out.println("Il rank di 5 è: "+rbRoot.rank(rbRoot.getRBLeft().getRBRight().getRBRight()));
        System.out.println("Size di 14: "+rbRoot.getRBRight().getRBRight().getSize());
        System.out.println("Size di 8: "+rbRoot.getRBRight().getRBLeft().getSize());
        
        System.out.println("Numero partizioni palindrome di AAAA: "+partizionePalindroma("AAAA",0,3));
        System.out.println("Numero partizioni palindrome di ABCDEFGH: "+partizionePalindroma("ABCDEFGH",0,7));
        System.out.println("Numero partizioni palindrome di QWERTYTREWQWERT: "+partizionePalindroma("QWERTYTREWQWERT",0,14));
        System.out.println("Numero partizioni palindrome di ABAFAABA: "+partizionePalindroma("ABAFAABA",0,7));
        
        System.out.println("La compatibilità tra MARIO e MARIA è: "+compatibilità("MARIO","MARIA",0,0,1).getKey()+", "+compatibilità("MARIO","MARIA",0,0,1).getValue());
        int[] arr= {9,15,3,6,4,2,5,10,3};
        System.out.println("La massima sequenza crescente in ");
        printArray(arr);
        LinkedList returna=max_seq(arr,0);
        System.out.print(" è: "+returna.toString());
    
    
    }
    
    
    /**
     * Metodo che crea un array di interi in un certo range della lunghezza voluta
     * 
     * @param l lunghezza dell'array
     * @param range il valore massimo che può avere ogni elemento
     * 
     * @return l'array conforme alle specifiche
     * Complessità: n
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
    
    /**
     * Metodo che crea un array di interi inizializzati ad un valore dato
     * 
     * @param l, lunghezza dell'array
     * @param value, il valore che assume ogni elemento
     * 
     * @return l'array conforme alle specifiche
     * Complessità: n
     */
    private static int[] buildArrayInit(int l, int value){
        int[] a=new int[l];
        for(int i=0;i<l;i++) a[i]=value;
        return a;
    }
    
    /**
     * Metodo che crea una matrice mxn di interi in un certo range
     * 
     * @param m, numero di righe della matrice
     * @param n, numero di colonne della matrice
     * @param range, il valore massimo che può avere ogni elemento
     * 
     * @return la matrice conforme alle specifiche
     * Complessità: m*n
     */
    private static int[][] buildMatrix(int m, int n, int range){
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            matrix[i]=buildArray(n,range);
        }
        return matrix;
    }
    
    /**
     * Metodo che crea una matrice mxn di interi inizializzata ad un certo valore
     * 
     * @param m, numero di righe della matrice
     * @param n, numero di colonne della matrice
     * @param value, il valore da assegnare ad ogni cella della matrice
     * 
     * @return la matrice conforme alle specifiche
     * Complessità: m*n
     */
    private static int[][] buildMatrixInit(int m, int n, int value){
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            matrix[i]=buildArrayInit(n,value);
        }
        return matrix;
    }
    
    /*
    * Metodo che stampa un array di interi
    *
    * @param a, l'array da stampare
    * Complessità: n
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
     * Metodo che stampa una matrice
     * 
     * @param matrix, la matrice da stampare
     * 
     * Complessità: m*n
     */
    private static void printMatrix(int[][] matrix){
        int m=matrix.length;
        for(int i=0; i<m;i++) printArray(matrix[i]);
        return;
    }
    
    /**
     * Metodo che crea la matrice di appoggio per poi chiamare il metodo di elaborazione
     * 
     * @param s, la stringa in cui calcolare le partizioni
     * @param i, l'indice di inizio della stringa in cui cercare le partizioni
     * @param j, l'indice di fine della stringa in cui cerca le partizioni
     * 
     * @return il numero minimo di partizioni palindrome
     * 
     * Complessità: j^2 + ?
     */
    private static int partizionePalindroma(String s, int i, int j){
        return partizionePalindroma(s,i,j,buildMatrixInit(++j,++j,-1));
    }
    
    /**
     * Metodo che calcola il numero minimo di partizioni palindrome in una stringa
     * 
     * @param s, la stringa in cui calcolare le partizioni
     * @param i, l'indice di inizio della stringa in cui cercare le partizioni
     * @param j, l'indice di fine della stringa in cui cerca le partizioni
     * @param matrix, la matrice ix(j-i) che contiene se la stringa da i a j è palindroma
     * 
     * @return il numero minimo di partizioni palindrome
     * 
     * Complessità: ?
     */
    private static int partizionePalindroma(String s, int i, int j,int[][] matrix){
        if(i>j) return 0;
        int result=matrix[i][j];
        int end=j,start=i;
        boolean flag=true;
        while(result!=1 && flag){
            if(result==-1){//non ho ancora verificato se questa stringa è palindroma
                result=(isPalindroma(s,i,j)? 1 : 0);
                matrix[i][j]=result;
                if(result==1) flag=false;
                else j--;
            }else{//la stringa non è palindroma
                j--;
            }
            result=matrix[i][j]; //aggiorno invariante
        }
        int z1=j-i;
        flag=true;
        result=matrix[i][end];
        while(result!=1 && flag){
            if(result==-1){//non ho calcolato se è palindroma
                result=(isPalindroma(s,i,end)? 1 : 0);
                matrix[i][end]=result;
                if(result==1) flag=false;
                else i++;
            }else{//stringa non è palindroma
                i++;
            }
            result=matrix[i][end];
        }
        int z2=end-i;
        if(z1>z2){//la stringa è palindroma da i-j compresi
            start=++j;
            return 1+partizionePalindroma(s,start,end);
        }
        //la stringa è palindroma da i a end compresi
        end=--i;
        return 1+partizionePalindroma(s,start,end);
    }
    
    /**
     * Metodo che verifica se una sottostringa è palindroma
     * 
     * @param s, la stringa in cui eseguire l'algoritmo
     * @param i,l'indice di partenza della sottostringa
     * @param j, l'idice di fine della sottostringa
     * 
     * @return true se la sottostringa da i a j è palindroma, false altrimenti
     * 
     * Complessità: n (j-i)
     */
    private static boolean isPalindroma(String s, int i, int j){
        if(j-i==0 || i-j==1){
            return true;
        }
        if(j<i || j>=s.length()){
            return false;
        }
        if(s.charAt(i)==s.charAt(j)){
            return isPalindroma(s,++i,--j);
        }else{
            return false;
        }
    }
    
    private static double PN(String[] w, int c){
        int[] s=buildArrayInit(w.length,0);
        double[] m=new double[w.length];
        for(double el: m) el=-1;
        int[] car=buildArrayInit(w.length,0);
        for(int i=0; i<w.length; i++){
            car[i]=w[i].length();
            if(i>0) car[i]=car[i]+car[i-1];
        }
        return PN(w,c,0,m,s,car);
    }
    
    private static double PN(String [] w, int c, int i, double[] m, int[] s, int[] car){
        if(m[i]!=-1) return m[i]; //ho già calcolato il costo
        int length=w.length;
        int a=car[length-1]-car[i]+w[i].length()+length-i; //caratteri più spazi
        if(a<=c){
            m[i]=(length-i)*(length-i)*(length-i);
            return m[i];
        }else{
            int min=-1;
            //for(int j=i; j++; )
            return -1;
        }
    }
    private static LinkedList max_seq(int [] s, int i){
        LinkedList result= new LinkedList();
        if(i==s.length-1){
            result.add(s[i]);
            return result;
        }
        int len=0;
        LinkedList actual=new LinkedList();
        for(int j=i+1; j<s.length; j++){
            if(s[j]>s[i]){
                actual=new LinkedList();
                actual.add(s[j]);
                LinkedList seq=new LinkedList();
                seq=max_seq(s,j);
                for(Object obj: seq){
                    int num=(int) obj;
                    actual.add(num);
                }
                if(actual.size() >len){
                    result=actual;
                    len=actual.size();
                }
            }
        }
        LinkedList not=max_seq(s,++i);
        return(not.size()>len ? not : result);
        
    }
    /**
     * Metodo che calcola la compatibilità tra due stringe
     * 
     * @param s1, la prima stringa
     * @param s2, la seconda stringa
     * @param i, l'indice del primo carattere nella prima stringa
     * @param j, l'indice del primo carattere nella seconda stringa
     * @param p, il numero di possibili stringhe compatibili
     * 
     * @return una tupla che contiene la lunghezza della stringa che contiene entrambe e il numero di stringhe possibili
     */
    private static Pair<Integer,Integer> compatibilità(String s1,String s2, int i, int j, int p){
        if(i>s1.length()-1){
            //la prima stringa è finita
            if(j>s2.length()-1) return new Pair<>(0,0); //anche la seconda
            return new Pair<>(s2.length()-j,1);
        }
        if(j>s2.length()-1){
            //la seconda stringa è finita
            if(i>s1.length()-1) return new Pair<>(0,0); //anche la prima
            return new Pair<>(s1.length()-i,1);
        }
        //caratteri uguali c'è solo una possibilità aggiungo quel carattere alla stringa
        if(s1.charAt(i)==s2.charAt(j)) return new Pair<>(1+compatibilità(s1,s2,++i,++j,p).getKey(),p);
        //caratteri diversi
        int i1=i,j1=j;
        Pair<Integer,Integer> z1=compatibilità(s1,s2,++i,j,p);
        Pair<Integer,Integer> z2=compatibilità(s1,s2,i1,++j1,p);
        //confronto le lunghezze considerndo un carattere o l'altro
        if(!(z1.getKey().equals(z2.getKey()))){
            if(z1.getKey()<z2.getKey()) return z1;
            return z2;
        }
        //le lunghezze sono uguali
        return new Pair<>(z1.getKey(),z1.getValue()+z2.getValue());
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
     * Complessità: n^2
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
     * Complessità: n^2
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
     * Ricerca elemento in un array di interi
     * 
     * @param a, l'array in cui fare la ricerca
     * @param v, il valore da cercare
     * 
     * @return la prima occorrenza del valore se presente, -1 altrimenti
     * 
     * Complessità: n
     * 
     * Esercizio 1.1.3 pag 5
    */
    private static int ricLineare(int[] a, int v){
        int i=0;
        for(;i<a.length;i++){
            if(a[i]==v) return i;
        }
        return -1;
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
     * 
     * Complessità: n
     * Esercizio 1.1.4 pag 5
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
    
    /**
     * 
     * Metodo che ordina un array di interi usando selection sort
     * @param array, l'array da ordinare
     * 
     * Complessità n^2
     * 
     * Esercizio 1.2.1 pagina 9
     */
    private static void selectionSort(int[] array){
        int i=0,j,min,temp;
        for(;i<array.length;i++){
            //per ogni elemento dell'array
            min=i;
            for(j=i+1; j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            if(min!=i){
                temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
    }
    
    /**
     * 
     * Metodo che valuta un polinomio in un punto
     * 
     * @param c, il vettore dei coefficienti del polinomio (il più significativo è il primo)
     * @param x, il punto in cui valutare il polinomio
     * 
     * @return un intero che rappresente il polinomio valutato in x
     * 
     * Complessità: n^2
     * 
     * Esercizio 1.2.3 pagina 10
     */
    private static int polinomio(int[] c, int x){
        int r=0,grado=c.length-1,potenza=1;
        for(int i=0; i<c.length; i++){
            //scorro il vettore dei coefficienti
            potenza=1;
            for(int j=(grado-i); j>0; j--){
                potenza=potenza*x; //ottengo la potenza relativa
            }
            r=r+potenza*c[i]; //aggiungo la potenza moltiplicata per il suo coefficiente
        }
        return r;
    }
    
    /**
     * Valuta un polinomio secondo la regola di Horner
     * an*x^n+a(n-1)*x^(n-1)+a(n-2)*x^(n-2)+...+a0
     * =
     * (..((an*x+a(n-1))*x+a(n-2))*x+...+a1)x+a0
     * @param c, un vettore che rappresenti i coefficienti del polinomio
     * @param x, il punto in cui valutare il polinomio
     * 
     * @return il valore del polinomio nel punto dato
     * 
     * Complessità: n
     * 
     * Esercizio 1.2.3 pagina 10
     */
    private static int polinomioHorner(int[] c, int x){
            int r=c[0];
            for(int i=1; i<c.length;i++){
               r=r*x+c[i];
            }
            return r;
    }
    private static void heapify(Node[] array, int i){
        Node left=array[i].getLeft();
        Node right=array[i].getRight();
        
    }
}
