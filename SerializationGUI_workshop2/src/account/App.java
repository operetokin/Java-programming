package account;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;



public class App {
	public static void main(String[] args)
	{
		InfoPanel infoPanel = new InfoPanel();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(800, 450));
		window.setTitle("Serialize Me!!!");
		window.setContentPane(infoPanel);
		window.setVisible(true);
		window.setLayout(null);
	}
}
