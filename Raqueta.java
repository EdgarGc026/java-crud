import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Raqueta {
	private int y, direccionY, alto, largo;
	private Color coloret;

	public Raqueta(int alto) {
		y = 0;
		direccionY = 1;
		largo = 70;
		coloret = Color.red;
		this.alto = alto;
	}

	public Raqueta(int alto, Color coloret) {
		this.alto = alto;
		this.coloret = coloret;
		y = 0;
		direccionY = 1;
	}

	public Raqueta(int alto, Color coloret, int largo) {
		this.alto = alto;
		this.coloret = coloret;
		this.largo = largo;
		y = 0;
		direccionY = 1;
	}

	//(x + direccionX > 0 && x + direccionX < ancho-largo 
	public void moverRaquetaabajo1() {
		if (y - 20 > -207) { //(484/2-largo)=207  /// ojo largo=70
			y = y -20;
		}
	}

	public void moverRaquetaarriba1() {
		if (y +largo+20< alto-242 ) {//(484/2)=242
			y = y +20;
		}
	}

	public void pintarRaqueta1(Graphics2D g) {
		g.fillRoundRect(15, 207 - y, 20, largo,25,25);
	}

	public Rectangle limiteRaqueta1(){
		return new Rectangle(15,207 - y,  20, largo);
	}
}