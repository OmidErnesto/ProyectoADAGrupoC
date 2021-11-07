## Información de los métodos

**Heap_Sort:** Método que reorganiza el arreglo y extrae uno a uno un elemento del Heap apoyándose del método apilar. Recibe únicamente como  parámetro el arreglo comparable a ordenar.
  
**apilar:** Método recursivo que apila los datos por medio de una raíz comparando con los nodos hijos. Recibe como parámetros el arreglo, el tamaño del arreglo y el mayor como raíz.
  
**Insertion:** Método que ordena por medio del algoritmo de InsertionSort. Recibe únicamente el arreglo como parámetro.  
  
**Qsort:** Método que verifica que el número de elementos del arreglo sea menor a 32 para hacerlo por medio del método de InsertionSort ya que es más eficiente, caso contrario se recurrirá a llamar al método QsortAux para resolverlo por el algoritmo de QuickSort  
  
**QsortAux:** Método que ordena por medio del algoritmo de QuickSort. Recibe como parámetros el arreglo, el índice del primero elemento y el índice del último.  
## Complejidad
HeapSort:  
```
Peor Caso: O(nlogn)  
Caso medio: O(nlogn)  
Mejor caso: O(nlogn)  
```
InsertionSort:  
```
Peor Caso: O(n2)  
Caso medio: O(n2)  
Mejor caso: O(n2)  
```
QuickSoert:  
```
Peor Caso: O(n2)   
Caso medio: O(nlogn)  
Mejor caso: O(nlogn)  
```

## Comparando  
![github-small](http://balsoftware.net/wp-content/uploads/2016/10/quicksort-vs-insertion-sort.gif)
