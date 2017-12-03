/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizialgoritmi.rb;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Francesco
 */
public class UtilityRBTree {

    /*
     * la prima chiamata sara' buildRandomRBTree(null, range, false, height, null)
     */
    public static RBNode buildRandomRBTree(RBNode parent, int range, boolean color, int height, Boolean left) {
        RBNode node = null;
        if (height > 0) {
            node = new RBNode();
            Random r = new Random();
            int key = r.nextInt(range);
            if (parent != null) {
                if (left) {
                    //figlio sinistro
                    while (key > parent.getValue()) {
                        //limito il range al valore del padre
                        key = r.nextInt(parent.getValue());
                    }
                } else {
                    //figlio destro
                    while (key < parent.getValue()) {
                        key = r.nextInt(range);
                    }
                }
            }
            height--;
            node.setColor(color);
            node.setParent(parent);
            node.setValue(key);
            node.setLeft(buildRandomRBTree(node, range, !color, height, true));
            node.setRight(buildRandomRBTree(node, range * 2, !color, height, false));
        }

        if (parent != null) {
            if (left) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
        return node;
    }

    public static RBNode findRBTreeRoot(RBNode rbNode) {
        RBNode root = rbNode;
        while (root.getParent() != null) {
            root = (RBNode) rbNode.getParent();
        }
        return root;
    }

    /* ---------------------- WRONG - TODO
    
    public static HashMap<RBNode, Integer> loadRBTree(RBNode node, int height, HashMap<RBNode, Integer> values) {
        if (node != null) {
            //System.out.println("h: " + height);
            values.put(node, height);
            loadRBTree((RBNode) node.getLeft(), --height, values);
            loadRBTree((RBNode) node.getRight(), height++, values);
        }
        return values;
    }

    public static void printRBTree(int height, HashMap<RBNode, Integer> values) {
        for (Map.Entry<RBNode, Integer> entrySet : values.entrySet()) {
            RBNode key = entrySet.getKey();
            Integer value = entrySet.getValue();
            System.out.println(key.getValue());
        }
        while (height > 0) {
            for (int i = 0; i < height; i++) {
                System.err.print("\t\t\t");
            }

            for (RBNode rbNode : values.keySet()) {
                if (values.get(rbNode) == height) {
                    System.err.print(rbNode.getValue());
                    System.err.print("\t\t");
                }
            }
            height--;
            System.err.println("");

        }
    }
    ----------------- END WRONG */
}
