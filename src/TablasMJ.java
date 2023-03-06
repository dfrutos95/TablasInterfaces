

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TablasMJ{
	public static void main(String[] args) {
		Vent v = new Vent();
		v.setVisible(true);
		v.setBounds(200,200,400,400);
	}
}

class Vent extends JFrame{
	
	public Vent(){
		setTitle("JTABLE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Componentes();
	}
	private void Componentes(){
		JPanel panel1 = new JPanel();
		String[] columnNames = {"First Name",
				 "Last Name",
				"Sport",
				"# of Years",
				"Vegetarian"};
				Object[][] data = {
						{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
						{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
						{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
						{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
						{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };
				
				JTable table = new JTable(data, columnNames);
				
				setContentPane(panel1);
				panel1.add(table);

	}
}
