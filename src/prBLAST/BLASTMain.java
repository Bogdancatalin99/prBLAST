package prBLAST;

import javax.swing.*;

public class BLASTMain {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Project Blast");
				BLASTVista vista = new BLASTVista();
				BLASTControl control = new BLASTControl(vista);

				vista.getbSearch().addActionListener(control);
//jmap				frame.getContentPane().add(vista);
				frame.setContentPane(vista); // jmap
				frame.pack();
				frame.setVisible(true);
//jmap				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //jmap
			}
		};
		SwingUtilities.invokeLater(runnable);
	}

}
