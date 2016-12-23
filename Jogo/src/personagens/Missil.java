package personagens;

import javax.swing.ImageIcon;

public class Missil extends PersonagemPadrao{
	

	private static final int LARGURA_TELA = 1500; //SETA A LARGURA FIXA DA TELA
	private static final int VELOCIDADE = 3;//velocidade do missil em pixels
	
	public Missil(int x, int y){
		super();
		
		super.setX(x); //COORDENADAS DO MISSEL  --- NA TELA
		super.setY(y); //COORDENADAS DO MISSEL  --- NA TELA -- NAO USA NOS INIMIGOS, SOMENTE NAVE...
		
		ImageIcon referencia = new ImageIcon("res\\missel.png"); //APARECER O MISSEL 
		super.setImagem(referencia.getImage()); //PASSANDO PRA CLASSE PAI A IMAGEM
		
		super.setLargura(super.getImagem().getWidth(null));  //PEGANDO AS DIMENSOES DA IMAGEM
		super.setAltura(super.getImagem().getHeight(null));  //PEGANDO AS DIMENSOES DA IMAGEM
		
		super.setVisible(true); //LOOP SETANDO A IMAGEM 
	}
	
	public void movimenta(){
		
		super.setX(super.getX()+VELOCIDADE); //VELOCIDADE DE MOVIMENTAÇÃO DO PERSONAGEM
		if(super.getX() > LARGURA_TELA){  // SE PASSAR DA LARGURA DA TELA, A IMAGEM DEVE SUMIR
			super.setVisible(false);  // QUANDO SAIR DA DIMENSAO DA TELA, APAGAR IMAGEM
		}
	}
}
