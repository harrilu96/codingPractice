package DCP_9_2_MostSimilarWebsites;

public class Pair<S,T> {

    private S left;
    private T right;

    public Pair (S left, T right) {
        this.left = left;
        this.right = right;
    }

    public void setLeft(S left) {
        this.left = left;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public S getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }
}
