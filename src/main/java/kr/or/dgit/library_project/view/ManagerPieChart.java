package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
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
		String[] bookGroupName= {"총류","철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"};
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=countArr[i];
		}
		for(int i=0;i<10;i++) {
			data.setValue(bookGroupName[i]+ratioCal(countArr[i], sum), countArr[i]);
		}

		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart("분류별 도서 대여현황", data, true, // legend?
				true, // tooltips?
				false // URLs?
		);
//		CategoryPlot p = chart.getCategoryPlot();
		PiePlot p=(PiePlot) chart.getPlot();
		p.setLabelFont(new Font("돋움", Font.BOLD,13));
		
		chart.getLegend().setItemFont(new Font("돋움", Font.BOLD,13));
		chart.getTitle().setFont(new Font("돋움", Font.BOLD,20));

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
	
	public String ratioCal(int totalNum, int num) {
		DecimalFormat df=new DecimalFormat("(##0.0%)");
		String ratio=df.format((double)totalNum/(double)num);
		return ratio;
	}
}
