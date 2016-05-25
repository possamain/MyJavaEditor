import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyledDocument;

import javafx.scene.layout.Border;

import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;


import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.util.List<File> files;
	private java.util.List<JTextPane> textPanes;
	private java.util.List<StyledDocument> doc;
	private java.util.List<Font> font;
	private java.util.List<MutableAttributeSet> attrs;
	private java.util.List<JTextField> linecount;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNuovo;
	private JMenuItem mntmApri;	
	private JMenuItem mntmSalva;
	private JMenuItem mntmSalvaConNome;
	private JMenuItem mntmEsci;
	private JMenuItem mntmCopia;
	private JMenuItem mntmTaglia;
	private JMenuItem mntmIncolla;
	private JMenu mnModifica;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmSelezionaTutto;
	private JToolBar toolBar;
	private JButton btnSave;
	private JButton btnCmd;
	private JPanel panel_1;
	

	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private static boolean changed = false;
	
	public GUI() {	
		getContentPane().setLayout(null);
		System.out.println("Controllare chiusure files");
		
		setVisible(true);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(1, 1, 278, 30);
		setJMenuBar(menuBar);
		//panel.add(menuBar);
		
		mnFile = new JMenu("File");	
		
		mntmNuovo = new JMenuItem("Nuovo");
		mntmNuovo.addActionListener(actions.New);
		mnFile.add(mntmNuovo);
		
		mntmApri = new JMenuItem("Apri");
		mntmApri.addActionListener(actions.Open);
		mnFile.add(mntmApri);
		
		mntmSalva = new JMenuItem("Salva");
		mntmSalva.addActionListener(actions.Save);
		mntmSalva.setEnabled(false);
		mntmSalva.setMnemonic(KeyEvent.VK_S);
		mnFile.add(getMntmSalva());
		
		mntmSalvaConNome = new JMenuItem("Salva con nome");
		mntmSalvaConNome.addActionListener(actions.SaveAs);
		mntmSalvaConNome.setEnabled(false);
		mnFile.add(getMntmSalvaConNome());
		
		mntmEsci = new JMenuItem("Esci");
		mntmEsci.addActionListener(actions.Quit);
		mnFile.add(mntmEsci);
		
		menuBar.add(mnFile);
		
		JMenu mnModifica_1 = new JMenu("Modifica");
		menuBar.add(mnModifica_1);
		
		mntmTaglia = new JMenuItem("Taglia");
		mntmTaglia.addActionListener(actions.Cut);
		mntmTaglia.setMnemonic(KeyEvent.VK_X);
		mnModifica_1.add(mntmTaglia);
		
		mntmCopia = new JMenuItem("Copia");
		mntmCopia.addActionListener(actions.Copy);
		mntmCopia.setMnemonic(KeyEvent.VK_C);
		mnModifica_1.add(mntmCopia);
		
		mntmIncolla = new JMenuItem("Incolla");
		mntmIncolla.setMnemonic(KeyEvent.VK_V);
		mntmIncolla.addActionListener(actions.Paste);
		mnModifica_1.add(mntmIncolla);
		
		mntmSelezionaTutto_1 = new JMenuItem("Seleziona tutto");
		mnModifica_1.add(mntmSelezionaTutto_1);
		
		
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 500, 25);
		getContentPane().add(toolBar);
		
		setBtnSave(new JButton("Save"));
		getBtnSave().setEnabled(false);
		//btnSave.add(actions.Save);
		toolBar.add(getBtnSave());
		
		btnCmd = new JButton("CMD");
		toolBar.add(btnCmd);
		btnCmd.addActionListener(actions.openCmd);
				
		panel_1 = new JPanel();
		panel_1.setBounds(25, 30, 549, 364);
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		setTabbedPane(new JTabbedPane(JTabbedPane.TOP));
		getTabbedPane().setSize(520, 360);
		
		panel_1.add(getTabbedPane());
		//scrollPane = new JScrollPane();
		
		JLabel lblVersion = new JLabel("Version 1.0 - OurIDEProject");
		lblVersion.setBounds(0, 0, 549, 14);
		getContentPane().add(lblVersion);
		validate();
		repaint();
		
		
		/*textAreas[0]= new JTextArea();
		textAreas[0].setFont(new Font("Monospaced", Font.PLAIN, 12));
		textAreas[0].setVisible(false);
		textAreas[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {		
				changed = true;
				btnSave.setEnabled(true);
				mntmSave.setEnabled(true);
			}
		});
		//textArea.*/
		//tabbedPane.getSelectedIndex()
		//textAreas.get(tabbedPane.getSelectedIndex()).paste();
		
		/*for(int i = 0; i<textPanes.size(); i++){
			textPanes.get(i).addKeyListener(actions.colorWords);
		}*/
		
		setFiles(new ArrayList<File>());
		setTextAreas(new ArrayList<JTextPane>());
		setAttrs(new ArrayList<MutableAttributeSet>());
		setDoc(new ArrayList<StyledDocument>());
		setTextFont(new ArrayList<Font>());
		setLinecount(new ArrayList<JTextField>());
		
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JTextPane getActiveTextArea() {
		return getTextAreas().get(getTabbedPane().getSelectedIndex());
	}

	
	public void setChanged(boolean changed) {
		GUI.changed = changed;
	}

	public static boolean isChanged() {
		return changed;
	}
	
	public java.util.List<File> getFiles() {
		return files;
	}

	public void setFiles(java.util.List<File> files) {
		this.files = files;
	}

	public java.util.List<JTextPane> getTextAreas() {
		return textPanes;
	}

	public void setTextAreas(ArrayList<JTextPane> arrayList) {
		this.textPanes = arrayList;
	}

	public JMenu getMnModifica() {
		return mnModifica;
	}

	public void setMnModifica(JMenu mnModifica) {
		this.mnModifica = mnModifica;
	}

	public JMenuItem getMntmNewMenuItem() {
		return mntmNewMenuItem;
	}

	public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
		this.mntmNewMenuItem = mntmNewMenuItem;
	}

	public JMenuItem getMntmSelezionaTutto() {
		return mntmSelezionaTutto;
	}

	public void setMntmSelezionaTutto(JMenuItem mntmSelezionaTutto) {
		this.mntmSelezionaTutto = mntmSelezionaTutto;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JMenuItem getMntmSalva() {
		return mntmSalva;
	}

	public void setMntmSalva(JMenuItem mntmSalva) {
		this.mntmSalva = mntmSalva;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		panel_1.add(tabbedPane, BorderLayout.NORTH);
	}

	public JMenuItem getMntmSalvaConNome() {
		return mntmSalvaConNome;
	}

	public void setMntmSalvaConNome(JMenuItem mntmSalvaConNome) {
		this.mntmSalvaConNome = mntmSalvaConNome;
	}
	
	public java.util.List<StyledDocument> getDoc() {
		return doc;
	}

	public void setDoc(java.util.List<StyledDocument> doc) {
		this.doc = doc;
	}

	public java.util.List<Font> getTextFont() {
		return font;
	}

	public void setTextFont(java.util.List<Font> font) {
		this.font = font;
	}

	public java.util.List<MutableAttributeSet> getAttrs() {
		return attrs;
	}

	public void setAttrs(java.util.List<MutableAttributeSet> attrs) {
		this.attrs = attrs;
	}

	public java.util.List<JTextField> getLinecount() {
		return linecount;
	}
	
	public void setLinecount(java.util.List<JTextField> linecount) {
		this.linecount = linecount;
	}

	Moduli moduli = new Moduli(this);
	Actions actions = new Actions(moduli);
	
	private JMenuItem mntmSelezionaTutto_1;
	
	
}
