package kr.or.dgit.library_project.ui;

import java.awt.Color;
import java.awt.EventQueue;

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

import kr.or.dgit.library_project.view.BookInsertDelete;
import kr.or.dgit.library_project.view.ManagerRentalBook;
import kr.or.dgit.library_project.view.ManegerUserInfo;


public class Manager extends JFrame {

	private JPanel contentPane;

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
/*<<<<<<< HEAD

		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 281, 94, 30);
		panel_18.add(lblNewLabel);
		

=======*/
		BookInsertDelete insertDeletePanel = new BookInsertDelete();
		tabbedPane.addTab("도서추가삭제", null, insertDeletePanel, null);
		insertDeletePanel.setLayout(null);

		ManegerUserInfo panel = new ManegerUserInfo();
		tabbedPane.addTab("회원정보", null, panel, null);

	}
}
