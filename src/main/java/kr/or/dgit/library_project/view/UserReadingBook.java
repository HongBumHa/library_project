package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.Reading;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.ReadingService;

public class UserReadingBook extends JPanel {

	
	public UserReadingBook() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(11, 21, 775, 329);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(12, 50, 751, 56);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotel = new JLabel("총 대여량 :");
		lblTotel.setFont(new Font("굴림", Font.BOLD, 12));
		lblTotel.setBounds(11, 21, 92, 15);
		panel.add(lblTotel);
		
		JLabel lblRentel = new JLabel("대여 수량 :");
		lblRentel.setFont(new Font("굴림", Font.BOLD, 12));
		lblRentel.setBounds(209, 21, 84, 15);
		panel.add(lblRentel);
		
		JLabel lblReturn = new JLabel("반납량 :");
		lblReturn.setFont(new Font("굴림", Font.BOLD, 12));
		lblReturn.setBounds(435, 21, 57, 15);
		panel.add(lblReturn);
		
		JLabel lblTotelint = new JLabel("");
		lblTotelint.setBounds(84, 21, 57, 15);
		panel.add(lblTotelint);
		
		JLabel lblRentelint = new JLabel("");
		lblRentelint.setBounds(291, 21, 57, 15);
		panel.add(lblRentelint);
		
		JLabel lblReturnint = new JLabel("");
		lblReturnint.setBounds(490, 21, 57, 15);
		panel.add(lblReturnint);
		
		JLabel lblTitle = new JLabel("현황 보기");
		lblTitle.setBounds(11, 10, 85, 28);
		panel_1.add(lblTitle);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));

	}


}
