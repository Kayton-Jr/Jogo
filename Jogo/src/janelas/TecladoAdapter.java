package janelas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import personagens.Inimigo;
import personagens.Nave;

public class TecladoAdapter extends KeyAdapter{

	private Nave nave = Nave.getInstance();
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
//			new Fase();
			//new ContainerDeJanelas();
			Fase faseNova = new Fase();
			faseNova.setEmJogo(true);
			faseNova.inicializaInimigos();
			Inimigo.setVelocidade();
		}
		
		nave.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		nave.keyReleased(e);
	}
}
