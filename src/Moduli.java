import java.awt.Color;
import java.awt.Font;import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;

import javafx.scene.control.ScrollPane;

public class Moduli {
	
	JFileChooser dialog;
	GUI gui;
	boolean sameName;
	
	
	public Moduli(GUI gui) {
		//System.out.println("creare metodo getLibero per files e textAreas");
		this.gui = gui;
		dialog = new JFileChooser();
	}
	
	void saveFileAs() {
		if(dialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
			saveFile(dialog.getSelectedFile().getAbsolutePath());
	}
	
	void saveOld(){
		if(GUI.isChanged()){
			if(JOptionPane.showConfirmDialog(null, "Vuoi salvare " + Actions.getCourrentFile() + "?","Save", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				saveFile(Actions.getCourrentFile());
		}				
	}
	
	void readInFile(String fileName){
		try{
			FileReader r = new FileReader(fileName);
			gui.getFiles().add(new File(fileName));
			
			newTextArea();
			
			
			
			//moduli.gui.mntmSalva.setEnabled(true);
			
			
			gui.getTextAreas().get(gui.getTextAreas().size()-1).read(r, null);
			r.close();
			//Actions.setCourrentFile(fileName);
			//gui.getTabbedPane().setTitleAt(gui.getTabbedPane().getSelectedIndex(), gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).getName());
			gui.setChanged(false);
		}catch(IOException e){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "File " + fileName + " non trovato!");
		}
	}
	
	void newTextArea (){
		
		gui.getTextAreas().add(new JTextPane());
		//gui.getTabbedPane().;
		gui.getTextAreas().get(gui.getTextAreas().size()-1).addKeyListener(gui.actions.colorWords);                                                                 
		gui.getTabbedPane().addTab(gui.getFiles().get(gui.getFiles().size()-1).getName(), null, gui.getTextAreas().get(gui.getTextAreas().size()-1));
		gui.getTextFont().add(new Font("Monospaced", Font.PLAIN, 12));
		//System.out.println(moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1));
		//moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex())
		gui.getDoc().add(gui.getTextAreas().get(gui.getTextAreas().size()-1).getStyledDocument());
		//doc = textPane.getStyledDocument();
		gui.getAttrs().add(gui.getTextAreas().get(gui.getTextAreas().size()-1).getInputAttributes());
		//MutableAttributeSet attrs = textPane.getInputAttributes();
		StyleConstants.setAlignment(gui.getAttrs().get(gui.getAttrs().size()-1), StyleConstants.ALIGN_LEFT);
		gui.getDoc().get(gui.getDoc().size()-1).setParagraphAttributes(0, 0, gui.getAttrs().get(gui.getDoc().size()-1), true);
		
		StyleConstants.setFontFamily(gui.getAttrs().get(gui.getAttrs().size()-1), gui.getTextFont().get(gui.getDoc().size()-1).getFamily());
		StyleConstants.setFontSize(gui.getAttrs().get(gui.getAttrs().size()-1), gui.getTextFont().get(gui.getDoc().size()-1).getSize());
		StyleConstants.setBold(gui.getAttrs().get(gui.getAttrs().size()-1), true);
		StyleConstants.setForeground(gui.getAttrs().get(gui.getAttrs().size()-1), Color.black);

		gui.getDoc().get(gui.getDoc().size()-1).setCharacterAttributes(0, gui.getDoc().get(gui.getDoc().size()-1).getLength() + 1, gui.getAttrs().get(gui.getDoc().size()-1), false);
		//doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);
		
		//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setFont(new Font("Monospaced", Font.PLAIN, 12));
		//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setVisible(true);
		
		//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setText("public class "+nomeNuovoFile.substring(0, nomeNuovoFile.length()-5)+"{\n\tpublic static void main(String[] args){\n\n\t}\n}");
		gui.getMntmSalvaConNome().setEnabled(true);
		
		for(int i = 0; i<gui.getTabbedPane().getTabCount(); i++)
			if(gui.getTabbedPane().getTitleAt(i) == gui.getFiles().get(gui.getFiles().size()-1).getAbsolutePath())
				try {
					gui.getTabbedPane().setTitleAt(gui.getTextAreas().size()-1, gui.getFiles().get(gui.getFiles().size()-1).getCanonicalPath().substring(gui.getFiles().get(gui.getFiles().size()-1).getAbsolutePath().lastIndexOf('/'), gui.getFiles().get(gui.getFiles().size()-1).getAbsolutePath().length()-1));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else 
				gui.getTabbedPane().setTitleAt(gui.getTextAreas().size()-1, gui.getFiles().get(gui.getFiles().size()-1).getName());
		
		setLineCount(new JTextArea(gui.getTextAreas().get(gui.getTabbedPane().getSelectedIndex()).getText()).getLineCount());
	}
	
	String[] getWords (String text){
		StringTokenizer st = new StringTokenizer(text);
		String[] words = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			words[i] = st.nextToken();
			i++;
		}
		return words;
	}
	
	void colorWords (String parola){
		System.out.println(parola);
		String tmp = gui.getTextAreas().get(gui.getTabbedPane().getSelectedIndex()).getText();
		//int i = 0;
		MutableAttributeSet attrs = gui.getTextAreas().get(gui.getTabbedPane().getSelectedIndex()).getInputAttributes();
		int i = tmp.indexOf(parola);
		//System.out.println(i);
		while (i != -1) {
			StyleConstants.setForeground(attrs, Color.blue);
			gui.getDoc().get(gui.getTabbedPane().getSelectedIndex()).setCharacterAttributes(i, i + parola.length(), attrs, false);
			StyleConstants.setForeground(attrs, Color.black);
			gui.getDoc().get(gui.getTabbedPane().getSelectedIndex()).setCharacterAttributes(i + parola.length(), gui.getDoc().get(gui.getTabbedPane().getSelectedIndex()).getLength() + 1, attrs, false);
			i += parola.length();
			i = tmp.indexOf(parola, i);
		}
	
	}
	
	void saveFile(String fileName) {
		try{
			FileWriter w = new FileWriter(fileName);
			gui.getActiveTextArea().write(w);
			w.close();
			Actions.setCourrentFile(fileName);
			//gui.setTitle(Actions.getCourrentFile());
			gui.setChanged(false);
			gui.getBtnSave().setEnabled(false);
			gui.getMntmSalva().setEnabled(false);
			gui.getTabbedPane().setTitleAt(gui.getTabbedPane().getSelectedIndex(), fileName);
			gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).renameTo(new File(fileName));
			System.out.println(gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).getName());
			//gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).renameTo(new File(fileName));
			//gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	void setLineCount(int c){
		int i = gui.getLinecount().size();
		System.out.println(i);
		while(i<c){
			gui.getLinecount().add(new JTextField(Integer.toString(i+1)));
			if(i==0)
				gui.getLinecount().get(i).setBounds(0, 58, 25, 18);
			else{
				Rectangle x=gui.getLinecount().get(i-1).getBounds();
				gui.getLinecount().get(i).setBounds(x.x,x.y+17,x.width,x.height);
			}
			gui.getLinecount().get(i).setEditable(false);
			gui.add(gui.getLinecount().get(i));
			i++;
		}
		while(i>c){
			//gui.getLinecount().get(i-1).setVisible(false);
			gui.remove(gui.getLinecount().get(i-1));
			gui.getLinecount().remove(i-1);
			i--;
		}
		gui.repaint();
	}
}
	

