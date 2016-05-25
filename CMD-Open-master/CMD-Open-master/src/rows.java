import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class rows{
	private static ArrayList<JTextField> al=new ArrayList<JTextField>();
	private static JFrame f;
	private static int i=0;
	public static void main(String[] args) {
		f=new JFrame();
		f.getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		
		/*File fi=new File("C:\\Users\\Andrea\\Desktop\\ciao.txt");
		Scanner t;
		try {
			t = new Scanner(fi);
			String s;
			int c=0;
			while(t.hasNextLine()){
				c++;
				s=t.nextLine();
				textArea.setText(textArea.getText()+s+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		set(textArea.getLineCount());
		
		textArea.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				set(textArea.getLineCount());
			}
		});
		
		textArea.setBounds(25, 11, 259, 350);
		textArea.setEditable(true);
		
		f.setSize(300, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		f.getContentPane().add(textArea);
	}
	public static void set(int c){
		while(i<c){
			al.add(new JTextField(Integer.toString(i+1)));
			if(i==0)
				al.get(i).setBounds(0, 11, 22, 17);
			else{
				Rectangle x=al.get(i-1).getBounds();
				al.get(i).setBounds(x.x,x.y+16,x.width,x.height);
			}
			al.get(i).setEditable(false);
			f.getContentPane().add(al.get(i));
			i++;
		}
		while(i>c){
			al.get(i-1).setVisible(false);
			f.remove(al.get(i-1));
			al.remove(i-1);
			i--;
		}
		f.repaint();
	}
}