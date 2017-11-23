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
	private JTextField tfAddr;
	private DefaultComboBoxModel sidoModel;
	private Users u;
	public  JComboBox<String> cmbCity;
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
		pUserInfo.setBounds(167, 25, 594, 227);
		add(pUserInfo);
		pUserInfo.setLayout(null);
		
		JPanel pUserId = new JPanel();
		pUserId.setBounds(36, 10, 228, 31);
		pUserInfo.add(pUserId);
		pUserId.setLayout(null);
		
		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setBounds(12, 8, 47, 15);
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		pUserId.add(lblUserId);
		
		tfUserId = new JTextField(u.getUserId());
		tfUserId.setEnabled(false);
		tfUserId.setBounds(83, 5, 116, 21);
		pUserId.add(tfUserId);
		tfUserId.setColumns(10);
		
		JPanel pUserName = new JPanel();
		pUserName.setBounds(36, 51, 228, 31);
		pUserInfo.add(pUserName);
		pUserName.setLayout(null);
		
		JLabel lblUserName = new JLabel("이 름");
		lblUserName.setBounds(12, 8, 40, 15);
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		pUserName.add(lblUserName);
		
		tfUserName = new JTextField(u.getUserName());
		tfUserName.setBounds(84, 5, 116, 21);
		tfUserName.setColumns(10);
		pUserName.add(tfUserName);
		
		JPanel pUserTel = new JPanel();
		pUserTel.setBounds(36, 92, 228, 31);
		pUserInfo.add(pUserTel);
		pUserTel.setLayout(null);
		
		JLabel lblUserTel = new JLabel("전화번호");
		lblUserTel.setBounds(5, 8, 65, 15);
		lblUserTel.setHorizontalAlignment(SwingConstants.CENTER);
		pUserTel.add(lblUserTel);
		
		tfUserTel = new JTextField(u.getUserTel());
		tfUserTel.setBounds(82, 5, 116, 21);
		tfUserTel.setColumns(10);
		pUserTel.add(tfUserTel);
		
		JPanel pUserAddr = new JPanel();
		pUserAddr.setBounds(36, 133, 548, 70);
		pUserInfo.add(pUserAddr);
		pUserAddr.setLayout(null);
		
		JLabel lblUserAddr = new JLabel("주 소");
		lblUserAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAddr.setBounds(12, 41, 44, 15);
		pUserAddr.add(lblUserAddr);
		
		sidoModel = new DefaultComboBoxModel<String>(getDate());
		cmbCity = new JComboBox<String>();
		
		cmbCity.setModel(sidoModel);
		cmbCity.setBounds(170, 11, 135, 21);
		pUserAddr.add(cmbCity);
		
		tfDoro = new JTextField();
		tfDoro.setBounds(317, 11, 110, 21);
		pUserAddr.add(tfDoro);
		tfDoro.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(439, 10, 97, 23);
		pUserAddr.add(btnSearch);
		
		tfAddr = new JTextField(u.getUserAddr());
		tfAddr.setBounds(68, 38, 468, 21);
		pUserAddr.add(tfAddr);
		tfAddr.setColumns(10);
		
		JPanel pUserEamil = new JPanel();
		pUserEamil.setBounds(276, 10, 308, 31);
		pUserInfo.add(pUserEamil);
		pUserEamil.setLayout(null);
		
		JLabel lblUserEamil = new JLabel("이메일");
		lblUserEamil.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEamil.setBounds(12, 8, 57, 15);
		pUserEamil.add(lblUserEamil);
		
		tfUserEamil = new JTextField(u.getUserEmail());
		tfUserEamil.setBounds(81, 5, 215, 21);
		tfUserEamil.setColumns(10);
		pUserEamil.add(tfUserEamil);
		
		JPanel pUserPw = new JPanel();
		pUserPw.setBounds(276, 51, 308, 31);
		pUserInfo.add(pUserPw);
		pUserPw.setLayout(null);
		
		JLabel lblUserPw = new JLabel("비밀번호");
		lblUserPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPw.setBounds(12, 8, 57, 15);
		pUserPw.add(lblUserPw);
		
		tfUserPw = new JPasswordField();
		tfUserPw.setBounds(81, 5, 215, 21);
		tfUserPw.setColumns(10);
		pUserPw.add(tfUserPw);
		
		JPanel pUserPwCh = new JPanel();
		pUserPwCh.setBounds(269, 92, 315, 31);
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 25, 148, 217);
		add(panel_7);
		panel_7.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(11, 288, 775, 246);
		add(scrollPane_1);
		
		historyTable = new JTable();
		
		settingTableView();
		
		JButton btnNewButton_2 = new JButton("히스토리");
		btnNewButton_2.setBounds(10, 255, 115, 23);
		add(btnNewButton_2);
		
		JButton btnUpdate = new JButton("수 정");
		btnUpdate.setBounds(662, 255, 90, 23);
		add(btnUpdate);
		
		JButton btnCancel = new JButton("취 소");
		btnCancel.setBounds(560, 255, 90, 23);
		add(btnCancel);
		
		JButton btnLeave = new JButton("회원탈퇴");
		btnLeave.setBounds(454, 255, 90, 23);
		add(btnLeave);
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = JOptionPane.showConfirmDialog(null, "회원 탈퇴를 하겠습니까?");
				if(i == 0) {
					u.setUserLeave("N");
					JOptionPane.showMessageDialog(null, "그 동안 이용해주셔서 감사합니다.");
					UsersService.getInstance().findupdateUsers(u);
					setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTf();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfUserPw.getText().length() <=7) {
					JOptionPane.showMessageDialog(null, "비밀번호 8자 이상입력해주세요");
					return;
				}
				if(tfUserPw.getText().equals(tfUserPwCh.getText())) {
					userUpdatae();
					JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다");
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지않습니다.");
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		
		return new DefaultTableModel(getData(),getColumnNames());
	}

	public void clearTf() {
		tfUserId.setText("");
		tfUserName.setText("");
		tfAddr.setText("");
		tfUserTel.setText("");
		tfUserEamil.setText("");
	}

	public UserInfoView(String str) {
		
	}

	public  JComboBox<String> getCmbCity() {
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
		for(int i =0; i < lists.size(); i++) {
			
			datas[i] = lists.get(i).toArray();
		
		}
		return datas;
	}

	private String[] getColumnNames() {
		return new String[] {"도서코드","도서이름","저자","출판사","가격","대여일","반납일"};
	}

	private Vector<String> getDate() {
		Vector<String> vt = new Vector<>();
		List<Post> lists = PostService.getInstance().findPostBysido();
		for(Post p : lists) {
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
		int rankCode = 2;
		String userLeave = "Y";
		Users user = new Users(userId, userName, userPw, userAddr, userTel, userEmail, delayDay, rankCode, userLeave);
		UsersService.getInstance().findupdateUsers(user);
	}
	
	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER,0,1,2,3,4,5,6);
		setCellWidth(80, 300, 80, 80, 50, 100, 100);
	}
	
	public void setCellWidth(int...width) {
		TableColumnModel cModel = historyTable.getColumnModel();
		System.out.println(Arrays.toString(width));
		for(int i=0; i<width.length; i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void setAlign(int align, int...idx) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = historyTable.getColumnModel();
		// idx = [0,2]
		for(int i=0; i<idx.length;i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
}
