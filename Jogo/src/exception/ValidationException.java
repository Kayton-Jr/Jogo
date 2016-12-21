package exception;

import javax.swing.JOptionPane;

public class ValidationException extends Exception{
	
	public ValidationException(){
		super("Contem caractere especial!");
	}

}
