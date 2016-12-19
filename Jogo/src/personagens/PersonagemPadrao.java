package personagens;

import java.awt.Image;
import java.awt.Rectangle;

public class PersonagemPadrao {
	
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int largura, altura;
	private boolean visible;
	
	public PersonagemPadrao(){
		
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
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Rectangle getBounds(){// padrao de jogos, retorna um retangulo
		return new Rectangle(x, y, largura, altura);//facilita o controle do retangulo das imagens, tratar colisoes
	}
}
