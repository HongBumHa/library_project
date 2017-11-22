package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.general.DefaultPieDataset;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.service.BookService;

public class ManagerPieChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerPieChart() {
		callPieChart();

	}

	public JFreeChart callPieChart() {
		DefaultPieDataset data = new DefaultPieDataset();
		int[] countArr = bigGroup();
		data.setValue("총류", countArr[0]);
		data.setValue("철학", countArr[1]);
		data.setValue("종교", countArr[2]);
		data.setValue("사화과학", countArr[3]);
		data.setValue("자연과학", countArr[4]);
		data.setValue("기술과학", countArr[5]);
		data.setValue("예술", countArr[6]);
		data.setValue("언어", countArr[7]);
		data.setValue("문학", countArr[8]);
		data.setValue("역사", countArr[9]);
		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", data, true, // legend?
				true, // tooltips?
				false // URLs?
		);
//		CategoryPlot p = (CategoryPlot) chart.getPlot();
//		p.setBackgroundPaint(Color.white);
//		// 차트의 배경 라인 색상입니다.
//		p.setRangeGridlinePaint(Color.gray);
//		// X 축의 라벨 설정입니다. (보조 타이틀)
//		p.getDomainAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 13));
//		// X 축의 도메인 설정입니다.
//		p.getDomainAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));
//		// Y 축의 라벨 설정입니다. (보조 타이틀)
//		p.getRangeAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));
//		// Y 축의 도메인 설정입니다.
//		p.getRangeAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));

		return chart;

	}

	public int[] bigGroup() {
		Book book = new Book();
		String[] bookArr = { "%A0%", "%b0%", "%c0%", "%d0%", "%e0%", "%f0%", "%g0%", "%h0%", "%i0%", "%j0%", };
		int[] rentCount = new int[10];
		for (int i = 0; i < bookArr.length; i++) {
			book.setBookCode(bookArr[i]);
			Book num = BookService.getInstance().selectBookForChart(book);
			rentCount[i] = num.getAllRentalCount();
		}

		return rentCount;
	}
}
