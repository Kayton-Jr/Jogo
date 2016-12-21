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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import exception.ValidationException;
import personagens.Jogador;

public class GameOver extends JFrame{
	
	private String nomePont[][] = new String[10][2];
	private Jogador jogador = Jogador.getInstance();
	private GravaPontos gravar = new GravaPontos(jogador);
	
	public GameOver(){
		
		criarPlacar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botao de fechar a janela
		setSize(500,420);//tamanho da janela
		setLocationRelativeTo(null);//define quando ira abrir a janela quando clicar ou passar em outro componente
		setResizable(false);//define se a tela pode ser ajustada o tamanho
		setVisible(true);//define a aparicaçao da janela
	}
	
	public void criarPlacar(){
		
		setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Pontuação");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelJogadores = new JPanel();
		panelJogadores.setLayout(new FlowLayout());
		
		JTextArea texto  = new JTextArea();
		texto.setEditable(false);
		texto.setText(setPlacar());
		
		panelJogadores.add(texto);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoSalvar = new JButton("Salvar sua pontuação");
		botaoSalvar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					gravar.salvaPontos();
					JOptionPane.showMessageDialog(null, "Pontuação salva com sucesso!", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		JButton botaoReiniciar = new JButton("Recomeçar jogo");
		botaoReiniciar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Jogo();
			}
			
		});
		
		panelBotoes.add(botaoSalvar);
		panelBotoes.add(botaoReiniciar);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelJogadores,BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
		setBackground(Color.GRAY);
	}
	
	public String setPlacar(){
		
		String retornoN="";
		String retornoP="";
		String retorno="";
		nomePont = gravar.getNomePont();
		for(int i=0;i<10;i++){
			
				
			retornoN = nomePont[i][0];
			retornoP = nomePont[i][1];
			
			retornoN = (i+1)+"°"+retornoN;
			retorno += retornoN+"---"+retornoP+"\n";
		}
		return retorno;
	}
}
