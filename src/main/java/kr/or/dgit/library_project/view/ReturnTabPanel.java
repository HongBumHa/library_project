package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import kr.or.dgit.library_project.dao.RentalBookDaoImpl;
import kr.or.dgit.library_project.dao.RentalViewDaoImpl;
import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.RentalBookService;
import kr.or.dgit.library_project.service.RentalViewService;

public class ReturnTabPanel extends JPanel {
	private JTextField tfBookCode;
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPrice;
	private JTextField tfDelayDay;
	private JTable RentalDataTable;
	private String userId;
	private Object[] sts = new String[] {
			"도서코드", "도서명", "저 자", "출판사", "가 격", "연체 일수"
		};

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Create the panel.
	 */
	public ReturnTabPanel(String userId) {
		setLayout(null);
		this.userId = userId;
		
		JPanel returnTabInfo = new JPanel();
		returnTabInfo.setLayout(null);
		returnTabInfo.setBounds(168, 34, 455, 257);
		add(returnTabInfo);
		
		JPanel returnTabTextField = new JPanel();
		returnTabTextField.setLayout(null);
		returnTabTextField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		returnTabTextField.setBounds(12, 39, 424, 167);
		returnTabInfo.add(returnTabTextField);
		
		JLabel lbBookCode = new JLabel("도서코드");
		lbBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookCode.setBounds(0, 2, 128, 27);
		returnTabTextField.add(lbBookCode);
		
		tfBookCode = new JTextField();
		tfBookCode.setEnabled(false);
		tfBookCode.setEditable(false);
		tfBookCode.setHorizontalAlignment(SwingConstants.LEFT);
		tfBookCode.setColumns(10);
		tfBookCode.setBounds(131, 2, 290, 27);
		returnTabTextField.add(tfBookCode);
		
		JLabel lbBookName = new JLabel("도서명");
		lbBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookName.setBounds(0, 29, 128, 27);
		returnTabTextField.add(lbBookName);
		
		tfBookName = new JTextField();
		tfBookName.setEnabled(false);
		tfBookName.setEditable(false);
		tfBookName.setHorizontalAlignment(SwingConstants.LEFT);
		tfBookName.setColumns(10);
		tfBookName.setBounds(131, 29, 290, 27);
		returnTabTextField.add(tfBookName);
		
		JLabel lbBookAuthor = new JLabel("저 자");
		lbBookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookAuthor.setBounds(0, 56, 128, 27);
		returnTabTextField.add(lbBookAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setEnabled(false);
		tfAuthor.setEditable(false);
		tfAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(131, 56, 290, 27);
		returnTabTextField.add(tfAuthor);
		
		JLabel lbPublisher = new JLabel("출판사");
		lbPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lbPublisher.setBounds(0, 83, 128, 27);
		returnTabTextField.add(lbPublisher);
		
		tfPublisher = new JTextField();
		tfPublisher.setEnabled(false);
		tfPublisher.setEditable(false);
		tfPublisher.setHorizontalAlignment(SwingConstants.LEFT);
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(131, 83, 290, 27);
		returnTabTextField.add(tfPublisher);
		
		JLabel lbPrice = new JLabel("가격");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setBounds(0, 110, 128, 27);
		returnTabTextField.add(lbPrice);
		
		tfPrice = new JTextField();
		tfPrice.setEnabled(false);
		tfPrice.setEditable(false);
		tfPrice.setHorizontalAlignment(SwingConstants.LEFT);
		tfPrice.setColumns(10);
		tfPrice.setBounds(131, 110, 290, 27);
		returnTabTextField.add(tfPrice);
		
		JLabel lbDelayDay = new JLabel("연체 일수");
		lbDelayDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbDelayDay.setBounds(0, 137, 128, 27);
		returnTabTextField.add(lbDelayDay);
		
		tfDelayDay = new JTextField();
		tfDelayDay.setEnabled(false);
		tfDelayDay.setEditable(false);
		tfDelayDay.setHorizontalAlignment(SwingConstants.LEFT);
		tfDelayDay.setColumns(10);
		tfDelayDay.setBounds(131, 137, 290, 27);
		returnTabTextField.add(tfDelayDay);
		
		JPanel returnTabButton = new JPanel();
		returnTabButton.setLayout(null);
		returnTabButton.setBounds(12, 206, 424, 41);
		returnTabInfo.add(returnTabButton);
		
		JButton btReturn = new JButton("반 납");
		btReturn.setFont(new Font("굴림", Font.BOLD, 13));
		btReturn.setBounds(127, 5, 82, 36);
		
		
		JButton btCancel = new JButton("취 소");
		
		btCancel.setFont(new Font("굴림", Font.BOLD, 13));
		btCancel.setBounds(214, 5, 82, 36);

		
		JLabel lbTitle = new JLabel("도서 정보");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("굴림", Font.BOLD, 15));
		lbTitle.setBounds(22, 5, 105, 28);
		returnTabInfo.add(lbTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		RentalDataTable = new JTable();
		/*RentalDataTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"도서코드", "도서명", "저 자", "출판사", "가 격", "연체 일수"
			}
		));*/
		
		RentalView rentalView = new RentalView();
		System.out.println(userId);
		rentalView.setUserId(userId);
		/*Vector<String> vc = new Vector<>();
		String[] st = new String[] {
				"도서코드", "도서명", "저 자", "출판사", "가 격", "연체 일수"
			};
		
		for(String ss : st) {
			vc.add(ss);
		}
		
		RentalDataTable.setModel(new DefaultTableModel(vc, rentalViewSr.findByWhereRentalView(rentalview)));*/
		
		
		
		RentalDataTable.setModel(createTableModel(rentalView));
		JTextField[] tfFields = {tfBookCode, tfBookName, tfAuthor, tfPublisher, tfPrice, tfDelayDay};
		RentalDataTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int i =0;
				for(i= 0; i < sts.length; i++) {
					tfFields[i].setText(RentalDataTable.getValueAt(RentalDataTable.getSelectedRow(), i).toString());
				}
				/*for(int n = i ; n < st.length ; n++) {
					Object numData = RentalDataTable.getValueAt(RentalDataTable.getSelectedRow(), n);
					tfFields[n].setText(numData.toString());
				}*/
			}		
		});
		
		btReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RentalBook rtBook = new RentalBook();
				rtBook.setBookCode(tfBookCode.getText());
				rtBook.setUserId(userId);
				
				RentalBookService rtBookService = new RentalBookService();
				rtBookService.deleteDataByWhereRentalBook(rtBook);
				
				RentalDataTable.setModel(createTableModel(rentalView));
				RentalDataTable.setVisible(true);
				scrollPane.setViewportView(RentalDataTable);

			}
		});
		returnTabButton.add(btReturn);
		
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i= 0; i < tfFields.length; i++) {
					tfFields[i].setText("");
				}
			}
		});
		returnTabButton.add(btCancel);
		
		scrollPane.setBounds(33, 339, 743, 232);
		add(scrollPane);
		scrollPane.setViewportView(RentalDataTable);
	}

	private TableModel createTableModel(RentalView rentalView) {
		RentalViewService rentalViewSr = new RentalViewService();
		List<RentalView> list = rentalViewSr.findByWhereRentalView(rentalView);
		Object[][] datas = new Object[list.size()][];
		
		for(int i = 0; i<list.size(); i++) {
			RentalView rentalObj = list.get(i);
			datas[i] = rentalObj.toArrayReturn();
		}
		
		TableModel ttmodel = new DefaultTableModel(datas, sts);
		return ttmodel;
	}
}
