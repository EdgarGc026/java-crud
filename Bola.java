
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Bola  {
	private int x, y, direccionX,direccionY,alto,ancho;
	public int diametro;
	private Color coloret;
	

	public Bola(int ancho , int alto) {
		this.ancho = ancho;
		this.alto = alto;
		x=0;
		y=0;
		direccionX = 27;
		direccionY = 27;
		diametro = 20;
		coloret = Color.red;
	}

	public Bola(int ancho , int alto, int diametro) {
		this.ancho = ancho;
		this.alto = alto;
		this.diametro = diametro;
		x = 0;
		y = 0;
		direccionX = 27;
		direccionY = 27;
	}

	public Bola(int ancho , int alto,int diametro,Color coloret) {
		this.ancho = ancho;
		this.alto = alto;
		this.diametro = diametro;
		this.coloret = coloret;
		x = 0;
		y = 0;
		direccionX = 27;
		direccionY = 27;
	}
	
	public void moverBola(){
		//CUANDO llega a la derecha y supera el ancho dela ventana 
		// le restamos -1 asi vamos hacia la izquierda
		if(x + direccionX > ancho - 40){
			direccionX = -27;
		}

		if(x+direccionX<0){
			direccionX = 27;
		}
			
		if(y+direccionY>alto-60){//el alto de la ventana menos el diametro *3 de la pelota para que no se salga del panel
			direccionY = -27;
		}
		
		if(y + direccionY < 0){
			direccionY = 27;
		}

		x = x + direccionX;//// nota ojo
		y = y + direccionY;
	}

	public void pintarBola(Graphics2D g){
		g.fillOval(5+x,30+y,20,20);	
	}

	public Rectangle limiteBola(){
		return new Rectangle(5+x,30+y, diametro, diametro );
	}

	public void rebotaBola(){
		if(x + direccionX > 40){
			direccionX = direccionX - 27;
		}else{
			direccionX = direccionX + 27;
		}
	}

	public boolean TocaFondo(){
		if (x + direccionX > ancho - 40 || x + direccionX < 0){
			return true;
		}else{
			return false;
		}
	}
}
