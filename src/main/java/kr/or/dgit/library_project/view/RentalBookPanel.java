package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.service.BookService;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class RentalBookPanel extends JPanel {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTextField tfBookCode;
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPrice;
	private JTextField tfRentCount;
	private JTable table;
	private JComboBox comboBox;

	public RentalBookPanel() {
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setLayout(null);
		pSearch.setBounds(219, 10, 767, 54);
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
		comboBox.setBounds(33, 10, 93, 25);
		pSearch.add(comboBox);

		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		tfSearch.setColumns(10);
		tfSearch.setBounds(158, 10, 421, 25);
		pSearch.add(tfSearch);

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataEach();

			}
		});
		btnSearch.setBounds(627, 11, 93, 23);
		pSearch.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 74, 770, 418);
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

		JLabel lblUserName = new JLabel("xxx회원님의 대여 현황");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblUserName);

		JLabel lblRent = new JLabel("대여: 5권");
		lblRent.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblRent);

		JLabel lblReturn = new JLabel("미반납: 1권");
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblReturn);

		JPanel pBookInfo = new JPanel();
		pBookInfo.setBounds(12, 75, 195, 363);
		add(pBookInfo);
		pBookInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblBookCode = new JLabel(" 도서코드");
		pBookInfo.add(lblBookCode);

		tfBookCode = new JTextField();
		tfBookCode.setColumns(10);
		pBookInfo.add(tfBookCode);

		JLabel lblBookName = new JLabel(" 도서명");
		pBookInfo.add(lblBookName);

		tfBookName = new JTextField();
		tfBookName.setColumns(10);
		pBookInfo.add(tfBookName);

		JLabel lblAuthor = new JLabel(" 저 자");
		pBookInfo.add(lblAuthor);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		pBookInfo.add(tfAuthor);

		JLabel lblPublisher = new JLabel(" 출판사");
		pBookInfo.add(lblPublisher);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		pBookInfo.add(tfPublisher);

		JLabel lblPrice = new JLabel(" 가격");
		pBookInfo.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		pBookInfo.add(tfPrice);

		JLabel lblRentCount = new JLabel(" 수량");
		pBookInfo.add(lblRentCount);

		tfRentCount = new JTextField();
		tfRentCount.setColumns(10);
		pBookInfo.add(tfRentCount);

		JPanel pBtn = new JPanel();
		pBtn.setBounds(22, 448, 171, 31);
		add(pBtn);
		pBtn.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnOk = new JButton("확인");
		pBtn.add(btnOk);

		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
	}

	private void addPopupMenu() {
		JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("추가하기");
		popupMenu.add(menuItem);
		table.setComponentPopupMenu(popupMenu);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addBookInfo();
				
			}
		});
	}
	
	private void addBookInfo() {
		cleanTf();
		int selectedIndex=table.getSelectedRow();
		String bCode=(String) table.getValueAt(selectedIndex, 0);
		String bName=(String) table.getValueAt(selectedIndex, 1);
		String bAuthor=(String) table.getValueAt(selectedIndex, 2);
		String bPublisher=(String) table.getValueAt(selectedIndex, 3);
		int bPrice=(int) table.getValueAt(selectedIndex, 4);
		int bRentalCount=(int) table.getValueAt(selectedIndex, 5);
		
		tfBookCode.setText(bCode);
		tfBookName.setText(bName);
		tfAuthor.setText(bAuthor);
		tfPublisher.setText(bPublisher);
		tfPrice.setText(String.valueOf(bPrice));
		tfRentCount.setText(String.valueOf(bRentalCount));
		
		
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
		Book book = new Book();
		
		if (searchBy == "도서코드") {
			book.setBookCode(item);
			lists = BookService.getInstance().selectBookBySomething(book);
			return lists;
		}
		if (searchBy == "도서명") {
			book.setBookName(item);
			lists = BookService.getInstance().selectBookBySomething(book);
			return lists;
		}
		if (searchBy == "저 자") {
			book.setAuthor(item);
			lists = BookService.getInstance().selectBookBySomething(book);
			return lists;
		}
		if (searchBy == "출판사") {
			book.setPublicName(item);
			lists = BookService.getInstance().selectBookBySomething(book);
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
	
	private void cleanTf() {
		tfBookCode.setText("");
		tfBookName.setText("");
		tfAuthor.setText("");
		tfPublisher.setText("");
		tfPrice.setText("");
		tfRentCount.setText("");
	}
}
