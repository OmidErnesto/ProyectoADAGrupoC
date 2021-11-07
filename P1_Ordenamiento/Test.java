import java.util.concurrent.ThreadLocalRandom;
import HeapSort.HeapSort;
import QuickSort.QuickSort;

public class Test {
	
	public static void main(String args[]) {
		
        Integer enteros[] = {12,50,99,11,13,78,5,24,66,7,70};
        String cadenas[] = {"mi","nombre","es","Omid","Chahuaris"};
        
        Integer enterosM[] = new Integer[1000];
        for(int i = 0; i < enterosM.length; i++) {
        	int valorEntero = (int) Math.floor(Math.random()*(1000)+1);
        	enterosM[i] = valorEntero;
        }
        	
        String cadenasM[] = new String[1000];
        for(int i = 0; i < cadenasM.length; i++) {
        	String cadenaAleatoria = cadenaAleatoria(10);
        	cadenasM[i] = cadenaAleatoria;
        }
        
        //HeapSort
        
        HeapSort<Integer> ob = new HeapSort<Integer>();
        ob.Heap_Sort(enteros);
        ob.Heap_Sort(enterosM);
        HeapSort<String> ob2 = new HeapSort<String>();
        ob2.Heap_Sort(cadenas);
        ob2.Heap_Sort(cadenasM);
 
        System.out.println("El arreglo de enteros ordenado por HeapSort es:");
        ob.printArray(enteros);
        System.out.println();
        System.out.println("El arreglo de enteros ordenado por HeapSort es:");
        ob.printArray(enterosM);
        System.out.println();
        System.out.println("El arreglo de cadenas ordenado por HeapSort es:");
        ob2.printArray(cadenas);
        System.out.println();
        System.out.println("El arreglo de cadenas ordenado por HeapSort es:");
        ob2.printArray(cadenasM);
        System.out.println();
        
        //QuickSort
        
        QuickSort<Integer> ob3 = new QuickSort<Integer>();
        ob3.Qsort(enteros,0,enteros.length-1);
        ob3.Qsort(enterosM,0,enterosM.length-1);
        QuickSort<String> ob4 = new QuickSort<String>();
        ob4.Qsort(cadenas,0,cadenas.length-1);
        ob4.Qsort(cadenasM,0,cadenasM.length-1);
        
        System.out.println("El arreglo de enteros ordenado por InsertionSort es:");
        ob3.printArray(enteros);
        System.out.println();
        System.out.println("El arreglo de enteros ordenado por QuickSort es:");
        ob3.printArray(enterosM);
        System.out.println();
        System.out.println("El arreglo de cadenas ordenado por InsertionSort es:");
        ob4.printArray(cadenas);
        System.out.println();
        System.out.println("El arreglo de cadenas ordenado por QuickSort es:");
        ob4.printArray(cadenasM);
        System.out.println();
        
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
	
	// Metodo para crear cadenas aleatoria
	public static String cadenaAleatoria(int longitud) {
	    // El banco de caracteres
	    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    // La cadena en donde iremos agregando un carácter aleatorio
	    String cadena = "";
	    for (int x = 0; x < longitud; x++) {
	        int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        cadena += caracterAleatorio;
	    }
	    return cadena;
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
	
}
