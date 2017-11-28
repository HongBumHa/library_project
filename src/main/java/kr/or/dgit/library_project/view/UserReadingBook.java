package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kr.or.dgit.library_project.dto.Reading;
import kr.or.dgit.library_project.service.ReadingService;

public class UserReadingBook extends JPanel {
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublicName;

	
	public UserReadingBook() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(11, 21, 775, 127);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(12, 50, 751, 56);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblBookName = new JLabel("도서명 :");
		lblBookName.setFont(new Font("굴림", Font.BOLD, 12));
		lblBookName.setBounds(11, 21, 57, 15);
		panel.add(lblBookName);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(65, 17, 181, 21);
		panel.add(tfBookName);
		tfBookName.setColumns(10);
		
		JLabel lblAuthor = new JLabel("저자명 :");
		lblAuthor.setFont(new Font("굴림", Font.BOLD, 12));
		lblAuthor.setBounds(257, 21, 57, 15);
		panel.add(lblAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(314, 17, 116, 21);
		panel.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		JLabel lblPublicName = new JLabel("출판사명 :");
		lblPublicName.setFont(new Font("굴림", Font.BOLD, 12));
		lblPublicName.setBounds(435, 21, 69, 15);
		panel.add(lblPublicName);
		
		tfPublicName = new JTextField();
		tfPublicName.setBounds(501, 17, 116, 21);
		panel.add(tfPublicName);
		tfPublicName.setColumns(10);
		
		JButton btnAdd = new JButton("도서신청");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = insertReading();
				if(res != -1) {
					JOptionPane.showMessageDialog(null, "도서 신청되었습니다.");
					tfAuthor.setText("");
					tfBookName.setText("");
					tfPublicName.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
				}
			}
		});
		btnAdd.setFont(new Font("굴림", Font.BOLD, 12));
		btnAdd.setBounds(642, 17, 97, 23);
		panel.add(btnAdd);
		
		JLabel lblTitle = new JLabel("도서 신청");
		lblTitle.setBounds(11, 10, 85, 28);
		panel_1.add(lblTitle);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));


	}



	protected int insertReading() {
		
		String bookName = tfBookName.getText();
		String author = tfAuthor.getText();
		String publicName = tfPublicName.getText();
		if(bookName.equals("")||author.equals("")||publicName.equals("")){
			return -1;
		}
		Reading rBook = new Reading(bookName, author, publicName);
		int res = ReadingService.getInstance().findinsert(rBook);
		return res;
	}
}
