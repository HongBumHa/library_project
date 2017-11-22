package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.service.BookGroupService;

public class BookInsertDelete extends JPanel {
	private JTable searchTable;
	private JTextField tfSearch;
	private JTextField tfAuthor;
	private JTextField tfPrice;
	private JTextField tfPublisher;
	private JTextField tfBookName;
	private JTextField tfBookCount;
	private DefaultComboBoxModel bigGroupModel = new DefaultComboBoxModel<>(
			new String[]{"총류","철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"}
			);
	
	private DefaultComboBoxModel middleGroupModel;
	private DefaultComboBoxModel searchComboModel = new DefaultComboBoxModel<>(
			new String[] {"전체보기", "도서코드", "도서명", "저 자", "출판사"}
			);
	
	private JComboBox comboBigGroup;
	private JComboBox comboMiddleGroup;
	private DefaultComboBoxModel middleComboModel;
	private List<BookGroup> bigLists;
	private List<BookGroup> middleLists;
	private String[] comboDatas;
	private BookGroup book = new BookGroup();
	private BookGroupService bgSer = new BookGroupService();
	private List<BookGroup> bigGroupLists;

	public BookInsertDelete() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel BookDelInsertPanel = new JPanel();
		add(BookDelInsertPanel, BorderLayout.CENTER);
		BookDelInsertPanel.setLayout(null);
		
		JScrollPane tableScroll = new JScrollPane();
		tableScroll.setBounds(12, 41, 368, 326);
		BookDelInsertPanel.add(tableScroll);
		
		searchTable = new JTable();
		tableScroll.setViewportView(searchTable);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(79, 10, 177, 21);
		BookDelInsertPanel.add(tfSearch);
		tfSearch.setColumns(10);
		
		JComboBox comboSearch = new JComboBox();
		comboSearch.setToolTipText("");
		comboSearch.setBounds(12, 10, 55, 21);
		comboSearch.setModel(searchComboModel);
		BookDelInsertPanel.add(comboSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(267, 9, 57, 23);
		BookDelInsertPanel.add(btnSearch);
		
		JRadioButton radioDelete = new JRadioButton("보유도서제거");
		radioDelete.setBounds(353, 9, 97, 23);
		BookDelInsertPanel.add(radioDelete);
		
		JRadioButton radioInsert = new JRadioButton("새로운도서생성");
		radioInsert.setBounds(449, 9, 109, 23);
		BookDelInsertPanel.add(radioInsert);
		
		JLabel lbBigGroup = new JLabel("대분류");
		lbBigGroup.setBounds(393, 42, 42, 15);
		BookDelInsertPanel.add(lbBigGroup);
		
		JLabel lbMiddleGroup = new JLabel("중분류");
		lbMiddleGroup.setBounds(392, 67, 36, 15);
		BookDelInsertPanel.add(lbMiddleGroup);
		
		JLabel lbAuthor = new JLabel("저자");
		lbAuthor.setBounds(392, 104, 24, 15);
		BookDelInsertPanel.add(lbAuthor);
		
		JLabel lbPrice = new JLabel("가격");
		lbPrice.setBounds(392, 135, 36, 15);
		BookDelInsertPanel.add(lbPrice);
		
		JLabel lbPublisher = new JLabel("출판사");
		lbPublisher.setBounds(392, 160, 43, 15);
		BookDelInsertPanel.add(lbPublisher);
		
		JLabel lbBookName = new JLabel("책제목");
		lbBookName.setBounds(393, 200, 42, 15);
		BookDelInsertPanel.add(lbBookName);
		
		JLabel lbBookCount = new JLabel("수량");
		lbBookCount.setBounds(393, 225, 57, 15);
		BookDelInsertPanel.add(lbBookCount);
		
		comboBigGroup = new JComboBox();
		comboBigGroup.setBounds(435, 39, 65, 21);
//		comboBigGroup.setModel(bigGroupModel);
//		comboBigGroup.setModel(createComboModel());
		BookDelInsertPanel.add(comboBigGroup);
		
		comboMiddleGroup = new JComboBox();
		comboMiddleGroup.setBounds(435, 67, 65, 21);
//		ComboSetting(bigLists.get(comboBigGroup.getSelectedIndex()));
		BookDelInsertPanel.add(comboMiddleGroup);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(442, 101, 116, 21);
		BookDelInsertPanel.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(442, 132, 116, 21);
		BookDelInsertPanel.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(442, 157, 116, 21);
		BookDelInsertPanel.add(tfPublisher);
		tfPublisher.setColumns(10);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(442, 197, 116, 21);
		BookDelInsertPanel.add(tfBookName);
		tfBookName.setColumns(10);
		
		tfBookCount = new JTextField();
		tfBookCount.setBounds(442, 222, 116, 21);
		BookDelInsertPanel.add(tfBookCount);
		tfBookCount.setColumns(10);
		
		JButton btnClickEvent = new JButton("제거");
		btnClickEvent.setBounds(392, 264, 97, 23);
		BookDelInsertPanel.add(btnClickEvent);

	}
	
	
	/*public void ComboSetting(BookGroup bookGroup) {
		BookGroupService bgsv = new BookGroupService();
		BookGroup setBookGroup = new BookGroup();
		
		if(bookGroup.getBigGroup().equals("null")) {
			bigLists = bgsv.findAllBookBigGroup();
			
			String[] comboData = new String[bigLists.size()];
			for(int i =0; i < bigLists.size(); i++) {
				BookGroup[] listsObj = new BookGroup[bigLists.size()];
				listsObj[i] = bigLists.get(i);
				comboData[i] = listsObj[i].getBookBigGroupName();
			}
			bigGroupModel = new DefaultComboBoxModel<>(comboDatas);
			comboBigGroup.setModel(bigGroupModel);
			comboMiddleGroup.setVisible(true);
			setVisible(true);
		}
		else {
			middleLists = bgsv.findAllMiddleGroup(bookGroup);
			
			comboDatas = new String[middleLists.size()];
			for(int i =0; i < middleLists.size(); i++) {
				BookGroup[] listsObj = new BookGroup[middleLists.size()];
				listsObj[i] = middleLists.get(i);
				comboDatas[i] = listsObj[i].getBookMiddleGroupName();
			}
			middleComboModel = new DefaultComboBoxModel<>(comboDatas);
			comboMiddleGroup.setModel(middleComboModel);
			comboMiddleGroup.setVisible(true);
			setVisible(true);
		}
//		bookGroup.setBigGroup((String)comboBigGroup.getSelectedItem());
		
		
	}*/
	
	public DefaultComboBoxModel createComboModel(BookGroup bookgroup) {
		bigGroupLists = bgSer.findAllBookBigGroup();
		
		if(bookgroup.getBookBigGroupName().isEmpty()) {
			String[] comboLists = new String[bigGroupLists.size()];
			
			for(int i = 0; i < bigGroupLists.size(); i++) {
				comboLists[i] = bigGroupLists.get(i).getBookBigGroupName();
			}
			
			bigGroupModel = new DefaultComboBoxModel<>(comboLists);
			return bigGroupModel;
		}
		
		List<BookGroup> middleLists = bgSer.findAllMiddleGroup(bookgroup);
		String[] middleComboLists = new String[middleLists.size()];
		return bigGroupModel;
	}
}
