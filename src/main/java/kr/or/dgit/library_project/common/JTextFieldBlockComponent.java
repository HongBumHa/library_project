package kr.or.dgit.library_project.common;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class JTextFieldBlockComponent extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JTextFieldBlockComponent(String title) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("돋움", Font.PLAIN, 15));
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
