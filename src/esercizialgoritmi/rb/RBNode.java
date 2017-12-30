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
     * @param toCopy il nodo cui effettuare la copia
     */
    public RBNode(RBNode toCopy){
        super(toCopy.parent,toCopy.value,toCopy.left,toCopy.right);
        this.color = toCopy.color;
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
    
    /**
     * Metodo che ritorna l'altezza nera di un nodo
     * 
     * @return l'altezza nera del nodo
     * 
     * Complessità: log2n
     */
    public int getBH(){
        int bh=0; //all'inizio altezza nera è 0
        RBNode left_son=this.getRBLeft();
        while(left_son!=null){//finché ci sono figli sx
            if(left_son.color==0) bh++; //ha un figlio nero
            left_son=left_son.getRBLeft();
        }
        return bh;
    }
    /**
     * Metodo che stampa un albero radicato in this
     * 
     * @param i, la profondità dell'albero (quando viene chiamato deve essere 0)
     *
     * Complessità: n
     */
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
    
    /**
     * Metodo che ruota a sx un rbalbero, sul nodo passato
     * 
     * @param root, la radice dell'albero in cui operare
     * @param node, il nodo su cui effettuare la rotazione
     * @return la radice dell'albero ruotato
     * 
     * Complessità: c
     */
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
            if(oldroot.getRBParent().getRBLeft()==oldroot){
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
            if(oldroot.getRBParent().getRBLeft()==oldroot){
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
        oldleft.parent=oldroot.parent; //collego la nuova radice al padre della vecchia
        oldroot.parent=oldroot.left; //il padre della radice vecchia è il suo figlio sinsitro
        oldroot.left=oldleft.right; //il figlio sinsitro della radice è il figlio destro del suo figlio sinsitro (prima della rotazione)
        if(oldleft.right!=null){
            oldleft.right.parent=oldroot; //aggiorno anche il relativo figlio
        }
        oldleft.right=oldroot; //il figlio destro della radice è la radice (prima della rotazione)
        return root;
    }
    
    public static RBNode delete(RBNode root, RBNode remNode){
        if(root==null) return null; //albero vuoto
        if(remNode==null) return null; //nodo non esiste
        if(remNode.color==1){
            //elimino un nodo rosso
            int num_figli=(remNode.left==null && remNode.right==null ? 0 : (remNode.left!=null && remNode.right!=null ? 2 : 1));
            if(num_figli==0){
                //non ha figli
                if(remNode.getRBParent()!=null){
                    //ha un padre
                    if(remNode==remNode.getRBParent().getRBLeft()){
                        //il nodo è figlio sinistro
                        remNode.getRBParent().left=null;
                        return root;
                    }else{
                        //il nodo è figlio destro
                        remNode.getRBParent().right=null;
                        return root;
                    }
                }//sto eliminando la radice
                return null;
            }
            if(num_figli==1){
                //ha un figlio solo
                if(remNode.left!=null){
                    //ha un figlio sinistro
                    if(remNode.getRBParent()!=null){
                        if(remNode==remNode.getRBParent().getRBLeft()){
                            //il nodo da eliminare è figlio sinistro
                            remNode.getRBParent().left=remNode.getRBLeft();
                            return root;
                        }else{
                            //il nodo da eliminare è figlio destro
                            remNode.getRBParent().right=remNode.getRBLeft();
                            return root;
                        }
                    }else{
                        //sto eliminando la radice
                        root=remNode.getRBLeft();
                        root.color=0;
                        return root;
                    }
                }else{
                    //ha un figlio destro
                    if(remNode.getRBParent()!=null){
                        if(remNode==remNode.getRBParent().getRBLeft()){
                            //il nodo da eliminare è figlio sinistro
                            remNode.getRBParent().left=remNode.getRBRight();
                            return root;
                        }else{
                            //il nodo da eliminare è figlio destro
                            remNode.getRBParent().right=remNode.getRBRight();
                            return root;
                        }
                    }else{
                        //sto eliminando la radice
                        root=remNode.getRBRight();
                        root.color=0;
                        return root;
                    }
                }
            }
            //ha due figli
            //cerco il minimo nel albero di destra
            RBNode successore=(RBNode) remNode.right.min();
            //copio il successore nel nodo da eliminare
            remNode.value=successore.value;
            //elimino il successore
            return delete(root,successore);
        }else{
            //sto eliminando nodo nero
            int num_figli=(remNode.left==null && remNode.right==null ? 0 : (remNode.left!=null && remNode.right!=null ? 2 : 1));
            if(num_figli==0){
                //non ha figli
                if(remNode.parent==null){
                    //sto eliminando la radice
                    return null;
                }else{
                    if(remNode.getRBParent().getRBLeft()==remNode){
                        //è figlio sinistro
                        remNode.getRBParent().left=null;
                        if(remNode.getRBParent().color==0){
                            //il padre è nero anomalia sul padre
                            return delete_fixup(root,remNode.getRBParent());
                        }else{
                            //il padre è rosso
                            remNode.getRBParent().color=0; //lo coloro di nero
                            return root;
                        }
                    }else{
                        //è figlio destro
                        remNode.getRBParent().right=null;
                        if(remNode.getRBParent().color==0){
                            //il padre è nero anomalia sul padre
                            return delete_fixup(root,remNode.getRBParent());
                        }else{
                            //il padre è rosso
                            remNode.getRBParent().color=0; //lo coloro di nero
                            return root;
                        }
                    }
                }
            }else{
                if(num_figli==1){
                    //nodo nero con un figlio
                    if(remNode.left!=null){
                        //ha un figlio sinistro
                        if(remNode.getRBParent()!=null){
                            //ha un padre
                            if(remNode.getRBParent().getRBLeft()==remNode){
                                //il nodo da eliminare è figlio sinistro
                                remNode.getRBParent().left=remNode.left;
                                if(remNode.getRBParent().color==0){
                                    //il padre è nero
                                    return delete_fixup(root,remNode.getRBParent());
                                }
                                //il padre è rosso
                                remNode.getRBParent().color=0;
                                return root;
                            }else{
                                //il nodo da eliminare è figlio destro
                                remNode.getRBParent().right=remNode.left;
                                if(remNode.getRBParent().color==0){
                                    //il padre è nero
                                    return delete_fixup(root,remNode.getRBParent());
                                }
                                //il padre è rosso
                                remNode.getRBParent().color=0;
                                return root;
                            }
                        }
                        //sto eliminando la radice
                        root=remNode.getRBLeft();
                        root.color=0;
                        return root;
                    }else{
                        //ha un figlio destro
                        if(remNode.getRBParent()!=null){
                            //ha un padre
                            if(remNode.getRBParent().getRBLeft()==remNode){
                                //il nodo da eliminare è figlio sinistro
                                remNode.getRBParent().left=remNode.right;
                                if(remNode.getRBParent().color==0){
                                    //il padre è nero
                                    return delete_fixup(root,remNode.getRBParent());
                                }
                                //il padre è rosso
                                remNode.getRBParent().color=0;
                                return root;
                            }else{
                                //il nodo da eliminare è figlio destro
                                remNode.getRBParent().right=remNode.right;
                                if(remNode.getRBParent().color==0){
                                    //il padre è nero
                                    return delete_fixup(root,remNode.getRBParent());
                                }
                                //il padre è rosso
                                remNode.getRBParent().color=0;
                                return root;
                            }
                        }
                        //sto eliminando la radice
                        root=remNode.getRBRight();
                        root.color=0;
                        return root;
                    }
                }else{
                    //nodo nero con due figli
                    //cerco il minimo nel albero di destra
                    RBNode successore=(RBNode) remNode.right.min();
                    //copio il successore nel nodo da eliminare
                    remNode.value=successore.value;
                    //elimino il successore
                    return delete(root,successore);
                }
            }
        }
    }
    
    private static RBNode delete_fixup(RBNode root, RBNode anomaly) {
        while(anomaly!=root && anomaly.color==0){
            if(anomaly.getRBParent().left==anomaly){
                //anomalia figlio sinistro
                if(anomaly.getRBParent().right!=null){ //prendo il fratello
                    if(anomaly.getRBParent().getRBRight().color==1){//il fratello è rosso
                        //caso 1
                        anomaly.getRBParent().color=1; //il padre rosso
                        anomaly.getRBParent().getRBRight().color=0; //il fratello nero
                        //ruoto a sinistra sul padre
                        root=ruota_sx(root,anomaly.getRBParent());
                    }
                    //il fratello è nero
                    if(anomaly.getRBParent().getRBRight().getRBRight()!=null){
                        //il fratello ha un figlio destro
                        if(anomaly.getRBParent().getRBRight().getRBLeft()!=null){
                            //il fratello ha anche figlio sinistro
                            if(anomaly.getRBParent().getRBRight().getRBLeft().color==anomaly.getRBParent().getRBRight().getRBRight().color && anomaly.getRBParent().getRBRight().getRBRight().color==0){
                                //i figli sono entrambi neri
                                // caso 2
                                anomaly.getRBParent().getRBRight().color=1; //fratello rosso
                                anomaly=anomaly.getRBParent(); //anomalia sale sul padre
                            }else{
                                //i figli non sono entrambi neri (almeno uno è rosso)
                                if(anomaly.getRBParent().getRBRight().getRBRight().color==0){
                                    //il figlio destro del fratello è nero
                                    //caso 3
                                    anomaly.getRBParent().getRBRight().color=anomaly.getRBParent().getRBRight().getRBLeft().color; //scambio il colore del fratello col suo figlio sinistro
                                    anomaly.getRBParent().getRBRight().getRBLeft().color=0; //figlio sinistro del fratello nero
                                    root=ruota_dx(root,anomaly.getRBParent().getRBRight()); //ruotiamo a dx sul fratello
                                }else{
                                    //il figlio destro del fratello è rosso
                                    //caso 4
                                    anomaly.getRBParent().getRBRight().color=anomaly.getRBParent().color; //il fratello prende il colore del padre
                                    anomaly.getRBParent().color=0; //padre nero
                                    anomaly.getRBParent().getRBRight().getRBRight().color=0; //filgio destro del fratello nero
                                    root=ruota_sx(root,anomaly.getRBParent());
                                    anomaly=root; //sposto anomalia su radice perchè caso terminale
                                }
                            }
                        }else{
                            //il fratello ha solo un figlio destro
                            if(anomaly.getRBParent().getRBRight().getRBRight().color==0){
                                //il figlio destro del fratello è nero
                                //caso 3
                                anomaly.getRBParent().getRBRight().color=0; //scambio il colore del fratello col suo figlio sinistro
                                root=ruota_dx(root,anomaly.getRBParent().getRBRight()); //ruotiamo a dx sul fratello
                            }else{
                                //il figlio destro del fratello è rosso
                                //caso 4
                                anomaly.getRBParent().getRBRight().color=anomaly.getRBParent().color; //il fratello prende il colore del padre
                                anomaly.getRBParent().color=0; //padre nero
                                anomaly.getRBParent().getRBRight().getRBRight().color=0; //filgio destro del fratello nero
                                root=ruota_sx(root,anomaly.getRBParent());
                                anomaly=root; //sposto anomalia su radice perchè caso terminale
                            }
                        }
                    }else{
                        //il fratello non ha figlio destro
                        //come fosse nero
                        //caso 3
                        if(anomaly.getRBParent().getRBRight().getRBLeft()!=null){
                            //il fratello ha però figlio sinitro
                            anomaly.getRBParent().getRBRight().color=anomaly.getRBParent().getRBRight().getRBLeft().color; //scambio il colore del fratello col suo figlio sinistro
                            anomaly.getRBParent().getRBRight().getRBLeft().color=0; //figlio sinistro del fratello nero
                            root=ruota_dx(root,anomaly.getRBParent().getRBRight()); //ruotiamo a dx sul fratello
                        }else{
                            //il fratello non ha figli
                            root=ruota_dx(root,anomaly.getRBParent().getRBRight());
                        }
                    }
                }else{
                    //il fratello non esiste (come fosse nero)
                    //allora anche i suoi figli non esistono
                    /*
                    * Attenzione assumo che in questo caso anomalia salga
                    *
                    *
                    */
                    anomaly=anomaly.getRBParent();
                }
            }else{
                //anomalia figlio destro
                if(anomaly.getRBParent().left!=null){ //prendo il fratello
                    if(anomaly.getRBParent().getRBLeft().color==1){//il fratello è rosso
                        //caso 1
                        anomaly.getRBParent().color=1; //il padre rosso
                        anomaly.getRBParent().getRBLeft().color=0; //il fratello nero
                        //ruoto a sinistra sul padre
                        root=ruota_sx(root,anomaly.getRBParent());
                    }
                    //il fratello è nero
                    if(anomaly.getRBParent().getRBLeft().getRBRight()!=null){
                        //il fratello ha un figlio destro
                        if(anomaly.getRBParent().getRBLeft().getRBLeft()!=null){
                            //il fratello ha anche figlio sinistro
                            if(anomaly.getRBParent().getRBLeft().getRBLeft().color==anomaly.getRBParent().getRBLeft().getRBRight().color && anomaly.getRBParent().getRBLeft().getRBRight().color==0){
                                //i figli sono entrambi neri
                                // caso 2
                                anomaly.getRBParent().getRBLeft().color=1; //fratello rosso
                                anomaly=anomaly.getRBParent(); //anomalia sale sul padre
                            }else{
                                //i figli non sono entrambi neri (almeno uno è rosso)
                                if(anomaly.getRBParent().getRBLeft().getRBRight().color==0){
                                    //il figlio destro del fratello è nero
                                    //caso 3
                                    anomaly.getRBParent().getRBLeft().color=anomaly.getRBParent().getRBLeft().getRBLeft().color; //scambio il colore del fratello col suo figlio sinistro
                                    anomaly.getRBParent().getRBLeft().getRBLeft().color=0; //figlio sinistro del fratello nero
                                    root=ruota_dx(root,anomaly.getRBParent().getRBLeft()); //ruotiamo a dx sul fratello
                                }else{
                                    //il figlio destro del fratello è rosso
                                    //caso 4
                                    anomaly.getRBParent().getRBLeft().color=anomaly.getRBParent().color; //il fratello prende il colore del padre
                                    anomaly.getRBParent().color=0; //padre nero
                                    anomaly.getRBParent().getRBLeft().getRBRight().color=0; //filgio destro del fratello nero
                                    root=ruota_sx(root,anomaly.getRBParent());
                                    anomaly=root; //sposto anomalia su radice perchè caso terminale
                                }
                            }
                        }else{
                            //il fratello ha solo un figlio destro
                            if(anomaly.getRBParent().getRBLeft().getRBRight().color==0){
                                //il figlio destro del fratello è nero
                                //caso 3
                                anomaly.getRBParent().getRBLeft().color=0; //scambio il colore del fratello col suo figlio sinistro
                                root=ruota_dx(root,anomaly.getRBParent().getRBLeft()); //ruotiamo a dx sul fratello
                            }else{
                                //il figlio destro del fratello è rosso
                                //caso 4
                                anomaly.getRBParent().getRBLeft().color=anomaly.getRBParent().color; //il fratello prende il colore del padre
                                anomaly.getRBParent().color=0; //padre nero
                                anomaly.getRBParent().getRBLeft().getRBRight().color=0; //filgio destro del fratello nero
                                root=ruota_sx(root,anomaly.getRBParent());
                                anomaly=root; //sposto anomalia su radice perchè caso terminale
                            }
                        }
                    }else{
                        //il fratello non ha figlio destro
                        //come fosse nero
                        //caso 3
                        if(anomaly.getRBParent().getRBLeft().getRBLeft()!=null){
                            //il fratello ha però figlio sinitro
                            anomaly.getRBParent().getRBLeft().color=anomaly.getRBParent().getRBLeft().getRBLeft().color; //scambio il colore del fratello col suo figlio sinistro
                            anomaly.getRBParent().getRBLeft().getRBLeft().color=0; //figlio sinistro del fratello nero
                            root=ruota_dx(root,anomaly.getRBParent().getRBLeft()); //ruotiamo a dx sul fratello
                        }else{
                            //il fratello non ha figli
                            root=ruota_dx(root,anomaly.getRBParent().getRBLeft());
                        }
                    }
                }else{
                    //il fratello non esiste (come fosse nero)
                    //allora anche i suoi figli non esistono
                    /*
                    * Attenzione assumo che in questo caso anomalia salga
                    *
                    *
                    */
                    anomaly=anomaly.getRBParent();
                }
            }
        }
        anomaly.color=0;
        return root;
    }
    
    /**
     * Metodo che inserisce in un rbalbero un nodo dato
     * 
     * @param root, la radice dell'rbalbero in cui fare l'inserimento
     * @param newNode, il nodo da inserire
     * 
     * @return la radice dell'rbalbero col nuovo nodo inserito
     * 
     * Complessità: log2(n)
     */
    public static RBNode insert(RBNode root, RBNode newNode){
        newNode.color=1; //inserisco nodo rosso
        root=(RBNode) Node.insert(root,newNode);
        //ora newNode è stato inserito ed è una anomolia
        //controllare errore se il padre non esiste
        while(newNode!=root && newNode.getRBParent().color==1){
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
                            root=ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                            //mi riconduco al caso 3
                        }
                        //l'anomalia è figlio sinistro caso 3
                        newNode.getRBParent().color=0; //padre nero
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        root=ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
                    }
                }else{
                    //lo zio non esiste ma è come fosse nero
                    //lo zio è nero
                    if(newNode==newNode.getRBParent().getRBRight()){
                        //l'anomalia è figlio destro caso 2
                        newNode=newNode.getRBParent(); //sposto anomalia sul padre
                        root=ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                        //mi riconduco al caso 3
                    }
                    //l'anomalia è figlio sinistro caso 3
                    newNode.getRBParent().color=0; //padre nero
                    newNode.getRBParent().getRBParent().color=1; //nonno rosso
                    root=ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
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
                            root=ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                            //mi riconduco al caso 3
                        }
                        //l'anomalia è figlio destro caso 3
                        newNode.getRBParent().color=0; //padre nero
                        newNode.getRBParent().getRBParent().color=1; //nonno rosso
                        root=ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
                    }
                }else{
                    //lo zio non esiste ma è come fosse nero
                    //lo zio è nero
                    if(newNode==newNode.getRBParent().getRBLeft()){
                        //l'anomalia è figlio sinistro caso 2
                        newNode=newNode.getRBParent(); //sposto anomalia sul padre
                        root=ruota_sx(root,newNode); //ruoto il sottoalbero radicato nel padre a sx
                        //mi riconduco al caso 3
                    }
                    //l'anomalia è figlio destro caso 3
                    newNode.getRBParent().color=0; //padre nero
                    newNode.getRBParent().getRBParent().color=1; //nonno rosso
                    root=ruota_dx(root,newNode.getRBParent().getRBParent()); //ruoto a destra sul nonno
                }
            }
        }
        root.color=0; //radice nera
        return root;
    }
}
