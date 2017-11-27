package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagerInserDeletePopupFrame extends JFrame {

	private JPanel contentPane;

	public ManagerInserDeletePopupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ManagerInserDeletePopUp mm = ManagerInserDeletePopUp.getInstance();
		contentPane.add(mm);
		contentPane.setVisible(true);
		setContentPane(contentPane);
	}

}
