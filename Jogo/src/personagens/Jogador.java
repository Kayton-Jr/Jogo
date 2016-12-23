package personagens;

public class Jogador {

	private String nome;  //PARA SETAR O USUARIO 
	private int score;
	private static Jogador instance;
	
	public Jogador(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public static Jogador getInstance(){
		if(instance == null){
			instance = new Jogador();
		}
		return instance;
	}
}
