package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RentBookInfoView extends JFrame {

	private JPanel contentPane;
	private JTextField tfBookCode;
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPrice;
	private JTextField tfAmount;

	public RentBookInfoView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 606, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 0));
		panel.setBounds(5, 5, 585, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBookCode = new JLabel(" 도서코드");
		lblBookCode.setBounds(12, 0, 63, 28);
		panel.add(lblBookCode);
		
		tfBookCode = new JTextField();
		tfBookCode.setBounds(12, 28, 116, 28);
		tfBookCode.setColumns(10);
		panel.add(tfBookCode);
		
		JLabel lblBookName = new JLabel(" 도서명");
		lblBookName.setBounds(148, 0, 63, 28);
		panel.add(lblBookName);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(148, 28, 423, 28);
		tfBookName.setColumns(10);
		panel.add(tfBookName);
		
		JLabel lblAuthor = new JLabel(" 저 자");
		lblAuthor.setBounds(12, 66, 63, 28);
		panel.add(lblAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(12, 93, 155, 28);
		tfAuthor.setColumns(10);
		panel.add(tfAuthor);
		
		JLabel lblPublisher = new JLabel(" 출판사");
		lblPublisher.setBounds(188, 66, 63, 28);
		panel.add(lblPublisher);
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(188, 93, 155, 28);
		tfPublisher.setColumns(10);
		panel.add(tfPublisher);
		
		JLabel lblPrice = new JLabel(" 가격");
		lblPrice.setBounds(367, 66, 63, 28);
		panel.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(365, 93, 89, 28);
		tfPrice.setColumns(10);
		panel.add(tfPrice);
		
		JLabel lblAmount = new JLabel(" 수량");
		lblAmount.setBounds(474, 66, 63, 28);
		panel.add(lblAmount);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(476, 93, 49, 28);
		tfAmount.setColumns(10);
		panel.add(tfAmount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 145, 171, 31);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button = new JButton("대여");
		panel_1.add(button);
		
		JButton button_1 = new JButton("취소");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(button_1);
		
		addBookInfo();
	}
	
	private void addBookInfo() {
		cleanTf();
		
		int selectedIndex=RentalBookPanel.table.getSelectedRow();
		String bCode=(String) RentalBookPanel.table.getValueAt(selectedIndex, 0);
		String bName=(String) RentalBookPanel.table.getValueAt(selectedIndex, 1);
		String bAuthor=(String) RentalBookPanel.table.getValueAt(selectedIndex, 2);
		String bPublisher=(String) RentalBookPanel.table.getValueAt(selectedIndex, 3);
		int bPrice=(int) RentalBookPanel.table.getValueAt(selectedIndex, 4);
		int bRentalCount=(int) RentalBookPanel.table.getValueAt(selectedIndex, 5);
		
		tfBookCode.setText(bCode);
		tfBookName.setText(bName);
		tfAuthor.setText(bAuthor);
		tfPublisher.setText(bPublisher);
		tfPrice.setText(String.valueOf(bPrice));
		tfAmount.setText(String.valueOf(bRentalCount));
		
		
	}
	private void cleanTf() {
		tfBookCode.setText("");
		tfBookName.setText("");
		tfAuthor.setText("");
		tfPublisher.setText("");
		tfPrice.setText("");
		tfAmount.setText("");
	}
}
