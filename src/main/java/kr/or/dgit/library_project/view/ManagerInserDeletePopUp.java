package kr.or.dgit.library_project.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.dto.Publisher;
import kr.or.dgit.library_project.service.BookGroupService;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.PublisherService;
import kr.or.dgit.library_project.service.RentalViewService;

import java.awt.Font;

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
	
	private static ManagerInserDeletePopUp instance = new ManagerInserDeletePopUp();
	private JLabel lbChangeTitle;
		
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
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(139, 175, 127, 21);
		add(tfPublisher);
		tfPublisher.setColumns(11);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(139, 113, 127, 21);
		add(tfBookName);
		tfBookName.setColumns(11);
		
		tfBookCount = new JTextField();
		tfBookCount.setBounds(139, 231, 127, 21);
		add(tfBookCount);
		tfBookCount.setColumns(11);
		
		tfArrays = new JTextField[]{tfBookName, tfAuthor, tfPublisher, tfPrice, tfBookCount};
			
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
		btnClickEvent.setBounds(92, 265, 112, 23);
		
		
		btnClickEvent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 필요하다면 경고 메세지 말고 새로운 프레임이 뜨게 할 수 있음
				/*if(btnClickEvent.getText() == "제거") {
					Book book = new Book();
					book.setBookCode(BookInsertDelete.getInstance().getBookcodeInfo());
					
					if(RentalViewService.getInstance().findByBookDataRentalView(book) != null) {
						JOptionPane.showMessageDialog(null, "아직 반납되지 않은 도서가 존재합니다.");
						return;
					}
					// history내의 정보 변화는 나중에
					
					System.out.println("bookCodeDelete Check : " + book.getBookCode());
					
					BookService.getInstance().deleteBook(book);
					for(int i = 0 ; i < tfArrays.length; i++) {
						tfArrays[i].setText("");
					}
					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().mIDFrameClose();
				}*/
				if(btnClickEvent.getText() == "변경") {
					Book book = new Book();
					book.setBookCode(BookInsertDelete.getInstance().getBookcodeInfo());
					
					if(RentalViewService.getInstance().findByBookDataRentalView(book) != null) {
						JOptionPane.showMessageDialog(null, "아직 반납되지 않은 도서가 존재합니다.");
						return;
					}
					
					Publisher pb = new Publisher();
					pb.setPublicName(tfPublisher.getText());

					book.setBookName(tfBookName.getText());
					book.setAuthor(tfAuthor.getText());
					book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(pb).getPublicCode());
					book.setPrice(Integer.parseInt(tfPrice.getText()));
					book.setAmount(Integer.parseInt(tfBookCount.getText()));

					BookService.getInstance().updateBook(book);
					
					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().mIDFrameClose();
				}
				if(btnClickEvent.getText() == "새로운도서추가") {
					Book book = new Book();
					book.setAuthor(tfAuthor.getText());
					Publisher publisher = new Publisher();
					publisher.setPublicName(tfPublisher.getText());
					
					System.out.println("name " + tfBookName.getText());
					book.setBookName(tfBookName.getText());
					
					if(PublisherService.getInstance().selectPublisherByCodeName(publisher) != null) {
						book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(publisher).getPublicCode());
						if(BookService.getInstance().findselectByWhereBookData(book).size() != 0) {		
							book.setBookName(tfBookName.getText());

							if(BookService.getInstance().findselectByWhereBookData(book).size() != 0){
								JOptionPane.showMessageDialog(null, "이미 존재하는 도서 입니다.");
								tfFieldClearAndAdding();
								return;
							}
						}
					}

					String bigNo = bigGroupLists.get(comboBigGroup.getSelectedIndex()).getBigGroup();
					String middleNo = middleMap.get(bigNo)[comboMiddleGroup.getSelectedIndex()].getMiddleGroup();
					String GroupInfo = bigNo + middleNo;
					
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("bookCode", GroupInfo+"%");
					List<Book> selectList = BookService.getInstance().selectBookBySomething(map);

					String bookLastCode = "";				
					
					int bookIncreCode = Integer.parseInt(selectList.get(selectList.size()-1).getBookCode().substring(4, 8));
					String checkLine = (bookIncreCode+1)+"";
					int loop = checkLine.length();
					
					for( int i = 4; i > loop  ; i--) {
						bookLastCode += "0";
					}
					
					bookLastCode += checkLine;
						
					if(PublisherService.getInstance().selectPublisherByCodeName(publisher) == null) {
						List<Publisher> pbList = PublisherService.getInstance().selectPublisherByAll();
						int pbCode = Integer.parseInt(pbList.get(pbList.size()-1).getPublicCode());

						String pubCodeSt = "";

						String checkLine2 = (pbCode+1)+"";
						int loop2 = checkLine2.length();
						for( int i = 4; i > loop2  ; i--) {
							pubCodeSt += "0";
						}
						pubCodeSt += checkLine2;

						publisher.setPublicCode(pubCodeSt);
						PublisherService.getInstance().insertPublisher(publisher);
					}
					
					book.setBookCode(GroupInfo+bookLastCode);
					book.setAmount(Integer.parseInt(tfBookCount.getText()));
					book.setPrice(Integer.parseInt(tfPrice.getText()));
					
					book.setPublicName(PublisherService.getInstance().selectPublisherByCodeName(publisher).getPublicCode());
					
					BookService.getInstance().insertBook(book);
					
					BookInsertDelete.getInstance().refreshSearchTable();
					BookInsertDelete.getInstance().mIDFrameClose();
				}
			}
		});
		
		add(btnClickEvent);
		
		lbChangeTitle = new JLabel("ChangeTitle");
		lbChangeTitle.setFont(new Font("굴림", Font.BOLD, 14));
		lbChangeTitle.setBounds(12, 10, 112, 15);
		add(lbChangeTitle);
		
		
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
		
		BookGroup[] middleMapArray = middleMap.get(bookgroup.getBigGroup());
		String[] middleComboLists = new String[middleMapArray.length];
	
		for(int i = 0; i < middleMapArray.length; i++) {
			middleComboLists[i] = middleMapArray[i].getBookMiddleGroupName();
		}
		middleGroupModel = new DefaultComboBoxModel<>(middleComboLists);
		return middleGroupModel;
	}
	
	public void tfFieldNotUsing() {
		for(int i = 0 ; i < tfArrays.length; i++) {
			tfArrays[i].setEnabled(false);
		}
	}
	
	public void tfFieldClearAndAdding() {
		for(int i = 0 ; i < tfArrays.length; i++) {
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
		
		
		for(int n = 0; n < middlelist.size(); n++) {
			if(TwoArrayindex == 10) {
				TwoArrayindex = 0; 
			}
			if(bookTwoArray[index][0] == null) {
				bookTwoArray[index][0] = middlelist.get(n);
				TwoArrayindex++; 
				continue;
			}
			
			if(bookTwoArray[index][0].getBookMiddleGroupName().equals(biglist.get(index).getBookBigGroupName())){
				bookTwoArray[index][TwoArrayindex] = middlelist.get(n); 
				TwoArrayindex++; 
				if(n % 10 == 9) {
					middleMap.put(biglist.get(index).getBigGroup(), bookTwoArray[index]);
					index++;
					continue;
				}
				continue;
			}
		}
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
	
	
	
}
