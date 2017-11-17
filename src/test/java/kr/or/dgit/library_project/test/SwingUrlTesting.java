package kr.or.dgit.library_project.test;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SwingUrlTesting extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingUrlTesting frame = new SwingUrlTesting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SwingUrlTesting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		 JLabel link = new JLabel(" Click here to find the PUID          \n");
			link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			link.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
			      if (e.getClickCount() > 0) {
			    	  if (Desktop.isDesktopSupported()) {
			                Desktop desktop = Desktop.getDesktop();
			                try {
			                		URI uri = new URI("http://www.naver.com");
			                        desktop.browse(uri);
			                } catch (IOException ex) {
			                        // do nothing
			                } catch (URISyntaxException ex) {
								//do nothing
							}
			        } else {
			               //do nothing
			        }
			      }
			   }
			});
	
	contentPane.add(link);
	setContentPane(contentPane);
			
		
	}

	
	
	
}
