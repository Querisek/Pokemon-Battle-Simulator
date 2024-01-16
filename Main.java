import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setResizable(false);
        
        try {
        	File f = new File("battleHistory.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter writer = new PrintWriter(fw);
            writer.print("");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error during saving has occurred.");
        }

	}

}
