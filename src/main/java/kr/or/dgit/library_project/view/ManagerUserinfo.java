package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;

public class ManagerUserinfo extends JPanel {
	private static final ManagerUserinfo instance = new ManagerUserinfo();
	private JPasswordField pfUserPw;
	private JPasswordField pfUserPwCh;
	
	public static ManagerUserinfo getInstance() {
		return instance;
	}

	private ManagerUserinfo() {
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_9.setBounds(87, 63, 594, 202);
		panel_8.add(panel_9);
		
		JPanel pUserId = new JPanel();
		pUserId.setLayout(null);
		pUserId.setBounds(36, 10, 228, 31);
		panel_9.add(pUserId);
		
		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setBounds(12, 8, 47, 15);
		pUserId.add(lblUserId);
		
		JTextField tfUserId = new JTextField();
		tfUserId.setColumns(10);
		tfUserId.setBounds(64, 5, 116, 21);
		pUserId.add(tfUserId);
		
		JPanel pUserName = new JPanel();
		pUserName.setLayout(null);
		pUserName.setBounds(36, 51, 228, 31);
		panel_9.add(pUserName);
		
		JLabel lblUserName = new JLabel("이 름");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(12, 8, 40, 15);
		pUserName.add(lblUserName);
		
		JTextField tfUserName = new JTextField();
		tfUserName.setColumns(10);
		tfUserName.setBounds(64, 5, 116, 21);
		pUserName.add(tfUserName);
		
		JPanel pUserTel = new JPanel();
		pUserTel.setLayout(null);
		pUserTel.setBounds(36, 92, 228, 31);
		panel_9.add(pUserTel);
		
		JLabel lblUserTel = new JLabel("전화번호");
		lblUserTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserTel.setBounds(5, 8, 65, 15);
		pUserTel.add(lblUserTel);
		
		JTextField tfUserTel = new JTextField();
		tfUserTel.setColumns(10);
		tfUserTel.setBounds(64, 5, 116, 21);
		pUserTel.add(tfUserTel);
		
		JPanel pUserAddr = new JPanel();
		pUserAddr.setLayout(null);
		pUserAddr.setBounds(36, 133, 548, 31);
		panel_9.add(pUserAddr);
		
		JLabel lblUserAddr = new JLabel("주 소");
		lblUserAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAddr.setBounds(12, 10, 44, 15);
		pUserAddr.add(lblUserAddr);
		
		JTextField tfUserAddr = new JTextField();
		tfUserAddr.setColumns(10);
		tfUserAddr.setBounds(63, 7, 454, 21);
		pUserAddr.add(tfUserAddr);
		
		JPanel pUserEmail = new JPanel();
		pUserEmail.setLayout(null);
		pUserEmail.setBounds(276, 10, 308, 31);
		panel_9.add(pUserEmail);
		
		JLabel lblUserEmail = new JLabel("이메일");
		lblUserEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEmail.setBounds(12, 8, 57, 15);
		pUserEmail.add(lblUserEmail);
		
		JTextField tfUserEmail = new JTextField();
		tfUserEmail.setColumns(10);
		tfUserEmail.setBounds(118, 5, 178, 21);
		pUserEmail.add(tfUserEmail);
		
		JPanel pUserPw = new JPanel();
		pUserPw.setLayout(null);
		pUserPw.setBounds(276, 51, 308, 31);
		panel_9.add(pUserPw);
		
		JLabel lblUserPw = new JLabel("비밀번호");
		lblUserPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPw.setBounds(12, 8, 57, 15);
		pUserPw.add(lblUserPw);
		
		pfUserPw = new JPasswordField();
		pfUserPw.setBounds(118, 5, 178, 21);
		pUserPw.add(pfUserPw);
		
		JPanel pUserPwCh = new JPanel();
		pUserPwCh.setLayout(null);
		pUserPwCh.setBounds(276, 92, 308, 31);
		panel_9.add(pUserPwCh);
		
		JLabel lblUserPwCh = new JLabel("비밀번호 확인");
		lblUserPwCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPwCh.setBounds(12, 8, 84, 15);
		pUserPwCh.add(lblUserPwCh);
		
		pfUserPwCh = new JPasswordField();
		pfUserPwCh.setBounds(118, 5, 178, 21);
		pUserPwCh.add(pfUserPwCh);
		
		JButton btnUpdate = new JButton("확 인");
		btnUpdate.setBounds(190, 174, 97, 23);
		panel_9.add(btnUpdate);
		
		JButton btnCencel = new JButton("취 소");
		btnCencel.setBounds(293, 174, 97, 23);
		panel_9.add(btnCencel);
		
		JPanel psearchUser = new JPanel();
		psearchUser.setLayout(null);
		psearchUser.setBounds(143, 10, 491, 43);
		panel_8.add(psearchUser);
		
		JComboBox cmbseach = new JComboBox();
		cmbseach.setModel(new DefaultComboBoxModel(new String[] {"아이디", "이름", "전화번호", "이메일", "주소"}));
		cmbseach.setBounds(12, 10, 93, 25);
		psearchUser.add(cmbseach);
		
		JTextField tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		tfSearch.setColumns(10);
		tfSearch.setBounds(117, 10, 259, 25);
		psearchUser.add(tfSearch);
		
		JButton tfSearch_1 = new JButton("search");
		tfSearch_1.setBounds(388, 11, 93, 23);
		psearchUser.add(tfSearch_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 321, 758, 258);
		panel_8.add(scrollPane_1);
		
		JTable table_1 = new JTable();
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
		
		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 281, 94, 30);
		panel_8.add(lblNewLabel);
	}
}
