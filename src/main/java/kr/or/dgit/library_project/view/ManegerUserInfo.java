package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.service.UsersService;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

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
	public static JTextField getTfAddr() {
		return tfAddr;
	}

	public static void setTfAddr(JTextField tfAddr) {
		ManegerUserInfo.tfAddr = tfAddr;
	}
	private static JTextField tfDoro;
	private static JComboBox<String> cmbSido;
	private DefaultComboBoxModel<String> sidoModel;
	public ManegerUserInfo() {
		setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(192, 192, 192), 0));
		panel_9.setBounds(80, 65, 648, 165);
		add(panel_9);
		
		JPanel pId = new JPanel();
		pId.setLayout(null);
		pId.setBounds(19, 6, 190, 31);
		panel_9.add(pId);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(4, 8, 47, 15);
		pId.add(lblId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(63, 5, 116, 21);
		pId.add(tfId);
		
		JPanel pName = new JPanel();
		pName.setLayout(null);
		pName.setBounds(19, 47, 190, 31);
		panel_9.add(pName);
		
		JLabel lblName = new JLabel("이 름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(5, 7, 40, 15);
		pName.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(62, 4, 116, 21);
		pName.add(tfName);
		
		JPanel pTel = new JPanel();
		pTel.setLayout(null);
		pTel.setBounds(221, 47, 295, 31);
		panel_9.add(pTel);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setBounds(3, 7, 65, 15);
		pTel.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(73, 4, 201, 21);
		pTel.add(tfTel);
		
		JPanel pAddr = new JPanel();
		pAddr.setLayout(null);
		pAddr.setBounds(19, 86, 497, 69);
		panel_9.add(pAddr);
		
		JLabel lblAddr = new JLabel("주 소");
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddr.setBounds(12, 14, 44, 15);
		pAddr.add(lblAddr);
		
		sidoModel = new DefaultComboBoxModel<String>(getDate());
		cmbSido = new JComboBox<String>(sidoModel);
		cmbSido.setBounds(68, 11, 99, 21);
		pAddr.add(cmbSido);
		
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(68, 40, 376, 21);
		pAddr.add(tfAddr);
		
		tfDoro = new JTextField();
		tfDoro.setBounds(179, 11, 177, 21);
		pAddr.add(tfDoro);
		tfDoro.setColumns(10);
		
		JButton btnAddr = new JButton("검색");
		btnAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostView frame = new PostView(3);
				frame.setVisible(true);
			}
		});
		btnAddr.setBounds(368, 10, 76, 23);
		pAddr.add(btnAddr);
		
		JPanel pEmail = new JPanel();
		pEmail.setLayout(null);
		pEmail.setBounds(221, 6, 295, 31);
		panel_9.add(pEmail);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(4, 8, 57, 15);
		pEmail.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(70, 5, 202, 21);
		pEmail.add(tfEmail);
		
		JButton btnUpdate = new JButton("수 정");
		btnUpdate.setBounds(528, 33, 97, 23);
		panel_9.add(btnUpdate);
		
		JButton btnClear = new JButton("확 인");
		btnClear.setBounds(529, 60, 97, 23);
		panel_9.add(btnClear);
		
		JButton btnDel = new JButton("회원탈퇴");
		btnDel.setBounds(528, 86, 97, 23);
		panel_9.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "회원 탈퇴를 하겠습니까?");
				if(i == 0) {
					deleteU();
				}else {
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
		pSerach.setLayout(null);
		pSerach.setBounds(100, 10, 491, 43);
		add(pSerach);
		cmbSearch = new JComboBox<String>();
		cmbSearch.setModel(new DefaultComboBoxModel<String>(new String[] {"아이디", "이름", "전화번호", "이메일"}));
		cmbSearch.setBounds(12, 10, 93, 25);
		pSerach.add(cmbSearch);
		
		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		tfSearch.setColumns(10);
		tfSearch.setBounds(117, 10, 259, 25);
		pSerach.add(tfSearch);
		
		JButton btnsearch = new JButton("검 색");
		
		btnsearch.setBounds(388, 11, 93, 23);
		pSerach.add(btnsearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 235, 758, 258);
		add(scrollPane);
		DefaultTableModel tableModel = new DefaultTableModel(getData(),getColumnNames());
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setComponentPopupMenu(createPopupMenu());;
		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(3, 10, 94, 30);
		add(lblNewLabel);
		
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel(searchData(),getColumnNames());
				table.setModel(model);
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
		for(Post p : lists) {
			vt.add(p.getSido());
		}
		return vt;
	}

	protected void userUpdatae() {
		String userId = tfId.getText();
		Users u = UsersService.getInstance().findUsersByNo(new Users(userId));
		String userName = tfName.getText();
		String userAddr = tfAddr.getText();
		String userTel = tfTel.getText();
		String userEmail = tfEmail.getText();
		String userPw = u.getUserPw();
		int delayDay = 0;
		int rankCode = 2;
		String userLeave = "Y";
		Users user = new Users(userId, userName, userPw, userAddr, userTel, userEmail, delayDay, rankCode, userLeave);
		UsersService.getInstance().findupdateUsers(user);
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
		return new String[] {
				"아이디", "이 름", "전화번호", "주 소", "이메일","탈퇴여부"
			};
	}
	private Object[][] searchData(){
		List<Users> lists = searchU();
		Object[][] datas = new Object[lists.size()][];
		for(int i =0; i < lists.size(); i++) {
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}
	private Object[][] getData() {
		List<Users> lists = UsersService.getInstance().findUsersByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i =0; i < lists.size(); i++) {
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
	}
	
	public List<Users> searchU() {
		String searchBy = (String)cmbSearch.getSelectedItem();
		String searchItem = tfSearch.getText();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (searchBy.equals("아이디")) {
			map.put("userId", "%"+searchItem+"%");
		}
		if (searchBy.equals("이름")) {
			map.put("userName", "%"+searchItem+"%");
		}
		if (searchBy.equals("전화번호")) {
			map.put("userTel", "%"+searchItem+"%");
		}
		if (searchBy.equals("이메일")) {
			map.put("userEmail", "%"+searchItem+"%");
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
		int selectedIndex=table.getSelectedRow();
		tfId.setText((String)table.getValueAt(selectedIndex, 0));
		tfName.setText((String)table.getValueAt(selectedIndex, 1));
		tfTel.setText((String)table.getValueAt(selectedIndex, 2));
		tfAddr.setText((String)table.getValueAt(selectedIndex, 3));
		tfEmail.setText((String)table.getValueAt(selectedIndex, 4));
	}

}
