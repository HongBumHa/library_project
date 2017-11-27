package kr.or.dgit.library_project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.service.RentalBookService;
import kr.or.dgit.library_project.service.RentalViewService;
import kr.or.dgit.library_project.ui.MainUi;

public class ReturnTabPanel extends JPanel {
	private JTextField tfBookCode;
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPrice;
	private JTextField tfDelayDay;
	private JTable RentalDataTable;
	private Users userId;

	private Object[] sts = new String[] {
			"도서코드", "도서명", "저 자", "출판사", "가 격", "연체 일수"
		};
	private JTextField[] tfFields;
	
	private static final ReturnTabPanel instance = new ReturnTabPanel();
	private RentalView rentalView;




	public static ReturnTabPanel getInstance() {
		return instance;
	}
	

	private ReturnTabPanel() {
		setLayout(null);

		userId = MainUi.getUsers();

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

		
		rentalView = new RentalView();

		rentalView.setUserId(userId.getUserId());

		tfFields = new JTextField[] { tfBookCode, tfBookName, tfAuthor, tfPublisher, tfPrice, tfDelayDay };

		RentalDataTable.setModel(createTableModel(rentalView));
		setAlignWidth();
		RentalDataTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int i = 0;
				for (i = 0; i < sts.length; i++) {
					tfFields[i].setText(RentalDataTable.getValueAt(RentalDataTable.getSelectedRow(), i).toString());
				}
			}
		});

		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				RentalBook rtBook = new RentalBook();
				rtBook.setBookCode(tfBookCode.getText());
				rtBook.setUserId(ReturnTabPanel.this.userId.getUserId());

				RentalBookService rtBookService = new RentalBookService();
				rtBookService.deleteDataByWhereRentalBook(rtBook);


				RentalDataTable.setModel(createTableModel(rentalView));
				setAlignWidth();
				RentalDataTable.setVisible(true);
			
				reloadTableView();

				refreshTextField();

				UserInfoView.getInstance().settingTableView();
				int res = RentalBookPanel.getInstance().rentBookCountById();
				RentalBookPanel.getInstance().getLblRent().setText("대여: " + res + " 권");
				RentalBookPanel.getInstance().loadDataAll();
				UserpresentView.getInstance().getcPanel().removeAll();
				UserpresentView.getInstance().getcPanel().setChart(UserpresentView.getInstance().getpChart().callPieChart());
				UserpresentView.setting();
				scrollPane.setViewportView(RentalDataTable);
			}
		});
		returnTabButton.add(btReturn);

		btCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTextField();
			}
		});

		returnTabButton.add(btCancel);

		scrollPane.setBounds(33, 339, 743, 232);
		add(scrollPane);
		scrollPane.setViewportView(RentalDataTable);
	}

	private TableModel createTableModel(RentalView rentalView) {
		List<RentalView> list = RentalViewService.getInstance().findByWhereRentalView(rentalView);
		Object[][] datas = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			RentalView rentalObj = list.get(i);
			datas[i] = rentalObj.toArrayReturn();
		}

		TableModel ttmodel = new DefaultTableModel(datas, sts){
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		return ttmodel;
	}

	public void refreshTextField() {
		for (int i = 0; i < tfFields.length; i++) {
			tfFields[i].setText("");
		}
	}
	

	public void setAlignWidth() {
		setAlign(SwingConstants.CENTER,0,1,2,3,4,5);
		setCellWidth(70, 300, 100, 100, 70, 50);
	}
	
	public void setCellWidth(int...width) {
		TableColumnModel cModel = RentalDataTable.getColumnModel();
		System.out.println(Arrays.toString(width));
		for(int i=0; i<width.length; i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void setAlign(int align, int...idx) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = RentalDataTable.getColumnModel();
		// idx = [0,2]
		for(int i=0; i<idx.length;i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public void reloadTableView() {
		RentalDataTable.setModel(createTableModel(rentalView));
		RentalDataTable.setVisible(true);

	}
}
