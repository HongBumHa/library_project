package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.service.UsersService;

@SuppressWarnings("serial")
public class ManegerUserInfo extends JPanel {
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTel;
	private static JTextField tfAddr;
	private JTextField tfEmail;
	private JTextField tfSearch;
	private JTable table;
	private JComboBox<String> cmbSearch;
	private DefaultTableModel tableModel;

	public static JTextField getTfAddr() {
		return tfAddr;
	}

	public static void setTfAddr(JTextField tfAddr) {
		ManegerUserInfo.tfAddr = tfAddr;
	}

	private static JTextField tfDoro;
	private static JComboBox<String> cmbSido;
	private DefaultComboBoxModel<String> sidoModel;

	private JComboBox<String> cmbRank;

	public ManegerUserInfo() {
		setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_9.setBounds(39, 82, 732, 153);
		add(panel_9);

		JPanel pId = new JPanel();
		pId.setBorder(null);
		pId.setLayout(null);
		pId.setBounds(28, 10, 182, 31);
		panel_9.add(pId);

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(4, 8, 47, 15);
		pId.add(lblId);

		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(58, 5, 116, 21);
		pId.add(tfId);

		JPanel pName = new JPanel();
		pName.setBorder(null);
		pName.setLayout(null);
		pName.setBounds(222, 10, 137, 31);
		panel_9.add(pName);

		JLabel lblName = new JLabel("이 름");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(3, 9, 36, 15);
		pName.add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(41, 6, 86, 21);
		pName.add(tfName);

		JPanel pTel = new JPanel();
		pTel.setBorder(null);
		pTel.setLayout(null);
		pTel.setBounds(28, 43, 182, 31);
		panel_9.add(pTel);

		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTel.setBounds(3, 7, 54, 15);
		pTel.add(lblTel);

		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(57, 4, 116, 21);
		pTel.add(tfTel);

		JPanel pAddr = new JPanel();
		pAddr.setBorder(null);
		pAddr.setLayout(null);
		pAddr.setBounds(28, 76, 497, 69);
		panel_9.add(pAddr);

		JLabel lblAddr = new JLabel("주 소");
		lblAddr.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddr.setBounds(12, 26, 44, 15);
		pAddr.add(lblAddr);

		sidoModel = new DefaultComboBoxModel<String>(getDate());
		cmbSido = new JComboBox<String>(sidoModel);
		cmbSido.setBounds(60, 12, 128, 21);
		pAddr.add(cmbSido);

		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(60, 38, 352, 21);
		pAddr.add(tfAddr);

		tfDoro = new JTextField();
		tfDoro.setBounds(190, 12, 145, 21);
		pAddr.add(tfDoro);
		tfDoro.setColumns(10);

		JButton btnAddr = new JButton("검색");
		btnAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostView frame = new PostView(3);
				frame.setVisible(true);
			}
		});
		btnAddr.setBounds(336, 12, 76, 23);
		pAddr.add(btnAddr);

		JPanel pEmail = new JPanel();
		pEmail.setBorder(null);
		pEmail.setLayout(null);
		pEmail.setBounds(222, 43, 263, 31);
		panel_9.add(pEmail);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(4, 8, 51, 15);
		pEmail.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(55, 4, 205, 21);
		pEmail.add(tfEmail);

		JPanel pRank = new JPanel();
		pRank.setBorder(null);
		pRank.setLayout(null);
		pRank.setBounds(371, 10, 157, 31);
		panel_9.add(pRank);

		JLabel lblRank = new JLabel("등 급");
		lblRank.setHorizontalAlignment(SwingConstants.LEFT);
		lblRank.setBounds(3, 8, 40, 15);
		pRank.add(lblRank);

		cmbRank = new JComboBox();
		cmbRank.setModel(new DefaultComboBoxModel<String>(new String[] { "관리자", "회원", "블랙리스트" }));
		cmbRank.setBounds(44, 5, 109, 21);

		pRank.add(cmbRank);

		JButton btnUpdate = new JButton("수 정");
		btnUpdate.setBounds(584, 28, 97, 23);
		panel_9.add(btnUpdate);

		JButton btnClear = new JButton("확 인");
		btnClear.setBounds(584, 65, 97, 23);
		panel_9.add(btnClear);

		JButton btnDel = new JButton("회원탈퇴");
		btnDel.setBounds(584, 102, 97, 23);
		panel_9.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "회원 탈퇴를 하겠습니까?");
				if (i == 0) {
					deleteU();
				} else {
					JOptionPane.showInternalMessageDialog(null, "취소하셨습니다");
				}
			}

		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userUpdatae();
			}
		});

		JPanel pSerach = new JPanel();
		pSerach.setBounds(37, 36, 499, 25);
		add(pSerach);
		pSerach.setLayout(new BoxLayout(pSerach, BoxLayout.X_AXIS));
		cmbSearch = new JComboBox<String>();
		cmbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbSearch.getSelectedItem().equals("전체보기")) {
					tableModel = new DefaultTableModel(getData(), getColumnNames()) {
						public boolean isCellEditable(int i, int c) {
							return false;
						}
					};
					tfSearch.setText("");
					table.setModel(tableModel);
					setAlignWidth();
				}
			}
		});
		cmbSearch.setModel(new DefaultComboBoxModel<String>(new String[] { "전체보기", "아이디", "이름", "전화번호", "이메일" }));
		pSerach.add(cmbSearch);

		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		tfSearch.setColumns(10);
		pSerach.add(tfSearch);

		JButton btnsearch = new JButton("검 색");
		pSerach.add(btnsearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 278, 777, 282);
		add(scrollPane);
		tableModel = new DefaultTableModel(getData(), getColumnNames()) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					selectTable();
				}
			}
		});
		table.setModel(tableModel);
		setAlignWidth();
		scrollPane.setViewportView(table);
		table.setComponentPopupMenu(createPopupMenu());
		;

		JLabel lblNewLabel_1 = new JLabel("유저리스트");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(11, 252, 86, 25);
		add(lblNewLabel_1);

		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel(searchData(), getColumnNames());
				table.setModel(model);
				setAlignWidth();
			}
		});
	}

	public static JComboBox<String> getCmbSido() {
		return cmbSido;
	}

	public static JTextField getTfDoro() {
		return tfDoro;
	}

	public static void setTfDoro(JTextField tfDoro) {
		ManegerUserInfo.tfDoro = tfDoro;
	}

	public static void setCmbSido(JComboBox<String> cmbSido) {
		ManegerUserInfo.cmbSido = cmbSido;
	}

	private Vector<String> getDate() {
		Vector<String> vt = new Vector<>();
		List<Post> lists = PostService.getInstance().findPostBysido();
		for (Post p : lists) {
			vt.add(p.getSido());
		}
		return vt;
	}

	protected void userUpdatae() {
		if (!isCheck()) {
			JOptionPane.showMessageDialog(null, "빈 칸을 입력해주세요", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		String userId = tfId.getText();
		Users u = UsersService.getInstance().findUsersByNo(new Users(userId));
		String userName = tfName.getText();
		String userAddr = tfAddr.getText();
		String userTel = tfTel.getText();
		String userEmail = tfEmail.getText();
		String userPw = u.getUserPw();
		int delayDay = 0;
		String rankCode = null;
		String rankName = (String) cmbRank.getSelectedItem();
		switch (rankName) {
		case "관리자":
			rankCode = "1";
			break;
		case "회원":
			rankCode = "2";
			break;
		case "블랙리스트":
			rankCode = "3";
			break;
		}
		String userLeave = "Y";
		Users user = new Users(userId, userName, userPw, userAddr, userTel, userEmail, delayDay, rankCode, userLeave);
		UsersService.getInstance().findupdateUsers(user);
		JOptionPane.showMessageDialog(null, user.getUserName() + "님 정보가 수정되었습니다.");
		tableModel = new DefaultTableModel(searchData(), getColumnNames()) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table.setModel(tableModel);
		setAlignWidth();
	}

	private boolean isCheck() {
		String userName = tfName.getText();
		String userAddr = tfAddr.getText();
		String userTel = tfTel.getText();
		String userEmail = tfEmail.getText();
		String userId = tfId.getText();
		if (userName.equals("") || userAddr.equals("") || userTel.equals("") || userEmail.equals("")
				|| userId.equals("")) {

			return false;
		}
		return true;

	}

	protected void clear() {
		tfSearch.setText("");
		tfAddr.setText("");
		tfEmail.setText("");
		tfId.setText("");
		tfName.setText("");
		tfDoro.setText("");
		tfTel.setText("");
	}

	private String[] getColumnNames() {
		return new String[] { "아이디", "이 름", "전화번호", "주 소", "이메일", "등급", "탈퇴여부" };

	}

	private Object[][] searchData() {
		List<Users> lists = searchU();
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	private Object[][] getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> lists = UsersService.getInstance().findSelectByUserList(map);
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	public void deleteU() {
		Users u = new Users();
		u.setUserId(tfId.getText());
		Users ul = UsersService.getInstance().findUsersByNo(u);
		ul.setUserLeave("N");
		UsersService.getInstance().findupdateUsers(ul);
		JOptionPane.showMessageDialog(null, "회원을 탈퇴시켰습니다.");
		tableModel = new DefaultTableModel(getData(), getColumnNames()) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		table.setModel(tableModel);
		setAlignWidth();

	}

	public List<Users> searchU() {
		String searchBy = (String) cmbSearch.getSelectedItem();
		String searchItem = tfSearch.getText();

		Map<String, Object> map = new HashMap<String, Object>();

		if (searchBy.equals("아이디")) {
			map.put("userId", "%" + searchItem + "%");
		}
		if (searchBy.equals("이름")) {
			map.put("userName", "%" + searchItem + "%");
		}
		if (searchBy.equals("전화번호")) {
			map.put("userTel", "%" + searchItem + "%");
		}
		if (searchBy.equals("이메일")) {
			map.put("userEmail", "%" + searchItem + "%");
		}

		List<Users> lists = UsersService.getInstance().findSelectByUserList(map);
		return lists;
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popUpMenu = new JPopupMenu();
		JMenuItem item = new JMenuItem("확인");
		item.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				selectTable();

			}
		});
		popUpMenu.add(item);
		return popUpMenu;
	}

	protected void selectTable() {

		int selectedIndex = table.getSelectedRow();
		tfId.setText((String) table.getValueAt(selectedIndex, 0));
		tfName.setText((String) table.getValueAt(selectedIndex, 1));
		tfTel.setText((String) table.getValueAt(selectedIndex, 2));
		tfAddr.setText((String) table.getValueAt(selectedIndex, 3));
		tfEmail.setText((String) table.getValueAt(selectedIndex, 4));
		cmbRank.setSelectedItem((String) table.getValueAt(selectedIndex, 5));

	}

	public void setAlignWidth() {

		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		setCellWidth(70, 70, 100, 300, 150, 70, 50);

	}

	public void setCellWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void setAlign(int align, int... idx) {
		// 0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = table.getColumnModel();
		// idx = [0,2]
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}
}
