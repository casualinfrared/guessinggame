//GameUI class, Nathaniel Crosby.
//Last modified Thursday, 28 November 2019.
//This class is the main game UI. it also handles correct and incorrect answers
//i had a songselector class but i consolidated the code into this one.
import javax.swing.*; //JFrame, JPanel, JLabel, JButton, JTextField
import java.awt.*; //Colour
import java.awt.event.*; //ActionListener, ActionEvent
import javax.swing.border.*; //Border, BorderFactory
import java.util.*;
public class GameUI implements ActionListener
{
    private JFrame frame;
    private JPanel panel, buttonPanel1, scorePanel1;
    private Border border1;
    private JLabel title, description, correctGuesses, 
                   incorrectGuesses, correctornot, instruction;
    private JTextArea textArea1;
    private Font font1;
    private JTextField textField1;
    private JButton button1, button2, button3;
    private int correctScore=0,
                incorrectScore=0,
                num, randomSong;
    private final String[] songStr =  {"dance monkey", "don't start now", "ride it", "south of the border", "circles"
       , "lose you to love me", "good as hell", "memories", "bruises", "outnumbered"}; //array of strings of the songs
    private JMenu helpmenu, filemenu;
    private JMenuItem help, close;
    private JMenuBar menubar;
    
    public GameUI()
    {
       frame = new JFrame("Song Guessing Game"); //creates a new panel object and sets the window title
       panel = new JPanel(); //creates a new panel object
       buttonPanel1 = new JPanel(); //ditto
       scorePanel1 = new JPanel(); //ditto
       title = new JLabel("Guessing Game"); //creates a new label object
       instruction = new JLabel ("Please write the song title below:");
       correctornot = new JLabel();
       description = new JLabel("I am thinking of a hit song in the top 10 UK Singles Chart as of  12/11/2019");
       correctGuesses = new JLabel("Correct Guesses: 0");
       incorrectGuesses = new JLabel("Incorrect Guesses: 0");
       font1 = new Font("Calibri", Font.BOLD, 26); //defines the font for the welcome label.
       button1 = new JButton("Check Answer");
       button2 = new JButton("Exit"); //create start and exit buttons.
       button3 = new JButton ("Reset");
       textField1 = new JTextField();
       helpmenu = new JMenu("Help");
       filemenu = new JMenu("File");
       help = new JMenuItem("About");
       close = new JMenuItem("Close");
       menubar = new JMenuBar();
       
       //add menu bar and items to it
       menubar.add(filemenu);
       menubar.add(helpmenu); //adds the menu to the menubar
       helpmenu.add(help); //adds about box to submenu
       filemenu.add(close);
       frame.setJMenuBar(menubar); //adds the menubar to the frame
       
       //creates a new text area with the list of songs and the artist. It also sets the text area to non-editable by the user.
       textArea1 = new JTextArea("1. Dance Monkey - Tones & I\n2. Don't Start Now - Dua Lipa\n3. Ride It - Regard\n4. South of the Border - Ed Sheeran/Cabello/Cardi B\n5. Circles - Post Malone\n6. Lose You to Love Me - Selena Gomez\n7. Good as Hell - Lizzo\n8. Memories - Maroon 5\n9. Bruises - Lewis Capaldi\n10. Outnumbered - Dermot Kennedy");
       textArea1.setEditable(false);
       
       //changes the font of the title label to Calibri with size 26
       title.setFont(font1);
       
       //adds the panel to the frame
       frame.add(panel);
       
       //sets the frame to be non-resizable.
       frame.setResizable(false);
       
       //sets the background of the panel colour to white
       panel.setBackground(Color.white);
       
       //dunno what this does but it makes it work
       panel.setLayout(null);
       buttonPanel1.setLayout(null);
       scorePanel1.setLayout(null);
       
       //creates the border with a lowered bevel and applies the border to the button panel, the score panel and the song text area
       border1 = BorderFactory.createLoweredBevelBorder();
       buttonPanel1.setBorder(border1);
       scorePanel1.setBorder(border1);
       textArea1.setBorder(border1);
       
       //sets the dimentions and position of everything
       frame.setBounds(0,0,614,527);
       title.setBounds(214,0,200,50);
       description.setBounds(89,25,450,50);
       correctGuesses.setBounds(45,0,144,50);
       incorrectGuesses.setBounds(40,25,164,50);
       correctornot.setBounds(315,271,210,50);
       instruction.setBounds(305,296,290,50);
       textArea1.setBounds(15,75,575,202);
       buttonPanel1.setBounds(15,370,575,83);
       scorePanel1.setBounds(15,285,210,77);
       button1.setBounds(16,19,160,42);
       button2.setBounds(396,19,160,42);
       button3.setBounds(206,19,160,42);
       textField1.setBounds(235,336,355,25);
       
       //add everything except the buttons and the scores to the main panel
       panel.add(buttonPanel1);
       panel.add(scorePanel1);
       panel.add(title);
       panel.add(description);
       panel.add(instruction);
       panel.add(correctornot);
       panel.add(textArea1);
       panel.add(textField1);
       
       //add the buttons to the button panel
       buttonPanel1.add(button1);
       buttonPanel1.add(button2);
       buttonPanel1.add(button3);
       
       //add the score labels to the score panel
       scorePanel1.add(correctGuesses);
       scorePanel1.add(incorrectGuesses);
       
       //sets the window frame visible
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       //sets the default button to button1 (check answer) so it can be pressed when the user strikes the return key
       frame.getRootPane().setDefaultButton(button1);
       
       //makes buttons wait for the actionListener
       button1.addActionListener(this);
       button2.addActionListener(this);
       button3.addActionListener(this);
       close.addActionListener(this);
       help.addActionListener(this);
       
       //selects the song from the array up top.
       Random r=new Random();
       randomSong=r.nextInt(songStr.length);
    }
    public void actionPerformed(ActionEvent event)
    {
        //define str for comparison
        String str;
        if (event.getSource() == button1)
        {
         //gets text of what user entered into the textarea and converts it into a string
         str = textField1.getText();
         if (str.equalsIgnoreCase(songStr[randomSong])) //compares between strings str and songStr[randomSong]. equalsIgnoreCase makes the code ignore case.
         {    
             correctornot.setText("You've guessed CORRECTLY!"); //changes the label to reflect that you're correct
             correctScore ++; //add 1 to correctScore
             correctGuesses.setText("Correct Guesses: " + correctScore); //changes the label to reflect the new score
             Random r=new Random();
             randomSong=r.nextInt(songStr.length); //selects a new song
         }
         else //you were incorrect
         {
             correctornot.setText("You've guessed INCORRECTLY!"); //changes the label to reflect that you're incorrect
             incorrectScore ++; //add 1 to incorrectScore
             incorrectGuesses.setText("Incorrect Guesses: " + incorrectScore); //changes the label to reflect the new score
         }
        }
        if (event.getSource() == button2) //quit button
        {
            System.exit(0); //terminate
        }
        if (event.getSource() == button3) //reset button
        {
           new GameUI();
           frame.dispose();
        }
        if (event.getSource() == close)
        {
           System.exit(0);
        }
        if (event.getSource() == help)
        {
           new About();
        }
    }
}
