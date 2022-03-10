package Trees;

/*
@author: Karim
@Kaysium

-- AVL Tree --
Constraits:
Height of Left - Right subtree is at most 1

Makes the height of a tree is at most O(log n)
All operations are O(log n)

*/

import java.util.*;

class AVLNode<E> {
    protected E data;
    protected int height;
    protected AVLNode<E> left, right;

    public AVLNode(E data) {
        this.data = data;
        this.height = 0;
    }
}

public class AVL<E extends Comparable<E>> {
    protected AVLNode<E> root;

    public AVL() {
        this.root = null;
    }

    void insert(E data) {
        this.root = RecInsert(root, data);
    }

    AVLNode<E> RecInsert(AVLNode<E> root, E data) {
        if (root == null) {
            root = new AVLNode<E>(data);
            return root;
        } else {
            if (data.compareTo(root.data) < 0) {
                root.left = RecInsert(root.left, data);

                if (getHeight(root.left) - getHeight(root.right) > 1) {
                    if (data.compareTo(root.left.data) < 0) {
                        root = LeftRotation(root);
                    } else {
                        root = DoubleLeft(root);
                    }
                }
            } else if (data.compareTo(root.data) > 0) {
                root.right = RecInsert(root.right, data);

                if (getHeight(root.right) - getHeight(root.left) > 1) {
                    if (data.compareTo(root.right.data) > 0) {
                        root = RightRotation(root);
                    } else {
                        root = DoubleRight(root);
                    }
                }
            }
            return root;
        }
    }

    int getHeight(AVLNode<E> root) {
        return root == null ? -1 : root.height; // -1 or 0 if true
    }

    AVLNode<E> LeftRotation(AVLNode<E> root) {
        AVLNode<E> node = root.left;
        root.left = node.right;
        node.right = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        node.height = Math.max(getHeight(node.left), root.height) + 1;

        return node;
    }

    AVLNode<E> RightRotation(AVLNode<E> root) {
        AVLNode<E> node = root.right;
        root.right = node.left;
        node.left = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        node.height = Math.max(getHeight(node.right), root.height) + 1;

        return node;
    }

    AVLNode<E> DoubleLeft(AVLNode<E> root) {
        root.left = RightRotation(root.left);

        return LeftRotation(root);
    }

    AVLNode<E> DoubleRight(AVLNode<E> root) {
        root.right = LeftRotation(root.right);

        return RightRotation(root);
    }

    void preorder() {
        preorder(root);
    }

    void preorder(AVLNode<E> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        AVL<Integer> AVL = new AVL<Integer>();
        int Size = sc.nextInt();

        for (int i = 0; i < Size; i++) {
            AVL.insert(sc.nextInt());
        }

        AVL.preorder();
        sc.close();
    }
}
