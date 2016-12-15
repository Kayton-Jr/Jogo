package janelas;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContainerDeJanelas extends JFrame{
	
	public ContainerDeJanelas(){
		
		//add(new JButton("teste"));//add um componente, no caso um botao
		add(new Fase());
		setTitle("Meu primeiro jogo");//titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setSize(1500,800);//tamanho da janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}

}
