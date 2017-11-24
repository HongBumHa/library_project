package kr.or.dgit.library_project.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.service.BookService;

public class BestBookView extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public BestBookView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 611, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		BookRankView panel_2 = new BookRankView();
		JFreeChart jChart = panel_2.callPieChart();
		contentPane.setLayout(null);
		ChartPanel cPanel = new ChartPanel(jChart);
		cPanel.setBounds(11, 13, 578, 417);
		
		contentPane.add(cPanel);
		cPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 442, 578, 180);
		contentPane.add(scrollPane);
		DefaultTableModel tableModel = new DefaultTableModel(getData(),getColumnNames());
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
	private String[] getColumnNames() {
		return new String[] {"순위","도서이름","저자","출판사명","수량","총대여수량"};
	}


	private Object[][] getData() {
		List<Book> lists = BookService.getInstance().findselectByRank();
		int j = 1;
		Object[][] datas = new Object[10][];
		for(int i =0; i < 10; i++) {
			if(i ==0) {
				lists.get(i).setPrice(j);
			}
			if(i !=0&&i != 9) {
				if(lists.get(i).getAllRentalCount() < lists.get(i-1).getAllRentalCount()) {
					lists.get(i).setPrice(++j);
					
				}else if(lists.get(i).getAllRentalCount() ==lists.get(i-1).getAllRentalCount()) {
					lists.get(i).setPrice(j);
				}
			}else if (i == 9) {
				if(lists.get(i).getAllRentalCount() <lists.get(i-1).getAllRentalCount()) {
					lists.get(i).setPrice(++j);
					
			}else if(lists.get(i).getAllRentalCount() ==lists.get(i-1).getAllRentalCount()) {
					lists.get(i).setPrice(j);
				}
			}
			datas[i] = lists.get(i).toArray2();
		
		}
		return datas;
	}
}
