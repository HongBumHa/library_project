package kr.or.dgit.library_project.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.dto.Publisher;
import kr.or.dgit.library_project.dto.Reading;
import kr.or.dgit.library_project.service.BookGroupService;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.PublisherService;
import kr.or.dgit.library_project.service.RentalViewService;

public class ManagerInserDeletePopUp extends JPanel {

	private JTextField tfAuthor;
	private JTextField tfPrice;
	private JTextField tfBookName;
	private JTextField tfBookCount;
	private JTextField tfPublisher;
	private JComboBox comboBigGroup;
	private JComboBox comboMiddleGroup;
	private List<BookGroup> bigGroupLists;
	private DefaultComboBoxModel middleGroupModel;
	private JTextField[] tfArrays;
	private DefaultComboBoxModel bigGroupModel;
	private HashMap<String, BookGroup[]> middleMap;
	private JButton btnClickEvent;
	private ManagerInserDeletePopupFrame popupFrame;

	//
	private JComboBox publisherCombo;

	private static ManagerInserDeletePopUp instance = new ManagerInserDeletePopUp();
	private JLabel lbChangeTitle;
	private JButton testBtn;

	public static ManagerInserDeletePopUp getInstance() {
		return instance;
	}

	private ManagerInserDeletePopUp() {
		BookGroup book = new BookGroup();
		allMachMiddleGroup();
		setLayout(null);

		JLabel lbBigGroup = new JLabel("대분류");
		lbBigGroup.setBounds(64, 54, 47, 15);
		add(lbBigGroup);

		JLabel lbMiddleGroup = new JLabel("중분류");
		lbMiddleGroup.setBounds(64, 85, 47, 15);
		add(lbMiddleGroup);

		JLabel lbAuthor = new JLabel("저자");
		lbAuthor.setBounds(64, 147, 47, 15);
		add(lbAuthor);

		JLabel lbPrice = new JLabel("가격");
		lbPrice.setBounds(64, 207, 47, 15);
		add(lbPrice);

		JLabel lbPublisher = new JLabel("출판사");
		lbPublisher.setBounds(64, 178, 47, 15);
		add(lbPublisher);

		JLabel lbBookName = new JLabel("책제목");
		lbBookName.setBounds(64, 116, 47, 15);
		add(lbBookName);

		JLabel lbBookCount = new JLabel("수량");
		lbBookCount.setBounds(64, 232, 47, 18);
		add(lbBookCount);

		tfAuthor = new JTextField();
		tfAuthor.setBounds(139, 144, 127, 21);
		add(tfAuthor);
		tfAuthor.setColumns(11);

		tfPrice = new JTextField();
		tfPrice.setBounds(139, 204, 127, 21);
		add(tfPrice);
		tfPrice.setColumns(11);

		List<Publisher> pubList = PublisherService.getInstance().selectPublisherByAll();
		String[] pubArray = new String[pubList.size()];

		for (int n = 0; n < pubList.size(); n++) {
			pubArray[n] = pubList.get(n).getPublicName();
		}

		publisherCombo = new JComboBox(pubArray);
		publisherCombo.setVisible(true);
		ComboAgent agent = new ComboAgent(publisherCombo);
		publisherCombo.setEditable(true);

		publisherCombo.setBounds(139, 175, 127, 21);
		add(publisherCombo);

		tfBookName = new JTextField();
		tfBookName.setBounds(139, 113, 127, 21);
		add(tfBookName);
		tfBookName.setColumns(11);

		tfBookCount = new JTextField();
		tfBookCount.setBounds(139, 231, 127, 21);
		add(tfBookCount);
		tfBookCount.setColumns(11);

		// tfArrays = new JTextField[]{tfBookName, tfAuthor, tfPublisher, tfPrice,
		// tfBookCount};
		tfArrays = new JTextField[] { tfBookName, tfAuthor, new JTextField(), tfPrice, tfBookCount };

		comboBigGroup = new JComboBox();
		comboBigGroup.setPreferredSize(new Dimension(60, 21));
		comboBigGroup.setBounds(139, 51, 97, 21);

		comboBigGroup.setModel(createComboModel(book));
		comboBigGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookGroup middlebook = bigGroupLists.get(comboBigGroup.getSelectedIndex());
				comboMiddleGroup.setModel(createComboModel(middlebook));
				setVisible(true);
			}
		});
		add(comboBigGroup);

		comboMiddleGroup = new JComboBox();
		comboMiddleGroup.setBounds(139, 82, 97, 21);
		BookGroup middlebook = new BookGroup();
		middlebook = bigGroupLists.get(comboBigGroup.getSelectedIndex());

		comboMiddleGroup.setModel(createComboModel(middlebook));
		add(comboMiddleGroup);

		btnClickEvent = new JButton("btnClickEvent");
		btnClickEvent.setBounds(49, 267, 127, 23);

		btnClickEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnClickEvent.getText() == "변경") {
					Book book = new Book();
					book.setBookCode(BookInsertDelete.getInstance().getBookcodeInfo());

					if (RentalViewService.getInstance().findByBookDataRentalView(book) != null) {
						JOptionPane.showMessageDialog(null, "아직 반납되지 않은 도서가 존재합니다.");
						return;
					}

					Publisher pb = new Publisher();

					//
					// pb.setPublicName(tfPublisher.getText());
					pb.setPublicName(publisherCombo.getSelectedItem().toString());

					book.setBookName(tfBookName.getText());
					book.setAuthor(tfAuthor.getText());

					//
					// book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(pb).getPublicCode());
					book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(pb).getPublicCode());

					System.out.println(tfPrice.getText().replaceAll(" ", ""));

					book.setPrice(Integer.parseInt(tfPrice.getText().replaceAll(" ", "")));
					book.setAmount(Integer.parseInt(tfBookCount.getText()));

					BookService.getInstance().updateBook(book);

					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().mIDFrameClose();
				}
				if (btnClickEvent.getText() == "새로운도서추가") {
					Book book = new Book();
					book.setAuthor(tfAuthor.getText());
					Publisher publisher = new Publisher();
					// publisher.setPublicName(tfPublisher.getText());
					publisher.setPublicName(((JTextField) publisherCombo.getEditor().getEditorComponent()).getText()
							.replaceAll(" ", ""));

					System.out.println("name " + tfBookName.getText());
					book.setBookName(tfBookName.getText());

					if (PublisherService.getInstance().selectPublisherByCodeName(publisher) != null) {
						book.setPublicName(
								PublisherService.getInstance().selectPublisherByCodeName(publisher).getPublicCode());
						if (BookService.getInstance().findselectByWhereBookData(book).size() != 0) {
							book.setBookName(tfBookName.getText());

							if (BookService.getInstance().findselectByWhereBookData(book).size() != 0) {
								JOptionPane.showMessageDialog(null, "이미 존재하는 도서 입니다.");
								tfFieldClearAndAdding();
								return;
							}
						}
					}

					String makeLastCode = createLastCode();

					if (PublisherService.getInstance().selectPublisherByCodeName(publisher) == null) {
						createNewPubliser(publisher);
						refreshPublicComboItem();
					}

					book.setBookCode(makeLastCode);
					book.setAmount(Integer.parseInt(tfBookCount.getText()));
					book.setPrice(Integer.parseInt(tfPrice.getText()));
					book.setPublicName(
							PublisherService.getInstance().selectPublisherByCodeName(publisher).getPublicCode());
					BookService.getInstance().insertBook(book);

					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().mIDFrameClose();
				}

				if (btnClickEvent.getText() == "신청도서추가") {
					Book book = new Book();

					for (int n = 0; n < tfArrays.length; n++) {
						if (n == 2) {
							if (((JTextField) publisherCombo.getEditor().getEditorComponent()).getText()
									.equals("") == true) {
								JOptionPane.showMessageDialog(null, "공백이 존재합니다.", "경고", JOptionPane.ERROR_MESSAGE);
								return;
							}
							continue;
						}
						if (tfArrays[n].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "공백이 존재합니다.", "경고", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}

					Publisher pb = new Publisher();
					// pb.setPublicName(tfPublisher.getText());
					pb.setPublicName(((JTextField) publisherCombo.getEditor().getEditorComponent()).getText()
							.replaceAll(" ", ""));

					if (PublisherService.getInstance().selectPublisherByCodeName(pb) == null) {
						createNewPubliser(pb);
					}

					book.setBookCode(createLastCode());
					book.setBookName(tfBookName.getText());
					book.setAuthor(tfAuthor.getText());
					book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(pb).getPublicCode());
					book.setPrice(Integer.parseInt(tfPrice.getText()));
					book.setAmount(Integer.parseInt(tfBookCount.getText()));

					BookService.getInstance().insertBook(book);
					Reading reading = new Reading();
					reading.setBookName(book.getBookName());

					refreshPublicComboItem();
					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().refreshReadingTable(reading);
					BookInsertDelete.getInstance().mIDFrameClose();
				}
			}
		});

		add(btnClickEvent);

		lbChangeTitle = new JLabel("ChangeTitle");
		lbChangeTitle.setFont(new Font("굴림", Font.BOLD, 14));
		lbChangeTitle.setBounds(12, 10, 224, 15);
		add(lbChangeTitle);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int val = JOptionPane.showConfirmDialog(null, "취소하시겠습니까?", "취소", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (val == 0) {
					BookInsertDelete.getInstance().mIDFrameClose();
				}
			}
		});
		btnCancel.setBounds(181, 267, 97, 23);
		add(btnCancel);

		// testBtn = new JButton("test");
		// testBtn.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		//
		//
		// Publisher pb = new Publisher();
		// pb.setPublicName(((JTextField)publisherCombo.getEditor().getEditorComponent()).getText().replace("
		// ", ""));
		// if(PublisherService.getInstance().selectPublisherByCodeName(pb) == null) {
		// createNewPubliser(pb);
		// }
		//
		// List<Publisher> pubList =
		// PublisherService.getInstance().selectPublisherByAll();
		// String[] pubArray = new String[pubList.size()];
		//
		// for(int n = 0; n < pubList.size(); n++ ) {
		// pubArray[n] = pubList.get(n).getPublicName();
		// System.out.println(pubList.get(n).getPublicName());
		// }
		// publisherCombo.setModel(new DefaultComboBoxModel(pubArray));
		// ComboAgent agent = new ComboAgent(publisherCombo);
		// publisherCombo.setVisible(true);
		// setVisible(true);
		// }
		// });
		// testBtn.setBounds(318, 230, 97, 23);
		// add(testBtn);
	}

	private void refreshPublicComboItem() {
		List<Publisher> pubList = PublisherService.getInstance().selectPublisherByAll();
		String[] pubArray = new String[pubList.size()];

		for (int n = 0; n < pubList.size(); n++) {
			pubArray[n] = pubList.get(n).getPublicName();
		}

		publisherCombo.setModel(new DefaultComboBoxModel(pubArray));
		ComboAgent agent = new ComboAgent(publisherCombo);
		publisherCombo.setVisible(true);
		publisherCombo.setEditable(true);
		setVisible(true);
	}

	public DefaultComboBoxModel createComboModel(BookGroup bookgroup) {
		bigGroupLists = BookGroupService.getInstance().findAllBookBigGroup();

		if (bookgroup.getBigGroup() == null) {
			String[] comboLists = new String[bigGroupLists.size()];

			for (int i = 0; i < bigGroupLists.size(); i++) {
				comboLists[i] = bigGroupLists.get(i).getBookBigGroupName();
			}

			bigGroupModel = new DefaultComboBoxModel<>(comboLists);
			return bigGroupModel;
		}
		BookGroup[] middleMapArray = middleMap.get(bookgroup.getBigGroup());
		String[] middleComboLists = new String[middleMapArray.length];

		for (int i = 0; i < middleMapArray.length; i++) {
			middleComboLists[i] = middleMapArray[i].getBookMiddleGroupName();
		}

		middleGroupModel = new DefaultComboBoxModel<>(middleComboLists);
		return middleGroupModel;
	}

	public void tfFieldNotUsing() {
		for (int i = 0; i < tfArrays.length; i++) {
			tfArrays[i].setEnabled(false);
		}
	}

	public void tfFieldClearAndAdding() {
		for (int i = 0; i < tfArrays.length; i++) {
			tfArrays[i].setText("");
			tfArrays[i].setEnabled(true);
		}
	}

	public Object[][] getDataAll() {
		List<Book> lists = BookService.getInstance().selectBookByAll();

		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			data[i] = lists.get(i).toArray();
		}
		return data;
	}

	public void allMachMiddleGroup() {
		BookGroup bookGroup = new BookGroup();

		middleMap = new HashMap<>();

		List<BookGroup> middlelist = BookGroupService.getInstance().findAllMiddleGroup(bookGroup);
		List<BookGroup> biglist = BookGroupService.getInstance().findAllBookBigGroup();

		BookGroup[][] bookTwoArray = new BookGroup[biglist.size()][10];

		int index = 0;
		int TwoArrayindex = 0;

		for (int n = 0; n < middlelist.size(); n++) {
			if (TwoArrayindex == 10) {
				TwoArrayindex = 0;
			}
			if (bookTwoArray[index][0] == null) {
				bookTwoArray[index][0] = middlelist.get(n);
				TwoArrayindex++;
				continue;
			}
			
			
			if (bookTwoArray[index][0].getBookMiddleGroupName().equals(biglist.get(index).getBookBigGroupName())) {
				bookTwoArray[index][TwoArrayindex] = middlelist.get(n);
				TwoArrayindex++;
				if (n % 10 == 9) {
					middleMap.put(biglist.get(index).getBigGroup(), bookTwoArray[index]);
					index++;
					continue;
				}
				continue;
			}
		}
	}

	public void createNewPubliser(Publisher publisher) {
		List<Publisher> pbList = PublisherService.getInstance().selectPublisherByAll();
		int pbCode = Integer.parseInt(pbList.get(pbList.size() - 1).getPublicCode());

		String pubCodeSt = "";

		String checkLine2 = (pbCode + 1) + "";
		int loop2 = checkLine2.length();
		for (int i = 4; i > loop2; i--) {
			pubCodeSt += "0";
		}
		pubCodeSt += checkLine2;

		publisher.setPublicCode(pubCodeSt);
		PublisherService.getInstance().insertPublisher(publisher);
	}

	public JComboBox getComboBigGroup() {
		return comboBigGroup;
	}

	public HashMap<String, BookGroup[]> getMiddleMap() {
		return middleMap;
	}

	public JComboBox getComboMiddleGroup() {
		return comboMiddleGroup;
	}

	public JTextField[] getTfArrays() {
		return tfArrays;
	}

	public JButton getBtnClickEvent() {
		return btnClickEvent;
	}

	public JLabel getLbChangeTitle() {
		return lbChangeTitle;
	}

	public String createLastCode() {
		String bigNo = bigGroupLists.get(comboBigGroup.getSelectedIndex()).getBigGroup();
		String middleNo = middleMap.get(bigNo)[comboMiddleGroup.getSelectedIndex()].getMiddleGroup();
		String GroupInfo = bigNo + middleNo;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookCode", GroupInfo + "%");
		List<Book> selectList = BookService.getInstance().selectBookBySomething(map);

		String bookLastCode = "";

		int bookIncreCode = Integer.parseInt(selectList.get(selectList.size() - 1).getBookCode().substring(4, 8));
		String checkLine = (bookIncreCode + 1) + "";
		int loop = checkLine.length();

		for (int i = 4; i > loop; i--) {
			bookLastCode += "0";
		}

		bookLastCode += checkLine;

		return GroupInfo + bookLastCode;
	}

	public JComboBox getPublisherCombo() {
		return publisherCombo;
	}

	public void setPopupFrame(ManagerInserDeletePopupFrame popupFrame) {
		this.popupFrame = popupFrame;
	}

	public int publicComboSelected(String publisherName) {
		for (int index = 0; index < publisherCombo.getItemCount(); index++) {
			String item = publisherCombo.getItemAt(index).toString();
			if (item.equals(publisherName) == true) {
				publisherCombo.setSelectedIndex(index);
				return 0;
			}
		}
		return 1;
	}

	class ComboAgent extends KeyAdapter {
		JComboBox combo;
		JTextField editor;

		public ComboAgent(JComboBox box) {
			combo = box;
			editor = (JTextField) combo.getEditor().getEditorComponent();
			combo.setVisible(true);
			editor.addKeyListener(this);
		}

		public void keyReleased(KeyEvent e) {
			char ch = e.getKeyChar();

			if (ch == KeyEvent.CHAR_UNDEFINED || Character.isISOControl(ch))
				return;

			int pos = editor.getCaretPosition();
			String str = editor.getText();

			if (str.length() == 0)
				return;

			for (int k = 0; k < combo.getItemCount(); k++) {
				String iteml = combo.getItemAt(k).toString().toLowerCase();
				String item = combo.getItemAt(k).toString();
				// 조건 비교.. 입력한 문자열이 리스트에 있는 아이템의 첫머리로 일치하는지..
				if (item.startsWith(str) || iteml.startsWith(str) || item.startsWith(str.toLowerCase())
						|| iteml.startsWith(str.toLowerCase())) {
					// 일치한다면 field에 매치된 아이템을 셋팅하고
					// 자동으로 완성된 부분을 선택표시로 하여 강조한다.
					editor.setText(item);
					editor.setCaretPosition(item.length());
					editor.moveCaretPosition(pos);
					break;
				}
			}
		}
	}

}
