package HeapSort;
public class HeapSort<T> {
	public <T extends Comparable<T>> void sort(T[] arreglo) {
		
		int n = arreglo.length;

		// Reorganizar el arreglo 
		for (int i = n/2 - 1; i>=0; i--)
			apilar(arreglo,n,i);

		// Extraer uno por uno los elementos del Heap
		for (int i = n-1; i>0; i--) {
			// Insertar la raiz actual al final del arreglo
			T temp = arreglo[0];
			arreglo[0] = arreglo[i];
			arreglo[i] = temp;

			// Recurrir a la funcion apilar con el nuevo arreglo reducido
			apilar(arreglo,i,0);
		}
	}

	public <T extends Comparable<T>> void apilar(T[] arreglo, int n, int i) {
		
		int mayor = i; // El mayor como raiz
		int izquierdo = 2*i+1;
		int derecho = 2*i+2;

		// Si el hijo izquierdo es mas grande que la raiz
		if (izquierdo < n && arreglo[izquierdo].compareTo(arreglo[mayor]) >= 1)
			mayor = izquierdo;

		// Si el hijo derecho es mas grande que la raiz
		if (derecho < n && arreglo[derecho].compareTo(arreglo[mayor]) >= 1)
			mayor = derecho;

		// Si el mas grande no es la raiz
		if (mayor != i) {
			T aux = arreglo[i];
			arreglo[i] = arreglo[mayor];
			arreglo[mayor] = aux;

			// Aplicar la recursividad del subarbol afectado
			apilar(arreglo, n, mayor);
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
