package janelas;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContainerDeJanelas extends JFrame{
	
	public ContainerDeJanelas(){
		
		add(new JButton("teste"));//add um componente, no caso um botao
		setTitle("Meu primeiro jogo");//titulo
		setSize(500,400);//tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}

}
