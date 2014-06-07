package threadpra;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JSlider;
import javax.swing.JScrollBar;

import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

import java.awt.Canvas;

import javax.swing.JLabel;

import java.awt.Label;

public class window {

	private JFrame frame;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	private String st;
	private JButton button;
	private JButton button_1;
	BufferedReader in ;
	PrintWriter out ;
	private JLabel lblNewLabel;
	flag p1=new flag();
public window(String str) throws IOException {
	in = new BufferedReader(new 
			InputStreamReader(EchoClient.ss.getInputStream()));
	out = new PrintWriter(
			new OutputStreamWriter(EchoClient.ss.getOutputStream()));
		st=str;
  this.p1=p1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					
					button = new JButton("\u958B\u59CB");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							out.println("start");
							out.flush();
						}
					});
					button.setBounds(429, 162, 72, 50);
					frame.getContentPane().add(button);
					
					button_1 = new JButton("\u6253\u64CA");
					button_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							out.println("5");
							out.flush();
						}
					});
					button_1.setBounds(94, 382, 200, 50);
					frame.getContentPane().add(button_1);
					
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(94, 31, 200, 337);
					frame.getContentPane().add(scrollPane_1);
					//					windowthread wt = new windowthread(frame,textArea);
					//					playadj pa= new playadj(frame,textArea);
										
										textArea = new JTextArea(5,10);
										scrollPane_1.setViewportView(textArea);
										textArea.setWrapStyleWord(true);
										textArea.setRows(5);
										textArea.setLineWrap(true);
										
										windowthread wt = new windowthread(frame,textArea,p1);
					
//					lblNewLabel = new JLabel("New label");
//					lblNewLabel.setBounds(373, 259, 261, 237);
//					frame.getContentPane().add(lblNewLabel);
//					frame.setVisible(true);
					playadj pa= new playadj(frame,lblNewLabel);
					wt.start();
					pa.start();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					window window = new window(frame,textField);
//					window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public window() {
//		
//		initialize();
//		
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		frame.setBounds(100, 100, 753, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel = new JLabel("New label");
	}
}
