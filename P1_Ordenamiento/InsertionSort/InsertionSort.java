package InsertionSort;

public class InsertionSort<T> {

    public <T extends Comparable<T>> void Insertion(T[] arreglo) {
    	
        int i, j;					//Indices de la lista
        T aux;						//Variable auxiliar para intercambiar valores

        for (j = 1; j < arreglo.length; j++){	//Empezamos en uno
            aux = arreglo[j];					//Guardamos el valor a ordenar
            i = j - 1;
            while ( i >= 0 && arreglo[i].compareTo(aux) >= 1){ //Mientras que sea mayor que aux se ordena
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = aux;				//Ponemos el valor a en su posicion ordenada
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
    