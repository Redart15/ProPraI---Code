package tree.no_generics;

public class StringTree {

    class StringNode {
        private StringNode left;
        private StringNode right;
        private final String value;

        public StringNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void insert(StringNode that) {
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

    private StringNode rootNode;

    public StringTree(String root) {
        this.rootNode = new StringNode(root);
    }

    public void insert(String s) {
        rootNode.insert(new StringNode(s));
    }

    public void print() {
        rootNode.print();
    }

    public static void main(String[] args) {
        StringTree tree = new StringTree("Hallo");
        tree.insert("Welt");
        tree.insert("I");
        tree.insert("bims");
        tree.print();
    }


}
