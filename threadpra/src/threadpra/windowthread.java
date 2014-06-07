package threadpra;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class windowthread extends Thread{
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private ScrollPane scrollPane;
	flag p1=new flag();
	public windowthread(JFrame frame,JTextArea textArea,flag p1)
	{
		this.frame=frame;
		this.textArea=textArea;
		this.p1=p1;
		
	}
	public void run() {
		initialize();
		
	}
	
	private void initialize() {
		String console="",c1="",c2="";
		int t=0;
		
		//textArea.setText(clithread.str);
		while(p1.getbg()==true){
			//textField.setText(clithread.str);
				textArea.setText(clithread.st2);
				textArea.setCaretPosition(textArea.getDocument().getLength());
				if(clithread.str.equals("3"))
				{textArea.setText(clithread.st2);
				textArea.append("\n\r"+"結束! 下一打席");
				textArea.setCaretPosition(textArea.getDocument().getLength());
				break;
				}
				
			
		}
	}
}
