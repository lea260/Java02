package main;


public class PrimeraClase {
	public static void main(String args[]) {		
		//FormularioBoton form = new FormularioBoton();
		Form2 form = new Form2();
		//posicion en x, posicion en y
		form.setBounds(0, 0, 300, 150 );
		form.setVisible(true);
		form.setResizable(false);
		//formulario en el centro
		form.setLocationRelativeTo(null);		
	}
}