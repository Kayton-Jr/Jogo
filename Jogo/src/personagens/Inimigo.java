package personagens;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int largura, altura;
	private boolean visible;
	private static int contador=0;

	private static final int LARGURA_TELA = 1500;
	private static final int VELOCIDADE = 1;//velocidade do missil em pixels
	
	public Inimigo(int x, int y){
		this.x = x;
		this.y = y;
		
		
		ImageIcon referencia;
		if(contador++ % 3 ==0){
			referencia = new ImageIcon("res\\inimigo2.gif");
		}
		else{
			referencia = new ImageIcon("res\\inimigo1.gif");
		}
		imagem = referencia.getImage();
		
		this.largura = imagem.getHeight(null);
		this.altura = imagem.getWidth(null);
		
		visible = true;
	}
	
	public Rectangle getBounds(){// padrao de jogos, retorna um retangulo
		return new Rectangle(x, y, largura, altura);
	}
	
	public void movimenta(){
		
		if(this.x < 0){
			this.x = LARGURA_TELA;
		}
		else{
			this.x -= VELOCIDADE;
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
