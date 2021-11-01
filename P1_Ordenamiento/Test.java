import HeapSort.HeapSort;

public class Test {
	
	public static void main(String args[]) {
		
        Integer array[] = { 12, 11, 13, 5, 6, 7 };
        
        HeapSort<Integer> ob = new HeapSort<Integer>();
        ob.sort(array);
 
        System.out.println("El arreglo ordenado por HeapSort es:");
        ob.printArray(array);
    }

}
