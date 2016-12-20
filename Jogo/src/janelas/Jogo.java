package janelas;

import javax.swing.JFrame;

public class Jogo extends JFrame{

	public Jogo(){
		
		add(new Fase());
		setTitle("Meu primeiro jogo");//titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setSize(500,420);//tamanho da janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}
	
}
