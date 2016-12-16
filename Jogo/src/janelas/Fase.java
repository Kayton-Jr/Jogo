package janelas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import personagens.Nave;

public class Fase extends JPanel implements ActionListener{
	
	private Image fundo;
	private Nave nave = Nave.getInstance();
	private Timer timer;
	
	public Fase(){
		
		setDoubleBuffered(true);//remover possiveis erros ou coisas do tipo entre passagens de tela
		setFocusable(true);//seta o focu para a tela
		addKeyListener(new TecladoAdapter());//pegar o evento e realizar uma açao para ela
		ImageIcon referencia = new ImageIcon("res\\fundo.png");
		fundo = referencia.getImage();
				
		timer = new Timer(5, this);//a cada 5 ms chamar o construtor de Fase q ira executar uma action(no caso a action implementada na msm classe)
		timer.start();//inicia a thread
	}
	
	public void paint(Graphics g){
		
		Graphics2D graficos = (Graphics2D) g;//classe filha de grafics
		graficos.drawImage(fundo, 0, 0, null);//imagem printada, coordenadas x e y,tratamento para a imagem(observer-modifica o tipo da imagem)
		graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
		
		g.dispose();// limpa a tela para a proxima pintura
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		nave.movimenta();
		repaint();//repintar a tela
	}

}
