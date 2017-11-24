package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class UserinfoHistoryViewFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblBookcodeText;
	private JLabel lblBookNameText;
	private JLabel lblpulbicText;
	private JLabel lblReturnText;
	private JLabel lblRentelText;
	private JLabel lblpriceText;
	private JLabel lblahcText;

	public UserinfoHistoryViewFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 697, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("책 정보");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 22, 54, 30);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 50, 665, 133);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblBookcode = new JLabel("도서코드 :");
		lblBookcode.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblBookcode.setBounds(12, 21, 60, 15);
		panel.add(lblBookcode);

		JLabel lblBookName = new JLabel("도서명 :");
		lblBookName.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblBookName.setBounds(196, 22, 57, 15);
		panel.add(lblBookName);

		JLabel lblReturn = new JLabel("반납일 :");
		lblReturn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblReturn.setBounds(196, 90, 57, 15);
		panel.add(lblReturn);

		JLabel lblahc = new JLabel("저자 :");
		lblahc.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblahc.setBounds(431, 58, 44, 15);
		panel.add(lblahc);

		JLabel lblprice = new JLabel("가격 :");
		lblprice.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblprice.setBounds(196, 58, 44, 15);
		panel.add(lblprice);

		JLabel lblRental = new JLabel("대여일 :");
		lblRental.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblRental.setBounds(12, 90, 57, 15);
		panel.add(lblRental);

		JLabel lblpublic = new JLabel("출판사 :");
		lblpublic.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblpublic.setBounds(14, 57, 51, 15);
		panel.add(lblpublic);

		lblBookcodeText = new JLabel("");
		lblBookcodeText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBookcodeText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblBookcodeText.setBounds(74, 21, 111, 16);
		panel.add(lblBookcodeText);

		lblBookNameText = new JLabel("");
		lblBookNameText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBookNameText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblBookNameText.setBounds(247, 22, 383, 15);
		panel.add(lblBookNameText);

		lblpulbicText = new JLabel("");
		lblpulbicText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblpulbicText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblpulbicText.setBounds(74, 58, 111, 15);
		panel.add(lblpulbicText);

		lblReturnText = new JLabel("");
		lblReturnText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblReturnText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblReturnText.setBounds(247, 90, 111, 15);
		panel.add(lblReturnText);

		lblRentelText = new JLabel("");
		lblRentelText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRentelText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblRentelText.setBounds(74, 90, 110, 15);
		panel.add(lblRentelText);

		lblpriceText = new JLabel("");
		lblpriceText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblpriceText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblpriceText.setBounds(247, 58, 111, 15);
		panel.add(lblpriceText);

		lblahcText = new JLabel("");
		lblahcText.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblahcText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblahcText.setBounds(473, 58, 157, 15);
		panel.add(lblahcText);
		setlblText();
	}

	public void setlblText() {
		int index = UserInfoView.getInstance().getHistoryTable().getSelectedRow();
		
		lblBookcodeText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 0));
		lblBookNameText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 1));
		lblpulbicText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 3));
		lblReturnText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 5));
		lblRentelText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 6));
		lblpriceText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 4));
		lblahcText.setText((String)UserInfoView.getInstance().getHistoryTable().getValueAt(index, 2));
	}
}
