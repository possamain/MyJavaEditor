import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextPaneAttributes extends JFrame {
	private static final long serialVersionUID = -8550678834314816950L;
	JTextPane textPane;
	StyledDocument doc;
	AscoltatoreEventiAzione listener = new AscoltatoreEventiAzione();

	public TextPaneAttributes() {
		textPane = new JTextPane();
		textPane.setEditable(true);
		textPane.addKeyListener(listener);
		Font font = new Font("Monaco", Font.BOLD, 12);
		doc = textPane.getStyledDocument();
		MutableAttributeSet attrs = textPane.getInputAttributes();
		StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_LEFT);
		doc.setParagraphAttributes(0, 0, attrs, true);
		StyleConstants.setFontFamily(attrs, font.getFamily());
		StyleConstants.setFontSize(attrs, font.getSize());
		StyleConstants.setBold(attrs, true);
		StyleConstants.setForeground(attrs, Color.black);

		doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		getContentPane().add(scrollPane);
	}// costruttore

	private class AscoltatoreEventiAzione implements ActionListener, KeyListener {

		@Override
		public void actionPerformed(ActionEvent ev) {

		}// action performed

		@Override
		public void keyPressed(KeyEvent ev) {

		}// keyPressed

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@Override
		public void keyReleased(KeyEvent ev) {
			if (ev.getID() == KeyEvent.KEY_RELEASED && ev.getSource() == textPane) {
				String tmp = textPane.getText();
				if (tmp.indexOf("prova") != -1) {
					MutableAttributeSet attrs = textPane.getInputAttributes();
					int i = tmp.indexOf("prova");
					while (true) {
						if (i == -1)
							break;
						else {
							StyleConstants.setForeground(attrs, Color.blue);
							doc.setCharacterAttributes(i, i + 5, attrs, false);
							StyleConstants.setForeground(attrs, Color.black);
							doc.setCharacterAttributes(i + 5, doc.getLength() + 1, attrs, false);
							i += 5;
							i = tmp.indexOf("prova", i);
						}
					} // while della prova
				} // if per colorare "prova"

				if (tmp.indexOf("ADD") != -1) {
					MutableAttributeSet attrs = textPane.getInputAttributes();
					int i = tmp.indexOf("ADD");
					System.out.println("Primo indice i per ADD " + i);
					while (true) {
						if (i == -1)
							break;
						else {
							StyleConstants.setForeground(attrs, Color.green);
							doc.setCharacterAttributes(i, i + 3, attrs, false);
							StyleConstants.setForeground(attrs, Color.black);
							doc.setCharacterAttributes(i + 3, doc.getLength() + 1, attrs, false);
							i += 3;
							i = tmp.indexOf("ADD", i);
							System.out.println("Prossima pasozione della parola ADD" + i);
						}
					} // while della prova
				}

			} // if
		}// keyReleased

		@Override
		public void keyTyped(KeyEvent ev) {

		}// keyTyped

	}// AscoltatoreEventiAzione

	public static void main(String[] args) {
		TextPaneAttributes frame = new TextPaneAttributes();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}// main
}// TextPane attributes