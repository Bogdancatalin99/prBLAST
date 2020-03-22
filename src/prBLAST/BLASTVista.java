package prBLAST;

import javax.swing.*;
import java.awt.*;

public class BLASTVista extends JPanel {


	
	// Ordenamos la interfaz por paneles donde cada uno tiene sus elementos:
	private JPanel pSearch; // --> Panel que contiene la secuencia y el porcentaje.
	private JLabel lSeq;
	private JComboBox <String> cbSequences;
	private JLabel lPercent;
	private JTextField tfPercent;
	// ---

	private JPanel pButtons; // --> Panel que contiene los botones de seq y nucleotidos
	private JRadioButton rbProtein;
	private JLabel lProteinButton;
	private JRadioButton rbNucleotidSeq;
	private JLabel lNucleotidSeqButton;
	// ---

	private JPanel pFiles; // --> Panel que contiene el archivo de busqueda y el de indices.
	private JLabel lSearchFile;
	private JComboBox <String> cbSearchFile;
	private JLabel lIndexFile;
	private JComboBox <String> cbIndexFile;
	// ---

	private JPanel pRequest; // --> Pannel que contiene el boton de buscar el el area de texto.
	private JButton bSearch;
	private JTextArea taArea;
	private JScrollPane sBar;
	//---
	
// jmap	private JPanel pAll; // --> Panel que contiene a los anteriores.

//	public void BLASTvista() {
	public BLASTVista() {

		// Ordenamos el panel 'pSearch':
		pSearch = new JPanel();
		pSearch.setLayout(new GridLayout(2, 2)); // Creamos las dimensiones del panel

		lSeq = new JLabel("Sequence:");
		pSearch.add(lSeq);
		cbSequences = new JComboBox <String> (); // Establecemos que se pueda editar el cbSeq
		cbSequences.setEditable(true);
		pSearch.add(cbSequences);
		
		lPercent = new JLabel("Percent");
		pSearch.add(lPercent);
		tfPercent = new JTextField("", 15);
		pSearch.add(tfPercent);

		

		// Ordenamos el panel 'pFiles':
		pFiles = new JPanel();
		pFiles.setLayout(new GridLayout(2, 2)); // Creamos las dimensiones del panel

		lSearchFile = new JLabel("Search File:");
		pFiles.add(lSearchFile);
		cbSearchFile = new JComboBox <String> (); // A�adimos el archivo de las secuencias al cbSearchFile
		String sequences = "yeast.aa";
		cbSearchFile.addItem(sequences);
		pFiles.add(cbSearchFile);
		
		lIndexFile = new JLabel("Index File:");
		pFiles.add(lIndexFile);
		cbIndexFile = new JComboBox <String> (); // A�adimos el archivode indices al cbIndexFile
		String indexes = "yeast.aa.indexs";
		cbIndexFile.addItem(indexes);
		pFiles.add(cbIndexFile);
	

		// Ordenamos el 'pButtons':
		pButtons = new JPanel();
		pButtons.setLayout(new GridLayout(2, 1)); // Creamos las dimensiones del panel

		rbProtein = new JRadioButton();
		rbProtein.setSelected(true);
		pButtons.add(rbProtein);
		lProteinButton = new JLabel("Protein");
		pButtons.add(lProteinButton);
		
		rbNucleotidSeq = new JRadioButton();
		pButtons.add(rbNucleotidSeq);
		lNucleotidSeqButton = new JLabel("Nucleotid sequence");
		pButtons.add(lNucleotidSeqButton);

		ButtonGroup bgButtons = new ButtonGroup();
		bgButtons.add(rbProtein);
		bgButtons.add(rbNucleotidSeq);
		// Ordenamos el 'pRequest':
		pRequest = new JPanel();
		pRequest.setLayout(new GridLayout(1, 3));
		bSearch = new JButton("Search");
		pRequest.add(bSearch);

		taArea = new JTextArea();
		taArea.setEditable(false);
		//pRequest.add(taArea);

		sBar = new JScrollPane(taArea);
		sBar.setSize(getPreferredSize());
		pRequest.add(sBar);
		
		//Ordenamos el panel con todos los demas paneles:
//jmap		pAll = new JPanel();
		this.setLayout(new GridLayout(4,1));
		this.add(pFiles);
		this.add(pSearch);
		this.add(pButtons);
		this.add(pRequest);
		
		
//jmap		this.add(pAll);

	}

	public JPanel getpSearch() {
		return pSearch;
	}

	public JLabel getlSeq() {
		return lSeq;
	}

	public JComboBox <String> getCbSequences() {
		return cbSequences;
	}

	public JLabel getlPercent() {
		return lPercent;
	}

	public JTextField getTfPercent() {
		return tfPercent;
	}

	public JPanel getpButtons() {
		return pButtons;
	}

	public JRadioButton getRbProtein() {
		return rbProtein;
	}

	public JLabel getlProteinButton() {
		return lProteinButton;
	}

	public JRadioButton getRbNucleotidSeq() {
		return rbNucleotidSeq;
	}

	public JLabel getlNucleotidSeqButton() {
		return lNucleotidSeqButton;
	}

	public JPanel getpFiles() {
		return pFiles;
	}

	public JLabel getlSearchFile() {
		return lSearchFile;
	}

	public JComboBox<String> getCbSearchFile() {
		return cbSearchFile;
	}

	public JLabel getlIndexFile() {
		return lIndexFile;
	}

	public JComboBox<String> getCbIndexFile() {
		return cbIndexFile;
	}

	public JPanel getpRequest() {
		return pRequest;
	}

	public JButton getbSearch() {
		return bSearch;
	}

	public JTextArea getTaArea() {
		return taArea;
	}

	public JScrollPane getsBar() {
		return sBar;
	}

}
