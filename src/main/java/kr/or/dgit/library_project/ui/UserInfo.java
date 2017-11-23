package kr.or.dgit.library_project.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.view.RentalBookPanel;
import kr.or.dgit.library_project.view.ReturnTabPanel;
import kr.or.dgit.library_project.view.UserInfoView;
import kr.or.dgit.library_project.view.UserReadingBook;
import kr.or.dgit.library_project.view.UserpresentView;

public class UserInfo extends JFrame {


	private JPanel contentPane;
	public UserInfo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 842, 575);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 819, 534);
		contentPane.add(tabbedPane);

		RentalBookPanel rentalBookTab = new RentalBookPanel();
		rentalBookTab.setLayout(null);
		tabbedPane.addTab("대 여", null, rentalBookTab, null);


		ReturnTabPanel returnTab = new ReturnTabPanel();
		returnTab.setLayout(null);
		tabbedPane.addTab("반 납", null, returnTab, null);

		returnTab.setLayout(new BorderLayout(0, 0));

		UserInfoView testing = UserInfoView.getInstance();
		testing.setLayout(null);
		tabbedPane.addTab("회원정보", null, testing, null);
		
		UserpresentView 유저현황 = new UserpresentView();
		tabbedPane.addTab("New tab", null, 유저현황, null);

	}	
}
