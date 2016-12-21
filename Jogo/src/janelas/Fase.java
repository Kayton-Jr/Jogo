package janelas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import personagens.Inimigo;
import personagens.Jogador;
import personagens.Missil;
import personagens.Nave;

public class Fase extends JPanel implements ActionListener{
	
	private Image fundo;
	private Nave nave = Nave.getInstance();
	private Timer timer;
	private boolean emJogo;
	private boolean passaDeFase = false;
	private int fase=1;
	private int score;
	private Jogador jogador = Jogador.getInstance();
	private static boolean mudaTela=false;

	private static List<Inimigo> inimigos = null;
	
	private int[][] coordenadas = { { 2380, 29 }, { 2600, 59 }, { 1380, 89 },
			{ 780, 109 }, { 580, 139 }, { 880, 239 }, { 790, 259 }, { 760, 50 },
			{ 790, 150 }, { 1980, 209 }, { 560, 45 }, { 510, 70 }, { 930, 159 },
			{ 590, 80 }, { 530, 60 }, { 940, 59 }, { 990, 30 }, { 920, 200 },
			{ 900, 259 }, { 660, 50 }, { 540, 90 }, { 810, 220 }, { 860, 20 },
			{ 740, 180 }, { 820, 128 }, { 490, 170 }, { 700, 30 }, { 920, 300 },
			{ 856, 328 }, { 456, 320 } };
	
	public static boolean isMudaTela(){
		return mudaTela;
	}
	
	public Fase(){
		setDoubleBuffered(true);//remover possiveis erros ou coisas do tipo entre passagens de tela
		setFocusable(true);//seta o focu para a tela
		addKeyListener(new TecladoAdapter());//pegar o evento e realizar uma açao para ela
		ImageIcon referencia = new ImageIcon("res\\fundo(3).jpg");
		fundo = referencia.getImage();
		
		score=0;
		emJogo= true;
		
		inicializaInimigos(); 
				
		timer = new Timer(5, this);//a cada 5 ms chamar o construtor de Fase q ira executar uma action(no caso a action implementada na msm classe)
		timer.start();//inicia a thread
	}
	
	public void paint(Graphics g){
		
		Graphics2D graficos = (Graphics2D) g;// classe filha de grafics
		graficos.drawImage(fundo, 0, 0, null);// imagem printada, coordenadas x
												// e y,tratamento para a
												// imagem(observer-modifica o
												// tipo da imagem)

		if (emJogo) {

			graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);

			List<Missil> misseis = nave.getMisseis();

			for (int i = 0; i < misseis.size(); i++) {

				Missil m = (Missil) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			for (int i = 0; i < inimigos.size(); i++) {

				Inimigo in = inimigos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			
			graficos.setColor(Color.white);
			graficos.drawString("Inimigos: "+ inimigos.size(), 5, 15);
			graficos.drawString("Fase: "+fase, 5, 30);

		}
		else{
			ImageIcon fimJogo;
			if(inimigos.isEmpty()){
				fimJogo = new ImageIcon("res\\proxFase.jpg");
			}
			else{
				fimJogo = new ImageIcon("res\\game_over.jpg");
			}			
			
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			graficos.setColor(Color.white);
			graficos.drawString("Pontuação: "+score, 5, 15);
		}
		g.dispose();// limpa a tela para a proxima pintura
		
	}

	@Override       
	public void actionPerformed(ActionEvent e) {//metodo das acoes
		// TODO Auto-generated method stub
		
		if(inimigos.isEmpty()){
			emJogo = false;
			passaDeFase = true;
		}
		
		List<Missil> misseis = nave.getMisseis();
		
		for(int i=0; i<misseis.size(); i++){
			
			Missil m = (Missil) misseis.get(i);
			
			if(m.isVisible()){
				m.movimenta();
			}
			else{
				misseis.remove(i);
			}
		}
		
		for(int i=0; i<inimigos.size(); i++){
			
			Inimigo in = inimigos.get(i);
			
			if(in.isVisible()){
				in.movimenta();
			}
			else{
				inimigos.remove(i);
			}
		}
		
		nave.movimenta();
		checarColisao();
		repaint();//repintar a tela
	}
	
	public void inicializaInimigos(){
		
		inimigos = new ArrayList<Inimigo>();
		
		for(int i=0; i <coordenadas.length; i++){
			inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
		}
	}
	
	public void checarColisao(){
		
		Rectangle formaNave = nave.getBounds();
		Rectangle formaInimigo;
		Rectangle formaMissil;
		
		for(int i=0; i<inimigos.size(); i++){
			
			Inimigo tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();
			
			if(formaNave.intersects(formaInimigo)){
				nave.setVisible(false);
				tempInimigo.setVisible(false);
				
				emJogo=false;
			}
		}
		
		List<Missil> misseis = nave.getMisseis();
		
		for(int i=0; i<misseis.size(); i++){
			
			Missil tempMissil = misseis.get(i);
			formaMissil = tempMissil.getBounds();
			
			for(int j=0; j<inimigos.size(); j++){
				
				Inimigo tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();
				
				if(formaMissil.intersects(formaInimigo)){
					score++;
					tempInimigo.setVisible(false);
					tempMissil.setVisible(false);
				}
				
			}
		}
	}
	
	public void finalizaTela(){
		
		if(!inimigos.isEmpty()){
			Inimigo.resetaVelocidade();
			setVisible(false);
			jogador.setScore(score);
			timer.stop();
			mudaTela=true;
			new GameOver();
		}
	}
	
	public class TecladoAdapter extends KeyAdapter {//classe interna: só serve para esse contexto de fase e precisa acessar os atributos dela

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				emJogo = true;
				if(passaDeFase){
					Inimigo.aumentaVelocidade();
					passaDeFase = false;
					fase++;
				}
				finalizaTela();
				inicializaInimigos();
			}
			
			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}

	}
}
