package kr.or.dgit.library_project.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.HistoryViewService;
import kr.or.dgit.library_project.service.RentalBookService;
import kr.or.dgit.library_project.ui.MainUi;

public class UserChart extends JPanel {

	public UserChart() {
		callPieChart();
	}
	
	public JFreeChart callPieChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Users u = MainUi.getUsers();
		HistoryView h = HistoryViewService.getInstance().findUserReturnCount(u);
		RentalBook r = RentalBookService.getInstance().findselectByUserRentalbookCount(u);
		int total = h.getPrice() + Integer.parseInt(r.getUserId());
		dataset.addValue(total, "총 대여량", "총 대여량");
		dataset.addValue(h.getPrice(), "반납량", "반납량");
		dataset.addValue(Integer.parseInt(r.getUserId()), "현 대여량", "현 대여량");
		JFreeChart chart =ChartFactory.createStackedBarChart(u.getUserName()+"님 현황", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
		changeFont(chart);
		chart.getTitle().setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("맑은 고딕", Font.PLAIN, 15));
		return chart;

	}

	private void changeFont(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		  
		  Font font = plot.getDomainAxis().getLabelFont();
		  // X축 라벨
		  plot.getDomainAxis().setLabelFont(new Font("맑은 고딕", font.getStyle(), 10));
		  // X축 도메인
		  plot.getDomainAxis().setTickLabelFont(new Font("맑은 고딕", font.getStyle(), 14));
		  
		  font = plot.getRangeAxis().getLabelFont();
		  // Y축 라벨
		  plot.getRangeAxis().setLabelFont(new Font("맑은 고딕", font.getStyle(), 10));
		  // Y축 범위
		  plot.getRangeAxis().setTickLabelFont(new Font("맑은 고딕", font.getStyle(), 10));
	}

}
