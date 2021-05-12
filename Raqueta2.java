import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Raqueta2 {
	private int y, direccionY, alto, largo;
	private Color coloret;

	public Raqueta2(int alto) {
		y = 0;
		direccionY = 1;
		largo = 70;
		coloret = Color.red;
		this.alto = alto;
	}

	public Raqueta2(int alto, Color coloret) {
		this.alto = alto;
		this.coloret = coloret;
		y = 0;
		direccionY = 1;
	}

	public Raqueta2(int alto, Color coloret, int largo) {
		this.alto = alto;
		this.coloret = coloret;
		this.largo = largo;
		y = 0;
		direccionY = 1;
	}

	//(x + direccionX > 0 && x + direccionX < ancho-largo 
	public void moverRaquetaabajo2() {
		if (y -20>-207 ) {
			y = y -20;
		}
	}

	public void moverRaquetaarriba2() {
		if (y +largo+20< alto-242) {
			y = y +20;
		}
	}

	public void pintarRaqueta2(Graphics2D g) {
		g.fillRoundRect(603,207-y, 20,largo,25,25);
	}

	public Rectangle limiteRaqueta2(){
		return new Rectangle(603,207-y, 20,largo);
	}
}