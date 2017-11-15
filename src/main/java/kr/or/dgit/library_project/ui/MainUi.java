package kr.or.dgit.library_project.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.common.JTextFieldBlockComponent;

import java.awt.SystemColor;

public class MainUi extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextFieldBlockComponent panel;
	private ImageIcon img=null;


	
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
		
		
		JRadioButton userRadio = new JRadioButton("회 원");
		userRadio.setHorizontalAlignment(SwingConstants.CENTER);
		userRadio.setSelected(true);
		userRadio.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		userRadio.setBounds(93, 113, 66, 23);
		contentPane.add(userRadio);

		JRadioButton managerRadio = new JRadioButton("관리자");
		managerRadio.setHorizontalAlignment(SwingConstants.CENTER);
		managerRadio.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		managerRadio.setBounds(163, 113, 73, 23);
		contentPane.add(managerRadio);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(userRadio);
		radioGroup.add(managerRadio);

		JLabel lblNewLabel = new JLabel("DGIT Library");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setFont(new Font("휴먼옛체", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 456, 75);
		contentPane.add(lblNewLabel);

		panel = new JTextFieldBlockComponent(" 아이디");
		panel.setBounds(86, 157, 169, 42);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(86, 209, 169, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblPsw = new JLabel(" 비밀번호");
		lblPsw.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		panel_1.add(lblPsw);

		passwordField = new JPasswordField();
		panel_1.add(passwordField);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userRadio.isSelected() == true) {
					userId();
				}
				if (managerRadio.isSelected() == true) {
					managerId();
				}
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

	public boolean managerId() {
		String id=panel.getTextField().getText();
		String pw=passwordField.getText();
		if (id.equals("manager01") && pw.equals("1q2w3e4r")) {
			JOptionPane.showMessageDialog(null, id+"님 환영합니다.");
			Manager managerUi = new Manager();
			managerUi.setVisible(true);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요.");
			return false;
		}
	}
	public boolean userId() {
		String id=panel.getTextField().getText();
		UserInfo uinfo = new UserInfo();
		uinfo.setUserId(id);
		String pw=passwordField.getText();
		JOptionPane.showMessageDialog(null, id+"님 환영합니다.");
		uinfo.setVisible(true);
		return true;
	}
}