package threadpra;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;





import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class playadj extends Thread{

	BufferedReader in ;
	PrintWriter out ;
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private Label label;
	private JLabel lblNewLabel;
	private Canvas canvas;
	 
	public playadj() throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(EchoClient.ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(EchoClient.ss.getOutputStream()));
	}
	public playadj(JFrame frame,JLabel lblNewLabel)
	{
		this.frame=frame;
		this.lblNewLabel=lblNewLabel;
	}
	public void run(){
		
		
		 Image image = null,img2=null;
		 int x=0,y=40,t=0,t1=0;
		
		 try{
		File file = new File("baseball256.png");
        image = ImageIO.read(file);
        InputStream is = new BufferedInputStream(
                new FileInputStream("D:/yuzench/anpro/threadpra/baseball256.png"));
            image = ImageIO.read(is);
            
//            file = new File("emp.png");
//            img2=ImageIO.read(file);
//           is = new BufferedInputStream(
//                    new FileInputStream("D:/yuzench/anpro/threadpra/emp.png"));
//                img2 = ImageIO.read(is);
		 } catch (IOException e) {
		    }
		//lblNewLabel=new JLabel(new ImageIcon(image));
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(373, 259, 261, 237);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
			
			                                                               
			
//			 lblNewLabel=new JLabel(new ImageIcon(img2));
//			 lblNewLabel.setBounds(373, 259, 261, 237);
//			frame.getContentPane().add(lblNewLabel);
//			frame.setVisible(true);
		 
	
//		Bitmap bmpTrendChart = BitmapFactory.decodeFile(filePath)
//		canvas=new Canvas();
//		Image img; 
//		img = Toolkit.getDefaultToolkit().getImage("D:/yuzench/anpro/threadpra/baseball256.png"); 
//		lblNewLabel.setIcon(new ImageIcon(img));
//		int imgW = img.getWidth(null);
//		  int imgH = img.getHeight(null);
//		  int[] watermark = new int[imgW*imgH];
//		  //grabImage(img, watermark);
	}
	
}
