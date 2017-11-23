package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.RentalViewService;
import kr.or.dgit.library_project.ui.MainUi;

public class RentalBookPanel extends JPanel {

	private JPanel contentPane;
	private JTextField tfSearch;
	public static JTable table;
	private JComboBox comboBox;

	public RentalBookPanel() {
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setLayout(null);
		pSearch.setBounds(219, 10, 391, 54);
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
		tfSearch.setBounds(117, 10, 159, 25);
		pSearch.add(tfSearch);

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataEach();
			}
		});
		btnSearch.setBounds(288, 11, 93, 23);
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

		JLabel lblUserName = new JLabel(MainUi.getUsers().getUserId()+"님의 대여 현황");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblUserName);

		JLabel lblRent = new JLabel("대여: "+rentBookCountById()+" 권");
		lblRent.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblRent);

		JLabel lblReturn = new JLabel("연체: ");
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		pUserRentInfo.add(lblReturn);
		
		JButton btnReading = new JButton("도서신청");
		btnReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadingVIew frame = new ReadingVIew();
				frame.setVisible(true);
			}
		});
		btnReading.setBounds(708, 10, 97, 23);
		add(btnReading);
		
		JButton btnBestBook = new JButton("인기도서");
		btnBestBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BestBookView frame = new BestBookView();
				frame.setVisible(true);
			}
		});
		btnBestBook.setBounds(708, 43, 97, 23);
		add(btnBestBook);
	}

	private void addPopupMenu() {
		JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("대여하기");
		popupMenu.add(menuItem);
		table.setComponentPopupMenu(popupMenu);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkRent()==true) {
					RentBookInfoView rbiv=new RentBookInfoView();
					rbiv.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "대여 불가능 도서입니다.");
				}
			}
		});
	}
	
	

	public void loadDataAll() {
		DefaultTableModel model = new DefaultTableModel(getDataAll(), getColumnNames());
		table.setModel(model);
		setAlignWidth();
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
		setAlignWidth();
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
		}
		if (searchBy.equals("도서명")) {
			map.put("bookName", "%"+item+"%");
		}
		if (searchBy.equals("저 자")) {
			map.put("author", "%"+item+"%");
		}
		if (searchBy.equals("출판사")) {
			map.put("publicName", "%"+item+"%");
		}
		lists = BookService.getInstance().selectBookBySomething(map);
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
	
	public boolean checkRent() {
		int selectedIndex=table.getSelectedRow();
		boolean result;
		
		int bAmount=(int) table.getValueAt(selectedIndex, 5);
		if(bAmount<=0) {
			result=false;
		}else
			result=true;
		
		return result;
	}
	
	public int rentBookCountById() {
		String userId=MainUi.getUsers().getUserId();
		RentalView rv=new RentalView();
		rv.setUserId(userId);
		List<RentalView> lists=RentalViewService.getInstance().findByWhereRentalView(rv);
		int count=lists.size();
		
		return count;
	}
	
	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER,0,1,2,3,4,5,6);
		setCellWidth(70, 300, 100, 100, 70, 30, 55);
	}
	
	public void setCellWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		System.out.println(Arrays.toString(width));
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
