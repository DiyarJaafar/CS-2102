class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    public boolean isBigger(int e) {
        return (this.data >= e);
    }

    /**
     * checks if a binary tree is a heap (root being the smallest)
     * @return boolean wheather the calling BT of this method follows all the rules of being a Heap
     */
    public boolean isItAHeap (){
        //checks the node it is at to make sure its smaller than its sub nodes
        if (!(this.left.isBigger(this.data) && this.right.isBigger(this.data))) {
            return false;
        }
        //recursive call to check the nodes down the sub nodes from the current root
        return this.left.isItAHeap() && this.right.isItAHeap();
    }

    /**
     * makes sure the calling binary tree elements are all contained within the parameter binary tree
     * @param other takes in a BT as an interface type
     * @return boolean wheather the paramter BT contains all the elements of the calling BT
     */
    public boolean containsTheSameElements (IBinTree other){
      //checks if the current node is in the input binary tree or not
        if (!other.hasElt(this.data)) {
            return false;
        }
        //recursively calls the sub nodes to make sure all the elements have been checkes
        return this.left.containsTheSameElements(other) && this.right.containsTheSameElements(other);
    }
}