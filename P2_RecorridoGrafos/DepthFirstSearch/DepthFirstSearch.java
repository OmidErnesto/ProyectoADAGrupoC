package DepthFirstSearch;

import java.util.Stack;

public class DepthFirstSearch {
	
	public static void DFS(int[][] array,int ancho,int alto,int num) { 
	     	
			int base = array[ancho][ancho]; 
	        int limiteHorizontal = array.length; 
	        int limiteVertical = array[0].length; 
	         
	        boolean[][] visitado = new boolean[limiteHorizontal][limiteVertical]; 
	         
	        Stack<String> stack = new Stack<>(); 
	 
	        stack.push(ancho + "," + ancho); 
	 
	        while (stack.empty() == false) { 
	            String x = stack.pop(); 
	            int fila = Integer.parseInt(x.split(",")[0]); 
	            int columna = Integer.parseInt(x.split(",")[1]); 
	 
	            if(fila<0 || columna<0 || fila>=limiteHorizontal || columna>=limiteVertical || visitado[fila][columna]  
	                      || array[fila][columna] > (base+num)  || array[fila][columna] < (base-num)){ 
	                continue; 
	            } 
	 
	            visitado[fila][columna]=true; 
	            array[fila][columna]=1; 
	            stack.push(fila + "," + (columna-1)); // lado izquierdo del nodo 
	            stack.push(fila + "," + (columna+1)); // lado derecho del nodo  
	            stack.push((fila-1) + "," + columna); // arriba del nodo  
	            stack.push((fila+1) + "," + columna); // abajo del nodo 
	        } 
	    } 
	
}
