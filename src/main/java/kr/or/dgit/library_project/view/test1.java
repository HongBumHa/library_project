package kr.or.dgit.library_project.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class test1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public test1() {
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 116, 21);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 21, 116, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 42, 116, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 63, 116, 21);
		panel.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 84, 116, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(0, 105, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 126, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

	}
}
