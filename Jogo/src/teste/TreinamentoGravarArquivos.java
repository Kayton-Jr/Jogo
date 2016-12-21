package teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import janelas.GravaPontos;
import personagens.Jogador;

public class TreinamentoGravarArquivos {

	public static void main(String[] args) {
		
		int p1 = 10;
		int p2 = 23;
		int p3 = 45;
		String n1 = "jose";
		String n2 = "paulo";
		String n3 = "Paulo";
		String comp[][] = {{n2},{String.valueOf(p2)}};
		
		Jogador jogador = Jogador.getInstance();
		jogador.getNome();
		jogador.getScore();
		String tempNome[] = new String[10];
		String tempPont[] = new String[10]; 
		
		try {
			InputStream is = new FileInputStream("res\\Placar.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String a[] = new String[10];
			String nomePont[][] = new String[10][2];
			for(int i=0;i<10;i++){
				a[i]=br.readLine();
				nomePont[i] = a[i].split("/");
				tempNome[i] = nomePont[i][0];
				tempPont[i] = nomePont[i][1];
			}
			br.close();
			int tI=0;
			for(int i=0;i<10;i++){
				if(p1>=Integer.parseInt(nomePont[i][1].trim())){
					tI=i;
					for(i=i;i<10;i++){
						if(i+1<10){
							
							nomePont[i+1][1] = tempPont[i];
							nomePont[i+1][0] = tempNome[i];
						}
					}
					nomePont[tI][1] = String.valueOf(p1);
					nomePont[tI][0] = n1;
				}
			}
			
			String retornoN="";
			String retornoP="";
			String retorno="";
			//nomePont=GravaPontos.getPontuacao();
			for(int i=0;i<10;i++){
				
					
				retornoN = nomePont[i][0];
				retornoP = nomePont[i][1];
				
				retornoN = (i+1)+"°"+retornoN;
				retorno += retornoN+"---"+retornoP+"\n";
			}
			
//			OutputStream os = new FileOutputStream("res\\Placar.txt");
//			OutputStreamWriter osw = new OutputStreamWriter(os);
//			BufferedWriter bw = new BufferedWriter(osw);
//			
//			bw.write("NOME/PONTUAÇÃO");
//			bw.newLine();
//			for(int i=0;i<10;i++){
//				bw.write(nomePont[i][0]+"/"+nomePont[i][1]);
//				bw.newLine();
//			}
//			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo");
		}
		
	}
	
	
	public void salvarPontuacao(int score, String nome){
		
		try {
			InputStream is = new FileInputStream("res\\Placar.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String b = br.readLine();
			
			while(b!=null){
				String[] temp = new String[100];
				temp = b.split("******");
			}
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo");
		}
		
	}
	
	public void escrevendo(){
		
		try{
			OutputStream os = new FileOutputStream("res\\Placar.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("teste");
			bw.newLine();
			bw.write("teste2");
			bw.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
