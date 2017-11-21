package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.service.BookGroupService;
import kr.or.dgit.library_project.service.BookService;

public class BookInsertDelete extends JPanel {
	private JTable searchTable;
	private JTextField tfSearch;
	private JTextField tfAuthor;
	private JTextField tfPrice;
	private JTextField tfPublisher;
	private JTextField tfBookName;
	private JTextField tfBookCount;
	private DefaultComboBoxModel bigGroupModel;
	/*new DefaultComboBoxModel<>(
			new String[]{"총류","철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"}
			);*/
	private DefaultComboBoxModel middleGroupModel;
	private DefaultComboBoxModel searchComboModel = new DefaultComboBoxModel<>(
			new String[] {"전체보기", "도서코드", "도서명", "저 자", "출판사"}
			);
	
	private JComboBox comboBigGroup;
	private JComboBox comboMiddleGroup;
	private DefaultComboBoxModel middleComboModel;
//	private BookGroupService bgSer = new BookGroupService();
	private List<BookGroup> bigGroupLists;
	private String[] searchTableTitle = new String[] { "도서코드", "도서명", "저자", "출판사", "가격", "수량", "대여횟수" };
	private JComboBox comboSearch;
	private JTextField[] tfArrays;
	
	public BookInsertDelete() {
		setLayout(new BorderLayout(0, 0));
		
		BookGroup book = new BookGroup();
		
		JPanel BookDelInsertPanel = new JPanel();
		add(BookDelInsertPanel, BorderLayout.CENTER);
		BookDelInsertPanel.setLayout(null);
		
		JScrollPane tableScroll = new JScrollPane();
		tableScroll.setBounds(12, 41, 470, 326);
		BookDelInsertPanel.add(tableScroll);
		
		JRadioButton radioDelete = new JRadioButton("보유도서제거");
		radioDelete.setBounds(434, 9, 110, 23);
		BookDelInsertPanel.add(radioDelete);
		
		JRadioButton radioInsert = new JRadioButton("새로운도서생성");
		radioInsert.setBounds(545, 9, 132, 23);
		BookDelInsertPanel.add(radioInsert);
		
		JLabel lbBigGroup = new JLabel("대분류");
		lbBigGroup.setBounds(484, 42, 57, 15);
		BookDelInsertPanel.add(lbBigGroup);
		
		JLabel lbMiddleGroup = new JLabel("중분류");
		lbMiddleGroup.setBounds(483, 67, 43, 15);
		BookDelInsertPanel.add(lbMiddleGroup);
		
		JLabel lbAuthor = new JLabel("저자");
		lbAuthor.setBounds(502, 104, 42, 15);
		BookDelInsertPanel.add(lbAuthor);
		
		JLabel lbPrice = new JLabel("가격");
		lbPrice.setBounds(502, 135, 36, 15);
		BookDelInsertPanel.add(lbPrice);
		
		JLabel lbPublisher = new JLabel("출판사");
		lbPublisher.setBounds(500, 160, 58, 15);
		BookDelInsertPanel.add(lbPublisher);
		
		JLabel lbBookName = new JLabel("책제목");
		lbBookName.setBounds(499, 200, 42, 15);
		BookDelInsertPanel.add(lbBookName);
		
		JLabel lbBookCount = new JLabel("수량");
		lbBookCount.setBounds(501, 225, 57, 15);
		BookDelInsertPanel.add(lbBookCount);
		
		comboBigGroup = new JComboBox();
		comboBigGroup.setBounds(555, 39, 65, 21);
//		comboBigGroup.setModel(bigGroupModel);
		comboBigGroup.setModel(createComboModel(book));
		comboBigGroup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BookGroup middlebook = bigGroupLists.get(comboBigGroup.getSelectedIndex());
				comboMiddleGroup.setModel(createComboModel(middlebook));
				BookDelInsertPanel.setVisible(true);
			}
		});
		BookDelInsertPanel.add(comboBigGroup);
		
		comboMiddleGroup = new JComboBox();
		comboMiddleGroup.setBounds(555, 64, 65, 21);
		BookGroup middlebook = new BookGroup();
		middlebook = bigGroupLists.get(comboBigGroup.getSelectedIndex());
		System.out.println(middlebook.getBigGroup());
		comboMiddleGroup.setModel(createComboModel(middlebook));
		BookDelInsertPanel.add(comboMiddleGroup);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(557, 101, 116, 21);
		BookDelInsertPanel.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(557, 132, 116, 21);
		BookDelInsertPanel.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(555, 157, 116, 21);
		BookDelInsertPanel.add(tfPublisher);
		tfPublisher.setColumns(10);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(561, 197, 116, 21);
		BookDelInsertPanel.add(tfBookName);
		tfBookName.setColumns(10);
		
		tfBookCount = new JTextField();
		tfBookCount.setBounds(561, 222, 116, 21);
		BookDelInsertPanel.add(tfBookCount);
		tfBookCount.setColumns(10);
		
		tfArrays = new JTextField[]{tfAuthor, tfPrice, tfPublisher, tfBookName, tfBookCount};
		
		searchTable = new JTable();
		DefaultTableModel searchTableModel = new DefaultTableModel(getDataAll(), searchTableTitle);
		searchTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int i =0;
				for(i= 0; i < tfArrays.length; i++) {
					tfArrays[i].setText(searchTable.getValueAt(searchTable.getSelectedRow(), i).toString());
				}
			}
		});
		searchTable.setModel(searchTableModel);
		tableScroll.setViewportView(searchTable);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(121, 10, 219, 21);
		BookDelInsertPanel.add(tfSearch);
		tfSearch.setColumns(10);
		
		comboSearch = new JComboBox();
		comboSearch.setToolTipText("");
		comboSearch.setBounds(12, 10, 97, 21);
		comboSearch.setModel(searchComboModel);
		BookDelInsertPanel.add(comboSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(344, 8, 65, 23);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadDataEach();
			}
		});
		BookDelInsertPanel.add(btnSearch);
		
		JButton btnClickEvent = new JButton("제거");
		btnClickEvent.setBounds(571, 253, 97, 23);
		BookDelInsertPanel.add(btnClickEvent);

	}
	
	public DefaultComboBoxModel createComboModel(BookGroup bookgroup) {
		bigGroupLists = BookGroupService.getInstance().findAllBookBigGroup();
		
		if(bookgroup.getBigGroup() == null) {
			String[] comboLists = new String[bigGroupLists.size()];
			
			for(int i = 0; i < bigGroupLists.size(); i++) {
				comboLists[i] = bigGroupLists.get(i).getBookBigGroupName();
			}
			
			bigGroupModel = new DefaultComboBoxModel<>(comboLists);
			return bigGroupModel;
		}
		
		List<BookGroup> middleLists = BookGroupService.getInstance().findAllMiddleGroup(bookgroup);
		String[] middleComboLists = new String[middleLists.size()];
	
		for(int i = 0; i < middleLists.size(); i++) {
			middleComboLists[i] = middleLists.get(i).getBookMiddleGroupName();
		}
		middleGroupModel = new DefaultComboBoxModel<>(middleComboLists);
		return middleGroupModel;
	}
	
	public Object[][] getDataAll() {
		List<Book> lists = BookService.getInstance().selectBookByAll();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}
	
	public List<Book> searchItem() {
		String searchBy =(String) comboSearch.getSelectedItem();
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
	
	public Object[][] getDataEach() {
		List<Book> lists = searchItem();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}
	
	public void loadDataEach() {
		DefaultTableModel model = new DefaultTableModel(getDataEach(), searchTableTitle);
		searchTable.setModel(model);
	}
}
