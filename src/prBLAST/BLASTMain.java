package prBLAST;

import javax.swing.*;

public class BLASTMain {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Project Blast");
				BLASTVista vista = new BLASTVista();
				BLASTControl control = new BLASTControl(vista);

				vista.getbRequest().addActionListener(control);
				frame.getContentPane().add(vista);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			}
		};
		SwingUtilities.invokeLater(runnable);
	}

}
