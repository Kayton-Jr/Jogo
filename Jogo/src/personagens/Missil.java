package personagens;

import javax.swing.ImageIcon;

public class Missil extends PersonagemPadrao{
	

	private static final int LARGURA_TELA = 1500;
	private static final int VELOCIDADE = 2;//velocidade do missil em pixels
	
	public Missil(int x, int y){
		super();
		
		super.setX(x);
		super.setY(y);
		
		ImageIcon referencia = new ImageIcon("res\\missel.png");
		super.setImagem(referencia.getImage());
		
		super.setLargura(super.getImagem().getWidth(null));    
		super.setAltura(super.getImagem().getHeight(null));
		
		super.setVisible(true);
	}
	
	public void movimenta(){
		
		super.setX(super.getX()+VELOCIDADE);
		if(super.getX() > LARGURA_TELA){
			super.setVisible(false);
		}
	}
}
