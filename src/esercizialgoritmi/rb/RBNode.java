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
public class RBNode extends Node {
    
    //0 - black
    //1 - red
    private int color;

    public RBNode() {
    }

    public RBNode(int color, Node parent, int value, Node left_node, Node right_node) {
        super(parent, value, left_node, right_node);
        this.color = color;
    }
    
    /**
     * Costruttore di copia
     * @param to_copy 
     */
    public RBNode(RBNode to_copy){
        super(to_copy);
        this.color = to_copy.color;
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

}
