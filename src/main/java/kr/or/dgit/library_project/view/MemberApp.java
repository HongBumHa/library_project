package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.service.UsersService;

public class MemberApp extends JFrame {

	private JPanel contentPane;
	private JTextField tfDoro;
	private JTextField tfUserAddr;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JTextField tfName;
	private JPasswordField tfPwch;
	private JTextField tfTel1;
	private JTextField tfTel2;
	private UsersService service;
	private DefaultComboBoxModel sidoModel;
	private JComboBox cmbUserAddr;
	private JComboBox cmbTel;
	private int idRes;
	private int pwRes;
	private int pwChRes;

	public JComboBox getCmbUserAddr() {
		return cmbUserAddr;
	}

	public void setCmbUserAddr(JComboBox cmbUserAddr) {
		this.cmbUserAddr = cmbUserAddr;
	}

	private static final MemberApp instance = new MemberApp();
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private JLabel lblIdCh;

	public static MemberApp getInstance() {
		return instance;
	}

	private MemberApp() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 492, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pAddr = new JPanel();
		pAddr.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		pAddr.setBounds(30, 311, 399, 62);
		contentPane.add(pAddr);
		pAddr.setLayout(null);

		JLabel lblUserAddr = new JLabel("주소");
		lblUserAddr.setBounds(6, 12, 94, 15);
		pAddr.add(lblUserAddr);
		sidoModel = new DefaultComboBoxModel<String>(getDate());
		cmbUserAddr = new JComboBox<String>();
		cmbUserAddr.setModel(sidoModel);
		cmbUserAddr.setBounds(137, 8, 96, 21);
		pAddr.add(cmbUserAddr);

		tfDoro = new JTextField();
		tfDoro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDoro.setText("");
				tfDoro.setForeground(new Color(0, 0, 0));
			}
		});
		tfDoro.setForeground(new Color(230, 230, 250));
		tfDoro.setText("도로명");
		tfDoro.setHorizontalAlignment(SwingConstants.CENTER);
		tfDoro.setBounds(245, 7, 80, 24);
		pAddr.add(tfDoro);
		tfDoro.setColumns(10);

		tfUserAddr = new JTextField();
		tfUserAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		tfUserAddr.setBounds(6, 35, 387, 24);
		pAddr.add(tfUserAddr);
		tfUserAddr.setColumns(10);

		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfDoro.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "도로명 주소를 입력하세요");
					return;
				}
				PostView frame = new PostView(0);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(328, 8, 67, 24);
		pAddr.add(btnNewButton);

		JPanel pId = new JPanel();
		pId.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		pId.setBounds(30, 44, 295, 30);
		contentPane.add(pId);
		pId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbId = new JLabel(" 아이디");
		pId.add(lbId);

		tfId = new JTextField();

		tfId.setForeground(Color.BLACK);
		pId.add(tfId);
		tfId.setColumns(10);

		JPanel pPw = new JPanel();
		pPw.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		pPw.setBounds(30, 129, 295, 30);
		contentPane.add(pPw);
		pPw.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPw = new JLabel(" 비밀번호");
		pPw.add(lblPw);

		tfPw = new JPasswordField();
		pPw.add(tfPw);

		JPanel pName = new JPanel();
		pName.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		pName.setBounds(30, 87, 295, 30);
		contentPane.add(pName);
		pName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblName = new JLabel(" 이 름");
		pName.add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		pName.add(tfName);

		JPanel pPwch = new JPanel();
		pPwch.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		pPwch.setBounds(30, 170, 295, 30);
		contentPane.add(pPwch);
		pPwch.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPwch = new JLabel(" 비밀번호 확인");
		pPwch.add(lblPwch);

		tfPwch = new JPasswordField();

		pPwch.add(tfPwch);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		panel.setBounds(30, 212, 374, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("전화번호");
		label.setBounds(5, 13, 57, 15);
		panel.add(label);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(getData());
		cmbTel = new JComboBox(model);
		cmbTel.setBounds(125, 10, 73, 21);
		panel.add(cmbTel);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setBounds(210, 13, 57, 15);
		panel.add(lblNewLabel);

		tfTel1 = new JTextField();
		tfTel1.setBounds(220, 10, 65, 21);
		panel.add(tfTel1);
		tfTel1.setColumns(10);

		JLabel label_1 = new JLabel("-");
		label_1.setBounds(289, 13, 57, 15);
		panel.add(label_1);

		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		tfTel2.setBounds(297, 10, 65, 21);
		panel.add(tfTel2);

		JButton btnIdCh = new JButton("중복검사");
		btnIdCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idCheck(tfId.getText());
			}
		});
		btnIdCh.setBounds(332, 53, 97, 23);
		contentPane.add(btnIdCh);

		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 10, 97, 15);
		contentPane.add(lblNewLabel_1);

		JButton btnAdd = new JButton("회원가입");
		btnAdd.setBackground(new Color(106, 90, 205));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertUser()) {
					setVisible(false);
				}

			}
		});
		btnAdd.setBounds(371, 392, 97, 30);
		contentPane.add(btnAdd);

		JButton button = new JButton("취 소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		button.setBounds(262, 392, 97, 30);
		contentPane.add(button);

		JLabel pwCh = new JLabel("비밀번호가 불일치합니다");

		pwCh.setForeground(Color.RED);
		pwCh.setBounds(332, 180, 146, 15);
		contentPane.add(pwCh);

		JLabel pwChCh = new JLabel("8자이상입력하세요");
		pwChCh.setForeground(Color.RED);
		pwChCh.setBounds(331, 141, 130, 15);
		contentPane.add(pwChCh);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		panel_1.setLayout(null);
		panel_1.setBounds(30, 261, 374, 40);
		contentPane.add(panel_1);

		JLabel label_2 = new JLabel("이메일");
		label_2.setBounds(5, 14, 57, 15);
		panel_1.add(label_2);

		tfEmail1 = new JTextField();
		tfEmail1.setColumns(10);
		tfEmail1.setBounds(83, 10, 116, 21);
		panel_1.add(tfEmail1);

		JLabel label_4 = new JLabel("@");
		label_4.setBounds(211, 13, 23, 15);
		panel_1.add(label_4);

		tfEmail2 = new JTextField();
		tfEmail2.setColumns(10);
		tfEmail2.setBounds(233, 10, 129, 21);
		panel_1.add(tfEmail2);

		lblIdCh = new JLabel("4자리이상입력해주세요");
		lblIdCh.setForeground(new Color(0, 255, 0));
		lblIdCh.setBounds(184, 28, 146, 15);
		contentPane.add(lblIdCh);

		tfPw.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (tfPw.getText().length() >= 8) {
					pwChCh.setForeground(Color.BLACK);
					pwChCh.setText("사용가능합니다.");
					pwChRes = 1;
				} else {
					pwChCh.setForeground(Color.RED);
					pwChCh.setText("8자이상입력하세요");
				}
			}
		});

		tfPwch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String res = tfPw.getText();
				String res2 = tfPwch.getText();
				if (res.equals(res2)) {
					pwCh.setForeground(Color.BLACK);
					pwCh.setText("비밀번호가 일치합니다.");
					pwRes = 1;
				} else {
					pwCh.setForeground(Color.RED);
					pwCh.setText("비밀번호가 불일치합니다.");
				}

			}
		});
	}

	protected boolean insertUser() {	
		
		if(idRes!=1) {
			JOptionPane.showMessageDialog(null, "중복검사를 하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}


		Pattern p = Pattern.compile("^[가-힣]{2,5}$");
		Matcher m = p.matcher(tfName.getText());
		if(tfName.getText().length() ==0) {

			JOptionPane.showMessageDialog(null, "이름을 입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}else if(!m.find()) {
			JOptionPane.showMessageDialog(null, "이름을 2~5자 한글로 입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}

		
		if(pwRes!=1) {
			JOptionPane.showMessageDialog(null, "비밀번호를 8자이상입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (pwChRes != 1) {
			JOptionPane.showMessageDialog(null, "비밀번호가 불일치합니다",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}

		
		if(tfEmail1.getText().length()==0 || tfEmail2.getText().length() ==0) {

			JOptionPane.showMessageDialog(null, "이메일을 입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}

		p = Pattern.compile("^[0-9]{3,4}$");
		m = p.matcher(tfTel1.getText());
		Pattern p2 = Pattern.compile("^[0-9]{4}$");
		Matcher m2 = p.matcher(tfTel2.getText());
		
		if(tfTel1.getText().length() ==0 ||tfTel2.getText().length() ==0) {

			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요",null,JOptionPane.WARNING_MESSAGE);

			return false;
		}else if(!m.find() || !m2.find()){

			JOptionPane.showMessageDialog(null, "다시 전화번호를 입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}

		
		if(tfUserAddr.getText().length() == 0) {

			JOptionPane.showMessageDialog(null, "주소를 입력하세요",null,JOptionPane.WARNING_MESSAGE);
			return false;
		}
		String email = tfEmail1.getText() + "@" + tfEmail2.getText();
		String tel = (String) cmbTel.getSelectedItem() + "-" + tfTel1.getText() + "-" + tfTel2.getText();
		Users u = new Users();
		u.setUserId(tfId.getText());
		u.setDelayDay(0);
		u.setRankCode("2");
		u.setUserEmail(email);
		u.setUserTel(tel);
		u.setUserAddr(tfUserAddr.getText());
		u.setUserName(tfName.getText());
		u.setUserLeave("Y");
		u.setUserPw(tfPw.getText());
		int i = UsersService.getInstance().findinsertUser(u);
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "정보를 다시 입력해주세요",null,JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "축하합니다 회원가입이 되었습니다.");
		}
		return true;
	}

	public void clear() {
		tfId.setText("");
		tfPw.setText("");
		tfPwch.setText("");
		tfUserAddr.setText("");
		tfTel2.setText("");
		tfTel1.setText("");
		tfName.setText("");
		tfEmail1.setText("");
		tfEmail2.setText("");
	}

	public JTextField getTfDoro() {
		return tfDoro;
	}

	public void setTfDoro(JTextField tfDoro) {
		this.tfDoro = tfDoro;
	}

	public JTextField getTfUserAddr() {
		return tfUserAddr;
	}

	public void setTfUserAddr(JTextField tfUserAddr) {
		this.tfUserAddr = tfUserAddr;
	}

	private String[] getData() {

		return new String[] { "010", "011", "016", "018" };
	}

	protected void idCheck(String text) {
		lblIdCh.setText("");

		if(text.length() <= 3) {
			JOptionPane.showMessageDialog(null, "4자이상 입력하세요.",null,JOptionPane.WARNING_MESSAGE);

			return;
		}
		List<Users> lists = UsersService.getInstance().findUsersByAll();
		int res = 0;

		for (Users u : lists) {
			if (u.getUserId().equals(text)) {
				res = 1;
				break;
			}
		}
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
			idRes = 1;
		} else {
			JOptionPane.showMessageDialog(null, "중복된 아이디입니다.",null,JOptionPane.WARNING_MESSAGE);
		}
	}

	private Vector<String> getDate() {
		Vector<String> vt = new Vector<>();
		List<Post> lists = PostService.getInstance().findPostBysido();
		for (Post p : lists) {
			vt.add(p.getSido());
		}
		return vt;
	}
}
