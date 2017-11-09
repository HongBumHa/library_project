package kr.or.dgit.library_project.common;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JTextfieldInlineComponent extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JTextfieldInlineComponent(String title) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 88, 21);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 10, 225, 21);
		add(textField);
		textField.setColumns(10);

	}

}
