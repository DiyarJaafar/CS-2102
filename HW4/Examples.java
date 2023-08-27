import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    //Below objects are for testing the addEltValidator
    HeapChecker testing = new HeapChecker();
    DataHeap valiExampleOne = new DataHeap(3,new DataHeap(4,new MtHeap(),new DataHeap(5)), new DataHeap(6));
    IHeap heap; //Heap to be tested

    public Examples(){

    }

    @Test
    public void checkIfHeap(){
        DataBT twoNodes = new DataBT(3,new DataBT(4), new MtBT());
        assertTrue(twoNodes.isItAHeap());
    }
    @Test
    public void checkIfHeap1(){
        DataBT threeNodes = new DataBT(3,new DataBT(4), new DataBT(1));
        assertFalse(threeNodes.isItAHeap());
    }
    @Test
    public void checkIfHeap2(){
        DataBT fourNodes = new DataBT(1,new DataBT(4,new DataHeap(7,new MtHeap(), new MtHeap()),new MtHeap()), new DataBT(9));
        assertTrue(fourNodes.isItAHeap());
    }
    @Test
    public void chekingTheAddValidatorWithPreMadeHeaps(){
        valiExampleOne.addElt(1);
        DataHeap valiExampleOneAddedOne = new DataHeap(1,new DataHeap(4,new MtHeap(),new DataHeap(5)), new DataHeap(3, new DataHeap(6),new MtHeap()));
        assertTrue(testing.addEltValidator(valiExampleOne,1,valiExampleOneAddedOne));
    }
    @Test
    public void ExampleOneAddValidatorAddingOne(){
        assertTrue(testing.addEltValidator(valiExampleOne,1,valiExampleOne.addElt(1)));
    }
    @Test
    public void chekingTheRemValidatorWithPreMadeHeaps(){
        valiExampleOne.remMinElt();
        DataHeap valiExampleOneRemThree = new DataHeap(4,new DataHeap(5), new DataHeap(6));
        assertTrue(testing.remMinEltValidator(valiExampleOne,valiExampleOneRemThree));
    }
    @Test
    public void ExampleOneRemValidatorRemingThree(){
        assertTrue(testing.remMinEltValidator(valiExampleOne,valiExampleOne.remMinElt()));
    }
    @Test
    public void RemoveElementFromEmptyHeap()
    {
        heap = new MtHeap();
        assertTrue(testing.remMinEltValidator(heap, heap.remMinElt()));
    }
    @Test
    public void RemoveMinElementMultipleInstances()
    {
        heap = new MtHeap();
        heap = heap.addElt(1);
        heap = heap.addElt(2);
        heap = heap.addElt(1);
        heap = heap.addElt(3);
        heap = heap.addElt(1);
        heap = heap.addElt(4);
        assertTrue(testing.remMinEltValidator(heap, heap.remMinElt()));
    }
    @Test
    public void addElementMultipleInstances()
    {
        heap = new MtHeap();
        heap = heap.addElt(4);
        heap = heap.addElt(2);
        heap = heap.addElt(6);
        heap = heap.addElt(1);
        heap = heap.addElt(9);
        heap = heap.addElt(3);
        heap = heap.addElt(5);
        assertTrue(testing.addEltValidator(heap,8, heap.addElt(8)));
    }
}