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

public class TreinamentoGravarArquivos {

	public static void main(String[] args) {
		
		int p1 = 10;
		int p2 = 23;
		int p3 = 45;
		String n1 = "jose";
		String n2 = "paulo";
		String n3 = "Paulo";
		String comp[][] = {{n2},{String.valueOf(p2)}};
		
		try {
			InputStream is = new FileInputStream("res\\Placar.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String a[] = new String[11];
			String nomePont[][] = new String[11][11];
			String nome[] = new String[11];
			String pont[] = new String[11];
			//String pont[] = new String[11];
			br.readLine();
			for(int i=0;i<=10;i++){
				a[i]=br.readLine();
				nomePont[i] = a[i].split("/");
				nome[i] = nomePont[i][1];
				pont[i] = nomePont[i][2];
				if(p2<=Integer.parseInt(nomePont[i][2].trim())){
					nomePont[i++][2] = nomePont[i][2];
					nomePont[i][2] = comp[0][0];
				}
			}
			System.out.println("");
			//String b = br.readLine();
			
//			while(b!=null){
//				String[] temp = new String[100];
//				temp = b.split("******");
//			}
			br.close();
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
