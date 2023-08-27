public class HeapChecker {

    /**
     * Checks that an element has been properly added to a heap, returns true if yes
     * @param oHeap - heap to which the element is added
     * @param toBeAdded - element added to heap
     * @param nHeap - heap with element added to it
     */
    public boolean addEltValidator(IHeap oHeap, int toBeAdded, IBinTree nHeap){
        //makes sure the new heap does not contain excess or less elements than it should
        if (oHeap.size()+1!=nHeap.size()){
            return false;
        }
        //makes sure it has the added element in addition to the original elements of the heap (calls the function that checks the same element)
        if (!(nHeap.hasElt(toBeAdded) && oHeap.containsTheSameElements(nHeap))){
            return false;
        }
        //makes sure it is a heap with the root being the smallest by calling the helper method
        if (!nHeap.isItAHeap()){
            return false;
        }
        //it returns true when none of the above rules of the heap and addElt method is violated
        return true;
    }
    /**
     * Checks that the minimum element has been properly removed from a heap, returns true if yes
     * @param oHeap - heap before removal of minimum element
     * @param nHeap - heap with minimum element removed
     */

    public boolean remMinEltValidator (IHeap oHeap, IBinTree nHeap){
        //Checks that non-empty original heap size is one greater than new heap size, or that empty original heap returns new heap size 0
        if (((oHeap.size()-1 != nHeap.size()) && (oHeap.size() != 0)) || (oHeap.size() == 0 && nHeap.size() != 0)){
            return false;
        }
        //checks whether the new heap containa the orginal elemens
        if (!nHeap.containsTheSameElements(oHeap)){
            return false;
        }
        //it returns true when none of the above rules of the heap and remMinElt method is violated
        return nHeap.isItAHeap();
    }


}
