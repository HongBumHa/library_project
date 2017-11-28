package kr.or.dgit.library_project.test;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dddd extends JFrame {
	public Dddd() {
	}

	private JPanel contentPane;

	public static class Browser extends JFrame
	{
	    private String[] list = {"Timeking", "Manghon", "timemanghon"};
	    private JComboBox box;
	        
	    public Browser()
	    {
	        super("HTML Browser");
	        setSize(500, 300);
	    
	        box = new JComboBox(list);
	        box.setEditable(true);
	        add("North", box);
	        
	        ComboAgent agent = new ComboAgent(box);
	        
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }    
	    
	    class ComboAgent extends KeyAdapter
	    {
	        JComboBox combo;
	        JTextField editor;
	        
	        public ComboAgent(JComboBox box)
	        {
	            combo = box;
	            editor = (JTextField)combo.getEditor().getEditorComponent();
	            editor.addKeyListener(this);
	        }
	        
	        public void keyReleased(KeyEvent e)
	        {
	            char ch = e.getKeyChar();
	            
	            if(ch == KeyEvent.CHAR_UNDEFINED || Character.isISOControl(ch))
	                return;
	            
	            int pos = editor.getCaretPosition();
	            String str = editor.getText();
	            
	            if(str.length() == 0)
	                return;
	            
	            for(int k=0; k<combo.getItemCount(); k++)
	            {
	                String iteml = combo.getItemAt(k).toString().toLowerCase();
	                String item = combo.getItemAt(k).toString();
	                // 조건 비교.. 입력한 문자열이 리스트에 있는 아이템의 첫머리로 일치하는지..
	                if( item.startsWith(str) || iteml.startsWith(str) ||
	                    item.startsWith(str.toLowerCase()) ||
	                    iteml.startsWith(str.toLowerCase()) )
	                {
	                    // 일치한다면 field에 매치된 아이템을 셋팅하고
	                    // 자동으로 완성된 부분을 선택표시로 하여 강조한다.
	                    editor.setText(item);    
	                    editor.setCaretPosition(item.length());
	                    editor.moveCaretPosition(pos);
	                    break;
	                }
	            }
	        }
	    }
	    
	    public static void main(String[] args)
	    {
	        new Browser();
	    }
	}
}
