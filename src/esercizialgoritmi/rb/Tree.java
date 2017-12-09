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
public class Tree {
    private Node root;
    private int h; //altezza o profondità massima dell'albero
    
    public Tree(){
        root=null;
        h=0;
    }
    
    public Tree(Node n){
        root=n;
        h=1;
    }
    
    public Node getRoot(){
        return root;
    }
    public int getH(){
        return h;
    }
    
    public void setRoot(Node n){
        root=n;
    }
    
    public void setH(int x){
        h=x;
    }
    
       
}
