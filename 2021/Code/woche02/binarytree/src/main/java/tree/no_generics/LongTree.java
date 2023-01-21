package tree.no_generics;

public class LongTree {

    class LongNode {
        private LongNode left;
        private LongNode right;
        private final Long value;

        public LongNode(Long value) {
            this.value = value;
        }

        public Number getValue() {
            return value;
        }

        public void insert(LongNode that) {
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

    private LongNode rootNode;

    public LongTree(long root) {
        this.rootNode = new LongNode(root);
    }

    public void insert(long l) {
        rootNode.insert(new LongNode(l));
    }

    public void print() {
        rootNode.print();
    }

    public static void main(String[] args) {
        LongTree tree = new LongTree(15);
        tree.insert(2);
        tree.insert(8);
        tree.insert(-4);
        tree.insert(7);
        tree.insert(19);
        tree.print();
    }


}
