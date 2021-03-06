package kr.or.dgit.library_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagerInserDeletePopupFrame extends JFrame {

	private JPanel contentPane;
	public static ManagerInserDeletePopupFrame instance = new ManagerInserDeletePopupFrame();

	public static ManagerInserDeletePopupFrame getInstance() {
		return instance;
	}

	private ManagerInserDeletePopupFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		ManagerInserDeletePopUp mm = ManagerInserDeletePopUp.getInstance();
		contentPane.add(mm, BorderLayout.CENTER);
		contentPane.setVisible(true);
		setContentPane(contentPane);
	}
}
