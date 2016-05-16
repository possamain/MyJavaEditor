import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Moduli {
	
	JFileChooser dialog;
	GUI gui;
	boolean sameName;
	
	
	public Moduli(GUI gui) {
		System.out.println("creare metodo getLibero per files e textAreas");
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
			gui.getTextAreas().add(new JTextArea());
			gui.getTextAreas().get(gui.getTextAreas().size()-1).setFont(new Font("Monospaced", Font.PLAIN, 12));
			gui.getTextAreas().get(gui.getTextAreas().size()-1).setVisible(true);
			gui.getTextAreas().get(gui.getTextAreas().size()-1).addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {		
					gui.setChanged(true);
					gui.getBtnSave().setEnabled(true);
					gui.getMntmSalva().setEnabled(true);
				}
			});			
			for(int i = 0; i<gui.getTabbedPane().getTabCount(); i++)
				if(gui.getTabbedPane().getTitleAt(i)== fileName)
					sameName = true;
			if(sameName)
				gui.getTabbedPane().addTab(fileName, null, gui.getTextAreas().get(gui.getTextAreas().size()-1), null);
			else {
				gui.getTabbedPane().addTab(fileName, null, gui.getTextAreas().get(gui.getTextAreas().size()-1), null);
			}
			//moduli.gui.mntmSalva.setEnabled(true);
			gui.getMntmSalvaConNome().setEnabled(true);
			gui.getTextAreas().get(gui.getTextAreas().size()-1).read(r, null);
			r.close();
			Actions.setCourrentFile(fileName);
			gui.getTabbedPane().setTitleAt(gui.getTabbedPane().getSelectedIndex(), gui.getFiles().get(gui.getTabbedPane().getSelectedIndex()).getName());
			gui.setChanged(false);
		}catch(IOException e){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "File " + fileName + "non trovato!");
		}
	}
	
	void saveFile(String fileName) {
		try{
			FileWriter w = new FileWriter(fileName);
			gui.getTextArea().write(w);
			w.close();
			Actions.setCourrentFile(fileName);
			//gui.setTitle(Actions.getCourrentFile());
			gui.setChanged(false);
			gui.getBtnSave().setEnabled(false);
			gui.getMntmSalva().setEnabled(false);
			gui.getTabbedPane().setTitleAt(gui.getTabbedPane().getSelectedIndex(), fileName);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}
