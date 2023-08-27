class MtBT implements IBinTree {
    MtBT(){}

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since enpty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    // An empty heap should always lose a competition for which root is smaller (for the merge function)
    public boolean isBigger(int e) {
        return true;
    }
//checks if the calling binary tree is a heap or not
    public boolean isItAHeap() {
        return true;
    }
    //makes sure the calling binary tree elements are all contained within the parameter binary tree
    public boolean containsTheSameElements(IBinTree other) {
        return true;
    }
}