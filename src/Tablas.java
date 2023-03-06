import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class Tablas extends AbstractTableModel{
	static boolean prueba=false;
	static String tipoSel="defecto";
	static String modoSel="defecto";
	public static void main(String[] args){
		JFrame frame = new JFrame("Tabla");
		BorderLayout bl = new BorderLayout();
		JPanel panel = new JPanel(bl) {
			@Override
	        protected void paintComponent(Graphics grphcs) {
	            super.paintComponent(grphcs);
	            Graphics2D g2d = (Graphics2D) grphcs;
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            GradientPaint gp = new GradientPaint(0, 100,
	                    Color.decode("#80D0C7"), 1000, getHeight(),
	                    Color.decode("#0093E9"), true);
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }
		};
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		frame.add(panel);
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		Color bordes = Color.decode("#75E6DA");
		Color fondoTexto = Color.decode("#D4F1F4");
		Color cabecera = Color.decode("#75E6DA");
		
		 
		String[] columnNames = {"Titulo",
                "Autor",
                "Año publicacion",
                "Editorial",
                "ISBN"};
		Object[][] data = {
			{"Pride and Prejudice", "Jane Austen", "1813", "T. Egerton, Whitehall", "38659585"},
			{"Harry Potter and The Deathly Hallows", "J.K. Rowling", "2010", "Bloomsbury", "1345643256"},
			{"EL HOMBRE QUE TENÍA MIEDO A VIVIR", "Miguel Angel Montero", "2018", "Anaya", "8409049325"},
			{"La Bestia", "Carmen Mola", "2022", "Booket", "840826284X"},
			{"Las herederas de la Singer","Otra persona" ,"2022", "Grijalbo", "8425360978"},
			{"Pride and Prejudice", "Jane Austen", "1813", "T. Egerton, Whitehall", "38659585"},
			{"Harry Potter and The Deathly Hallows", "J.K. Rowling", "2010", "Bloomsbury", "1345643256"},
			{"EL HOMBRE QUE TENÍA MIEDO A VIVIR", "Miguel Angel Montero", "2018", "Anaya", "8409049325"},
			{"La Bestia", "Carmen Mola", "2022", "Booket", "840826284X"},
			{"Las herederas de la Singer","Otra persona" ,"2022", "Grijalbo", "8425360978"}
		};
		JTable table = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(table);
		table.setFillsViewportHeight(false);
		sp.setPreferredSize(new Dimension(600, 150));
		table.setBackground(fondoTexto);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(cabecera);
		panel.add(sp, BorderLayout.NORTH);
		TableColumn columna = null;
		for (int i = 0; i < 5; i++) {
		    columna = table.getColumnModel().getColumn(i);
		    if (i == 0) {
		        columna.setPreferredWidth(100);
		    } 
		    else if(i==1) {
		    	columna.setPreferredWidth(75);
		    }
		    else if(i==2){
		    	columna.setPreferredWidth(15);
		    }
		    else if(i==3){
		    	columna.setPreferredWidth(75);
		    }
		    else {
		        columna.setPreferredWidth(50);
		    }
		}
		
		
		
		JRadioButton filas = new JRadioButton("Filas");
		filas.setOpaque(false);
		JRadioButton columnas = new JRadioButton("Columnas");
		columnas.setOpaque(false);
		
		ButtonGroup tipo = new ButtonGroup();
		tipo.add(filas);
		tipo.add(columnas);
		
		JRadioButton simple = new JRadioButton("Simple");
		simple.setOpaque(false);
		JRadioButton intervalo = new JRadioButton("Intervalo");
		intervalo.setOpaque(false);
		JRadioButton aleatorio = new JRadioButton("Aleatorio");
		aleatorio.setOpaque(false);
		
		ButtonGroup modo = new ButtonGroup();
		modo.add(simple);
		modo.add(intervalo);
		modo.add(aleatorio);
		
		JPanel tipos = new JPanel(new GridLayout(2,1));
		tipos.add(filas);
		tipos.add(columnas);
		TitledBorder borde = new TitledBorder(new LineBorder(bordes, 1, true), "Tipo de selección");
		tipos.setBorder(borde);
		tipos.setOpaque(false);
		//tipos.setBackground(fondo);
		
		JPanel modos = new JPanel(new GridLayout(3,1));
		modos.add(simple);
		modos.add(intervalo);
		modos.add(aleatorio);
		TitledBorder borde2 = new TitledBorder(new LineBorder(bordes, 1, true), "Modo de selección");
		modos.setBorder(borde2);
		modos.setOpaque(false);
		//modos.setBackground(fondo);
		
		JPanel central = new JPanel(new GridLayout(1,2));
		central.add(tipos);
		central.add(modos);
		central.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
		//central.setBackground(fondo);
		central.setOpaque(false);
		panel.add(central);
		
		
		
		JTextArea texto = new JTextArea();
		JScrollPane spTexto = new JScrollPane(texto);
		spTexto.setPreferredSize(new Dimension(500, 150));
		spTexto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		spTexto.setBackground(fondoTexto);
		
		panel.add(spTexto, BorderLayout.SOUTH);
		
		
		ActionListener escuchador = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton rb = (JRadioButton) e.getSource();
				if(rb==filas) {
					table.setRowSelectionAllowed(true);
					table.setColumnSelectionAllowed(false);
					prueba=false;
				}
				else if(rb==columnas) {
					table.setRowSelectionAllowed(false);
					table.setColumnSelectionAllowed(true);
					prueba=true;
				}
				tipoSel=rb.getText();
			}
		};
		ActionListener escuchador2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton rb = (JRadioButton) e.getSource();
				if(rb==simple) {
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
				else if(rb==intervalo) {
					table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				}
				else if(rb==aleatorio) {
					table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				}
				modoSel=rb.getText();
			}
			
		};
		
		ListSelectionListener escuchadorLista = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String registro = texto.getText();
				int[] arrayFilas = table.getSelectedRows();
				for(int i = 0; i<arrayFilas.length; i++) {
					arrayFilas[i]=arrayFilas[i]+1;
				}
				int[] arrayColumnas=table.getSelectedColumns();
				for(int i = 0; i<arrayColumnas.length; i++) {
					arrayColumnas[i]=arrayColumnas[i]+1;
				}
				String filas = Arrays.toString(arrayFilas);
				String columnas = Arrays.toString(arrayColumnas);
				if(e.getValueIsAdjusting()) {
					if(!prueba) {
						texto.setText(registro+"Filas: "+filas+", Tipo: "+tipoSel+", Modo: "+modoSel+"\n");
					}else {
						texto.setText(registro+"Columnas: "+columnas+", Tipo: "+tipoSel+", Modo: "+modoSel+"\n");
					}
				}
				
				//texto.setText(Integer.toString(table.getSelectedRow()+1));
				
			}
			
		};
		table.getSelectionModel().addListSelectionListener(escuchadorLista);
		filas.addActionListener(escuchador);
		columnas.addActionListener(escuchador);
		simple.addActionListener(escuchador2);
		intervalo.addActionListener(escuchador2);
		aleatorio.addActionListener(escuchador2);
		frame.setVisible(true);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
