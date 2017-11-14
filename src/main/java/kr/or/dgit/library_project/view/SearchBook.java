package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.FlowLayout;

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

public class SearchBook extends JPanel {

	private JTable table;
	private JTable table_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_10;
	
	public SearchBook() {
		setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_6.setBounds(228, 31, 594, 202);
		add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(36, 10, 228, 31);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 8, 47, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.setBounds(86, 5, 116, 21);
		panel_8.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(36, 51, 228, 31);
		panel_6.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel label_9 = new JLabel("이 름");
		label_9.setBounds(12, 8, 40, 15);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(84, 5, 116, 21);
		textField_8.setColumns(10);
		panel_9.add(textField_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(36, 92, 228, 31);
		panel_6.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel label_10 = new JLabel("전화번호");
		label_10.setBounds(5, 8, 65, 15);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(82, 5, 116, 21);
		textField_9.setColumns(10);
		panel_10.add(textField_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(36, 133, 548, 31);
		panel_6.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("주 소");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 44, 15);
		panel_11.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시", "인턴광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충정북도"}));
		comboBox_1.setBounds(68, 7, 87, 21);
		panel_11.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"남구", "동구", "북구", "달서구", "중구", "서구"}));
		comboBox_2.setBounds(158, 7, 78, 21);
		panel_11.add(comboBox_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(241, 7, 295, 21);
		panel_11.add(textField_10);
		textField_10.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(276, 10, 308, 31);
		panel_6.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel label_12 = new JLabel("이메일");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(12, 8, 57, 15);
		panel_12.add(label_12);
		
		textField_11 = new JTextField();
		textField_11.setBounds(81, 5, 215, 21);
		textField_11.setColumns(10);
		panel_12.add(textField_11);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(276, 51, 308, 31);
		panel_6.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel label_13 = new JLabel("비밀번호");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(12, 8, 57, 15);
		panel_13.add(label_13);
		
		textField_12 = new JTextField();
		textField_12.setBounds(81, 5, 215, 21);
		textField_12.setColumns(10);
		panel_13.add(textField_12);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(269, 92, 315, 31);
		panel_6.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_14 = new JLabel("비밀번호 확인");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 8, 84, 15);
		panel_14.add(label_14);
		
		textField_13 = new JTextField();
		textField_13.setBounds(88, 5, 215, 21);
		textField_13.setColumns(10);
		panel_14.add(textField_13);
		
		JButton btnNewButton_3 = new JButton("확 인");
		btnNewButton_3.setBounds(190, 174, 97, 23);
		panel_6.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("취 소");
		btnNewButton_4.setBounds(293, 174, 97, 23);
		panel_6.add(btnNewButton_4);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setVgap(15);
		panel_7.setBounds(47, 45, 148, 137);
		add(panel_7);
		
		JButton btnNewButton = new JButton("수 정");
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원탈퇴");
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("대여/반납 내역");
		panel_7.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 267, 775, 243);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"도서코드", "도서명", "저 자", "가 격", "대여일", "반납일", "연체여부", "필요한거"
			}
		));
		scrollPane_1.setViewportView(table_1);
	}

}
