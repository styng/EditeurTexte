package ihm;

import modele.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;

public class IHMGraphique extends JFrame implements IHM
{
	private ZoneTexteImpl zT_;

	private JPanel container, buttons;
	private JTextPane text;
	private JScrollPane scrollPane;
	private JLabel selecLabel;

	public IHMGraphique(ZoneTexteImpl zT){
		this.zT_ = zT;

		container = new JPanel();
		buttons = new JPanel();
		text = new JTextPane();
		scrollPane = new JScrollPane(text);
		selecLabel = new JLabel("No selection");

		this.setSize(800, 600);
		this.setTitle("Editeur de texte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		text.setCaretPosition(0);
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				ActionZoneTexte ecrire = new Ecrire(zT_, text.getText());
				ecrire.execute();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		text.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				displaySelectionInfo(e.getDot(), e.getMark());
			}

			protected void displaySelectionInfo(final int dot,
												final int mark) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						if (dot == mark) {  // no selection
							selecLabel.setText("No selection");
						} else if (dot < mark) {
							selecLabel.setText("selection from: " + dot
									+ " to " + mark + "\n");
							ActionZoneTexte command = new Selectionner(zT_, dot, mark);
							command.execute();
						} else {
							selecLabel.setText("selection from: " + mark
									+ " to " + dot + "\n");
							ActionZoneTexte command = new Selectionner(zT_, mark, dot);
							command.execute();
						}
					}
				});
			}
		});
		text.setMargin(new Insets(5,5,5,5));
		scrollPane.setPreferredSize(new Dimension(785, 500));

		JButton copier = new JButton("Copier");
		JButton coller = new JButton("Coller");
		JButton couper = new JButton("Couper");

		copier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(text.getSelectedText() != null){
					ActionZoneTexte copier = new Copier(zT_);
					copier.execute();
					text.setSelectionEnd(0);
				}
			}
		});
		coller.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		couper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(text.getSelectedText() != null){
					ActionZoneTexte couper = new Couper(zT_);
					couper.execute();
					text.setText(zT_.getTexte());
					text.setSelectionEnd(0);
				}
			}
		});

		buttons.add(copier);
		buttons.add(coller);
		buttons.add(couper);

		container.setLayout(new FlowLayout(FlowLayout.LEFT));
		container.add(buttons);
		container.add(scrollPane);
		container.add(selecLabel);

	}

	@Override
	public void demarrer() 
	{
		this.setContentPane(container);
		this.setVisible(true);
	}
}


