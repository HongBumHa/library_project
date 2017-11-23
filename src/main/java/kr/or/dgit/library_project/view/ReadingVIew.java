package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReadingVIew extends JFrame {

	private JPanel contentPane;

	public ReadingVIew() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 802, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserReadingBook panel = new UserReadingBook();
		panel.setBounds(0, 10, 789, 155);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
