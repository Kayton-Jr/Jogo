package janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import personagens.Jogador;
import Exception.ValidationException;

public class Login extends JFrame{
	
	private JTextField nomeField;
	private Jogador jogador = Jogador.getInstance();
	private String iniciarJogo;

	public Login(){
		
		criarMenu();
		criarFomulario();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setSize(500,420);//tamanho da janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}
	
	public String getIniciarJogo() {
		return iniciarJogo;
	}

	public void criarFomulario(){
		
		setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastro do Jogador");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeField = new JTextField(10);
		
		panelCadastro.add(nomeLabel);
		panelCadastro.add(nomeField);		
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if(!nomeField.getText().matches("^[a-z0-9A-Z]*$")){
						throw new ValidationException();
					}
					else if(nomeField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "O nome do jogador nao pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					else{
						jogador.setNome(nomeField.getText());
						JOptionPane.showMessageDialog(null, "Jogador salvo", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
						iniciarJogo = JOptionPane.showInputDialog("Deseja inciar o jogo?\nSim ou Não");
						if("sim".equalsIgnoreCase(iniciarJogo)){
							dispose();
							new Jogo();
						}
						}
				}
				catch(ValidationException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				nomeField.setText("");
			}
			
		});
		
		panelBotoes.add(botaoSalvar);
		panelBotoes.add(botaoLimpar);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelCadastro, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
		setBackground(Color.gray);
		
	}

	public void criarMenu(){
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
	}
	
	
}
