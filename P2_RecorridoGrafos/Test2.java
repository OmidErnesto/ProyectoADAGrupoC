import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Test2 extends JFrame {
	
	JLabel jLabelObject = new JLabel();
	private static final int ANCHO = 900;
	private static final int ALTO = 700;
	String ruta;
	
	public Test2(String ruta){
		
		this.ruta = ruta;
		setSize(ANCHO,ALTO);
		setTitle("RECORRER IMAGEN");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		leerImagen();
		setVisible(true);
		
	}
	

	public void leerImagen() {

		jLabelObject = new JLabel();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(ruta));
			escalaGrises(img);
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		Image dimg = img.getScaledInstance(500, 700,Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(dimg);
		jLabelObject.setIcon(logo);

		add(jLabelObject);

	}
	
	public static void main(String args[]) {
		
		new Test2("P2_RecorridoGrafos/images/imagen.png");
	}
	
	public BufferedImage escalaGrises(BufferedImage imageActual){
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

}
