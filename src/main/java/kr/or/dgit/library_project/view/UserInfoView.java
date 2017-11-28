package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.service.UsersService;
import kr.or.dgit.library_project.ui.MainUi;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class UserInfoView extends JPanel {
	private JTable table;
	private JTable historyTable;
	private JTextField tfUserId;
	private JTextField tfUserName;
	private JTextField tfUserTel;
	private JTextField tfUserEamil;
	private JPasswordField tfUserPw;
	private JPasswordField tfUserPwCh;
	private JTextField tfDoro;

	public JTable getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(JTable historyTable) {
		this.historyTable = historyTable;
	}

	private JTextField tfAddr;
	private DefaultComboBoxModel sidoModel;
	private Users u;
	public JComboBox<String> cmbCity;
	private static final UserInfoView instance = new UserInfoView();
	private JScrollPane scrollPane_1;

	public static UserInfoView getInstance() {
		return instance;
	}

	private UserInfoView() {
		setLayout(null);
		u = MainUi.getUsers();
		JPanel pUserInfo = new JPanel();
		pUserInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pUserInfo.setBounds(52, 15, 728, 213);
		add(pUserInfo);
		pUserInfo.setLayout(null);

		JPanel pUserId = new JPanel();
		pUserId.setBounds(46, 9, 201, 31);
		pUserInfo.add(pUserId);
		pUserId.setLayout(null);

		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setBounds(0, 8, 47, 15);
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		pUserId.add(lblUserId);

		tfUserId = new JTextField(u.getUserId());
		tfUserId.setEnabled(false);
		tfUserId.setBounds(65, 5, 126, 21);
		pUserId.add(tfUserId);
		tfUserId.setColumns(10);

		JPanel pUserName = new JPanel();
		pUserName.setBounds(46, 50, 201, 31);
		pUserInfo.add(pUserName);
		pUserName.setLayout(null);

		JLabel lblUserName = new JLabel("이 름");
		lblUserName.setBounds(0, 8, 40, 15);
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		pUserName.add(lblUserName);

		tfUserName = new JTextField(u.getUserName());
		tfUserName.setBounds(66, 5, 126, 21);
		tfUserName.setColumns(10);
		pUserName.add(tfUserName);

		JPanel pUserTel = new JPanel();
		pUserTel.setBounds(46, 91, 201, 31);
		pUserInfo.add(pUserTel);
		pUserTel.setLayout(null);

		JLabel lblUserTel = new JLabel("전화번호");
		lblUserTel.setBounds(0, 8, 59, 15);
		lblUserTel.setHorizontalAlignment(SwingConstants.CENTER);
		pUserTel.add(lblUserTel);

		tfUserTel = new JTextField(u.getUserTel());
		tfUserTel.setBounds(65, 5, 126, 21);
		tfUserTel.setColumns(10);
		pUserTel.add(tfUserTel);

		JPanel pUserAddr = new JPanel();
		pUserAddr.setBounds(46, 133, 538, 70);
		pUserInfo.add(pUserAddr);
		pUserAddr.setLayout(null);

		JLabel lblUserAddr = new JLabel("주 소");
		lblUserAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAddr.setBounds(0, 39, 44, 15);
		pUserAddr.add(lblUserAddr);

		sidoModel = new DefaultComboBoxModel<String>(getDate());
		cmbCity = new JComboBox<String>();

		cmbCity.setModel(sidoModel);
		cmbCity.setBounds(97, 11, 135, 21);
		pUserAddr.add(cmbCity);

		tfDoro = new JTextField();
		tfDoro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDoro.setText("");
				tfDoro.setForeground(Color.black);
			}
		});
		tfDoro.setHorizontalAlignment(SwingConstants.CENTER);
		tfDoro.setForeground(new Color(230, 230, 250));
		tfDoro.setText("도로명");
		tfDoro.setBounds(244, 11, 151, 21);
		pUserAddr.add(tfDoro);
		tfDoro.setColumns(10);

		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(408, 10, 97, 23);
		pUserAddr.add(btnSearch);

		tfAddr = new JTextField(u.getUserAddr());
		tfAddr.setBounds(68, 38, 468, 21);
		pUserAddr.add(tfAddr);
		tfAddr.setColumns(10);

		JPanel pUserEamil = new JPanel();
		pUserEamil.setBounds(273, 10, 310, 31);
		pUserInfo.add(pUserEamil);
		pUserEamil.setLayout(null);

		JLabel lblUserEamil = new JLabel("이메일");
		lblUserEamil.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserEamil.setBounds(4, 8, 57, 15);
		pUserEamil.add(lblUserEamil);

		tfUserEamil = new JTextField(u.getUserEmail());
		tfUserEamil.setBounds(87, 5, 215, 21);
		tfUserEamil.setColumns(10);
		pUserEamil.add(tfUserEamil);

		JPanel pUserPw = new JPanel();
		pUserPw.setBounds(273, 51, 310, 31);
		pUserInfo.add(pUserPw);
		pUserPw.setLayout(null);

		JLabel lblUserPw = new JLabel("비밀번호");
		lblUserPw.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserPw.setBounds(4, 8, 57, 15);
		pUserPw.add(lblUserPw);

		tfUserPw = new JPasswordField();
		tfUserPw.setBounds(87, 5, 215, 21);
		tfUserPw.setColumns(10);
		pUserPw.add(tfUserPw);

		JPanel pUserPwCh = new JPanel();
		pUserPwCh.setBounds(273, 92, 310, 31);
		pUserInfo.add(pUserPwCh);
		pUserPwCh.setLayout(null);

		JLabel lblUserPwCh = new JLabel("비밀번호 확인");
		lblUserPwCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPwCh.setBounds(0, 8, 84, 15);
		pUserPwCh.add(lblUserPwCh);

		tfUserPwCh = new JPasswordField();
		tfUserPwCh.setBounds(88, 5, 215, 21);
		tfUserPwCh.setColumns(10);
		pUserPwCh.add(tfUserPwCh);
		
				JButton btnLeave = new JButton("회원탈퇴");
				btnLeave.setFont(new Font("굴림", Font.PLAIN, 13));
				btnLeave.setBounds(610, 139, 90, 34);
				pUserInfo.add(btnLeave);
				
						JButton btnUpdate = new JButton("수 정");
						btnUpdate.setFont(new Font("굴림", Font.PLAIN, 13));
						btnUpdate.setBounds(610, 42, 90, 34);
						pUserInfo.add(btnUpdate);
						
								JButton btnCancel = new JButton("취 소");
								btnCancel.setFont(new Font("굴림", Font.PLAIN, 13));
								btnCancel.setBounds(610, 89, 90, 34);
								pUserInfo.add(btnCancel);
								
								JLabel label = new JLabel("");
								label.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label.setBounds(42, 16, 4, 17);
								pUserInfo.add(label);
								
								JLabel label_1 = new JLabel("");
								label_1.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_1.setBounds(42, 57, 4, 17);
								pUserInfo.add(label_1);
								
								JLabel label_2 = new JLabel("");
								label_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_2.setBounds(42, 98, 4, 17);
								pUserInfo.add(label_2);
								
								JLabel label_3 = new JLabel("");
								label_3.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_3.setBounds(269, 17, 4, 17);
								pUserInfo.add(label_3);
								
								JLabel label_4 = new JLabel("");
								label_4.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_4.setBounds(269, 58, 4, 17);
								pUserInfo.add(label_4);
								
								JLabel label_5 = new JLabel("");
								label_5.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_5.setBounds(269, 99, 4, 17);
								pUserInfo.add(label_5);
								
								JLabel label_6 = new JLabel("");
								label_6.setBorder(new LineBorder(new Color(0, 128, 128), 2));
								label_6.setBounds(42, 170, 4, 17);
								pUserInfo.add(label_6);
								btnCancel.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										clearTf();
									}
								});
						btnUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (tfUserPw.getText().length() <= 7) {
									JOptionPane.showMessageDialog(null, "비밀번호 8자 이상입력해주세요");
									return;
								}
								if (!checkTf()) {
									JOptionPane.showMessageDialog(null, "빈 칸을 입력해주세요");
								}
								if (tfUserPw.getText().equals(tfUserPwCh.getText())) {
									userUpdatae();
									JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다");
								} else {
									JOptionPane.showMessageDialog(null, "비밀번호가 맞지않습니다.");
								}
							}
						});
				btnLeave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						int i = JOptionPane.showConfirmDialog(null, "회원 탈퇴를 하겠습니까?");
						if (i == 0) {
							u.setUserLeave("N");
							JOptionPane.showMessageDialog(null, "그 동안 이용해주셔서 감사합니다.");
							UsersService.getInstance().findupdateUsers(u);
							setVisible(false);
						}
					}
				});

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(4, 264, 801, 235);
		add(scrollPane_1);

		historyTable = new JTable();
		historyTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					UserinfoHistoryViewFrame frame = new UserinfoHistoryViewFrame();
					frame.setVisible(true);
				}
			}
		});

		settingTableView();

		JButton btnNewButton_2 = new JButton("히스토리");
		btnNewButton_2.setBounds(10, 233, 115, 23);
		add(btnNewButton_2);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfDoro.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "도로명을 입력해주세요");
					return;
				}
				PostView frame = new PostView(1);
				frame.setVisible(true);
			}
		});
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public void settingTableView() {
		historyTable.setModel(makeTableModel());
		setAlignWidth();
		historyTable.setVisible(true);
		scrollPane_1.setViewportView(historyTable);
		scrollPane_1.setVisible(true);
	}

	private DefaultTableModel makeTableModel() {

		return new DefaultTableModel(getData(), getColumnNames()) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

	}

	public void clearTf() {
		tfUserName.setText(u.getUserName());
		tfAddr.setText(u.getUserAddr());
		tfUserTel.setText(u.getUserTel());
		tfUserEamil.setText(u.getUserEmail());
		tfUserPw.setText("");
		tfUserPwCh.setText("");
	}

	public UserInfoView(String str) {

	}

	public JComboBox<String> getCmbCity() {
		return cmbCity;
	}

	public JTextField getTfAddr() {
		return tfAddr;
	}

	public void setTfAddr(JTextField tfAddr) {
		this.tfAddr = tfAddr;
	}

	private Object[][] getData() {
		HistoryView users = new HistoryView();
		users.setUserId(MainUi.getUsers().getUserId());

		List<HistoryView> lists = HistoryViewService.getInstance().findUserHistoryVide(users);
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {

			datas[i] = lists.get(i).toArray();

		}
		return datas;
	}

	private String[] getColumnNames() {
		return new String[] { "도서코드", "도서이름", "저자", "출판사", "가격", "대여일", "반납일" };
	}

	private Vector<String> getDate() {
		Vector<String> vt = new Vector<>();
		List<Post> lists = PostService.getInstance().findPostBysido();
		for (Post p : lists) {
			vt.add(p.getSido());
		}
		return vt;
	}

	public JTextField getTfDoro() {
		return tfDoro;
	}

	public void setTfDoro(JTextField tfDoro) {
		this.tfDoro = tfDoro;
	}

	public void setCmbCity(JComboBox<String> cmbCity) {
		this.cmbCity = cmbCity;
	}

	public void userUpdatae() {
		String userId = tfUserId.getText();
		String userName = tfUserName.getText();
		String userAddr = tfAddr.getText();
		String userTel = tfUserTel.getText();
		String userEmail = tfUserEamil.getText();
		String userPw = tfUserPw.getText();
		int delayDay = 0;
		String rankCode = "2";
		String userLeave = "Y";
		Users user = new Users(userId, userName, userPw, userAddr, userTel, userEmail, delayDay, rankCode, userLeave);
		UsersService.getInstance().findupdateUsers(user);
	}

	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		setCellWidth(80, 300, 80, 80, 50, 80, 80);
	}

	public void setCellWidth(int... width) {
		TableColumnModel cModel = historyTable.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void setAlign(int align, int... idx) {
		// 0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = historyTable.getColumnModel();
		// idx = [0,2]
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public boolean checkTf() {
		if (tfUserId.getText().equals("")) {
			return false;
		}
		if (tfUserName.getText().equals("")) {
			return false;
		}
		if (tfAddr.getText().equals("")) {
			return false;
		}
		if (tfUserTel.getText().equals("")) {
			return false;
		}
		if (tfUserEamil.getText().equals("")) {
			return false;
		}
		return true;
	}
}
