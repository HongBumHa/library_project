package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.PostService;
import kr.or.dgit.library_project.ui.MainUi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnAdd;
	private JButton btnCencal;
	private UserInfoView uiv;
	private MemberApp mba;
	public PostView(int ioi) {
		if(ioi == 0) {
			mba = MemberApp.getInstance();
		}else if(ioi == 1) {
			uiv = UserInfoView.getInstance();
		}
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 687, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		DefaultTableModel tableModel = null;
		if(ioi ==1) {
			tableModel = new DefaultTableModel(getData(),getColumnNames());
		}else if(ioi ==0) {
			tableModel = new DefaultTableModel(getData2(),getColumnNames2());
		}else {
			tableModel = new DefaultTableModel(getData3(),getColumnNames3());
		}
		
		table = new JTable();
		
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnAdd = new JButton("확인");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				String addr = selectTable();
				
				 int i = JOptionPane.showConfirmDialog(null, 
						addr, 
						"주소 확인창", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				 if(ioi ==1) {
					 
					 uiv.getTfAddr().setText(addr);
					 setVisible(false);
				 }else if(ioi ==0) {
					 mba.getTfUserAddr().setText(addr);
					 setVisible(false);
				 }else if(ioi ==3) {
					 ManegerUserInfo.getTfAddr().setText(addr);
					 setVisible(false);
				 }
				
			}
		});
		panel.add(btnAdd);
		
		btnCencal = new JButton("취소");
		btnCencal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(btnCencal);
		
	}

	private String[] getColumnNames3() {
		return new String[] {"우편번호","시도","시군구","도로","건물명1","건물명2"};
		
	}

	private Object[][] getData3() {
		String sido = (String)ManegerUserInfo.getCmbSido().getSelectedItem();
		String doro = ManegerUserInfo.getTfDoro().getText()  + "%";
		Post post = new Post(sido,doro);
		List<Post> lists = PostService.getInstance().findSelectByDoroList(post);
		Object[][] datas = new Object[lists.size()][];
		for(int i =0; i < lists.size(); i++) {
			
			datas[i] = lists.get(i).toArray();
			
		}
		return datas;
	}

	private Object[][] getData2() {
		String doro = mba.getTfDoro().getText() + "%";
		String sido = (String) mba.getCmbUserAddr().getSelectedItem();
		
		Post post = new Post(sido,doro);
		List<Post> lists = PostService.getInstance().findSelectByDoroList(post);
		Object[][] datas = new Object[lists.size()][];
		for(int i =0; i < lists.size(); i++) {
			
			datas[i] = lists.get(i).toArray();
			
		}
		return datas;
	}

	private String[] getColumnNames2() {
		return new String[] {"우편번호","시도","시군구","도로","건물명1","건물명2"};
	}

	protected String selectTable() {
		int selectedIndex=table.getSelectedRow();
	     String sido=(String) table.getValueAt(selectedIndex, 1);
	     String sigungu=(String) table.getValueAt(selectedIndex, 2);
	     String doro=(String) table.getValueAt(selectedIndex, 3);
	     String building1=(String) table.getValueAt(selectedIndex, 4);
	     String building2=(String) table.getValueAt(selectedIndex, 5);

	     String addr = sido+" "+sigungu+" "+doro+" "+building1+building2;
	    return addr;
	}

	private String[] getColumnNames() {
		return new String[] {"우편번호","시도","시군구","도로","건물명1","건물명2"};
	}

	private  Object[][] getData() {	
		String doro = uiv.getTfDoro().getText() + "%";
		String sido = (String) uiv.getCmbCity().getSelectedItem();
		
		Post post = new Post(sido,doro);
		List<Post> lists = PostService.getInstance().findSelectByDoroList(post);
		Object[][] datas = new Object[lists.size()][];
		for(int i =0; i < lists.size(); i++) {
			
			datas[i] = lists.get(i).toArray();
		
		}
	
		return datas;
	}

}
