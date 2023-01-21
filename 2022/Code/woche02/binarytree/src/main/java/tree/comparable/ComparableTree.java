package tree.comparable;

public class ComparableTree {

    class ComparableNode {
        private ComparableNode left;
        private ComparableNode right;
        private final Comparable value;

        public ComparableNode(Comparable value) {
            this.value = value;
        }

        public Comparable getValue() {
            return value;
        }

        public void insert(ComparableNode that) {
            if (that.value.compareTo(this.value) < 0) {
                if (left == null) {
                    left = that;
                }
                else {
                    left.insert(that);
                }
            }
            else {
                if (right == null) {
                    right = that;
                }
                else {
                    right.insert(that);
                }
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

    private ComparableNode rootNode;

    public ComparableTree(Comparable root) {
        this.rootNode = new ComparableNode(root);
    }

    public void insert(Comparable l) {
        rootNode.insert(new ComparableNode(l));
    }

    public void print() {
        rootNode.print();
    }

    public static void main(String[] args) {
        ComparableTree tree = new ComparableTree(15);
        tree.insert(2);
        tree.insert(8);
        tree.insert(-4);
        tree.insert(7);
        tree.insert(19);
        // Kompiliert!
        tree.insert("Kaboom");
        tree.print();
    }


}
