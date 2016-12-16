package personagens;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missil {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int largura, altura;
	private boolean visible;
	

	private static final int LARGURA_TELA = 1500;
	private static final int VELOCIDADE = 2;//velocidade do missil em pixels
	
	public Missil(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referencia = new ImageIcon("res\\missel(2).png");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);    
		this.altura = imagem.getHeight(null);
		
		visible = true;
	}
	
	public Rectangle getBounds(){// padrao de jogos, retorna um retangulo
		return new Rectangle(x, y, largura, altura);
	}
	
	public void movimenta(){
		
		this.x += VELOCIDADE;
		if(this.x > LARGURA_TELA){
			visible = false;
		}
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean Visible) {
		this.visible = Visible;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
}
