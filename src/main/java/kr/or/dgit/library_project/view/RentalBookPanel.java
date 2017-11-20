package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.service.BookService;

public class RentalBookPanel extends JPanel {

	private JPanel contentPane;
	private JTextField tfSearch;
	public static JTable table;
	private JComboBox comboBox;

	public RentalBookPanel() {
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setLayout(null);
		pSearch.setBounds(219, 10, 586, 54);
		add(pSearch);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="전체보기") {
					loadDataAll();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"전체보기", "도서코드", "도서명", "저 자", "출판사"}));
		comboBox.setBounds(12, 10, 93, 25);
		pSearch.add(comboBox);

		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		tfSearch.setColumns(10);
		tfSearch.setBounds(117, 10, 356, 25);
		pSearch.add(tfSearch);

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataEach();

			}
		});
		btnSearch.setBounds(485, 11, 93, 23);
		pSearch.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 74, 793, 418);
		add(scrollPane);

		table = new JTable();
		addPopupMenu();
		
		loadDataAll();
		scrollPane.setViewportView(table);

		JPanel pUserRentInfo = new JPanel();
		pUserRentInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		pUserRentInfo.setBounds(12, 10, 195, 54);
		add(pUserRentInfo);
		pUserRentInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblUserName = new JLabel("xxx님의 대여 현황");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblUserName);

		JLabel lblRent = new JLabel("대여: 5권");
		lblRent.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblRent);

		JLabel lblReturn = new JLabel("미반납: 1권");
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblReturn);
	}

	private void addPopupMenu() {
		JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("대여하기");
		popupMenu.add(menuItem);
		table.setComponentPopupMenu(popupMenu);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RentBookInfoView rbiv=new RentBookInfoView();
				rbiv.setVisible(true);
				
			}
		});
	}
	
	

	public void loadDataAll() {
		DefaultTableModel model = new DefaultTableModel(getDataAll(), getColumnNames());
		table.setModel(model);
	}

	public String[] getColumnNames() {
		return new String[] { "도서코드", "도서명", "저자", "출판사", "가격", "수량", "대여횟수" };
	}

	public Object[][] getDataAll() {
		List<Book> lists = BookService.getInstance().selectBookByAll();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	public void loadDataEach() {
		DefaultTableModel model = new DefaultTableModel(getDataEach(), getColumnNames());
		table.setModel(model);
	}

	public Object[][] getDataEach() {
		List<Book> lists = searchItem();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	public List<Book> searchItem() {
		String searchBy =(String) comboBox.getSelectedItem();
		String item = tfSearch.getText();
		List<Book> lists = null;
		Map<String, Object> map=new HashMap<String, Object>();
		
		if (searchBy.equals("도서코드")) {
			map.put("bookCode", "%"+item+"%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("저 자")) {
			map.put("author", "%"+item+"%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("출판사")) {

			map.put("publicName", "%"+item+"%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		return lists;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	/*public void selectedBook() {
		int selectedIndex=table.getSelectedRow();
		String bCode=(String) table.getValueAt(selectedIndex, 0);
		String bName=(String) table.getValueAt(selectedIndex, 1);
		String bAuthor=(String) table.getValueAt(selectedIndex, 2);
		String bPublisher=(String) table.getValueAt(selectedIndex, 3);
		int bPrice=(int) table.getValueAt(selectedIndex, 4);
		int bRentalCount=(int) table.getValueAt(selectedIndex, 5);
	}*/
}
