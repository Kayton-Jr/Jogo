package teste;

import janelas.ContainerDeJanelas;
import janelas.Fase;

public class TJanela {

	public static void main(String[] args) {
		
		ContainerDeJanelas cont = new ContainerDeJanelas();
		if(Fase.isEmJogo)
			cont.dispose();
	}
	
}
