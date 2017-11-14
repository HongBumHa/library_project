package kr.or.dgit.library_project.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.common.JTextFieldBlockComponent;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.UsersService;

public class MainUi extends JFrame {

	private JPanel contentPane;
	private JTextFieldBlockComponent idPanel;
	private ImageIcon img=null;
	private JTextFieldBlockComponent pwPanel;
	private UsersService service =  UsersService.getInstance();

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUi frame = new MainUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainUi() {
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ButtonGroup radioGroup = new ButtonGroup();

		JLabel lblNewLabel = new JLabel("DGIT Library");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setFont(new Font("휴먼옛체", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 456, 75);
		contentPane.add(lblNewLabel);

		idPanel = new JTextFieldBlockComponent(" 아이디");
		idPanel.setBounds(86, 157, 169, 42);
		contentPane.add(idPanel);

		pwPanel = new JTextFieldBlockComponent("비밀번호");
		pwPanel.setBounds(86, 209, 169, 42);
		contentPane.add(pwPanel);
		pwPanel.setLayout(new GridLayout(0, 1, 0, 0));


		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					checkId();
			}
		});
		
		btnNewButton.setBounds(86, 261, 79, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		btnNewButton_1.setBounds(164, 261, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("회원가입");
		btnNewButton_2.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		btnNewButton_2.setBounds(116, 295, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DGIT3-16\\Desktop\\2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 686, 446);
		contentPane.add(lblNewLabel_1);
	}

	private void checkId() {
		String id=idPanel.getTextField().getText();
		String pw=pwPanel.getTextField().getText();
		int rank = 0;
		String resId = null;
		String resPw = null;
		List<Users> lists = service.findUsersByAll();
		for(Users u : lists) {

			if(id.equals(u.getUserId())) {

				resId = u.getUserId();
				if(pw.equals(u.getUserPw())) {

					resPw = u.getUserPw();
					rank = u.getRankCode();
					break;
				}
			}
		}
		
		if(resId==null) {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해주세요");
			
		}else if(resPw == null) {
			JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요");

		}else {	
			Users users = service.findUsersByNo(new Users(id));
			switch (rank) {
			case 1:
				JOptionPane.showMessageDialog(null, id+" 관리자님 환영합니다.");
				Manager managerUi = new Manager();
				managerUi.setVisible(true);
				break;
			case 2:	
				JOptionPane.showMessageDialog(null, id+"님 환영합니다.");
				UserInfo uinfo = new UserInfo(users);
				uinfo.setVisible(true);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "블랙리스트입니다");
				break;
			}
		}
	}
}