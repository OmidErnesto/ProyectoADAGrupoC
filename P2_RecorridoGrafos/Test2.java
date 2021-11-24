import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import DepthFirstSearch.DepthFirstSearch;

public class Test2 {

	//Metodo para leer una imagen
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

		BufferedImage imagen = leerImagen();
		System.out.println("La imagen de 20x20 pixeles a sido cargada");
		int resultado [][] = new int[imagen.getWidth()][imagen.getHeight()];

		asignarMatriz(imagen,resultado);
		System.out.println("\nMatriz por recorrido DFS en la coordenada (362,425) con un limite de 80 pixeles para ver la cola amarilla de Dory\n");
		DepthFirstSearch.DFS(resultado,362,425,80);
		imprimirMatriz(resultado);

	}

	//Metodo para guardar en una matriz los valores en escalada de grises de cada pixel de una imagen
	private static int[][] asignarMatriz(BufferedImage imagen, int resultado[][]) {

		int mediaPixel;
		Color colorAux;

		for( int i = 0; i < imagen.getWidth(); i++ ){
			for( int j = 0; j < imagen.getHeight(); j++ ){
				colorAux = new Color(imagen.getRGB(i, j));
				mediaPixel = (int)((colorAux.getRed() * 0.3 +colorAux.getGreen() *0.59 +colorAux.getBlue() * 0.11));
				resultado[i][j] = mediaPixel;
			}
		}
		return resultado;
	}

	//Metodo para imprimir una matriz
	private static void imprimirMatriz(int resultado[][]) {

		for (int x = 0; x < resultado.length; x++) { 
			for (int y = 0; y < resultado[x].length; y++) {
				if(resultado[x][y]== 1)
					System.out.print (resultado[x][y]+" \t");
				else
					System.out.print ("0 \t");
			}
			System.out.println();
		} 
	}

}
