package personagens;

import javax.swing.ImageIcon;

public class Inimigo extends PersonagemPadrao{

	private static int contador=0;

	private static final int LARGURA_TELA = 500; //SETA A LARGURA FIXA DA TELA
	private static int VELOCIDADE = 1;//velocidade do missil em pixels
	
	public Inimigo(int x, int y){
		super();
		
		super.setX(x);  //COORDENADAS DO MISSEL  --- NA TELA
		super.setY(y);  //COORDENADAS DO MISSEL  --- NA TELA -- NAO USA NOS INIMIGOS, SOMENTE NAVE...
		
		
		ImageIcon referencia;
		if(contador++ % 3 ==0){ // DIFERENCIAR OS INIMIGOS --- TROCANDO AS IMAGENS DOS INIMIGOS
			referencia = new ImageIcon("res\\inimigo2.gif");//CHAMANDO IMAGEM DA PASTA UML
		}
		else{
			referencia = new ImageIcon("res\\inimigo1.gif"); //CHAMANDO IMAGEM DA PASTA UML
		}
		super.setImagem(referencia.getImage()); //PASSANDO PRA CLASSE PAI A IMAGEM
		
		super.setLargura(super.getImagem().getHeight(null)); //PEGANDO AS DIMENSOES DA IMAGEM
		super.setAltura(super.getImagem().getWidth(null));  //PEGANDO AS DIMENSOES DA IMAGEM
		
		super.setVisible(true); //LOOP SETANDO A IMAGEM 
	}
	
	public void movimenta(){
		
		if(super.getX() < 0){
			super.setX(LARGURA_TELA);  // SE PASSAR DA LARGURA DA TELA, A IMAGEM DEVE SUMIR
		}
		else{
			super.setX(super.getX()-(VELOCIDADE)); // MOVIMENTA PARA A DIRECAO DA NAVE 
		}
	}
	
	public static void aumentaVelocidade(){
		VELOCIDADE++;
	}
	
	public static void resetaVelocidade(){
		VELOCIDADE = 1;
	}
}
