package janelas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import personagens.Nave;

public class TecladoAdapter extends KeyAdapter{

	private Nave nave = Nave.getInstance();
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		nave.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		nave.keyReleased(e);
	}
}
