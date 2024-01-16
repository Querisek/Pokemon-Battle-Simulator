import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JFrame {
	String battleStart;
	Pokemon charizard;
	Pokemon blastoise;
	Pokemon ivysaur;
	Pokemon gengar;
	Pokemon raichu;
	Pokemon gyarados;
	Pokemon playersPokemon;
	String chosenPokemon;
	String enemyName;
	String enemyLabel;
	Pokemon enemy = new Pokemon((int) (Math.random() * (500) + (250)), (int) (Math.random() * (70) + (25)));
	JPanel panel;
	String selectedPokemon;
	int attackPower;
	int enemyPower;
	String result;
	String win;
	FileWriter fileW;
    PrintWriter printW;
	
	  public GUI() {
		  
	        setTitle("Pokemon battle simulator");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(800, 600);
	        
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        
	        int X = (int) (screenSize.getWidth() / 2 - getWidth() / 2);
	        int Y = (int) (screenSize.getHeight() / 2 - getHeight() / 2);
	        
	        setLocation(X, Y);
	        
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        JLabel selectPokemon = new JLabel("Select your pokemon!", JLabel.CENTER);
	        selectPokemon.setFont(new Font("Arial", Font.BOLD, 24));
	        selectPokemon.setBorder(new EmptyBorder(30, 0, 0, 0));
	        panel.add(selectPokemon, BorderLayout.NORTH);
	        
	        battleStart = "To start a battle,\nclick the button 'Attack'.\n";

	        JPanel pokemons = new JPanel(new GridLayout(2, 3));

	        ImageIcon charizardPNG = new ImageIcon(getClass().getResource("images/charizard.png"));
	        JLabel charizardLabel = new JLabel("", new ImageIcon(charizardPNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        charizardLabel.addMouseListener(new ImageClickListener(charizardLabel));
	        charizardLabel.setName("charizard");
	        pokemons.add(charizardLabel);

	        ImageIcon blastoisePNG = new ImageIcon(getClass().getResource("images/blastoise.png"));
	        JLabel blastoiseLabel = new JLabel("", new ImageIcon(blastoisePNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        blastoiseLabel.addMouseListener(new ImageClickListener(blastoiseLabel));
	        blastoiseLabel.setName("blastoise");
	        pokemons.add(blastoiseLabel);

	        ImageIcon ivysaurPNG = new ImageIcon(getClass().getResource("images/ivysaur.png"));
	        JLabel ivysaurLabel = new JLabel("", new ImageIcon(ivysaurPNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        ivysaurLabel.addMouseListener(new ImageClickListener(ivysaurLabel));
	        ivysaurLabel.setName("ivysaur");
	        pokemons.add(ivysaurLabel);

	        ImageIcon gyaradosPNG = new ImageIcon(getClass().getResource("images/gyarados.png"));
	        JLabel gyaradosLabel = new JLabel("", new ImageIcon(gyaradosPNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        gyaradosLabel.addMouseListener(new ImageClickListener(gyaradosLabel));
	        gyaradosLabel.setName("gyarados");
	        pokemons.add(gyaradosLabel);

	        ImageIcon gengarPNG = new ImageIcon(getClass().getResource("images/gengar.png"));
	        JLabel gengarLabel = new JLabel("", new ImageIcon(gengarPNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        gengarLabel.addMouseListener(new ImageClickListener(gengarLabel));
	        gengarLabel.setName("gengar");
	        pokemons.add(gengarLabel);

	        ImageIcon raichuPNG = new ImageIcon(getClass().getResource("images/raichu.png"));
	        JLabel raichuLabel = new JLabel("", new ImageIcon(raichuPNG.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
	        raichuLabel.addMouseListener(new ImageClickListener(raichuLabel));
	        raichuLabel.setName("raichu");
	        pokemons.add(raichuLabel);
	        
	        panel.add(pokemons, BorderLayout.CENTER);

	        add(panel);
	    }
	  
	  private class ImageClickListener implements MouseListener {
		  
		    private JLabel pokemonPlayer;

		    public ImageClickListener(JLabel pokemon) {
		        this.pokemonPlayer = pokemon;
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {

		        Icon chosenPNG = pokemonPlayer.getIcon();
		        chosenPokemon = pokemonPlayer.getName();
		        
		        try {
		            FileWriter fileWriter = new FileWriter("yourPokemon.txt");
		            PrintWriter printWriter = new PrintWriter(fileWriter);
		            printWriter.println(chosenPokemon);
		            printWriter.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }

		        try {
		            File file = new File("yourPokemon.txt");
		            Scanner scanner = new Scanner(file);
		            selectedPokemon = scanner.nextLine();
		            scanner.close();
		        } catch (IOException ex) {
		        	ex.printStackTrace();
		        }
		        
	    	    playersPokemon = new Pokemon((int) (Math.random() * (600) + (400)), (int) (Math.random() * (90) + (30)));

		        JPanel PNGPanel = (JPanel) getContentPane().getComponent(0);
		        PNGPanel.removeAll();
		        
		        JPanel chosenPanel = new JPanel(new BorderLayout());
		       
		        JTextArea textArea = new JTextArea(20, 20);
		        textArea.setBackground(Color.GRAY);
		        textArea.setEditable(false);
		        textArea.setText(battleStart);
		        textArea.setForeground(Color.WHITE);
		        Border border = BorderFactory.createLineBorder(Color.BLACK);
		        textArea.setBorder(BorderFactory.createCompoundBorder(border, border));
		        
		        JScrollPane centerScroll = new JScrollPane(textArea);
		         
		        JPanel centerSubPanel = new JPanel();

		        JLabel chosenLabel = new JLabel("", chosenPNG, JLabel.CENTER);
		        chosenPanel.add(chosenLabel, BorderLayout.WEST);
		        
		        JButton attackButton = new JButton("Attack");
		        JPanel attackPanel = new JPanel();
		        
		        JButton returnButton = new JButton("Return");
		        returnButton.setEnabled(false);
		        
		        JButton battlelogButton = new JButton("Battle log");
		        
		        JPanel buttonsPanel = new JPanel(new FlowLayout());
		        buttonsPanel.add(attackButton);
		        buttonsPanel.add(returnButton);
		        buttonsPanel.add(battlelogButton);
		        
		        
		        ImageIcon[] images = {
		                new ImageIcon(getClass().getResource("images/charizard.png")),
		                new ImageIcon(getClass().getResource("images/blastoise.png")),
		                new ImageIcon(getClass().getResource("images/ivysaur.png")),
		                new ImageIcon(getClass().getResource("images/gyarados.png")),
		                new ImageIcon(getClass().getResource("images/gengar.png")),
		                new ImageIcon(getClass().getResource("images/raichu.png"))
		        };
		        
		        int randomIndex = (int) (Math.random() * images.length);
		        ImageIcon randomPokemon = images[randomIndex];
		        JLabel randomLabel = new JLabel("", new ImageIcon(randomPokemon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)), JLabel.CENTER);
		        enemyLabel = "label" + Integer.toString(randomIndex + 1);
		        chosenPanel.add(randomLabel, BorderLayout.EAST);
		        chosenPanel.add(centerSubPanel, BorderLayout.CENTER);
		        centerSubPanel.add(centerScroll, BorderLayout.CENTER);
		        chosenPanel.add(buttonsPanel, BorderLayout.SOUTH);
		        centerSubPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
		        attackPanel.setBorder(new EmptyBorder(0, 0, 50, 0));
		        
		        PNGPanel.add(chosenPanel);
		        	        
		        
		        attackButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                if (playersPokemon.getHealth() > 0) {
		                    attackPower = (int) (Math.random() * (playersPokemon.getAttack() + 10) + (playersPokemon.getAttack() - 10));
		                    enemyPower = (int) (Math.random() * (enemy.getAttack() + 10) + (enemy.getAttack() - 10));
		                    enemy.setHealth((int) (enemy.getHealth() - attackPower));
		                    playersPokemon.setHealth((int) (playersPokemon.getHealth() - enemyPower));
		                    textArea.append("\nYou are attacking!\n"
		                        + "You dealt " + attackPower + " damage.\n" +
		                        "Your opponent has " + enemy.getHealth() + "\nhealth points left.\n");
		                    if (enemy.getHealth() <= 0) {
		                        textArea.append("\nYou won!.");
		                        attackButton.setEnabled(false);
		                        returnButton.setEnabled(true);
		                        try {
		                            File f = new File("Battle_Log.txt");
		                            FileWriter fw = new FileWriter(f);
		                            PrintWriter writer = new PrintWriter(fw);
		                            String text = textArea.getDocument().getText(0, textArea.getDocument().getLength());
		                            writer.println(text);
		                            writer.close();
		                        } catch (IOException ioe) {
		                            textArea.setText("Error during saving has occurred.");
		                        } catch (BadLocationException e1) {
		                            e1.printStackTrace();
		                        }
		                        
		                        result = "Battle result: win";
		                        
		                        try {
		                            FileWriter fw = new FileWriter("battleHistory.txt", true);
		                            PrintWriter writer = new PrintWriter(fw);
		                            writer.append("Battle result " + "(" + selectedPokemon + ")" + " : win\n");
		                        	writer.close();
		                        } catch (IOException ex) {
		                            System.out.println("Error during saving has occurred.");
		                        }
		                        
		                        return;
		                    }
		                    textArea.append("\nYour opponent is attacking!\n"
		                        + "He dealt " + enemyPower + " damage.\n" +
		                        "You have " + playersPokemon.getHealth() + "\nhealth points left.\n");
		                    if (playersPokemon.getHealth() <= 0) {
		                        textArea.append("\nYou lost!");
		                        attackButton.setEnabled(false);
		                        returnButton.setEnabled(true);
		                        try {
		                            File f = new File("Battle_Log.txt");
		                            FileWriter fw = new FileWriter(f);
		                            PrintWriter writer = new PrintWriter(fw);
		                            String text = textArea.getDocument().getText(0, textArea.getDocument().getLength());
		                            writer.println(text);
		                            writer.close();
		                        } catch (IOException ioe) {
		                            textArea.setText("Error during saving has occurred.");
		                        } catch (BadLocationException e1) {
		                            e1.printStackTrace();
		                        }
		                        
		                        try {
		                            FileWriter fw = new FileWriter("battleHistory.txt", true);
		                            PrintWriter writer = new PrintWriter(fw);
		                            writer.append("Battle result " + "(" + selectedPokemon + ")" + " : lose\n");
		                        	writer.close();
		                        } catch (IOException ex) {
		                            System.out.println("Error during saving has occurred.");
		                        }
		                        
		                        return;
		                    }
		                }				        
		            }
		        });
		        
                returnButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                chosenPokemon = null;
			                selectedPokemon = null;
			                enemyName = null;
			                enemyLabel = null;
			                battleStart = "To start a battle,\nclick the button 'Attack'.\n";
			                playersPokemon = null;
			                enemy = new Pokemon((int) (Math.random() * (500) + (250)), (int) (Math.random() * (70) + (25)));
			                attackPower = 0;
			                enemyPower = 0;

			                setVisible(false);
			                dispose();

			                GUI newGUI = new GUI();
			                newGUI.setVisible(true);
			                newGUI.setResizable(false);
			            }
			        });
		       
		        
		        battlelogButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {

		                chosenPokemon = null;
		                selectedPokemon = null;
		                enemyName = null;
		                enemyLabel = null;
		                battleStart = "To start a battle,\nclick the button 'Attack'.\n";
		                playersPokemon = null;
		                enemy = new Pokemon(500, 50);
		                attackPower = 0;
		                enemyPower = 0;
		                
		                setVisible(false);
		                dispose();
		                
		                GUI newGUI = new GUI();
		                JPanel panelv2 = new JPanel(new BorderLayout());
		                newGUI.add(panelv2);
		                
		                JTextArea textAreav2 = new JTextArea(20, 40);
				        textAreav2.setBackground(Color.GRAY);
				        textAreav2.setEditable(false);
				        textAreav2.setForeground(Color.WHITE);
				        
				        try {
				            File file = new File("battleHistory.txt");
				            Scanner scanner = new Scanner(file);
				            while(scanner.hasNextLine())
				            {
				            textAreav2.append(scanner.nextLine() + "\n");
				            }
				            scanner.close();
				        } catch (IOException ex) {
				        	ex.printStackTrace();
				        }
				        
				        JScrollPane centerScrollv2 = new JScrollPane(textAreav2);
				         
				        JPanel centerSubPanelv2 = new JPanel();
				        Border border = BorderFactory.createLineBorder(Color.BLACK);
				        textAreav2.setBorder(BorderFactory.createCompoundBorder(border, border));
				        centerSubPanelv2.setBorder(new EmptyBorder(100, 0, 0, 0));
				        centerSubPanelv2.add(centerScrollv2, BorderLayout.CENTER);
				        panelv2.add(centerSubPanelv2, BorderLayout.CENTER);
				        
				        JButton returnButton = new JButton("Return");
				        JPanel buttonsPanelv2 = new JPanel(new FlowLayout());
				        buttonsPanelv2.add(returnButton);
				        
				        panelv2.add(buttonsPanelv2, BorderLayout.SOUTH);
				        
		                newGUI.setVisible(true);
		                newGUI.setResizable(false);
		                
		                returnButton.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {

				                newGUI.setVisible(false);
				                newGUI.dispose();

				                GUI newGUI = new GUI();
				                newGUI.setVisible(true);
				                newGUI.setResizable(false);
				            }
				        });
		            }
		        });
		        
		        PNGPanel.revalidate();
		        PNGPanel.repaint();
		    }

		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {

		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {

		    }

		    @Override
		    public void mousePressed(java.awt.event.MouseEvent e) {

		    }

		    @Override
		    public void mouseReleased(java.awt.event.MouseEvent e) {

		    }
		    
		}
}


