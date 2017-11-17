package kr.or.dgit.library_project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.RentalViewService;
import javax.swing.DefaultComboBoxModel;

public class ManagerRentalBook extends JPanel {
	private JTable table;
	private JTextField tfSearch;
	private JRadioButton radioRent;
	private JRadioButton radioReturn;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public ManagerRentalBook() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(152, 10, 508, 41);
		add(panel);
		
		JLabel lblSearch = new JLabel("검 색");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("굴림", Font.BOLD, 15));
		lblSearch.setBounds(12, 12, 42, 18);
		panel.add(lblSearch);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("전체보기")) {
					if(radioRent.isSelected()==true) {
						loadDataRent();
					}
					if(radioReturn.isSelected()==true) {
						loadDataReturn();
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"전체보기", "도서코드", "도서명", "회원ID", "회원명", "대여일", "반납예정일"}));
		comboBox.setBounds(69, 11, 98, 21);
		panel.add(comboBox);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(179, 9, 213, 21);
		panel.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataEach();
			}
		});
		btnSearch.setBounds(404, 7, 70, 23);
		panel.add(btnSearch);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(12, 66, 759, 523);
		add(panel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 759, 465);
		panel_6.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		radioRent = new JRadioButton("대여현황");
		radioRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataRent();
			}
		});
		radioRent.setFont(new Font("굴림", Font.BOLD, 15));
		radioRent.setBounds(279, 6, 95, 36);
		radioRent.setSelected(true);
		panel_6.add(radioRent);
		
		radioReturn = new JRadioButton("반납현황");
		radioReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataReturn();
			}
		});
		radioReturn.setFont(new Font("굴림", Font.BOLD, 15));
		radioReturn.setBounds(390, 6, 95, 36);
		panel_6.add(radioReturn);
		
		ButtonGroup  group = new ButtonGroup(); //라디오버튼 그룹화를 위한 버튼그룹 설정
		group.add(radioRent);
		group.add(radioReturn);

		loadDataRent();
	}
	
	public void loadDataRent() {
		DefaultTableModel model = new DefaultTableModel(getDataRent(), getColumnNames());
		table.setModel(model);
	}

	public String[] getColumnNames() {
		return new String[] { "도서코드", "도서명", "회원ID", "회원명","저자","출판사","가격","대여일","반납예정일"};
	}

	public Object[][] getDataRent() {
		List<RentalView> lists = RentalViewService.getInstance().findAllRentalViewMap();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}
	
	public void loadDataReturn() {
		DefaultTableModel model = new DefaultTableModel(getDataReturn(), getColumnNames());
		table.setModel(model);
	}

	public Object[][] getDataReturn() {
		List<HistoryView> lists = HistoryViewService.getInstance().findAllHistoryViewDataMap();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray2();
		}
		return data;
	}
	
	//콤보박스 선택에 따른 검색(loadDataEach)
	public void loadDataEach() {
		if(radioRent.isSelected()==true) {
			DefaultTableModel model = new DefaultTableModel(getDataRentEach(), getColumnNames());
			table.setModel(model);
		}
		if(radioReturn.isSelected()==true) {
			DefaultTableModel model = new DefaultTableModel(getDataReturnEach(), getColumnNames());
			table.setModel(model);
		}
	}

	private Object[][] getDataRentEach() {
		List<RentalView> lists=searchRentEach();
		
		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	private List<RentalView> searchRentEach() {
		String selectedCombo=(String) comboBox.getSelectedItem();
		String item=tfSearch.getText();
		List<RentalView> lists=null;
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(selectedCombo.equals("도서코드")) {
			map.put("bookCode", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("회원ID")) {
			map.put("userId", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("회원명")) {
			map.put("userName", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("대여일")) {
			map.put("rentalDay", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("반납예정일")) {
			map.put("returnDay", "%"+item+"%");
			lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
			return lists;
		}
		return lists;
	}
	
	private Object[][] getDataReturnEach() {
		List<HistoryView> lists=searchReturnEach();
		
		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	private List<HistoryView> searchReturnEach() {
		String selectedCombo=(String) comboBox.getSelectedItem();
		String item=tfSearch.getText();
		List<HistoryView> lists=null;
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(selectedCombo.equals("도서코드")) {
			map.put("bookCode", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("회원ID")) {
			map.put("userId", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("회원명")) {
			map.put("userName", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("대여일")) {
			map.put("rentalDay", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		if(selectedCombo.equals("반납예정일")) {
			map.put("returnDay", "%"+item+"%");
			lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
			return lists;
		}
		return lists;
	}
}
