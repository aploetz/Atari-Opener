package atariopener;

import javax.swing.JFrame;

public class AtariOpenerMain {

	public static void main(String[] args) {

		JFrame openerFrame = new JFrame();
		openerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OpenerPanel panel = new OpenerPanel();

		openerFrame.add(panel);
		openerFrame.pack();
		openerFrame.setVisible(true);
		
		panel.start();
	}

}
