package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

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

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.ui.MainUi;

public class UserInfoView extends JPanel {

	private JTable table;
	private JTable historyTable;
	private JTextField tfUserId;
	private JTextField tfUserName;
	private JTextField tfUserTel;
	private JTextField tfUserEamil;
	private JTextField tfUserPw;
	private JTextField tfUserPwCh;
	private JTextField tfEctAddr;
	
	public UserInfoView() {
		setLayout(null);
		Users u = MainUi.getUsers();
		JPanel pUserInfo = new JPanel();
		pUserInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pUserInfo.setBounds(228, 31, 594, 202);
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
		pUserAddr.setBounds(36, 133, 548, 31);
		pUserInfo.add(pUserAddr);
		pUserAddr.setLayout(null);
		
		JLabel lblUserAddr = new JLabel("주 소");
		lblUserAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAddr.setBounds(12, 10, 44, 15);
		pUserAddr.add(lblUserAddr);
		
		DefaultComboBoxModel sidoModel = new DefaultComboBoxModel<String>(getDate());
		JComboBox<String> cmbCity = new JComboBox<String>();
		
		cmbCity.setModel(sidoModel);
		cmbCity.setBounds(68, 7, 87, 21);
		pUserAddr.add(cmbCity);
		
		
		JComboBox<String> cmbState = new JComboBox<String>();
		cmbState.setBounds(158, 7, 94, 21);
		pUserAddr.add(cmbState);
		
		tfEctAddr = new JTextField();
		tfEctAddr.setBounds(281, 7, 255, 21);
		pUserAddr.add(tfEctAddr);
		tfEctAddr.setColumns(10);
		
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
		
		tfUserPw = new JTextField();
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
		
		tfUserPwCh = new JTextField();
		tfUserPwCh.setBounds(88, 5, 215, 21);
		tfUserPwCh.setColumns(10);
		pUserPwCh.add(tfUserPwCh);
		
		JButton btnUpdate = new JButton("수 정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(190, 174, 97, 23);
		pUserInfo.add(btnUpdate);
		
		JButton btnCancel = new JButton("취 소");
		btnCancel.setBounds(293, 174, 97, 23);
		pUserInfo.add(btnCancel);
		
		JButton btnLeave = new JButton("회원탈퇴");
		btnLeave.setBounds(490, 174, 81, 23);
		pUserInfo.add(btnLeave);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setVgap(15);
		panel_7.setBounds(47, 45, 148, 137);
		add(panel_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 267, 775, 243);
		add(scrollPane_1);
		
		DefaultTableModel tableModel = new DefaultTableModel(getData(),getColumnNames());
		historyTable = new JTable();
		historyTable.setModel(tableModel);
		scrollPane_1.setViewportView(historyTable);
		
		JButton btnNewButton_2 = new JButton("히스토리");
		btnNewButton_2.setBounds(46, 234, 115, 23);
		add(btnNewButton_2);
		
		cmbCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> vt = new Vector<>();
				Post post = new Post();
				post.setSido((String) sidoModel.getSelectedItem());
				List<Post> lists = PostService.getInstance().findPostBySigungu(post);
				for(Post p : lists) {
					vt.add(p.getSigungu());
				}
				DefaultComboBoxModel sigunguModel = new DefaultComboBoxModel<String>(vt);
				cmbState.setModel(sigunguModel);
			}
		});
	}

	private Object[][] getData() {
		HistoryView users = new HistoryView();
		users.setUserId(MainUi.getUsers().getUserId());
		List<HistoryView> lists = HistoryViewService.getInstance().findUserHistoryVide(users);
		Object[][] datas = new Object[lists.size()][];
		for(HistoryView h : lists) {
			System.out.println(h.toArray().toString());
		}
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
}