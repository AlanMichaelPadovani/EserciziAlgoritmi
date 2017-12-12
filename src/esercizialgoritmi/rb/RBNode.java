/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi.rb;

/**
 *
 * @author Francesco
 */
public class RBNode extends Node{
    
    //0 - black
    //1 - red
    private int color;
    
    public RBNode() {
        super();
        this.color=1;
    }

    public RBNode(int color, Node parent, int value, Node left, Node right) {
        super(parent,value,left,right);
        this.color = color;
    }
    
    /**
     * Costruttore di copia
     * @param to_copy 
     */
    public RBNode(Node toCopy){
        super(toCopy);
        if(toCopy instanceof RBNode){
            RBNode toCopy2= (RBNode) toCopy;
            this.color = toCopy2.color;
        }
    }
    
    public RBNode getRBParent(){
        if(this.parent instanceof RBNode){
            RBNode parent=(RBNode) this.parent;
            return parent;
        }
        return null;
    }
    
    public RBNode getRBRight(){
        if(this.right instanceof RBNode){
            RBNode right=(RBNode) this.right;
            return right;
        }
        return null;
    }
    
    public RBNode getRBLeft(){
        if(this.left instanceof RBNode){
            RBNode left=(RBNode) this.left;
            return left;
        }
        return null;
    }
    
    public int getColor() {
        return color;
    }
    
     public String getColorDesc() {
        if (this.color == 1){
            return "red";
        } else {
            return "black";
        }
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public void setColor(boolean color) {
        if (color){
            this.color = 1;
        } else {
            this.color = 0;
        }
    }
    
    public void print(int i){
        if(this==null) return; //non esiste nodo
        if(this.color==1){
            System.out.println(ANSI_RED+this+ANSI_RESET);
        }else{
            System.out.println(this);
        }
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
    private static void insertAnomaly(RBNode root, RBNode newNode){
        if(root==null){//albero vuoto
            root=new RBNode(newNode); //inserisco nodo attuale al posto dell'albero vuoto
            return;
        }
        if(newNode.value>root.value){//il nodo ha valore maggiore della radice
            if(root.right==null){ //non ha figlio destro
                root.right=newNode;
                return;
            }
            insert(root.right,newNode);
        }else{ //il nodo ha valore minore o uguale della radice
            if(root.left==null){ //non ha figlio destro
                root.left=newNode;
                return;
            }
            insert(root.left,newNode);
        }
        return;
    }
    public static RBNode ruota_sx(RBNode root, RBNode node){
        if(root==null) return root; //albero vuoto
        //memorizzo situazione iniziale
        RBNode oldroot=node;
        if(oldroot==null) return root; //non esiste il nodo passato
        RBNode oldright=node.getRBRight();
        if(oldright==null) return root; //non c'è figlio destro non posso ruotare
        if(oldroot.getRBParent()!=null){
            //la radice aveva un padre
            //aggiorno il suo puntatore al figlio dopo la rotazione
            if(oldroot.getRBParent().getLeft()==oldroot){
                //la radice era figlia sinistra
                oldroot.getRBParent().left=oldright;
            }else{
                //la radice era figlia destra
                oldroot.getRBParent().right=oldright;
            }
        }else{
            //sto ruotando la radice
            
            root=oldright;
        }
        //effettuo la rotazione
        oldroot.parent=oldroot.right; //il padre della radice vecchia è il suo figlio destro
        oldroot.right=oldright.left; //il figlio destro della radice è il figlio sinistro del suo figlio destro
        if(oldright.left!=null){
            oldright.left.parent=oldroot; //aggiorno anche il relativo figlio
        }
        oldright.left=oldroot; //il figlio destro della radice è la radice (prima della rotazione)
        return root;
    }
    
    public static RBNode ruota_dx(RBNode root, RBNode node){
        if(root==null) return root; //albero vuoto
        //memorizzo situazione iniziale
        RBNode oldroot=node;
        if(oldroot==null) return root; //non esiste il nodo passato
        RBNode oldleft=node.getRBLeft();
        if(oldleft==null) return root; //non c'è figlio sinsitro non posso ruotare
        if(oldroot.getRBParent()!=null){
            //la radice aveva un padre
            //aggiorno il suo puntatore al figlio dopo la rotazione
            if(oldroot.getRBParent().getLeft()==oldroot){
                //la radice era figlia sinistra
                oldroot.getRBParent().left=oldleft;
            }else{
                //la radice era figlia destra
                oldroot.getRBParent().right=oldleft;
            }
        }else{
            //sto ruotando la radice
            root=oldleft;
        }
        //effettuo la rotazione
        oldroot.parent=oldroot.left; //il padre della radice vecchia è il suo figlio sinsitro
        oldroot.left=oldleft.right; //il figlio sinsitro della radice è il figlio destro del suo figlio sinsitro (prima della rotazione)
        if(oldleft.right!=null){
            oldleft.right.parent=oldroot; //aggiorno anche il relativo figlio
        }
        oldleft.right=oldroot; //il figlio destro della radice è la radice (prima della rotazione)
        return root;
    }
    
    public static void insert(RBNode root, RBNode newNode){
        insertAnomaly(root,newNode);
        //ora newNode è stato inserito ed è una anomolia
        //controllare errore se il padre non esiste
        while(newNode!=root && newNode.parent!=null && newNode.getRBParent().color==1){
            //non siamo radice e il padre è rosso
            if(newNode.parent==newNode.parent.parent.left){
                //il padre è figlio sinistro
                //y prende lo zio
                RBNode y=newNode.getRBParent().getRBParent().getRBRight();
                if(y!=null){
                    if(y.color==1){//anche zio rosso caso 1
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        newNode.getRBParent().color=0; //padre nero
                        y.color=0;
                        newNode=newNode.getRBParent().getRBParent();//anomalia sul nonno
                    }else{
                        //lo zio è nero
                        if(newNode==newNode.getRBParent().getRBRight()){
                            //l'anomalia è figlio destro caso 2
                            newNode=newNode.getRBParent(); //sposto anomalia sul padre
                            ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                            //mi riconduco al caso 3
                        }
                        //l'anomalia è figlio sinistro caso 3
                        newNode.getRBParent().color=0; //padre nero
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
                    }
                }else{
                    //lo zio non esiste
                    newNode.getRBParent().getRBParent().color=1; //nonno rosso
                    newNode.getRBParent().color=0; //padre nero
                    newNode=newNode.getRBParent().getRBParent();//anomalia sul nonno
                }
            }else{
                //il padre è figlio destro
                //y prende lo zio
                RBNode y=newNode.getRBParent().getRBParent().getRBLeft();
                if(y!=null){
                    if(y.color==1){//anche zio rosso caso 1
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        newNode.getRBParent().color=0; //padre nero
                        y.color=0;
                        newNode=newNode.getRBParent().getRBParent();//anomalia sul nonno
                    }else{
                        //lo zio è nero
                        if(newNode==newNode.getRBParent().getRBLeft()){
                            //l'anomalia è figlio sinistro caso 2
                            newNode=newNode.getRBParent(); //sposto anomalia sul padre
                            ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                            //mi riconduco al caso 3
                        }
                        //l'anomalia è figlio destro caso 3
                        newNode.getRBParent().color=0; //padre nero
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
                    }
                }else{
                    //lo zio non esiste
                    newNode.getRBParent().getRBParent().color=1; //nonno rosso
                    newNode.getRBParent().color=0; //padre nero
                    newNode=newNode.getRBParent().getRBParent();//anomalia sul nonno
                }
            }
        }
        root.color=0; //radice nera
        return;
    }
}
