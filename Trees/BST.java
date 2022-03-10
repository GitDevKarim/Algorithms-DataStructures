package Trees;

/*
@author: Karim
@Kaysium

-- BST --
Covers the following:
- Insertion
- Deletion
- Search
- Traversal
- Height
- Minimum
- Maximum
- Number of Nodes 

Time complexity:
At best case, O(log n)
At worst case, O(n)

- Insertion: O(log n)
- Deletion: O(log n)
- Search: O(log n)
- Traversal: O(n)
- Height: O(log n)
- Minimum: O(log n)
- Maximum: O(log n)
*/

import java.util.*;

class BTNode<E> {
    protected E data;
    protected BTNode<E> left, right;

    public BTNode(E data) {
        this.data = data;
    }
}

public class BST<E extends Comparable<E>> {
    protected BTNode<E> root;

    public BST() {
        root = null;
    }

    public BST(BTNode<E> root) {
        this.root = root;
    }

    public BST(E data, BST<E> leftTree, BST<E> rightTree) {
        root = new BTNode<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    void insert(E data) {
        root = insert(root, data);
    }

    BTNode<E> insert(BTNode<E> root, E item) {
        if (root == null) {
            root = new BTNode<E>(item);
            return root;
        } else {
            if (item.compareTo(root.data) < 0) {
                root.left = insert(root.left, item);
            } else if (item.compareTo(root.data) > 0) {
                root.right = insert(root.right, item);
            }
            return root;
        }
    }

    void preorder() {
        System.out.println("\nPreorder Traversal: ");
        preorder(root);
    }

    void preorder(BTNode<E> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder() {
        System.out.println("\nInorder Traversal: ");
        inorder(root);
    }

    void inorder(BTNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void postorder() {
        System.out.println("\nPostorder Traversal: ");
        postorder(root);
    }

    void postorder(BTNode<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    boolean Search(E item) {
        return Search(root, item);
    }

    boolean Search(BTNode<E> root, E item) {
        if (root == null) {
            return false;
        } else if (item.compareTo(root.data) == 0) {
            return true;
        } else if (item.compareTo(root.data) < 0) {
            return Search(root.left, item);
        } else {
            return Search(root.right, item);
        }
    }

    void Maximum() {
        System.out.println("\nMaximum: " + Maximum(root));
    }

    BTNode<E> Maximum(BTNode<E> root) {
        if (root.right != null) {
            Maximum(root.right);
        }
        return root;
    }

    void Minimum() {
        System.out.println("\nMinimum: " + Minimum(root));
    }

    BTNode<E> Minimum(BTNode<E> root) {
        if (root.left != null) {
            Minimum(root.left);
        }
        return root;
    }

    int Nodes(BTNode<E> root) {
        if (root != null) {
            return 1 + Nodes(root.left) + Nodes(root.right);
        } else {
            return 0;
        }
    }

    void deleteNode(E item) {
        root = deleteNode(root, item);
    }

    BTNode<E> deleteNode(BTNode<E> root, E item) {
        if (root == null) {
            return root;

        } else if (item.compareTo(root.data) < 0) {
            root.left = deleteNode(root.left, item);
        } else if (item.compareTo(root.data) > 0) {
            root.right = deleteNode(root.right, item);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.data = Minimum(root.right).data;
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BST<Integer> BST = new BST<>();

        // Insertions
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            BST.insert(sc.nextInt());
        }
        //

        // Travsersal
        BST.preorder();
        BST.inorder();
        BST.postorder();
        System.out.println();
        //

        // Search
        System.out.println("Search: " + BST.Search(sc.nextInt()));
        //

        // Maximum & Minimum
        BST.Maximum();
        BST.Minimum();
        //

        // Nodes
        System.out.println("Nodes: " + BST.Nodes(BST.root));
        //
        sc.close();
    }
}
