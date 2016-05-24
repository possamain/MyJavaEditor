import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;


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
		System.out.println("controllare cambio nomi interni al prg dopo salvataggi!!!");
		System.out.println("inserizi CTRL+Z, CTRL+X");
		System.out.println("estensioni in apertura files");
	}
	
	ActionListener New = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/*
			 * TODO configurabile anche con nome file in input con JOptionPane
			 */
			//boolean sameName = false;
			
			//String nomeNuovoFile = JOptionPane.showInputDialog("Nome file");
			moduli.gui.getFiles().add(new File("Untitled"));
			
			moduli.gui.getTextAreas().add(new JTextPane());
			moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).addKeyListener(colorWords);                                                                 
			
			moduli.gui.getTextFont().add(new Font("Monaco", Font.BOLD, 12));
			//System.out.println(moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1));
			//moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex())
			moduli.gui.getDoc().add(moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).getStyledDocument());
			//doc = textPane.getStyledDocument();
			moduli.gui.getAttrs().add(moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).getInputAttributes());
			//MutableAttributeSet attrs = textPane.getInputAttributes();
			StyleConstants.setAlignment(moduli.gui.getAttrs().get(moduli.gui.getAttrs().size()-1), StyleConstants.ALIGN_LEFT);
			moduli.gui.getDoc().get(moduli.gui.getDoc().size()-1).setParagraphAttributes(0, 0, moduli.gui.getAttrs().get(moduli.gui.getDoc().size()-1), true);
			
			StyleConstants.setFontFamily(moduli.gui.getAttrs().get(moduli.gui.getAttrs().size()-1), moduli.gui.getTextFont().get(moduli.gui.getDoc().size()-1).getFamily());
			StyleConstants.setFontSize(moduli.gui.getAttrs().get(moduli.gui.getAttrs().size()-1), moduli.gui.getTextFont().get(moduli.gui.getDoc().size()-1).getSize());
			StyleConstants.setBold(moduli.gui.getAttrs().get(moduli.gui.getAttrs().size()-1), true);
			StyleConstants.setForeground(moduli.gui.getAttrs().get(moduli.gui.getAttrs().size()-1), Color.black);

			moduli.gui.getDoc().get(moduli.gui.getDoc().size()-1).setCharacterAttributes(0, moduli.gui.getDoc().get(moduli.gui.getDoc().size()-1).getLength() + 1, moduli.gui.getAttrs().get(moduli.gui.getDoc().size()-1), false);
			//doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);
			
			//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setFont(new Font("Monospaced", Font.PLAIN, 12));
			//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setVisible(true);
			
			//moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1).setText("public class "+nomeNuovoFile.substring(0, nomeNuovoFile.length()-5)+"{\n\tpublic static void main(String[] args){\n\n\t}\n}");
			
			if(moduli.gui.getTabbedPane().getTabCount()>=1){
				for(int i = 0; i<moduli.gui.getTabbedPane().getTabCount(); i++)
					if(moduli.gui.getTabbedPane().getTitleAt(i)==moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()&&moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()!="Untitled"){
						moduli.gui.getTabbedPane().addTab(moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()+" - "+moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getPath(), null, moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1), null);
						moduli.sameName = true;
					}
				if(moduli.sameName)
					moduli.gui.getTabbedPane().addTab(moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName()+" - "+moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getPath(), null, moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1), null);
				else {
					moduli.gui.getTabbedPane().addTab(moduli.gui.getFiles().get(moduli.gui.getFiles().size()-1).getName(), null, moduli.gui.getTextAreas().get(moduli.gui.getTextAreas().size()-1), null);
				}
			}
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
			 //PENEdialog.setFileFilter(new FileNameExtensionFilter("JavaFiles (.java)", new ExtensionFilter(null, new))); 
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
	
	ActionListener Cut = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).cut();
		}
	};
	
	ActionListener Copy = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).copy();
		}
	};
	
	ActionListener Paste = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).paste();
		}
	};
	
	ActionListener SelectAll = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).selectAll();;
		}
	};
		
	ActionListener openCmd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new RunCMD(moduli.gui.getFiles().get(moduli.gui.getTabbedPane().getSelectedIndex()));
		}
	};
	
	KeyListener paroleChiave = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			String line;
			String [] paroleRiservate = new String[48];
			String [] parole = moduli.getWords(moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).getText());
			FileReader fr;
			BufferedReader br;
			try {
				fr = new FileReader("ParoleRiservate");
				br = new BufferedReader(fr);
				int i = 0;
				while ((line = br.readLine()) != null){
					paroleRiservate[i] = line;
					i++;
				}
				fr.close();
				moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).setText("");
				for (i = 0; i<paroleRiservate.length; i++)
					for (int j = 0; j<parole.length; j++)
						if (paroleRiservate[i] == parole[j]){}
							
							//moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex()).getCsetText(parole[j]);
				
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	KeyListener colorWords = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent ev) {
			if (ev.getID() == KeyEvent.KEY_RELEASED && ev.getSource() == moduli.gui.getTextAreas().get(moduli.gui.getTabbedPane().getSelectedIndex())) {
				/*
				 * while che passa ogni parola riservata del file allegato 
				 * al progetto al modulo colorWords()
				 */
				String parola;
				try {
					FileReader fr = new FileReader("ParoleRiservate");
					BufferedReader br = new BufferedReader(fr);
					parola = br.readLine();
					while(parola != null){
						//System.out.println(parola);	
						moduli.colorWords(parola);
						parola = br.readLine();
					}
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}// keyReleased
			
		
		@Override
		public void keyPressed(KeyEvent e) {
			moduli.gui.setChanged(true);
			moduli.gui.getBtnSave().setEnabled(true);
			moduli.gui.getMntmSalva().setEnabled(true);
			
		}
	};
	
	
	
	

}
