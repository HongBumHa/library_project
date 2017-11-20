package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.UsersService;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ManagerUserinfo extends JPanel {
   private static final ManagerUserinfo instance = new ManagerUserinfo();
   private JPasswordField pfUserPw;
   private JPasswordField pfUserPwCh;


   public ManagerUserinfo() {
      JPanel panel_8 = new JPanel();
      panel_8.setMaximumSize(new Dimension(20000, 20000));
      panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JPanel panel_9 = new JPanel();
      panel_9.setLayout(null);
      panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
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

      JPanel psearchUser = new JPanel();
      psearchUser.setLayout(null);
      panel_8.add(psearchUser);

      JComboBox cmbseach = new JComboBox();
      cmbseach.setModel(new DefaultComboBoxModel(new String[] { "아이디", "이름", "전화번호", "이메일", "주소" }));
      cmbseach.setBounds(12, 10, 93, 25);
      psearchUser.add(cmbseach);

      JTextField tfSearch = new JTextField();
      tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
      tfSearch.setColumns(10);
      tfSearch.setBounds(117, 10, 259, 25);
      psearchUser.add(tfSearch);

      JButton tfSearch_1 = new JButton("검색");
      tfSearch_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      tfSearch_1.setBounds(388, 11, 93, 23);
      psearchUser.add(tfSearch_1);

//      JScrollPane scrollPane = new JScrollPane();
//      scrollPane.setBounds(22, 331, 690, 167);
//      panel_8.add(scrollPane);

//      DefaultTableModel tableModel = new DefaultTableModel(getData(), getColumnNames());
//      JTable table = new JTable();
//      scrollPane.setViewportView(table);

      JLabel lblNewLabel = new JLabel("회원리스트");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      panel_8.add(lblNewLabel);

      JButton btnUpdate = new JButton("수 정");
      panel_8.add(btnUpdate);

      JButton btnCencel = new JButton("취 소");
      panel_8.add(btnCencel);

      JButton btnDel = new JButton("회원 탈퇴");
      panel_8.add(btnDel);

      JLabel lblTitle = new JLabel("회원정보");
      lblTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
      panel_8.add(lblTitle);
   }

  /* private Object[][] getData() {
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("userLeave", "Y");
      List<Users> lists = UsersService.getInstance().findSelectByUserList(map);
      Object[][] datas = new Object[lists.size()][];
      for (int i = 0; i < lists.size(); i++) {
         datas[i] = lists.toArray();
      }
      return datas;
   }*/

   private String[] getColumnNames() {
      return new String[] { "ID", "이름", "주소", "전화번호", "이메일" };
   }
}
