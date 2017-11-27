package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.RentalBookService;
import kr.or.dgit.library_project.ui.MainUi;
import javax.swing.ImageIcon;

public class UserpresentView extends JPanel {
	private static final UserpresentView instance = new UserpresentView();
	private static JLabel lblToteint;
	private static JLabel lblRentalint;
	private static JLabel lblReturnint;
	private JFreeChart jChart;
	private ChartPanel cPanel;
	private UserChart pChart;
	public UserChart getpChart() {
		return pChart;
	}
	public void setpChart(UserChart pChart) {
		this.pChart = pChart;
	}
	public JFreeChart getjChart() {
		return jChart;
	}
	public void setjChart(JFreeChart jChart) {
		this.jChart = jChart;
	}
	public ChartPanel getcPanel() {
		return cPanel;
	}
	public static UserpresentView getInstance() {
		return instance;
	}
	public void setcPanel(ChartPanel cPanel) {
		this.cPanel = cPanel;
	}
	private UserpresentView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 10, 416, 474);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("현황 보기");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lblNewLabel.setBounds(12, 10, 101, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 63, 393, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotel = new JLabel("총 대여량 :");
		lblTotel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblTotel.setBounds(12, 23, 84, 15);
		panel_1.add(lblTotel);
		
		lblToteint = new JLabel("");
		lblToteint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblToteint.setBounds(86, 23, 45, 15);
		panel_1.add(lblToteint);
		
		JLabel lblRental = new JLabel("현 대여량 :");
		lblRental.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblRental.setBounds(127, 23, 75, 15);
		panel_1.add(lblRental);
		
		lblRentalint = new JLabel("");
		lblRentalint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblRentalint.setBounds(206, 23, 57, 15);
		panel_1.add(lblRentalint);
		
		JLabel lblReturn = new JLabel("총 반납량 :");
		lblReturn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblReturn.setBounds(247, 23, 72, 15);
		panel_1.add(lblReturn);
		
		lblReturnint = new JLabel("");
		lblReturnint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblReturnint.setBounds(329, 23, 41, 15);
		panel_1.add(lblReturnint);
		
		pChart = new UserChart();
		jChart = pChart.callPieChart();
		cPanel = new ChartPanel(jChart);
		cPanel.setBounds(11, 137, 394, 311);
		panel.add(cPanel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DGIT3-7\\Desktop\\bookimg.PNG"));
		lblNewLabel_1.setBounds(427, 10, 371, 477);
		add(lblNewLabel_1);
		setting();
	}
	public static void setting() {
		Users u = MainUi.getUsers();
		HistoryView h = HistoryViewService.getInstance().findUserReturnCount(u);
		RentalBook r = RentalBookService.getInstance().findselectByUserRentalbookCount(u);
		int total = h.getPrice() + Integer.parseInt(r.getUserId());
		lblRentalint.setText(r.getUserId()+
				"권");
		lblToteint.setText(total + "권");
		lblReturnint.setText(h.getPrice()+"권");
	}
}
