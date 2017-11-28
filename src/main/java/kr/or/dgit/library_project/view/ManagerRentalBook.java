package kr.or.dgit.library_project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.RentalViewService;

public class ManagerRentalBook extends JPanel {
	public static JTable table;
	private JTextField tfSearch;
	private JRadioButton radioRent;
	private JRadioButton radioReturn;
	private JComboBox comboBox;
	private JButton btnChart;

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
				tfSearch.setText("");
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
		panel_6.setBounds(5, 56, 759, 501);
		add(panel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 759, 447);
		panel_6.add(scrollPane);
		
		table = new JTable();
		addPopupMenu();
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
				comboBox.setSelectedIndex(0);
			}
		});
		radioReturn.setFont(new Font("굴림", Font.BOLD, 15));
		radioReturn.setBounds(390, 6, 95, 36);
		panel_6.add(radioReturn);
		
		ButtonGroup  group = new ButtonGroup(); //라디오버튼 그룹화를 위한 버튼그룹 설정
		group.add(radioRent);
		group.add(radioReturn);
		
		btnChart = new JButton("도서현황보기");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerChart mgChart=new ManagerChart();
				mgChart.setVisible(true);
			}
		});
		btnChart.setBounds(580, 13, 130, 23);
		panel_6.add(btnChart);

		loadDataRent();
	}
	
	private void addPopupMenu() {
		JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("자세히보기");
		popupMenu.add(menuItem);
		table.setComponentPopupMenu(popupMenu);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerBookDetailInfo mbdi=new ManagerBookDetailInfo();
				mbdi.setVisible(true);
			}
		});
	}
	
	public void loadDataRent() {
		DefaultTableModel model = new DefaultTableModel(getDataRent(), getRentColumnNames()){
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table.setModel(model);
		setAlignWidth();
	}

	public String[] getRentColumnNames() {
		return new String[] { "도서코드", "도서명", "회원ID", "회원명","저자","출판사","가격","대여일","반납예정일"};
	}
	
	public String[] getReturnColumnNames() {
		return new String[] { "도서코드", "도서명", "회원ID", "회원명","저자","출판사","가격","대여일","반납일"};
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
		DefaultTableModel model = new DefaultTableModel(getDataReturn(), getReturnColumnNames()){
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table.setModel(model);
		setAlignWidth();
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
			DefaultTableModel model = new DefaultTableModel(getDataRentEach(), getRentColumnNames()){
				public boolean isCellEditable(int i, int c) {
					return false;
				}
			};
			table.setModel(model);
		}
		if(radioReturn.isSelected()==true) {
			DefaultTableModel model = new DefaultTableModel(getDataReturnEach(), getReturnColumnNames()){
				public boolean isCellEditable(int i, int c) {
					return false;
				}
			};
			table.setModel(model);
		}
		setAlignWidth();
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
		}
		if(selectedCombo.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
		}
		if(selectedCombo.equals("회원ID")) {
			map.put("userId", "%"+item+"%");
		}
		if(selectedCombo.equals("회원명")) {
			map.put("userName", "%"+item+"%");
		}
		if(selectedCombo.equals("대여일")) {
			map.put("rentalDay", "%"+item+"%");
		}
		if(selectedCombo.equals("반납예정일")) {
			map.put("returnDay", "%"+item+"%");
		}
		lists=RentalViewService.getInstance().findByWhereRentalViewMap(map);
		return lists;
	}
	
	private Object[][] getDataReturnEach() {
		List<HistoryView> lists=searchReturnEach();
		
		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray2();
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
		}
		if(selectedCombo.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
		}
		if(selectedCombo.equals("회원ID")) {
			map.put("userId", "%"+item+"%");
		}
		if(selectedCombo.equals("회원명")) {
			map.put("userName", "%"+item+"%");
		}
		if(selectedCombo.equals("대여일")) {
			map.put("rentalDay", "%"+item+"%");
		}
		if(selectedCombo.equals("반납예정일")) {
			map.put("returnDay", "%"+item+"%");
		}
		lists=HistoryViewService.getInstance().findWhereHistoryViewMap(map);
		return lists;
	}
	
	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER,0,1,2,3,4,5,6,7,8);
		setCellWidth(100, 300, 80, 80, 100, 150, 100, 100, 100);
	}
	
	public void setCellWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<width.length; i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void setAlign(int align, int...idx) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		// idx = [0,2]
		for(int i=0; i<idx.length;i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
}
