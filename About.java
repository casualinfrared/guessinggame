//Welcome class, Nathaniel Crosby.
//Last modified Thursday, 28 November 2019
import javax.swing.*; //basically everything here
import java.awt.*; //Colour
import java.awt.event.*; //ActionListener, ActionEvent
import javax.swing.border.*; //Border, BorderFactory
public class About implements ActionListener
{
    private JFrame frame;
    private JPanel panel, buttonPanel1;
    private Border border1;
    private JLabel title;
    private JTextArea textArea1;
    private Font font1;
    private JButton button1;
    private JScrollPane scroll;
    /**
     * Constructor for objects of class About
     */
    public About()
    {
       frame = new JFrame("About Guessing Game"); //creates a new panel object and sets the window title
       panel = new JPanel(); //creates a new panel object
       buttonPanel1 = new JPanel(); //ditto
       title = new JLabel("Guessing Game"); //creates a new label object
       font1 = new Font("Calibri", Font.BOLD, 26); //defines the font for the welcome label.
       button1 = new JButton("OK");
       scroll = new JScrollPane(textArea1);
       //create a new textarea that explains what the game is about.
       textArea1 = new JTextArea(16,58);
       textArea1.setEditable ( false );
       textArea1.setText ("Guessing Game by Nathaniel Crosby. Version 1.03\nBuilt Thursday, 28 November 2019.\nThis program is free software: you can redistribute it and/or modify\nit under the terms of the GNU General Public License as published by\nthe Free Software Foundation, either version 3 of the License,\nor(at your option) any later version.\n\nThis program is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. \nSee the GNU General Public License for more details.\n\nYou should have received a copy of the GNU General Public License\nalong with this program.  If not, see <https://www.gnu.org/licenses/>.");
       scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
       
       frame.setBounds (0,0,433,418); //sets the bounds of the frame
       title.setBounds (121,5,200,50); //sets the bounds of the title label
       buttonPanel1.setBounds (16,290,394,80);
       textArea1.setBounds (16,50,394,235);
       button1.setBounds (116,19,160,42);
       
       //adds the thingies to the panel
       panel.add (buttonPanel1);
       panel.add (title);
       panel.add (textArea1);
       panel.add (scroll);
       buttonPanel1.add (button1);
       
       frame.setLocationRelativeTo(null);
       frame.setVisible ( true ); //sets the frame visible
       frame.getRootPane().setDefaultButton(button1); //sets default button to button1 so you can press enter key to start
       
       // Register buttons
       button1.addActionListener(this);
       
      }
    public void actionPerformed(ActionEvent event)
    {
        if ( event.getSource() == button1 )
        {
            frame.dispose(); //quits welcome.
        }
    }
}
