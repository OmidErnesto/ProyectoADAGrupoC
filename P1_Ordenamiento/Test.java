import HeapSort.HeapSort;

public class Test {
	
	public static void main(String args[]) {
        Integer array[] = { 12, 11, 13, 5, 6, 7 };
        String caracteres[] = {"Hola","Soy","Omid"};
        
        HeapSort<Integer> ob = new HeapSort<Integer>();
        ob.sort(array);
        
        HeapSort<String> ob2 = new HeapSort<String>();
        ob2.sort(caracteres);
 
        System.out.println("El arreglo ordenado por HeapSort es:");
        ob2.printArray(caracteres);
    }

}
