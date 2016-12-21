package janelas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

import personagens.Jogador;

public class GravaPontos {

	private int score;
	private String nome;
	private String nomePont[][] = new String[10][2];
	
	public GravaPontos(Jogador jogador){
		this.score = jogador.getScore();
		this.nome = jogador.getNome();
	}
	
	public String[][] getNomePont() {
		checaPontos();
		return nomePont;
	}

	public void checaPontos(){
		
		String tempNome[] = new String[10];
		String tempPont[] = new String[10]; 
		
		try {
			InputStream is = new FileInputStream("res\\Placar.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String a[] = new String[10];
			for(int i=0;i<10;i++){
				a[i]=br.readLine();
				nomePont[i] = a[i].split("/");
				tempNome[i] = nomePont[i][0];
				tempPont[i] = nomePont[i][1];
			}
			br.close();
			int tI=0;
			for(int i=0;i<10;i++){
				if(this.score>=Integer.parseInt(nomePont[i][1].trim())){
					tI=i;
					for(i=i;i<10;i++){
						if(i+1<10){
							
							nomePont[i+1][1] = tempPont[i];
							nomePont[i+1][0] = tempNome[i];
						}
					}
					nomePont[tI][1] = String.valueOf(this.score);
					nomePont[tI][0] = this.nome;
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo");
		}
	}
	
	public void salvaPontos(){
		
		try {
			OutputStream os = new FileOutputStream("res\\Placar.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			for(int i=0;i<10;i++){
				bw.write(nomePont[i][0]+"/"+nomePont[i][1]);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo");
		}
	}
}
