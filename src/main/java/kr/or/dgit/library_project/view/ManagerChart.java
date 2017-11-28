package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import java.awt.GridLayout;

public class ManagerChart extends JFrame {

	private JPanel contentPane;

	public ManagerChart() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 723, 914);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelPie = new JPanel();
		contentPane.add(panelPie);
		ManagerPieChart pie=new ManagerPieChart();
		JFreeChart pieChart=pie.callPieChart();
		ChartPanel piePanel=new ChartPanel(pieChart);
		panelPie.add(piePanel);
				
		JPanel panelBar = new JPanel();
		contentPane.add(panelBar);
		ManagerBarChart bar=new ManagerBarChart();
		JFreeChart barChart=bar.callBarChart();
		ChartPanel barPanel=new ChartPanel(barChart);
		panelBar.add(barPanel);
		
	}

}
