package prBLAST;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import blast.BlastController;
public class BLASTControl implements ActionListener {

	private BLASTVista vista; // con esto accedemos a nuestra clase BLASTVista

	public BLASTControl(BLASTVista v) {
		this.vista = v;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.getbRequest())) { // si pulsamos el boton 'Request'...
			if (vista.getCbSequences().getSelectedItem() == null || vista.getTfPercent().getText().equals("")) { 	//si las secuencia del CB es null o el porcentaje 
				vista.getTaArea().setText("ERROR: fields not completed");									// esta vacio: ERROR
			}								

			else {
				float f = Float.parseFloat(vista.getTfPercent().getText()); 	//creamos na variable para almacenar el porcentaje que se introduce
				if (f < 0.1 || f > 1.0) {										//si el pocentaje no esta en esos limites: ERROR
					vista.getTaArea().setText("ERROR: invalid percentage");
				}

				else {
					String Seq = vista.getCbSequences().getSelectedItem().toString().toUpperCase();	//Creamos una variable para almacenar la secuencia del CB en mayusculas
					if (!AlreadySearched(Seq)) {												//Si no esta almacenada: 
						vista.getCbSequences().addItem(Seq);											//La añadimos al CB
					}

					char b;
					if (vista.getRbProtein().isSelected()) {	//si se selecciona el radioboton proteinas
						b = 'p';
						String result = BLASTSubmitQuery(Seq, f, b);	//se muestra por pantalla el resultado de la peticion
						vista.getTaArea().setText(result);
					} else {
						vista.getTaArea().setText("Nucleotid search is not available");
					}
				}
			}
		}
	}	

	// metodo para comparar si hay secuencias duplicacdas
	public boolean AlreadySearched(String a) {
		int length = vista.getCbSequences().getItemCount();
		for (int i = 0; i < length; i++) {
			String actualSeq = vista.getCbSequences().getItemAt(i).toString();
			if (actualSeq.equals(a)) {
				return true;
			}
			
		}
		return false;
	}

	public String BLASTSubmitQuery(String Seq, float f, char b) {
		String dataSearchFile = vista.getCbSearchFile().getSelectedItem().toString();
		String dataIndexFile = vista.getCbIndexFile().getSelectedItem().toString();
		BlastController bCnt = new BlastController();
		String FinalResult = "";
		try {
			FinalResult = bCnt.blastQuery('p', dataSearchFile, dataIndexFile, f, Seq);
		} catch (Exception exc) {
			System.out.println("ERROR while calling: " + exc.toString());
		}
		return FinalResult;

	}
}
