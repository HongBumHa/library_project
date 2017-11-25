package kr.or.dgit.library_project.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.library_project.view.BookInsertDelete;
import kr.or.dgit.library_project.view.ManagerRentalBook;
import kr.or.dgit.library_project.view.ManegerUserInfo;
import kr.or.dgit.library_project.view.ManagerPieChart;


public class Manager extends JFrame {

	private JPanel contentPane;
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
		setTitle("관리자 모드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 787, 618);
		contentPane.add(tabbedPane);
		
		ManagerRentalBook rentReturn = new ManagerRentalBook();
		tabbedPane.addTab("대여/반납관리", null, rentReturn, null);
		
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
			},
			new String[] {
				"아이디", "이 름", "전화번호", "주 소", "이메일"
			}
		));
		scrollPane_1.setViewportView(table_1);
/*<<<<<<< HEAD

		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 281, 94, 30);
		panel_18.add(lblNewLabel);
		

=======*/
		BookInsertDelete insertDeletePanel = BookInsertDelete.getInstance();
		tabbedPane.addTab("도서추가삭제", null, insertDeletePanel, null);
		insertDeletePanel.setLayout(null);

		ManegerUserInfo panel = new ManegerUserInfo();
		tabbedPane.addTab("New tab", null, panel, null);

	}
}
