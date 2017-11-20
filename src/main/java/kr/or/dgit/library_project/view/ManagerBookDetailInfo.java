package kr.or.dgit.library_project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.UsersService;

public class ManagerBookDetailInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserId;
	private JTextField tfUserName;
	private JTextField tfUserPhone;
	private JTextField tfUserEmail;
	private JTextField tfUserAddr;
	private JTextField tfBookCode;
	private JTextField tfAuthor;
	private JTextField tfBookName;
	private JTextField tfPublisher;
	private JTextField tfPrice;
	private JTextField tfRentCount;
	private static BookService bookService;

	public ManagerBookDetailInfo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 432, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pUserInfo = new JPanel();
		pUserInfo.setBounds(5, 5, 410, 134);
		contentPane.add(pUserInfo);
		pUserInfo.setLayout(null);
		
		JLabel lblUserInfo = new JLabel("회원정보");
		lblUserInfo.setBounds(0, 10, 77, 18);
		pUserInfo.add(lblUserInfo);
		lblUserInfo.setFont(new Font("굴림", Font.BOLD, 15));
		lblUserInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setBounds(10, 38, 57, 15);
		pUserInfo.add(lblUserId);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(70, 35, 116, 21);
		pUserInfo.add(tfUserId);
		tfUserId.setColumns(10);
		
		JLabel lblUserName = new JLabel("회원명");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(211, 35, 57, 15);
		pUserInfo.add(lblUserName);
		
		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		tfUserName.setBounds(271, 32, 116, 21);
		pUserInfo.add(tfUserName);
		
		JLabel lblUserPhone = new JLabel("전화번호");
		lblUserPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPhone.setBounds(10, 66, 57, 15);
		pUserInfo.add(lblUserPhone);
		
		tfUserPhone = new JTextField();
		tfUserPhone.setColumns(10);
		tfUserPhone.setBounds(70, 63, 116, 21);
		pUserInfo.add(tfUserPhone);
		
		JLabel lblUserEmail = new JLabel("이메일");
		lblUserEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEmail.setBounds(211, 63, 57, 15);
		pUserInfo.add(lblUserEmail);
		
		tfUserEmail = new JTextField();
		tfUserEmail.setColumns(10);
		tfUserEmail.setBounds(271, 60, 116, 21);
		pUserInfo.add(tfUserEmail);
		
		JLabel lblUserAddr = new JLabel("주소");
		lblUserAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAddr.setBounds(10, 100, 57, 15);
		pUserInfo.add(lblUserAddr);
		
		tfUserAddr = new JTextField();
		tfUserAddr.setColumns(10);
		tfUserAddr.setBounds(70, 94, 317, 21);
		pUserInfo.add(tfUserAddr);
		
		JPanel pBookInfo = new JPanel();
		pBookInfo.setBounds(5, 143, 410, 134);
		contentPane.add(pBookInfo);
		pBookInfo.setLayout(null);
		
		JLabel lblBookInfo = new JLabel("도서정보");
		lblBookInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookInfo.setFont(new Font("굴림", Font.BOLD, 15));
		lblBookInfo.setBounds(0, 10, 77, 18);
		pBookInfo.add(lblBookInfo);
		
		JLabel lblBookCode = new JLabel("도서코드");
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookCode.setBounds(10, 41, 57, 15);
		pBookInfo.add(lblBookCode);
		
		tfBookCode = new JTextField();
		tfBookCode.setColumns(10);
		tfBookCode.setBounds(70, 38, 114, 21);
		pBookInfo.add(tfBookCode);
		
		JLabel lblAuthor = new JLabel("저자");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setBounds(228, 41, 44, 15);
		pBookInfo.add(lblAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(276, 38, 116, 21);
		pBookInfo.add(tfAuthor);
		
		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setBounds(10, 72, 57, 15);
		pBookInfo.add(lblBookName);
		
		tfBookName = new JTextField();
		tfBookName.setColumns(10);
		tfBookName.setBounds(70, 69, 322, 21);
		pBookInfo.add(tfBookName);
		
		JLabel lblPublisher = new JLabel("출판사");
		lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisher.setBounds(10, 100, 57, 15);
		pBookInfo.add(lblPublisher);
		
		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(70, 97, 97, 21);
		pBookInfo.add(tfPublisher);
		
		JLabel lblPrice = new JLabel("가격");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(170, 100, 39, 15);
		pBookInfo.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(208, 97, 57, 21);
		pBookInfo.add(tfPrice);
		
		JLabel lblRentCount = new JLabel("대여횟수");
		lblRentCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentCount.setBounds(277, 100, 57, 15);
		pBookInfo.add(lblRentCount);
		
		tfRentCount = new JTextField();
		tfRentCount.setBounds(337, 97, 55, 21);
		pBookInfo.add(tfRentCount);
		tfRentCount.setColumns(10);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("굴림", Font.PLAIN, 14));
		btnClose.setBounds(159, 287, 90, 36);
		contentPane.add(btnClose);
		
		addBookInfo();
		addUserInfo();

	}

	private void addUserInfo() {
		Users item=searchUser();
		
		tfUserId.setText(item.getUserId());
		tfUserName.setText(item.getUserName());
		tfUserPhone.setText(item.getUserTel());
		tfUserAddr.setText(item.getUserAddr());
		tfUserEmail.setText(item.getUserEmail());
	}
	
	private Users searchUser() {
		int selectedIndex=ManagerRentalBook.table.getSelectedRow();
		String uId=(String) ManagerRentalBook.table.getValueAt(selectedIndex, 3);
		Users u=new Users();
		u.setUserId(uId);
		
		Users findUser=UsersService.getInstance().findUsersByNo(u);
		return findUser;
	}

	private void addBookInfo() {
		Book item=searchBook();
		
		tfBookCode.setText(item.getBookCode());
		tfBookName.setText(item.getBookName());
		tfAuthor.setText(item.getAuthor());
		tfPublisher.setText(item.getPublicName());
		tfPrice.setText(String.valueOf(item.getPrice()));
		tfRentCount.setText(String.valueOf(item.getAllRentalCount()));
		
	}

	private Book searchBook() {
		
		int selectedIndex=ManagerRentalBook.table.getSelectedRow();
		String bCode=(String) ManagerRentalBook.table.getValueAt(selectedIndex, 0);
		Book book =new Book();

		book.setBookCode(bCode);
		Book findBook= BookService.getInstance().selectBookByCode(book);
		
		
		return findBook;
	}
}
