package kr.or.dgit.library_project.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.nio.ByteOrder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import kr.or.dgit.library_project.view.ManagerUserinfo;
import kr.or.dgit.library_project.view.ManagerUsersInfo;
import java.awt.Dimension;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 787, 618);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("대여/반납 관리", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBounds(12, 10, 759, 272);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 48, 308, 214);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("아이디");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_2.add(textField);
		
		JLabel label_1 = new JLabel("회원이름");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("전화번호");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("주 소");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel("이메일");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JButton button = new JButton("확 인");
		panel_2.add(button);
		
		JButton button_1 = new JButton("취 소");
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(332, 48, 415, 214);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 2, 402, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"도서목록", "대여", "반납"}));
		panel_4.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_4.add(textField_5);
		
		JButton button_2 = new JButton("검색");
		panel_4.add(button_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(1, 37, 402, 140);
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_5 = new JLabel("도서코드");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_5.add(textField_6);
		
		JLabel label_6 = new JLabel("도서명");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_5.add(textField_7);
		
		JLabel label_7 = new JLabel("저 자");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_5.add(textField_8);
		
		JLabel label_8 = new JLabel("출판사");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_5.add(textField_9);
		
		JLabel label_9 = new JLabel("가격");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_5.add(textField_10);
		
		JLabel label_10 = new JLabel("총 대여 횟수");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_5.add(textField_11);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(1, 179, 402, 33);
		panel_3.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_3 = new JButton("대여/반납");
		panel_6.add(button_3);
		
		JButton button_4 = new JButton("취소");
		panel_6.add(button_4);
		
		JLabel label_11 = new JLabel("회원정보");
		label_11.setFont(new Font("굴림", Font.BOLD, 15));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(12, 10, 74, 28);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("도서정보");
		label_12.setFont(new Font("굴림", Font.BOLD, 15));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(339, 10, 74, 28);
		panel_1.add(label_12);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(12, 292, 759, 297);
		panel.add(panel_7);
		
		JLabel label_13 = new JLabel("모든도서/대여중도서/ 반납필요 도서 목록");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("굴림", Font.BOLD, 15));
		label_13.setBounds(0, 10, 759, 38);
		panel_7.add(label_13);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 759, 246);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"도서코드", "도서명", "저 자", "출판사", "가 격", "총 대여 횟수"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_one = new JPanel();
		tabbedPane.addTab("회원관리", null, panel_one, null);
		panel_one.setLayout(null);
		
		JPanel panel_first = new JPanel();
		panel_first.setLayout(null);
		panel_first.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_first.setBounds(87, 63, 594, 202);
		panel_one.add(panel_first);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(36, 10, 228, 31);
		panel_first.add(panel_10);
		
		JLabel label_14 = new JLabel("아이디");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(12, 8, 47, 15);
		panel_10.add(label_14);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(86, 5, 116, 21);
		panel_10.add(textField_12);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(36, 51, 228, 31);
		panel_first.add(panel_11);
		
		JLabel label_15 = new JLabel("이 름");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(12, 8, 40, 15);
		panel_11.add(label_15);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(84, 5, 116, 21);
		panel_11.add(textField_13);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBounds(36, 92, 228, 31);
		panel_first.add(panel_12);
		
		JLabel label_16 = new JLabel("전화번호");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(5, 8, 65, 15);
		panel_12.add(label_16);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(82, 5, 116, 21);
		panel_12.add(textField_14);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(36, 133, 548, 31);
		panel_first.add(panel_13);
		
		JLabel label_17 = new JLabel("주 소");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(12, 10, 44, 15);
		panel_13.add(label_17);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(68, 7, 87, 21);
		panel_13.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(158, 7, 78, 21);
		panel_13.add(comboBox_2);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(241, 7, 295, 21);
		panel_13.add(textField_15);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(276, 10, 308, 31);
		panel_first.add(panel_14);
		
		JLabel label_18 = new JLabel("이메일");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(12, 8, 57, 15);
		panel_14.add(label_18);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(81, 5, 215, 21);
		panel_14.add(textField_16);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBounds(276, 51, 308, 31);
		panel_first.add(panel_15);
		
		JLabel label_19 = new JLabel("비밀번호");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(12, 8, 57, 15);
		panel_15.add(label_19);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(81, 5, 215, 21);
		panel_15.add(textField_17);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBounds(269, 92, 315, 31);
		panel_first.add(panel_16);
		
		JLabel label_20 = new JLabel("비밀번호 확인");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(0, 8, 84, 15);
		panel_16.add(label_20);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(88, 5, 215, 21);
		panel_16.add(textField_18);
		
		JButton button_5 = new JButton("확 인");
		button_5.setBounds(190, 174, 97, 23);
		panel_first.add(button_5);
		
		JButton button_6 = new JButton("취 소");
		button_6.setBounds(293, 174, 97, 23);
		panel_first.add(button_6);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBounds(143, 10, 491, 43);
		panel_one.add(panel_17);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"아이디", "이름", "전화번호", "이메일", "주소"}));
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
		scrollPane_1.setBounds(12, 321, 758, 258);
		panel_one.add(scrollPane_1);
		
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
		
		JLabel lbLast = new JLabel("회원정보");
		lbLast.setFont(new Font("굴림", Font.BOLD, 15));
		lbLast.setHorizontalAlignment(SwingConstants.CENTER);
		lbLast.setBounds(12, 281, 94, 30);
		panel_one.add(lbLast);
		
		ManagerUserinfo panel_18 = new ManagerUserinfo();
		JPanel jp = new JPanel(new BorderLayout());
		jp.add(panel_18, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		panel_18.add(btnNewButton);
		tabbedPane.addTab("kkkk", null, jp, null);

		
	}
}
