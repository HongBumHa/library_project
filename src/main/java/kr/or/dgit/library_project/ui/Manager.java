package kr.or.dgit.library_project.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.view.BookInsertDelete;
import kr.or.dgit.library_project.view.ManagerRentalBook;
import kr.or.dgit.library_project.view.ManegerUserInfo;

public class Manager extends JFrame {

	private JPanel contentPane;

	public Manager() {
		setTitle("관리자 모드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		ManagerRentalBook rentReturn = new ManagerRentalBook();
		tabbedPane.addTab("도서현황", null, rentReturn, null);

		JLabel lblNewLabel = new JLabel("회원관리");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 281, 94, 30);

		BookInsertDelete panel_1 = BookInsertDelete.getInstance();
		tabbedPane.addTab("도서관리", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		ManegerUserInfo panel = new ManegerUserInfo();
		tabbedPane.addTab("회원관리", null, panel, null);
	}
}
