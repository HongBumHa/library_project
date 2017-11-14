package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.GridLayout;

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

public class RentalBookPanel extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	public RentalBookPanel() {
		setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(228, 10, 767, 54);
		add(panel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "도서코드", "도서명", "저 자", "출판사", "가 격" }));
		comboBox.setBounds(33, 10, 93, 25);
		panel_2.add(comboBox);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(158, 10, 421, 25);
		panel_2.add(textField);

		JButton button = new JButton("search");
		button.setBounds(627, 11, 93, 23);
		panel_2.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 85, 770, 418);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "도서코드", "도서명", "저 자", "출판사", "가 격", "총 대여 횟수", "대여 가능 여부" }));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(12, 10, 195, 54);
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label = new JLabel("xxx회원님의 대여 현황");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label);

		JLabel label_1 = new JLabel("대여: 5권");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("미반납: 1권");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 99, 195, 363);
		add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label_3 = new JLabel(" 도서코드");
		panel_4.add(label_3);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_4.add(textField_1);

		JLabel label_4 = new JLabel(" 도서명");
		panel_4.add(label_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_4.add(textField_2);

		JLabel label_5 = new JLabel(" 저 자");
		panel_4.add(label_5);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_4.add(textField_3);

		JLabel label_6 = new JLabel(" 출판사");
		panel_4.add(label_6);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_4.add(textField_4);

		JLabel label_7 = new JLabel(" 가격");
		panel_4.add(label_7);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_4.add(textField_5);

		JLabel label_8 = new JLabel(" 총대여횟수");
		panel_4.add(label_8);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_4.add(textField_6);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(24, 472, 171, 31);
		add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		JButton button_1 = new JButton("확인");
		panel_5.add(button_1);

		JButton button_2 = new JButton("취소");
		panel_5.add(button_2);

	}

}
