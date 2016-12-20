package personagens;

public class Jogador {

	private String nome;
	private String score;
	private static Jogador instance;
	
	private Jogador(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public static Jogador getInstance(){
		if(instance == null){
			instance = new Jogador();
		}
		return instance;
	}
}
