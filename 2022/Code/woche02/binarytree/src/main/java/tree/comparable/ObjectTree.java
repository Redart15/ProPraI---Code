package tree.comparable;

public class ObjectTree {

    interface Comparator {
        int compare(Object a, Object b);
    }

    private final Comparator comparator;

    class ObjectNode {
        private ObjectNode left;
        private ObjectNode right;

        private final Object value;

        public ObjectNode(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void insert(ObjectNode that) {
            if (comparator.compare(that.value, this.value) < 0) {
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

    private ObjectNode rootNode;

    public ObjectTree(Comparator comparator, Object root) {
        this.comparator = comparator;
        this.rootNode = new ObjectNode(root);
    }

    public void insert(Object l) {
        rootNode.insert(new ObjectNode(l));
    }

    public void print() {
        rootNode.print();
    }

    public static void main(String[] args) {

//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object a, Object b) {
//                if (a instanceof Comparable && b instanceof Comparable) {
//                    Comparable ca = (Comparable) a;
//                    Comparable cb = (Comparable) b;
//                    return ca.compareTo(b);
//                }
//                throw new RuntimeException("Object not tree.comparable");
//            }
//        };

//        Comparator hashComparator = new Comparator() {
//            @Override
//            public int compare(Object a, Object b) {
//                // Irgendeine (eher sinnfreie) Ordnung
//                // funktioniert aber mit jedem Objekt
//                return a.hashCode() - b.hashCode();
//            }
//        };

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object newValue, Object treeValue) {
                Integer that = null;
                if (newValue instanceof String) {
                    that = Integer.parseInt((String) newValue);
                }
                if (newValue instanceof Integer) {
                    that = (Integer) newValue;
                }
                if (newValue instanceof Boolean) {
                    that = ((Boolean) newValue).booleanValue() ? 1 : 0;
                }
                // wenn der Type nicht gefunden wurde gibt es eine NullpointerException
                return that.compareTo((Integer) treeValue);
            }
        };


        ObjectTree tree = new ObjectTree(comparator,15);
        tree.insert(2);
        tree.insert("8");
        tree.insert(-4);
        tree.insert(false);
        tree.insert(19);
        tree.print();
    }


}
