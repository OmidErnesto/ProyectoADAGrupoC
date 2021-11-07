import HeapSort.HeapSort;
import QuickSort.QuickSort;

public class Test {
	
	public static void main(String args[]) {
		
        Integer enteros[] = {12,50,99,11,13,78,5,24,66,7,70};
        String cadenas[] = {"mi","nombre","es","Omid","Chahuaris"};
        
        //HeapSort
        
        HeapSort<Integer> ob = new HeapSort<Integer>();
        ob.sort(enteros);
        HeapSort<String> ob2 = new HeapSort<String>();
        ob2.sort(cadenas);
 
        System.out.println("El arreglo de enteros ordenado por HeapSort es:");
        ob.printArray(enteros);
        System.out.println("El arreglo de cadenas ordenado por HeapSort es:");
        ob2.printArray(cadenas);
        
        //QuickSort
        
        Integer enteros2[] = {12,50,99,11,13,78,5,24,66,7,70};
        String cadenas2[] = {"mi","nombre","es","Omid","Chahuaris"};
        
        QuickSort<Integer> ob3 = new QuickSort<Integer>();
        ob3.Qsort(enteros2,0,enteros2.length-1);
        QuickSort<String> ob4 = new QuickSort<String>();
        ob4.Qsort(cadenas2,0,cadenas2.length-1);
 
        System.out.println("El arreglo de enteros ordenado por QuickSort es:");
        ob3.printArray(enteros2);
        System.out.println("El arreglo de cadenas ordenado por QuickSort es:");
        ob4.printArray(cadenas2);
        
        /*
        //InsertionSort
        
        Integer enteros3[] = {12,50,99,11,13,78,5,24,66,7,70};
        String cadenas3[] = {"mi","nombre","es","Omid","Chahuaris"};
        
        InsertionSort<Integer> ob5 = new InsertionSort<Integer>();
        ob5.Insertion(enteros3);
        InsertionSort<String> ob6 = new InsertionSort<String>();
        ob6.Insertion(cadenas3);
        
        System.out.println("El arreglo de enteros ordenado por InsertionSort es:");
        ob5.printArray(enteros2);
        System.out.println("El arreglo de cadenas ordenado por InsertionSort es:");
        ob6.printArray(cadenas2);
        */
        
        
        
     
    }

}
