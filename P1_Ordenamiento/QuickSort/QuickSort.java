package QuickSort;
import InsertionSort.InsertionSort;

public class QuickSort<T> {
	
	public <T extends Comparable<T>> void Qsort(T A[], int izquierda, int derecha) {
		int n = A.length;
		if(n <= 20) {
			InsertionSort.Insertion(A);
		}
		else {
			QsortAux(A,izquierda,derecha);
		}
	}

    public <T extends Comparable<T>> void QsortAux(T A[], int izquierda, int derecha) {

        T piv = A[izquierda]; 	  //el pivote sera el primer elemento
        int i = izquierda;        //busqueda de izquierda a derecha
        int j = derecha;          //busqueda de derecha a izquierda
        T aux;

        while(i<j) {                          			//mientras no se crucen                                   
            while(piv.compareTo(A[i])>=0 && i<j) {
                i++; 									//busca el elemento mayor que pivote
            }
            while(A[j].compareTo(piv)> 0) {
                j--;           							//busca el elemento menor que pivote
            }
            if (i<j) {                        			//si no hay cruce                      
                aux = A[i];                      		//se intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izquierda] = A[j];      						//se coloca el pivote en su posicion ordenada                                    
        A[j] = piv;      								//se coloca menores a su izquierda y mayores a su derecha

        if (izquierda < j-1) {
            Qsort(A,izquierda,j-1);          		//recursividad para ordenar el subarray izquierdo
        }
        if (j+1 < derecha) {
            Qsort(A,j+1,derecha);          			//recrusividad para order el subarray derecho
        }
    }
    
    /* Imprimir */
	public void printArray(T[] arreglo) {
		int n = arreglo.length;
		for (int i=0; i<n; i++)
			System.out.print(arreglo[i] + " ");
		System.out.println();
	}
   
}