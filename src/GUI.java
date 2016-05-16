import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Font;
import java.awt.List;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.util.List<File> files;
	private java.util.List<JTextArea> textAreas;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNuovo;
	private JMenuItem mntmApri;	
	private JMenuItem mntmSalva;
	private JMenuItem mntmSalvaConNome;
	private JMenuItem mntmEsci;
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
		System.out.println("Controllare chiusure files");
		
		setVisible(true);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		
		setMntmSalva(new JMenuItem("Salva"));
		getMntmSalva().addActionListener(actions.Save);
		getMntmSalva().setEnabled(false);
		mnFile.add(getMntmSalva());
		
		setMntmSalvaConNome(new JMenuItem("Salva con nome"));
		getMntmSalvaConNome().addActionListener(actions.SaveAs);
		getMntmSalvaConNome().setEnabled(false);
		mnFile.add(getMntmSalvaConNome());
		
		mntmEsci = new JMenuItem("Esci");
		mntmEsci.addActionListener(actions.Quit);
		mnFile.add(mntmEsci);
		
		menuBar.add(mnFile);
		
		JMenu mnModifica_1 = new JMenu("Modifica");
		menuBar.add(mnModifica_1);
		
		mntmTaglia = new JMenuItem("Taglia");
		mnModifica_1.add(mntmTaglia);
		
		mntmCopia = new JMenuItem("Copia");
		mnModifica_1.add(mntmCopia);
		
		mntmIncolla = new JMenuItem("Incolla");
		mnModifica_1.add(mntmIncolla);
		
		mntmSelezionaTutto_1 = new JMenuItem("Seleziona tutto");
		mnModifica_1.add(mntmSelezionaTutto_1);
		
		
		/*mnModifica = new JMenu("Modifica");
		mnModifica.add(actions.Cut);
		mnModifica.add(actions.Copy);
		mnModifica.add(actions.Paste);
		mnModifica.getItem(0).setText("Taglia");
		mnModifica.getItem(1).setText("Copia");
		mnModifica.getItem(2).setText("Incolla");
		menuBar.add(mnModifica);*/
		/*mntmSalva = new JMenuItem("Salva");
		mnFile.add(mntmSalva);
		
		mntmApri = new JMenuItem("Apri");
		mnFile.add(mntmApri);
		
		
		
		mntmNewMenuItem = new JMenuItem("New menu item");
		mnModifica.add(mntmNewMenuItem);
		
		mntmSelezionaTutto = new JMenuItem("Seleziona tutto");
		mnModifica.add(mntmSelezionaTutto);*/
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 500, 25);
		panel.add(toolBar);
		
		setBtnSave(new JButton("Save"));
		getBtnSave().setEnabled(false);
		//btnSave.add(actions.Save);
		toolBar.add(getBtnSave());
		
		btnCmd = new JButton("CMD");
		toolBar.add(btnCmd);
		btnCmd.addActionListener(actions.openCmd);
		
		panel_1 = new JPanel();
		panel_1.setBounds(5, 30, 574, 364);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		setTabbedPane(new JTabbedPane(JTabbedPane.TOP));
		scrollPane.setViewportView(getTabbedPane());
		
		JLabel lblVersion = new JLabel("Version 1.0 - Nicholas Possamai");
		lblVersion.setBounds(15, 415, 274, 25);
		panel.add(lblVersion);
		
		setTextAreas(new ArrayList<JTextArea>());
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
		
		setFiles(new ArrayList<File>());
		
	}
	
	public JTextArea getTextArea() {
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

	public java.util.List<JTextArea> getTextAreas() {
		return textAreas;
	}

	public void setTextAreas(java.util.List<JTextArea> textAreas) {
		this.textAreas = textAreas;
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
	}

	public JMenuItem getMntmSalvaConNome() {
		return mntmSalvaConNome;
	}

	public void setMntmSalvaConNome(JMenuItem mntmSalvaConNome) {
		this.mntmSalvaConNome = mntmSalvaConNome;
	}

	Moduli moduli = new Moduli(this);
	Actions actions = new Actions(moduli);
	private JMenuItem mntmSelezionaTutto_1;
	private JMenuItem mntmCopia;
	private JMenuItem mntmTaglia;
	private JMenuItem mntmIncolla;
}
