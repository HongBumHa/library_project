package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ManegerTesting extends JPanel {


	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTable table_1;
	
	public ManegerTesting() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(68, 72, 608, 246);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JButton button_5 = new JButton("확 인");
		button_5.setBounds(190, 174, 97, 23);
		panel_9.add(button_5);
		
		JButton button_6 = new JButton("취 소");
		button_6.setBounds(293, 174, 97, 23);
		panel_9.add(button_6);
		
		JLabel label_14 = new JLabel("아이디");
		label_14.setBounds(48, 26, 47, 15);
		panel_9.add(label_14);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_12 = new JTextField();
		textField_12.setBounds(121, 20, 116, 21);
		panel_9.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel label_15 = new JLabel("이 름");
		label_15.setBounds(58, 51, 40, 15);
		panel_9.add(label_15);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_13 = new JTextField();
		textField_13.setBounds(121, 51, 116, 21);
		panel_9.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel label_16 = new JLabel("전화번호");
		label_16.setBounds(47, 95, 65, 15);
		panel_9.add(label_16);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_14 = new JTextField();
		textField_14.setBounds(124, 92, 116, 21);
		panel_9.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel label_17 = new JLabel("주 소");
		label_17.setBounds(12, 148, 44, 15);
		panel_9.add(label_17);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(70, 145, 87, 21);
		panel_9.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(167, 143, 78, 21);
		panel_9.add(comboBox_2);
		
		textField_15 = new JTextField();
		textField_15.setBounds(246, 143, 295, 21);
		panel_9.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel label_18 = new JLabel("이메일");
		label_18.setBounds(290, 26, 57, 15);
		panel_9.add(label_18);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_16 = new JTextField();
		textField_16.setBounds(367, 20, 215, 21);
		panel_9.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel label_19 = new JLabel("비밀번호");
		label_19.setBounds(290, 67, 57, 15);
		panel_9.add(label_19);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_17 = new JTextField();
		textField_17.setBounds(369, 61, 215, 21);
		panel_9.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel label_20 = new JLabel("비밀번호 확인");
		label_20.setBounds(275, 109, 84, 15);
		panel_9.add(label_20);
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_18 = new JTextField();
		textField_18.setBounds(367, 107, 215, 21);
		panel_9.add(textField_18);
		textField_18.setColumns(10);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(126, 10, 491, 43);
		panel_1.add(panel_17);
		panel_17.setLayout(null);
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setModel(new DefaultComboBoxModel<>(new String[] {"아이디", "이름", "전화번호", "이메일", "주소"}));
		comboBox_3.setBounds(12, 10, 93, 25);
		panel_17.add(comboBox_3);
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		textField_19.setBounds(117, 10, 259, 25);
		panel_17.add(textField_19);
		
		JButton button_7 = new JButton("search");
		button_7.setBounds(388, 11, 93, 23);
		panel_17.add(button_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 347, 706, 258);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"아이디", "이 름", "전화번호", "주 소", "이메일"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setBounds(36, 317, 94, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setVisible(true);
	}

}
