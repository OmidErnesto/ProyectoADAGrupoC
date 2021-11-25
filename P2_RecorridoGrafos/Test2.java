import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import BreadFirstSearch.BreadthFirstSearch;
import DepthFirstSearch.DepthFirstSearch;

public class Test2 {

	//Metodo para leer la imagen de dory
	public static BufferedImage leerImagen() {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("P2_RecorridoGrafos/images/dory.jpg"));
			escalaGrises(img);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	//Metodo para leer la imagen de nemo
		public static BufferedImage leerImagen2() {

			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("P2_RecorridoGrafos/images/nemo.jpg"));
				escalaGrises(img);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return img;
		}

	//Metodo para pasar a escala de grises una imagen
	public static BufferedImage escalaGrises(BufferedImage imageActual){
		//Variables que almacenarán los píxeles
		int mediaPixel,colorSRGB;
		Color colorAux;

		//Recorremos la imagen píxel a píxel
		for( int i = 0; i < imageActual.getWidth(); i++ ){
			for( int j = 0; j < imageActual.getHeight(); j++ ){
				//Almacenamos el color del píxel
				colorAux=new Color(imageActual.getRGB(i, j));
				//Calculamos la media de los tres canales (rojo, verde, azul)
				mediaPixel=(int)((colorAux.getRed() * 0.3 +colorAux.getGreen() *0.59 +colorAux.getBlue() * 0.11));
				//Cambiamos a formato sRGB
				colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
				//Asignamos el nuevo valor al BufferedImage
				imageActual.setRGB(i, j,colorSRGB);
			}
		}
		return imageActual;
	}

	public static void main(String args[]) {	
		
		//Leer a Dory
		BufferedImage imagen = leerImagen();
		System.out.println("La imagen de 20x20 pixeles a sido cargada");
		int resultado [][] = new int [imagen.getHeight()][imagen.getWidth()];
		Color colores [][] = new Color[imagen.getHeight()][imagen.getWidth()];
		asignarMatrizColor(imagen,colores);

		asignarMatriz(imagen,resultado);
		System.out.println("\nMatriz por recorrido DFS en la coordenada (458,343) con un limite de 58 pixeles para ver la cola amarilla de Dory\n");
		DepthFirstSearch.DFS(resultado,458,343,58,colores);
		
		BufferedImage resultadoImg = imprimirImagen(colores);
		File outputfile = new File("G:/UNSA/SegundoAño/ADA/ProyectoADAGrupoC/P2_RecorridoGrafos/images/resultado.png");
		
		try {
			ImageIO.write(resultadoImg, "png", outputfile);
			System.out.println("Imagen guardada Correctamemte");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Leer a Nemo
		BufferedImage imagen2 = leerImagen2();
		int resultado2 [][] = new int [imagen.getHeight()][imagen.getWidth()];
		Color colores2 [][] = new Color[imagen.getHeight()][imagen.getWidth()];
		asignarMatrizColor(imagen2,colores2);
		
		asignarMatriz(imagen2,resultado2);
		System.out.println("\nMatriz por recorrido BFS en la coordenada (240,630) con un limite de 40 pixeles para ver la mancha blanca de Nemo\n");
		BreadthFirstSearch.BFS(resultado2,240,630,40,colores2);
		
		BufferedImage resultadoImg2 = imprimirImagen(colores2);
		File outputfile2 = new File("G:/UNSA/SegundoAño/ADA/ProyectoADAGrupoC/P2_RecorridoGrafos/images/resultado2.png");
		
		try {
			ImageIO.write(resultadoImg2, "png", outputfile2);
			System.out.println("Imagen 2 guardada Correctamemte");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static BufferedImage imprimirImagen(Color[][]arreglo) {
		
		BufferedImage salida = new BufferedImage(arreglo[0].length,arreglo.length, BufferedImage.TYPE_INT_RGB);
		for( int i = 0; i < arreglo.length; i++ ){
			for( int j = 0; j < arreglo[0].length; j++ ){
				salida.setRGB(j, i, arreglo[i][j].getRGB());
			}
		}
		return salida;
		
	}
	
	private static void asignarMatrizColor(BufferedImage imagen,Color[][] color) {
		
		for( int i = 0; i < imagen.getHeight(); i++ ){
			for( int j = 0; j < imagen.getWidth(); j++ ){
				color[i][j] = new Color(imagen.getRGB(j, i));
			}
		}
	
	}

	//Metodo para guardar en una matriz los valores en escalada de grises de cada pixel de una imagen
	private static void asignarMatriz(BufferedImage imagen, int resultado[][]) {

		int mediaPixel;
		Color colorAux;

		for( int i = 0; i < imagen.getHeight(); i++ ){
			for( int j = 0; j < imagen.getWidth(); j++ ){
				colorAux = new Color(imagen.getRGB(j, i));
				mediaPixel = (int)((colorAux.getRed() * 0.3 +colorAux.getGreen() *0.59 +colorAux.getBlue() * 0.11));
				resultado[i][j] = mediaPixel;
			}
		}
	}

}
