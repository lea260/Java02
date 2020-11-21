package main;

import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame 
implements ActionListener {
	
		private JLabel label1;
		private JTextField text;
		private JButton boton1;
		private JButton botonVer;		
		private JTable tabla;
		private JScrollPane pane1;
		private DefaultTableModel modelo;
		private final String[] columnas = {"Indice", "Nombre"};
		private static Integer indice=1;
		public Table() {
			setLayout(null);
			label1 = new JLabel("Usuario: ");
			label1.setBounds(10,10,100,30);		
			add(label1);
			
			text = new JTextField();
			text.setBounds(120,10, 150, 30);
			add(text);
			
			
			//40
			boton1= new JButton("Agregar");
			boton1.setBounds(10, 60, 100, 30);
			add(boton1);
			boton1.addActionListener(this);
			
			botonVer= new JButton("Ver");
			botonVer.setBounds(120, 60, 100, 30);
			add(botonVer);
			botonVer.addActionListener(this);
			
			
			tabla = new JTable();
			tabla.setBounds(10, 100, 470, 200);
			add(tabla);
			
			modelo = new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			
			agregarDatos();
						
			//260, suma setBounds(x,y, ancho, alto);
			//y+alto+10px separacion
			
			pane1 = new JScrollPane(tabla);
			pane1.setBounds(10, 100, 470, 200);
			add(pane1);
			//boton1.addActionListener((ActionListener) this);
			
			
			/*
			boton1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					label1.setText("apreto boton 01");
				}
				});*/
			//boton1.addActionListener((ActionListener) this);
			
		}//end constructor	
		
		private void agregarDatos() {
	        for (Integer i = 0; i < 9; i++) {
	        	indice = (Integer) i;
	            String mensaje = i + " UNIDADES";

	            // Creamos un nuevo renglon para la tabla
	            String[] datos = {i.toString(), mensaje};
	            // Agregamos los datos a la tabla
	            modelo.addRow(datos);
	        }
	    }
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//this.label1.setText("has apretado botones");
			if (e.getSource()==boton1) {
				indice++;
				String[] datos = {indice.toString(), text.getText()};
				text.setText("");
	            // Agregamos los datos a la tabla
	            modelo.addRow(datos);
			}
			//modelo.setValueAt(aValue, row, column);
			if (e.getSource()==botonVer) {
				if (tabla.getSelectedRow() != -1) {					
		            String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
		            String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
		            // Lo imprimimos en pantalla
		            System.out.println(codigo);
		            System.out.println(nombre);
		            text.setText(nombre);
		        } else {
		            System.out.println("Seleccione un renglon primero");
		        }
			}
			
		}
}