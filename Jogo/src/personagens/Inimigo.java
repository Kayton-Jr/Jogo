package personagens;

import javax.swing.ImageIcon;

public class Inimigo extends PersonagemPadrao{

	private static int contador=0;

	private static final int LARGURA_TELA = 500;
	private static float VELOCIDADE = 1;//velocidade do missil em pixels
	
	public Inimigo(int x, int y){
		super();
		
		super.setX(x);
		super.setY(y);
		
		
		ImageIcon referencia;
		if(contador++ % 3 ==0){
			referencia = new ImageIcon("res\\inimigo2.gif");
		}
		else{
			referencia = new ImageIcon("res\\inimigo1.gif");
		}
		super.setImagem(referencia.getImage());
		
		super.setLargura(super.getImagem().getHeight(null)); 
		super.setAltura(super.getImagem().getWidth(null));
		
		super.setVisible(true);
	}
	
	public void movimenta(){
		
		if(super.getX() < 0){
			super.setX(LARGURA_TELA);
		}
		else{
			super.setX(super.getX()/*-(int)(VELOCIDADE)*/);
		}
	}
	
	public static void setVelocidade(){
		VELOCIDADE = (float)1;
	}
}
