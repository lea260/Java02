package main;

import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

enum modo {
	  edit,
	  normal,
	  delete
	}


public class Table extends JFrame 
implements ActionListener {
	private int id;
	private String nombre;
	private modo modo1;
	private JLabel label1;
	private JTextField text1;
	private JButton boton1;
	private JButton botonEditar;
	private JButton botonEliminar;	
	private JTable tabla;
	private JScrollPane pane1;
	private DefaultTableModel modelo;
	private final String[] columnas = {"Id", "Nombre"};
	private static Integer indice=1;
	public Table() {
		modo1 = modo.normal;
		setLayout(null);
		label1 = new JLabel("Usuario: ");
		label1.setBounds(10,10,100,30);		
		add(label1);
		
		text1 = new JTextField();
		text1.setBounds(120,10, 150, 30);
		add(text1);
		
		
		//40
		boton1= new JButton("Agregar");
		boton1.setBounds(10, 60, 100, 30);
		add(boton1);
		boton1.addActionListener(this);
		
		botonEditar= new JButton("Editar");
		botonEditar.setBounds(120, 60, 100, 30);
		add(botonEditar);
		botonEditar.addActionListener(this);
		
		//
		botonEliminar= new JButton("Eliminar");
		botonEliminar.setBounds(120, 60, 100, 30);
		add(botonEliminar);
		botonEliminar.addActionListener(this);
		
		
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
	}	
		
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
			String[] datos = {indice.toString(), text1.getText()};
			text1.setText("");
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
		}
		//modelo.setValueAt(aValue, row, column);
		if (e.getSource()==botonEditar) {			
			if (tabla.getSelectedRow() != -1) {
				switch (this.modo1) {
				case normal:
					botonEditar.setText("Confirmar");
					this.modo1 = modo.edit;					
		            String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
		            id = Integer.parseInt(codigo);
		            nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
		            // Lo imprimimos en pantalla
		            System.out.println(codigo);
		            System.out.println(nombre);
		            text1.setText(nombre);					
					break;
				case edit:
					this.modo1 = modo.normal;
					botonEditar.setText("Editar");					
					String texto =  text1.getText();
					//actualizar modelo
					modelo.setValueAt(texto, id, 1);										
					break;
				default:
					
				}							
				
	        } else {
	            System.out.println("Seleccione un renglon primero");
	        }
		}
		
	}
}