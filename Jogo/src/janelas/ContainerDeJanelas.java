package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class ContainerDeJanelas extends JFrame{
	
	public ContainerDeJanelas(){
		
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"Jogo desenvolvido pelo grupo:\n"
						+ "Klayton Jr"
						+ "\nMarcus Vinicius"
						+ "\nVictor Hugo Marques", "Informacoes", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(sair);
		
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu);
		
		//add(new JButton("teste"));//add um componente, no caso um botao
		add(new Fase());
		setTitle("Meu primeiro jogo");//titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setSize(500,420);//tamanho da janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}

}
