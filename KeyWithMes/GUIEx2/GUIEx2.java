/**
 * @author Christian Piper
 * @since 10/15/21
 */

package KeyWithMes.GUIEx2;

// Import Java libraries
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class GUIEx2 extends JFrame implements ActionListener {

    private JTextField instructionText;
    private JLabel textLabel;
    private JTextArea textArea;
    private JButton enterWord;
    private JButton exit;

    public GUIEx2() {
        super("Exploring Java's GUI");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        instructionText = new JTextField(5);
        textLabel = new JLabel("Enter a word");
        textArea = new JTextArea();
        textArea.setColumns(10);
        textArea.setRows(10);

        enterWord = new JButton("Enter Word");
        exit = new JButton("Exit");

        c.add(textLabel);
        c.add(instructionText);

        c.add(enterWord);
        enterWord.addActionListener(this);
        c.add(exit);
        exit.addActionListener(this);
        c.add(textArea);

        setSize(300,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent aEvent) {

        if (aEvent.getSource() == enterWord) {
            String message = instructionText.getText() + "\n";
            textArea.append(message);
        }
        else if (aEvent.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        GUIEx2 j = new GUIEx2();
    }
}
