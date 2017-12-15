/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi.rb;

/**
 *
 * @author AlanMichael
 */
public class Node {
    protected int value;
    protected Node parent;
    protected Node left;
    protected Node right;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public Node(Node parent, int value, Node left_node, Node right_node){
        this.parent=parent;
        this.value=value;
        this.left=left_node;
        this.right=right_node;
    }
    public Node(){
        this.parent=null;
        this.value=-1;
        this.left=null;
        this.right=null;
    }
    
    /**
     * Costruttore di copia
     */
    public Node(Node to_copy){
        this.parent=to_copy.parent;
        this.value=to_copy.value;
        this.left=to_copy.left;
        this.right=to_copy.right;
    }
    public Node getParent(){
        return parent;
    }
    public Node getLeft(){
        return left;
    }
    public Node getRight(){
        return right;
    }
    public int getValue(){
        return value;
    }
    public void setParent(Node parent){
        this.parent=parent;
    }
    public void setLeft(Node left){
        this.left=left;
    }
    public void setRight(Node right){
        this.right=right;
    }
    public void setValue(int value){
        this.value=value;
    }
    @Override
    public String toString(){
        if(this==null) return null;
        return (""+value);
    }
    
    public void print(int i){
        if(this==null) return; //non esiste nodo
        
        System.out.println(this);
        i++;
        if(this.right==null && this.left==null) return; //il nodo non ha figli
        //il nodo ha almeno un figlio
        if(this.right!=null){//esiste figlio destro
            for(int j=1; j<i;j++) System.out.print(" ");
            System.out.print("|_");
            this.right.print(i);
        }else{
            //non esiste figlio destro
            for(int j=1; j<i;j++) System.out.print(" ");
            System.out.println("|_");
        }
        if(this.left!=null){//esiste figlio sinistro
            for(int j=1; j<i;j++) System.out.print(" ");
            System.out.print("|_");
            this.left.print(i);
        }
        i--;
    }
    
    /**
     * Metodo che ruota a sx un albero, sul nodo passato
     * 
     * @param root, la radice dell'albero in cui operare
     * @param node, il nodo su cui effettuare la rotazione
     * @return la radice dell'albero ruotato
     * 
     * Complessità: c
     */
    public static Node ruota_sx(Node root, Node node){
        if(root==null) return root; //albero vuoto
        //memorizzo situazione iniziale
        Node oldroot=node;
        if(oldroot==null) return root; //non esiste il nodo passato
        Node oldright=node.right;
        if(oldright==null) return root; //non c'è figlio destro non posso ruotare
        if(oldroot.parent!=null){
            //la radice aveva un padre
            //aggiorno il suo puntatore al figlio dopo la rotazione
            if(oldroot.parent.left==oldroot){
                //la radice era figlia sinistra
                oldroot.parent.left=oldright;
            }else{
                //la radice era figlia destra
                oldroot.parent.right=oldright;
            }
        }else{
            //sto ruotando la radice
            root=oldright;
        }
        //effettuo la rotazione
        oldright.parent=oldroot.parent; //collego la nuova radice al padre della vecchia
        oldroot.parent=oldroot.right; //il padre della radice vecchia è il suo figlio destro
        oldroot.right=oldright.left; //il figlio destro della radice è il figlio sinistro del suo figlio destro
        if(oldright.left!=null){
            oldright.left.parent=oldroot; //aggiorno anche il relativo figlio
        }
        oldright.left=oldroot; //il figlio destro della radice è la radice (prima della rotazione)
        
        return root;
    }
    
    /**
     * Metodo che ruota a dx un rbalbero, sul nodo passato
     * 
     * @param root, la radice dell'albero in cui operare
     * @param node, il nodo su cui effettuare la rotazione
     * @return la radice dell'albero ruotato
     * 
     * Complessità: c
     */
    public static Node ruota_dx(Node root, Node node){
        if(root==null) return root; //albero vuoto
        //memorizzo situazione iniziale
        Node oldroot=node;
        if(oldroot==null) return root; //non esiste il nodo passato
        Node oldleft=node.left;
        if(oldleft==null) return root; //non c'è figlio sinsitro non posso ruotare
        if(oldroot.parent!=null){
            //la radice aveva un padre
            //aggiorno il suo puntatore al figlio dopo la rotazione
            if(oldroot.parent.left==oldroot){
                //la radice era figlia sinistra
                oldroot.parent.left=oldleft;
            }else{
                //la radice era figlia destra
                oldroot.parent.right=oldleft;
            }
        }else{
            //sto ruotando la radice
            root=oldleft;
        }
        //effettuo la rotazione
        oldleft.parent=oldroot.parent; //collego la nuova radice al padre della vecchia
        oldroot.parent=oldroot.left; //il padre della radice vecchia è il suo figlio sinsitro
        oldroot.left=oldleft.right; //il figlio sinsitro della radice è il figlio destro del suo figlio sinsitro (prima della rotazione)
        if(oldleft.right!=null){
            oldleft.right.parent=oldroot; //aggiorno anche il relativo figlio
        }
        oldleft.right=oldroot; //il figlio destro della radice è la radice (prima della rotazione)
        return root;
    }
    
    /**
     * Metodo che cerca un nodo con una certa chiave nell'albero passato
     * 
     * @param key, la chiave da cercare nell'albero
     * @return il nodo se trovato, null altrimenti
     * 
     * Complessità: log2(n) (n numero nodi nell'albero)
     */
    public Node search(int key){
        if(this==null) return null; //elemento non trovato
        if(this.value==key) return this; //elemento trovato
        if(this.value>key){ //la chiave è minore del nodo corrente
            if(this.left==null) return null;
            return this.left.search(key); //lo cerco nel sottoalbero di sx
        }else{ //la chiave è maggiore del nodo corrente
            if(this.right==null) return null;
            return this.right.search(key); //lo cerco nel sottoalbero di dx
        }
    }
    
    /**
     * Metodo che pre-visita un albero (prima nodo attuale, poi figlio sx e dx)
     *
     * Complessità: n
     */
    private void pre_visit(){
        if(this!=null){
            System.out.print(this+", ");
            this.left.pre_visit();
            this.right.pre_visit();
        }
        return;
    }
    
    /**
     * Metodo che in-visita un albero (prima figlio sx, poi nodo attuale e figlio dx)
     *
     * Complessità: n
     */
    private void in_visit(){
        if(this!=null){
            this.left.in_visit();
            System.out.print(this+", ");
            this.right.in_visit();
        }
        return;
    }
    
    /**
     * Metodo che post-visita un albero (prima figlio sx, poi dx  e nodo attuale)
     *
     * Complessità: n
     */
    private void post_visit(){
        if(this!=null){
            System.out.print(this+", ");
            this.left.post_visit();
            this.right.post_visit();
        }
        return;
    }
    
    
    /**
     * Metodo che inserisce un nodo in un albero binario di ricerca
     * 
     * @param root, la radice dell'albero in cui inserire
     * @param newNode, il nodo da inserire
     * 
     * @return la radice dell'albero col nuovo nodo inserito
     * 
     * Complessità: log2(n)
     */
    public static Node insert(Node root, Node newNode){
        if(root==null){//albero vuoto
            return newNode; //inserisco nodo attuale al posto dell'albero vuoto
        }
        Node real_root=root; //salvo la radice iniziale
        while(true){
            if(newNode.value>root.value){//il nodo ha valore maggiore della radice
                if(root.right==null){ //non ha figlio destro
                    root.right=newNode;
                    newNode.parent=root;
                    return real_root;
                }
                root=root.right;
            }else{ //il nodo ha valore minore o uguale della radice
                if(root.left==null){ //non ha figlio destro
                    root.left=newNode;
                    newNode.parent=root;
                    return real_root;
                }
                root=root.left;
            }
        }
    }
    
    /**
     * Restituisce il più piccolo nodo nell'albero radicato sul nodo chiamante
     * 
     * @return il nodo con chiave minore nell'albero
     */
    public Node min(){
        if(this==null) return null; //albero vuoto
        if(this.left==null) return this;
        Node left=new Node(this.left);//prendo figlio sinistro
        while(left.left!=null) left=new Node(left.left); //continuo ad andare a sinistra
        return left;
    }
    
    /**
     * Restituisce il più grande nodo nell'albero radicato sul nodo chiamante
     * 
     * @return il nodo con chiave maggiore nell'albero
     */
    public Node max(){
        if(this==null) return null; //albero vuoto
        Node right=new Node(this.right);//prendo figlio destro
        while(right.right!=null) right=new Node(right.right); //continuo ad andare a destra
        return right;
    }
    
    /**
     * Ritorna il successore del nodo chiamante
     * 
     * @return il successore 
     */
    public Node successore(){
        if(this==null) return null; //albero vuoto
        if(this.right!=null) return this.right.min(); //ha figlio destro il suo successore è il minimo di quel sottoalbero
        //il nodo non ha figlio destro
        Node parent= new Node(this.parent);
        Node x=new Node(this);
        //mi salvo il suo padre
        while(parent!=null && parent.right==this){ //il padre esiste e il suo figlio destro è il nostro nodo
            x=parent;
            parent=parent.parent;
        }
        return parent;
    }
    
    /**
     * Metodo che elimina un nodo da un albero
     * 
     * @param root, l'albero in cui eliminare il nodo
     * @param remNode, il nodo da eliminare
     * 
     * Complessità: ??
     */
    public static Node delete(Node root, Node remNode){
        int num_figli=(remNode.left==null && remNode.right==null ? 0 : (remNode.left!=null && remNode.right!=null ? 2 : 1));
        if(num_figli==0){//non ha figli
            if(remNode.parent!=null){//ha un padre
                if(remNode==remNode.parent.left){
                    //è figlio sinistro
                    remNode.parent.left=null;
                    return root;
                }else{
                    //è figlio destro
                    remNode.parent.right=null;
                    return root;
                }
            }
            //non ha padre è una radice
            return null;
        }
        if(num_figli==1){
            //ha un figlio solo
            if(remNode.left!=null){
                //ha un figlio sinistro
                if(remNode.parent!=null){//ha un padre
                    if(remNode==remNode.parent.left){
                        //è figlio sinistro
                        remNode.parent.left=remNode.left;
                        return root;
                    }else{
                        //è figlio destro
                        remNode.parent.right=remNode.left;
                        return root;
                    }
                }
                //non ha padre è una radice
                root=remNode.left;
                return root;
            }else{
                //ha un figlio destro
                if(remNode.parent!=null){//ha un padre
                    if(remNode==remNode.parent.left){
                        //è figlio sinistro
                        remNode.parent.left=remNode.right;
                        return root;
                    }else{
                        //è figlio destro
                        remNode.parent.right=remNode.right;
                        return root;
                    }
                }
                //non ha padre è una radice
                root=remNode.right;
                return root;
            }
        }
        //ha due figli
        //prendo il suo successore
        Node next=remNode.successore();
        //successore prende posto del nodo da rimuovere
        next.parent=remNode.parent;
        if(!next.equals(remNode.left))
            next.left=remNode.left;
        else
            next.left = next.left;

        if(!next.equals(remNode.right))
            next.right=remNode.right;
        else
            next.right = next.right;
        if(remNode.parent!=null){//il nodo da eliminare non è radice
            if(remNode==remNode.parent.left){//il nodo da eliminare è figlio sx
                remNode.parent.left=next;
            }else{//il nodo da eliminare è figlio dx
                remNode.parent.right=next;
            }
        }else{
            //il nodo da eliminare è radice
            next.left = root.left;
            next.parent = null;
            
            
        }
        //non ha padre, ma ha due figli
        return next;
    }
}
