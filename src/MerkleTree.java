import java.util.Objects;

public class MerkleTree {
    HashNode root;

    public MerkleTree(Object obj) {
        this.root = new HashNode(obj);
    }

    private void insert(HashNode node, Object obj) {
        if (Objects.hashCode(obj) < Objects.hashCode(node)) {
            if (node.left == null) {
                node.left = new HashNode(obj, node);
                updateValues(node);
            } else {
                insert(node.left, obj);
            }
        } else {
            if (node.right == null) {
                node.right = new HashNode(obj, node);
                updateValues(node);
            } else {
                insert(node.right, obj);
            }
        }
    }

    private void updateValues(HashNode node) {
        node.value = Objects.hashCode(node.left) + Objects.hashCode(node.right);
        if (node.parent != null) {
            updateValues(node.parent);
        }
    }

    private void updateValues() {
        updateValues(this.root);
    }

    public void insert(Object obj) {
        insert(this.root, obj);
    }

    @Override
    public String toString() {
        return "MerkleTree{" +
                "root=" + root +
                '}';
    }

    public static class HashNode {
        private int value;
        private HashNode parent;
        private HashNode left;
        private HashNode right;

        public HashNode(Object obj) {
            this.value = obj.hashCode();
        }

        public HashNode(Object obj, HashNode parent) {
            this.value = Objects.hashCode(obj);
            this.parent = parent;
        }

        public HashNode(Object obj, HashNode left, HashNode right) {
            this.value = Objects.hashCode(obj);
            this.left = left;
            this.right = right;
        }

        public HashNode(Object obj, HashNode parent, HashNode left, HashNode right) {
            this.value = Objects.hashCode(obj);
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public HashNode setLeft(HashNode left) {
            this.left = left;
            return this;
        }

        public HashNode setRight(HashNode right) {
            this.right = right;
            return this;
        }

        public boolean hasChildren() {
            return (getLeft() != null) || (getRight() != null);
        }

        public boolean bothChildren() {
            return (getLeft() != null) && (getRight() != null);
        }

        public int getValue() {
            return value;
        }

        public HashNode getParent() {
            return parent;
        }

        public HashNode getLeft() {
            return left;
        }

        public HashNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "value=" + value +
                    ",left=" + left +
                    ",right=" + right +
                    '}';
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
