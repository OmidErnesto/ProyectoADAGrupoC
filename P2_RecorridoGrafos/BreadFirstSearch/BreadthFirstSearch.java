package BreadFirstSearch;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch { 
  
 public static void BFS(int[][] array,int X, int Y, int num, Color[][] colores) { 
 
        int limiteHorizontal = array.length; 
        int limiteVertical = array[0].length; 
         
        int base = array[X][Y]; 
        boolean[][] visitado = new boolean[limiteHorizontal][limiteVertical]; 
 
        Queue<String> queue = new LinkedList<>(); 
 
        queue.add(X + "," + Y); 
         
        while (!queue.isEmpty()) { 
 
            String x = queue.remove(); 
            int fila = Integer.parseInt(x.split(",")[0]); 
            int columna = Integer.parseInt(x.split(",")[1]); 
 
            if (fila<0 || columna<0 || fila>=limiteHorizontal || columna>=limiteVertical || visitado[fila][columna]  
                || array[fila][columna] > (base+num)  || array[fila][columna] < (base-num)) {
            	continue; 
            }
 
            visitado[fila][columna] = true;
            array[fila][columna]=1;
            Color c = new Color(0,0,0);
            colores[fila][columna] = c;
             
            queue.add(fila + "," + (columna - 1)); //Izquierda 
            queue.add(fila + "," + (columna + 1)); //Derecha 
            queue.add((fila - 1) + "," + columna); //Arriba 
            queue.add((fila + 1) + "," + columna); //abajo
            
        } 
    } 
}