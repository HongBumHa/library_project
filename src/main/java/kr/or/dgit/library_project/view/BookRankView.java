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
import kr.or.dgit.library_project.service.BookService;

public class BookRankView extends JPanel {


	public BookRankView() {
		callPieChart();
	}
	public JFreeChart callPieChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Book> lists = BookService.getInstance().findselectByRank();
		for(int i =0; i < 10; i ++) {
			dataset.addValue(lists.get(i).getAllRentalCount(), lists.get(i).getBookName(), (i+1)+"위");
		}


		JFreeChart chart =ChartFactory.createStackedBarChart("베스트셀러", "책이름", "", dataset, PlotOrientation.VERTICAL, true, true, false);
		changeFont(chart);
		chart.getTitle().setFont(new Font("돋움", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 15));
		return chart;

	}

	private void changeFont(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		  
		  Font font = plot.getDomainAxis().getLabelFont();
		  // X축 라벨
		  plot.getDomainAxis().setLabelFont(new Font("돋움", font.getStyle(), 5));
		  // X축 도메인
		  plot.getDomainAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));
		  
		  font = plot.getRangeAxis().getLabelFont();
		  // Y축 라벨
		  plot.getRangeAxis().setLabelFont(new Font("돋움", font.getStyle(), 10));
		  // Y축 범위
		  plot.getRangeAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));
	}
}
