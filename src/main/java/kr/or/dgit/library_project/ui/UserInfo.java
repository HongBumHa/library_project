package kr.or.dgit.library_project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.view.RentalBookPanel;
import kr.or.dgit.library_project.view.ReturnTabPanel;
import kr.or.dgit.library_project.view.UserInfoView;
import java.awt.BorderLayout;

public class UserInfo extends JFrame {

	private JPanel contentPane;

	public UserInfo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1008, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 980, 532);
		contentPane.add(tabbedPane);

		RentalBookPanel rentalBookTab = new RentalBookPanel();
		tabbedPane.addTab("대 여", null, rentalBookTab, null);
		rentalBookTab.setLayout(null);


		/*ReturnTabPanel returnTab = new ReturnTabPanel();
		tabbedPane.addTab("반 납", null, returnTab, null);

		returnTab.setLayout(new BorderLayout(0, 0));*/
		UserInfoView testing = new UserInfoView();

		tabbedPane.addTab("회원정보", null, testing, null);
		testing.setLayout(null);
	}
}
