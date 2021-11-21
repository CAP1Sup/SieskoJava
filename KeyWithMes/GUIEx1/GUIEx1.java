/**
 * @author Christian Piper
 * @since 10/6/21
 */
package KeyWithMes.GUIEx1;

// Import the Java GUI library
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIEx1 extends JFrame implements ActionListener {

  private JTextField userName;
  private JPasswordField password;
  private JLabel userLabel;
  private JLabel passLabel;
  private JButton ok;
  private JButton exit;

  GUIEx1() {
    super("Login Dialog");

    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    // Construct labels
    userLabel = new JLabel("Username: ");
    passLabel = new JLabel("Password: ");

    // Construct text fields
    userName = new JTextField(10);
    password = new JPasswordField(10);

    // Construct buttons
    ok = new JButton("ok");
    exit = new JButton("Exit");

    // Add each object to the container
    c.add(userLabel);
    c.add(userName);
    c.add(passLabel);
    c.add(password);
    c.add(ok);
    c.add(exit);

    ok.addActionListener(this);
    exit.addActionListener(this);

    // Set the size
    setSize(250, 150);
    setVisible(true);

    // Set the program to exit when the window is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == ok) {
      JOptionPane.showMessageDialog(null, "Hit the DB to test username and password");
    } else if (ae.getSource() == exit) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    GUIEx1 gui = new GUIEx1();
  }
}
