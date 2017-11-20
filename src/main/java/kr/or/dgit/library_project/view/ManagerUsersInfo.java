package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ManagerUsersInfo extends JPanel {
	private JPasswordField pfUserPw;
	private JPasswordField pfUserPwCh;
	
	public ManagerUsersInfo() {
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_9.setBounds(12, 76, 594, 167);
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
	}

}
