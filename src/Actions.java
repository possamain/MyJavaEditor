import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ActionMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

public class Actions {
	private static Moduli moduli;
	
	private JFileChooser dialog;
	//private static String courrentFile = "Untitled";
	public static String getCourrentFile() {
		return moduli.gui.getFiles().get(moduli.gui.getTabbedPane().getSelectedIndex()).getName();
	}
	
	public static void setCourrentFile(String courrentFile) {
		//boolean find = false;
		//TODO controllare chiamate per capire cosa fa, non lo ricordo Lel
		/*while(!moduli.gui.files.get(moduli.gui.tabbedPane.getSelectedIndex()).equals(courrentFile))
			
		moduli.gui.tabbedPane.setSelectedIndex(moduli.gui.files.get(moduli.gui.files.equals(courrentFile)));*/
		//moduli.gui.files.get(moduli.gui.tabbedPane.getSelectedIndex()).(new File(courrentFile));
	}

	//GUI gui;
	
	public Actions(Moduli moduli) {
		Actions.moduli = moduli;
		dialog = new JFileChooser();
		System.out.println("MANCANO DELLE COSEEEE!!!/n controlla TODO");
	}
	
	ActionListener New = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/*
			 * TODO configurabile anche con nome file in input con JOptionPane
			 */
			//boolean sameName = false;
			
			//int index = moduli.gui.textAreas.length+1;
			/*LISTE*/
			moduli.gui.getTextAreas().add(new JTextArea());
			moduli.gui.getFiles().add(new File("Untitled"));
			
			moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setFont(new Font("Monospaced", Font.PLAIN, 12));
			moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setVisible(true);
			moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {		
					moduli.gui.setChanged(true);
					moduli.gui.getBtnSave().setEnabled(true);
					moduli.gui.getMntmSalva().setEnabled(true);
				}
			});			
			for(int i = 0; i<moduli.gui.getTabbedPane().getTabCount(); i++)
				if(moduli.gui.getTabbedPane().getTitleAt(i)==moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()&&moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()!="Untitled")
					moduli.sameName = true;
			if(moduli.sameName)
				moduli.gui.getTabbedPane().addTab(moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()+" - "+moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getPath(), null, moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1), null);
			else {
				moduli.gui.getTabbedPane().addTab(moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName(), null, moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1), null);
			}
			//moduli.gui.mntmSalva.setEnabled(true);
			moduli.gui.getMntmSalvaConNome().setEnabled(true);
		}
	};
	
	 ActionListener Open = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			 moduli.saveOld();
			 dialog.setDialogTitle("Apri");
			 if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				 moduli.readInFile(dialog.getSelectedFile().getAbsolutePath());
			 }
			 moduli.gui.getMntmSalva().setEnabled(true);
			 moduli.gui.getMntmSalvaConNome().setEnabled(true);
		 }
	 };
	 
	ActionListener Save = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!getCourrentFile().equals("Untitled"))
				moduli.saveFile(getCourrentFile());
			else 
				moduli.saveFileAs();
		}
	};
	
	ActionListener SaveAs = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moduli.saveFileAs();			
		}
	};
	
	ActionListener Quit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(JOptionPane.showConfirmDialog(null, "Uscire dall'editor?")==JOptionPane.YES_OPTION){
				moduli.saveOld();
				System.exit(0);
			}
		}
	};
	
	ActionListener openCmd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/*try{
				System.out.println("CIao");
				//Runtime r = Runtime.getRuntime();
				//String s [] = new String [3];
				try{
					//Runtime r = Runtime.getRuntime();
					String s [] = new String [3];
					s[0] = "cmd.exe";
					s[1] = "/C";
					s[2] = moduli.gui.files.get(moduli.gui.tabbedPane.getSelectedIndex()).getAbsolutePath();
					new ProcessBuilder(s[0],s[1],s[2]).start();
				}catch(Throwable t){
					t.printStackTrace();
				}
				
			}catch(Throwable t){
				t.printStackTrace();
			}*/
			System.out.println("--> CMD: il codice fa qualcosa (loop), sistemare classe RunnableHelper.java");
			System.out.println("152\tButton btnCmd.addActionListener(actions.openCmd)\n147\t\tActions.openCmd - (actionPerformed)");
			/*RunnableHelper h = new RunnableHelper();
			h.runFile("cmd.exe");*/
			
		}
	};
	
	//TODO funzioni Taglia, Copia, Incolla, ..., su textAreas
	//ActionMap m = moduli.gui.textArea.getActionMap();
	/*Action Cut = m.get(DefaultEditorKit.cutAction);
	Action Copy = m.get(DefaultEditorKit.copyAction);
	Action Paste = m.get(DefaultEditorKit.pasteAction);*/


}
