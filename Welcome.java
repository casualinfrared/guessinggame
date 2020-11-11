
//Welcome class, Nathaniel Crosby.
//Last modified Wednesday, 13 November 2019.
//This class starts a welcome screen that tells the user
//what the game is about. When the start button is clicked, the game starts.
import javax.swing.*; //JFrame, JPanel, JLabel, JButton, JTextField
import java.awt.*; //Colour
import java.awt.event.*; //ActionListener, ActionEvent
import javax.swing.border.*; //Border, BorderFactory
public class Welcome implements ActionListener
{
    private JFrame frame;
    private JPanel panel, buttonPanel1;
    private Border border1;
    private JLabel title;
    private JTextArea textArea1;
    private Font font1;
    private JButton button1, button2;
    private JMenu helpmenu, filemenu;
    private JMenuItem help, close;
    private JMenuBar menubar;
    /**
     * Constructor for objects of class Welcome
     */
    public Welcome()
    {
       frame = new JFrame("Welcome"); //creates a new panel object and sets the window title
       panel = new JPanel(); //creates a new panel object
       buttonPanel1 = new JPanel(); //ditto
       title = new JLabel("Guessing Game"); //creates a new label object
       font1 = new Font("Calibri", Font.BOLD, 26); //defines the font for the welcome label.
       button1 = new JButton("Start");
       button2 = new JButton("Exit"); //create start and exit buttons.
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
       
       //create a new textarea that explains what the game is about.
       textArea1 = new JTextArea("Welcome to a guessing game by Nathaniel Crosby.\nThis game will display the top 10 hit songs on the UK singles chart\nas of Tuesday, 12 November 2019.\nYou will be asked to guess the song the computer is thinking of.\nThe game will tell you if you're correct or incorrect.\nThe game will keep score of correct and incorrect answers.\n\nTo start the game, click start.\nTo exit the game, click exit.\n\nThis program © Nathaniel Crosby 2019.");
       textArea1.setEditable ( false );
       
       title.setFont ( font1 );
       
       frame.add ( panel ); //adds the panel to the frame.
       frame.setResizable(false); //makes the window frame a fixed size.
       
       panel.setBackground(Color.white); //sets the panel background colour to white.
       panel.setLayout ( null );
       
       buttonPanel1.setLayout ( null );
       
       //sets the border of the button panel to a lowered bevel one
       border1 = BorderFactory.createLoweredBevelBorder();
       buttonPanel1.setBorder ( border1 ); //sets the border of buttonPanel1 to border1
       textArea1.setBorder ( border1 );
       
       frame.setBounds (0,0,433,378); //sets the bounds of the frame
       title.setBounds (121,0,200,50); //sets the bounds of the title label
       buttonPanel1.setBounds (16,230,394,80);
       textArea1.setBounds (16,40,394,180);
       button1.setBounds (16,19,80,42);
       button2.setBounds (297,19,80,42);
       
       //adds the thingies to the panel
       panel.add (buttonPanel1);
       panel.add (title);
       panel.add (textArea1);
       buttonPanel1.add (button1);
       buttonPanel1.add (button2);
       
       frame.setLocationRelativeTo(null);
       frame.setVisible ( true ); //sets the frame visible
       frame.getRootPane().setDefaultButton(button1); //sets default button to button1 so you can press enter key to start
       
       // Register buttons
       button1.addActionListener(this);
       button2.addActionListener(this);
       help.addActionListener(this);
       close.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event)
    {
        if ( event.getSource() == button1 )
        {
            new GameUI(); //starts the GameUI class
            frame.dispose(); //quits welcome.
        }
        if ( event.getSource() == button2 )
        {
            System.exit(0); //exits the program.
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
