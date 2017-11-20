package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MemberApp extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField tfUserPw;
	private JTextField tfUserId;
	private JPasswordField tfUserPwCh;
	private JTextField tfUserEmail;
	private JTextField tfDoro;
	private JTextField tfUserAddr;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberApp frame = new MemberApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 35, 371, 120);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 5));
		
		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUserId);
		
		tfUserId = new JTextField();
		panel.add(tfUserId);
		tfUserId.setColumns(10);
		
		JLabel lblUserName = new JLabel("성 명");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUserName);
		
		tfUserName = new JTextField();
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lblUserPw = new JLabel("비밀번호");
		lblUserPw.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUserPw);
		
		tfUserPw = new JPasswordField();
		panel.add(tfUserPw);
		
		JLabel lblUserPwCh = new JLabel("비밀번호 확인");
		lblUserPwCh.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUserPwCh);
		
		tfUserPwCh = new JPasswordField();
		panel.add(tfUserPwCh);
		
		JPanel pAddr = new JPanel();
		pAddr.setBounds(30, 310, 374, 59);
		contentPane.add(pAddr);
		pAddr.setLayout(null);
		
		JLabel lblUserAddr = new JLabel("주소");
		lblUserAddr.setBounds(82, 10, 24, 15);
		pAddr.add(lblUserAddr);
		
		JComboBox cmbUserAddr = new JComboBox();
		cmbUserAddr.setBounds(184, 7, 96, 21);
		pAddr.add(cmbUserAddr);
		
		tfDoro = new JTextField();
		tfDoro.setHorizontalAlignment(SwingConstants.CENTER);
		tfDoro.setText("도로명");
		tfDoro.setBounds(294, 6, 80, 24);
		pAddr.add(tfDoro);
		tfDoro.setColumns(10);
		
		tfUserAddr = new JTextField();
		tfUserAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		tfUserAddr.setBounds(0, 35, 374, 24);
		pAddr.add(tfUserAddr);
		tfUserAddr.setColumns(10);
		
		JPanel pBtn = new JPanel();
		pBtn.setBounds(30, 454, 371, 39);
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 2, 10, 0));
		
		JButton btnAdd = new JButton("취 소");
		pBtn.add(btnAdd);
		
		JButton btnCancel = new JButton("회원가입");
		pBtn.add(btnCancel);
		
		JLabel lblUserEmail = new JLabel("이메일");
		lblUserEmail.setBounds(30, 155, 138, 28);
		contentPane.add(lblUserEmail);
		lblUserEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfUserEmail = new JTextField();
		tfUserEmail.setBounds(198, 156, 92, 28);
		contentPane.add(tfUserEmail);
		tfUserEmail.setColumns(10);
	}
}
