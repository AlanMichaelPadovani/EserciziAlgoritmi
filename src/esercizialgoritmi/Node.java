/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi;

/**
 *
 * @author AlanMichael
 */
public class Node {
    private int value;
    private Node parent;
    private Node left_node;
    private Node right_node;
    
    public Node(Node parent, int value, Node left_node, Node right_node){
        this.parent=parent;
        this.value=value;
        this.left_node=left_node;
        this.right_node=right_node;
    }
    public Node(){
        this.parent=null;
        this.value=-1;
        this.left_node=null;
        this.right_node=null;
    }
    
    public Node getParent(){
        return parent;
    }
    public Node getLeft(){
        return left_node;
    }
    public Node getRight(){
        return right_node;
    }
    public int getValue(){
        return value;
    }
    public void setParent(Node parent){
        this.parent=parent;
    }
    public void setLeft(Node left){
        this.left_node=left;
    }
    public void setRight(Node right){
        this.right_node=right;
    }
    public void setValue(int value){
        this.value=value;
    }
    @Override
    public String toString(){
        return (""+value);
    }
}
