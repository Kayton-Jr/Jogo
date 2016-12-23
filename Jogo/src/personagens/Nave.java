package personagens;

import java.awt.event.KeyEvent; 
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Nave extends PersonagemPadrao{

	private static Nave instance;
	private List<Missil> misseis;
	
	public static Nave getInstance() {
		if(instance==null)
			instance = new Nave();
		return instance;
	}

	private Nave(){
		super();
		
		ImageIcon referencia = new ImageIcon("res\\nave.gif");
		super.setImagem(referencia.getImage());
		
		super.setAltura(super.getImagem().getHeight(null));
		super.setLargura(super.getImagem().getWidth(null));
		
		misseis = new ArrayList<Missil>();
		
		super.setX(100);
		super.setY(100);
		
	}
	
	public void atira(){
		this.misseis.add(new Missil(super.getX()+super.getLargura(), super.getY()+super.getAltura()/2));
	}

	public void movimenta(){
		//System.out.println(super.getX()+","+super.getY());
		super.setX(super.getX()+super.getDx());;//1 a 462  // VARIAÇÃO DOS MOVIMENTOS EM X
		super.setY(super.getY()+super.getDy());//1 a 340   // VARIAÇÃO DOS MOVIMENTOS EM Y
		//colocando os limites da tela
		if(super.getX()<1){
			super.setX(1);
		}
		
		if(super.getX()>462){ // LIMITANDO A MOVIMENTAÇÃO DA NAVE NA HORIZONTAL
			super.setX(462);
		}
		
		if(super.getY()<1){
			super.setY(1);
		}
		
		if(super.getY()>340){ // LIMITANDO A MOVIMENTAÇÃO DA NAVE NA VERTICAL
			super.setY(340);
		}
	}
	
	public void keyPressed(KeyEvent tecla){ // MOVIMENTAÇÃO PELO TECLADO
		
		int codigo = tecla.getKeyCode();  // VALORES DE CADA TECLA 
		
		if(codigo == KeyEvent.VK_SPACE){
			atira();
		}
		
		if(codigo == KeyEvent.VK_UP){ 
			super.setDy(-1);  // MOVIMENTAÇÃO EM PIXEL 
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			super.setDy(1);
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			super.setDx(-1);
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			super.setDx(1);
		}
	}
	
	public void keyReleased(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_UP){
			super.setDy(0);
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			super.setDy(0);
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			super.setDx(0);
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			super.setDx(0);
		}
		
	}

	public List<Missil> getMisseis() {
		return misseis;
	}
	
	public static void resetNave(){
		instance = null;
	}
}
