package personagens;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missil {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private boolean isVisible;
	
	private static final int LARGURA_TELA = 1500;
	private static final int VELOCIDADE = 2;//velocidade do missil em pixels
	
	public Missil(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referencia = new ImageIcon("res\\missel");
		imagem = referencia.getImage();
		
		isVisible = true;
	}
	
	
}
