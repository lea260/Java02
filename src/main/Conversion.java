package main;

import java.awt.event.*;
import javax.swing.*;

public class Conversion extends JFrame 
implements ActionListener, ItemListener {
		private JLabel label1;
		private JLabel label2;
		private JTextField txt1;
		private JTextField txt2;
		private JLabel resultado;		
		private JButton btnSumar;
		public Conversion() {			
			setLayout(null);			
			
			label1 = new JLabel("Valor 01:");
			label1.setBounds(10,10,100,30);		
			add(label1);//add(label1)
			
			txt1 = new JTextField();
			txt1.setBounds(120,10,360,30);		
			add(txt1);//add(label1)
			
			label1 = new JLabel("Valor 02:");
			label1.setBounds(10,50,100,30);		
			add(label1);//add(label1)
			
			txt2 = new JTextField();
			txt2.setBounds(120,50,360,30);		
			add(txt2);//add(label1)			
			
			resultado = new JLabel("Resultado:");
			resultado.setBounds(10,90,100,30);		
			add(resultado);//add(label1)			
			
			btnSumar= new JButton("Sumar:");
			btnSumar.setBounds(10, 130, 470, 30);
			add(btnSumar);
			btnSumar.addActionListener((ActionListener) this);
					
		}//end constructor		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//this.label1.setText("has apretado botones");
			if (e.getSource()==btnSumar) {
				double valor1, valor2;
				//int valor1, valor2;
				//valor1= Integer.parseInt(txt1.getText());
				//valor2= Integer.parseInt(txt2.getText());
				//int resultadoNum= valor1+valor2;
				valor1= Double.parseDouble(txt1.getText());
				valor2= Double.parseDouble(txt2.getText());
				double resultadoNum= valor1+valor2;
				String resultadoStr = String.valueOf("Resultado:"+ resultadoNum);								
				resultado.setText(resultadoStr);
			}			
		}
		
		//captura de evento para combobox
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
