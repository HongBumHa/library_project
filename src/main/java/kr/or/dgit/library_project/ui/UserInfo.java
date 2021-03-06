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
		setResizable(false);
		setTitle("DGIT LIBRARY USER MODE");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 579);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		RentalBookPanel rentalBookTab = RentalBookPanel.getInstance();
		rentalBookTab.setLayout(null);
		tabbedPane.addTab("대 여", null, rentalBookTab, null);
	
		ReturnTabPanel returnTab =  ReturnTabPanel.getInstance();
		returnTab.setLayout(null);
		tabbedPane.addTab("반 납", null, returnTab, null);

		returnTab.setLayout(new BorderLayout(0, 0));

		UserInfoView testing = UserInfoView.getInstance();
		testing.setLayout(null);
		tabbedPane.addTab("회원정보", null, testing, null);
		
		
		UserpresentView 유저현황 = UserpresentView.getInstance();
		tabbedPane.addTab("현황 보기", null, 유저현황, null);

	}	
}
