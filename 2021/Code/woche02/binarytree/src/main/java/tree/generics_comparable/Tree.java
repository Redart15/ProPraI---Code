package tree.generics_comparable;

import java.util.*;

public class Tree<T extends Comparable<T>> {

    class ComparableNode<T extends Comparable<? super T>> {
        private ComparableNode<T> left;
        private ComparableNode<T> right;
        private final T value;

        public ComparableNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void insert(ComparableNode<T> that) {
            if (that.value.compareTo(this.value) < 0) {
                insertLeft(that);
            }
            else {
                insertRight(that);
            }
        }

        private void insertRight(ComparableNode<T> that) {
            if (right == null) {
                right = that;
            }
            else {
                right.insert(that);
            }
        }

        private void insertLeft(ComparableNode<T> that) {
            if (left == null) {
                left = that;
            }
            else {
                left.insert(that);
            }
        }

        public void print() {
            if (left != null) {
                left.print();
            }
            System.out.print(" " + value + " ");
            if (right != null) {
                right.print();
            }
        }

    }

    private ComparableNode<T> rootNode;

    public Tree(T root) {
        this.rootNode = new ComparableNode<T>(root);
    }

    public void insert(T t) {
        rootNode.insert(new ComparableNode(t));
    }

    public void print() {
        rootNode.print();
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(15);
        tree.insert(2);
        tree.insert(8);
        tree.insert(-4);
        tree.insert(7);
        tree.insert(19);
        // Compiliert nicht
        //  tree.insert("Kaboom");
        tree.print();

        System.out.println();

        Tree<String> stree = new Tree<>("Hallo");
        stree.insert("Welt");
        stree.insert("I");
        stree.insert("bims");
        stree.print();

        List<String> objects = Collections.emptyList();

    }




}
