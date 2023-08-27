import java.lang.Math;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);
//checks if the calling binary tree is a heap or not
 boolean isItAHeap ();
//makes sure the calling binary tree elements are all contained within the parameter binary tree
 boolean containsTheSameElements(IBinTree other);

 }
