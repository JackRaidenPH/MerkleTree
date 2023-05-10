public class Main {
    public static void main(String[] args) {
        MerkleTree mt = new MerkleTree(9);
        mt.insert(4);
        mt.insert(17);
        mt.insert(3);
        mt.insert(6);
        mt.insert(22);
        mt.insert(5);
        mt.insert(7);
        mt.insert(20);
        mt.insert(60);
        System.out.println(mt);
    }
}