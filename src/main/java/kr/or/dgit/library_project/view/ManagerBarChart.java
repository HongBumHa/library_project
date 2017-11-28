package kr.or.dgit.library_project.view;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.service.BookService;

public class ManagerBarChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerBarChart() {

	}

	public JFreeChart callBarChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int[] countArr = rowCount();
		String[] bookGroupName = { "총류", "철학", "종교", "사회과학", "자연과학", "기술과학", "예술", "언어", "문학", "역사" };

		for (int i = 0; i < 10; i++) {
			dataset.addValue(countArr[i], bookGroupName[i], bookGroupName[i]);
		}

		JFreeChart chart = ChartFactory.createStackedBarChart("대분류별 도서 보유 현황","", "보유개수", dataset,
				PlotOrientation.VERTICAL, true, false, false);
		changeFont(chart);
		chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 15));
		chart.getTitle().setFont(new Font("돋움", Font.PLAIN, 20));
		
		return chart;

	}

	public int[] rowCount() {
		Book book = new Book();
		String[] bookArr = { "%A0%", "%b0%", "%c0%", "%d0%", "%e0%", "%f0%", "%g0%", "%h0%", "%i0%", "%j0%", };

		int[] count = new int[10];
		for (int i = 0; i < bookArr.length; i++) {
			book.setBookCode(bookArr[i]);
			Book num = BookService.getInstance().selectBookGroupRow(book);
			count[i] = num.getAllRentalCount();
		}
		return count;
	}

	private void changeFont(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		
		Font font = plot.getDomainAxis().getLabelFont();
		// X축 라벨
		plot.getDomainAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
		// X축 도메인
		plot.getDomainAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 15));

		font = plot.getRangeAxis().getLabelFont();
		// Y축 라벨
		plot.getRangeAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
		// Y축 범위
		// plot.getRangeAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));
	}

}
