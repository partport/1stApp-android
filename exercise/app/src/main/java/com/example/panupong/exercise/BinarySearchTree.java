package com.example.panupong.exercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static java.lang.System.*;

/**
 * Created by Panupong on 4/21/2016.
 */
public class BinarySearchTree extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigo);
        Node root = new Node(5);
        Log.d("00","Binary Tree Example");
        Log.d("00","Building tree with root value " + root.value);
        insert(root, 1);
        insert(root, 8);
        insert(root, 6);
        insert(root, 3);
        insert(root, 9);
        Log.d("00","Traversing tree in order");
        printInOrder(root);
        Log.d("00","Traversing tree front-to-back from location 7");
    }
    static class Node{
        Node left;
        Node right;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                out.println("  Inserted " + value + " to left of "
                        + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            out.println("  Traversed " + node.value);
            printInOrder(node.right);
        }
    }


}
