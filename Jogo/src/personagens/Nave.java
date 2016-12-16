package personagens;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Nave {

	private int x, y;
	private int dx, dy;
	private int altura, largura;
	private Image imagem;
	private static Nave instance;
	private List<Missil> misseis;
	
	public static Nave getInstance() {
		if(instance==null)
			instance = new Nave();
		return instance;
	}

	private Nave(){
		
		ImageIcon referencia = new ImageIcon("res\\nave.gif");
		setImagem(referencia.getImage());
		
		misseis = new ArrayList<Missil>();
		
		this.x=100;
		this.y=100;
		
	}
	
	public void atira(){
		this.misseis.add(new Missil(x+largura, y+altura/2));
	}

	public void movimenta(){
		System.out.println(x+","+y);
		x += dx;//-1 a 1428
		y += dy;//2 a 729
		//colocando os limites da tela
		if(this.x<-1){
			x = -1;
		}
		
		if(this.x>1428){
			x = 1428;
		}
		
		if(this.y<2){
			y = 2;
		}
		
		if(this.y>729){
			y = 729;
		}
	}
	
	public void keyPressed(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_SPACE){
			atira();
		}
		
		if(codigo == KeyEvent.VK_UP){
			dy = -1;
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			dy = 1;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = -1;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 1;
		}
	}
	
	public void keyReleased(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_UP){
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = 0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		
	}

	public List<Missil> getMisseis() {
		return misseis;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	
	
	
}
