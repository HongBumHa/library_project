package kr.or.dgit.library_project.view;

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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.dto.Reading;
import kr.or.dgit.library_project.service.BookGroupService;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.ReadingService;
import kr.or.dgit.library_project.service.RentalViewService;

public class BookInsertDelete extends JPanel {
	private JTable searchTable;
	private JTextField tfSearch;
	private DefaultComboBoxModel searchComboModel = new DefaultComboBoxModel<>(
			new String[] { "전체보기", "도서코드", "도서명", "저 자", "출판사" });

	private String[] searchTableTitle = new String[] { "도서코드", "도서명", "저자", "출판사", "가격", "수량", "대여횟수" };
	private String[] readingTableTitle = new String[] { "도서명", "저자", "출판사" };
	private JComboBox comboSearch;
	private String bookcodeInfo;
	private JTable readingTable;
	private JTextField publisherJT;
	private ManagerInserDeletePopupFrame mIDfram = ManagerInserDeletePopupFrame.getInstance();
	private static BookInsertDelete instance = new BookInsertDelete();
	private JScrollPane tableScroll;

	public static BookInsertDelete getInstance() {
		return instance;
	}

	private BookInsertDelete() {
		setLayout(null);

		bookcodeInfo = new String();
		setLayout(null);

		tableScroll = new JScrollPane();
		tableScroll.setBounds(2, 83, 764, 326);
		add(tableScroll);

		searchTable = new JTable();
		JPopupMenu searchPopupMenu = new JPopupMenu();
		JMenuItem upDatePopup = new JMenuItem("변경");
		JMenuItem deletePopup = new JMenuItem("삭제");

		searchTable.setComponentPopupMenu(searchPopupMenu);
		refreshSearchTable();
		tableScroll.setViewportView(searchTable);

		tfSearch = new JTextField();
		tfSearch.setBounds(237, 23, 228, 21);
		add(tfSearch);
		tfSearch.setColumns(10);

		comboSearch = new JComboBox();
		comboSearch.setToolTipText("");
		comboSearch.setBounds(136, 23, 97, 21);
		comboSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboSearch.getSelectedItem() == "전체보기") {
					refreshSearchTable();
					setVisible(true);
				}
			}
		});
		comboSearch.setModel(searchComboModel);
		add(comboSearch);

		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(468, 22, 65, 23);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadDataEach();
				tfSearch.setText("");
			}
		});
		add(btnSearch);

		JScrollPane readingScroll = new JScrollPane();
		readingScroll.setBounds(2, 456, 480, 114);

		readingTable = new JTable();
		readingTable.setModel(createReadingTableModel());
		setAlignWidthReadingT();

		JPopupMenu readingTablePopup = new JPopupMenu();
		JMenuItem readingInsertItem = new JMenuItem("신청 도서 추가");
		JMenuItem readingDeleteItem = new JMenuItem("신청 도서 거절");

		readingInsertItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField[] field = ManagerInserDeletePopUp.getInstance().getTfArrays();
				String[] readingTableData = new String[readingTable.getColumnCount()];

				ManagerInserDeletePopUp.getInstance().getBtnClickEvent().setText("신청 도서 추가");
				ManagerInserDeletePopUp.getInstance().getLbChangeTitle().setText("신청도서를 추가 합니다.");

				for (int i = 0; i < readingTable.getColumnCount(); i++) {
					readingTableData[i] = (String) readingTable.getValueAt(readingTable.getSelectedRow(), i);
				}

				field[0].setText(readingTableData[0]);
				field[1].setText(readingTableData[1]);
				publisherJT = ((JTextField) (ManagerInserDeletePopUp.getInstance().getPublisherCombo().getEditor()
						.getEditorComponent()));
				field[3].setText("");
				field[4].setText("");
				if (ManagerInserDeletePopUp.getInstance().publicComboSelected(readingTableData[2]) == 1) {
					publisherJT.setText(readingTableData[2]);
				}

				mIDfram.setVisible(true);
			}
		});

		readingDeleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] readingTableData = new String[readingTable.getColumnCount()];

				for (int i = 0; i < readingTable.getColumnCount(); i++) {
					readingTableData[i] = (String) readingTable.getValueAt(readingTable.getSelectedRow(), i);
				}

				int checkVal = JOptionPane.showConfirmDialog(null,
						"신청 도서를 받지 않겠습니까? \n <신청 도서 내용> \n" + "책 제목 : " + readingTableData[0] + "\n" + "저자 : "
								+ readingTableData[1] + "\n" + "출판사 : " + readingTableData[2],
						"신청도서 삭제 경고", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (checkVal == 0) {
					Reading reading = new Reading();
					reading.setBookName(readingTableData[0]);
					refreshReadingTable(reading);
				}
			}
		});

		readingTablePopup.add(readingInsertItem);
		readingTablePopup.add(readingDeleteItem);
		readingTable.setComponentPopupMenu(readingTablePopup);
		readingScroll.setViewportView(readingTable);
		add(readingScroll);

		JLabel lbTitle1 = new JLabel("보유 도서 목록");
		lbTitle1.setFont(new Font("굴림", Font.BOLD, 13));
		lbTitle1.setBounds(12, 62, 219, 15);
		add(lbTitle1);

		JLabel lbTitle2 = new JLabel("도서 신청 현황");
		lbTitle2.setFont(new Font("굴림", Font.BOLD, 13));
		lbTitle2.setBounds(12, 430, 176, 15);
		add(lbTitle2);

		// 도서 신청 프레임 연결하기

		JButton btnAddNewBook = new JButton("도서 추가");
		btnAddNewBook.setBounds(648, 42, 97, 23);
		btnAddNewBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerInserDeletePopUp.getInstance().getBtnClickEvent().setText("새로운도서추가");
				ManagerInserDeletePopUp.getInstance().tfFieldClearAndAdding();
				ManagerInserDeletePopUp.getInstance().getLbChangeTitle().setText("새로운 도서를 추가 합니다.");
				mIDfram.setVisible(true);
				setVisible(true);

			}
		});

		add(btnAddNewBook);
		upDatePopup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ManagerInserDeletePopUp.getInstance().tfFieldClearAndAdding();

				int bigIndex = 0;
				int middleIndex = 0;
				bookcodeInfo = searchTable.getValueAt(searchTable.getSelectedRow(), 0).toString();

				String bigGroupCode = bookcodeInfo.substring(0, 2);
				String middleGroupCode = bookcodeInfo.substring(2, 4);
				String booklastCode = bookcodeInfo.substring(4, 8);

				List<BookGroup> list = BookGroupService.getInstance().findAllBookBigGroup();

				for (int n = 0; n < list.size(); n++) {
					if (list.get(n).getBigGroup().equals(bigGroupCode)) {
						bigIndex = n;
					}
				}

				ManagerInserDeletePopUp.getInstance().getComboBigGroup().setSelectedIndex(bigIndex);

				for (int a = 0; a < ManagerInserDeletePopUp.getInstance().getMiddleMap()
						.get(bigGroupCode).length; a++) {
					if (ManagerInserDeletePopUp.getInstance().getMiddleMap().get(bigGroupCode)[a].getMiddleGroup()
							.equals(middleGroupCode)) {
						middleIndex = a;
					}
				}

				ManagerInserDeletePopUp.getInstance().getComboMiddleGroup().setSelectedIndex(middleIndex);

				for (int i = 0; i < ManagerInserDeletePopUp.getInstance().getTfArrays().length; i++) {
					if (i == 2) {
						ManagerInserDeletePopUp.getInstance().publicComboSelected(
								searchTable.getValueAt(searchTable.getSelectedRow(), i + 1).toString());
						continue;
					}
					if (i == 3) {
						ManagerInserDeletePopUp.getInstance().getTfArrays()[i].setText(searchTable
								.getValueAt(searchTable.getSelectedRow(), i + 1).toString().replace(",", ""));
						continue;
					}
					ManagerInserDeletePopUp.getInstance().getTfArrays()[i]
							.setText(searchTable.getValueAt(searchTable.getSelectedRow(), i + 1).toString());
				}

				ManagerInserDeletePopUp.getInstance().getBtnClickEvent().setText("변경");
				ManagerInserDeletePopUp.getInstance().getLbChangeTitle().setText("도서의 수량을 변경합니다.");
				mIDfram.setVisible(true);
				setVisible(true);
			}
		});

		deletePopup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				bookcodeInfo = searchTable.getValueAt(searchTable.getSelectedRow(), 0).toString();
				Book book = new Book();
				book.setBookCode(bookcodeInfo);

				if (RentalViewService.getInstance().findByBookDataRentalView(book) != null) {
					JOptionPane.showMessageDialog(null, "아직 반납되지 않은 도서가 존재합니다.");
					return;
				}

				book = BookService.getInstance().selectBookByCode(book);

				int checkVal = JOptionPane.showConfirmDialog(null,
						"정말 삭제 하시겠습니까? \n <상세 정보> \n" + "책 코드 : " + book.getBookCode() + "\n" + "책 제목 : "
								+ book.getBookName() + "\n" + "저자 : " + book.getAuthor() + "\n" + "출판사 : "
								+ book.getPublicName(),
						"도서 삭제 경고", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (checkVal == 0) {
					BookService.getInstance().deleteBook(book);
					refreshSearchTable();
				}
			}
		});
		searchPopupMenu.add(upDatePopup);
		searchPopupMenu.add(deletePopup);

		setVisible(true);

	}

	public DefaultTableModel createTableModel() {
		DefaultTableModel searchTableModel = new DefaultTableModel(getDataAll(), searchTableTitle){
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		return searchTableModel;
	}

	public void refreshSearchTable() {
		searchTable.setModel(createTableModel());
		setAlignWidth();
		searchTable.setVisible(true);
		tableScroll.setViewportView(searchTable);
		tableScroll.setVisible(true);
	}

	public void refreshReadingTable(Reading reading) {
		ReadingService.getInstance().deleteByName(reading);
		readingTable.setModel(createReadingTableModel());

		readingTable.setVisible(true);
	}

	public Object[][] getDataAll() {
		List<Book> lists = BookService.getInstance().selectBookByAll();

		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	public Object[][] getReadingDataAll() {
		List<Reading> lists = ReadingService.getInstance().findselectByAll();

		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = lists.get(i).modelData();
		}
		return datas;
	}

	public DefaultTableModel createReadingTableModel() {
		DefaultTableModel searchTableModel = new DefaultTableModel(getReadingDataAll(), readingTableTitle){
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		return searchTableModel;
	}

	public List<Book> searchItem() {
		String searchBy = (String) comboSearch.getSelectedItem();
		String item = tfSearch.getText();
		List<Book> lists = null;
		Map<String, Object> map = new HashMap<String, Object>();

		if (searchBy.equals("도서코드")) {
			map.put("bookCode", "%" + item + "%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("도서명")) {
			map.put("bookName", "%" + item + "%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("저 자")) {
			map.put("author", "%" + item + "%");
			lists = BookService.getInstance().selectBookBySomething(map);
			return lists;
		}
		if (searchBy.equals("출판사")) {

			map.put("publicName", "%" + item + "%");
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
		setAlignWidth();
	}

	public JTable getSearchTable() {
		return searchTable;
	}

	public void mIDFrameClose() {
		mIDfram.setVisible(false);
	}

	public String getBookcodeInfo() {
		return bookcodeInfo;
	}

	public void setAlignWidth() {

		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		setCellWidth(70, 300, 90, 90, 60, 30, 50);
	}

	public void setCellWidth(int... width) {
		TableColumnModel cModel = searchTable.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void setAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = searchTable.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public void setAlignWidthReadingT() {
		setAlignReadingT(SwingConstants.CENTER, 0, 1, 2);
		setCellWidthReadingT(280, 100, 100);
	}

	public void setCellWidthReadingT(int... width) {
		TableColumnModel cModel = readingTable.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void setAlignReadingT(int align, int... idx) {
		// 0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = readingTable.getColumnModel();
		// idx = [0,2]
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
}
