package kr.or.dgit.library_project.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.view.RentalBookPanel;
import kr.or.dgit.library_project.view.ReturnTabPanel;
import kr.or.dgit.library_project.view.SearchBook;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private String userId;
//	private static UserInfo instance = new UserInfo();
	
	

//	public static UserInfo getInstance() {
//		return instance;
//	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public UserInfo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1008, 582);
		setUserId(MainUi.id);
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

		System.out.println("userInfo:" + userId);
		ReturnTabPanel returnTab = new ReturnTabPanel(userId);
//		returnTab.setUserId(userId);
		tabbedPane.addTab("반 납", null, returnTab, null);
		returnTab.setLayout(null);


		SearchBook testing = new SearchBook();
		tabbedPane.addTab("회원정보", null, testing, null);
		testing.setLayout(null);

	}
}
