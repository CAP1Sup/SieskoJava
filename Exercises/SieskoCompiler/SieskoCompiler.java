/**
 * @author Christian Piper
 * @since 10/19/21
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SieskoCompiler extends JFrame implements ActionListener {

    JLabel instLabel;
    JButton ok, run;
    JTextField instField;
    JTextArea codeArea;

    String[] code;
    int codeIndexCounter;
    String codeDisplay;

    float[] memAddress;

    SieskoCompiler() {
        super("Siesko Coding Language IDE");

        instLabel = new JLabel("Instruction");
        ok = new JButton("OK");
        run = new JButton("Run Program");
        instField = new JTextField();
        codeArea = new JTextArea();

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(instLabel);
        c.add(ok);
        c.add(run);
        c.add(instField);
        c.add(codeArea);

        setSize(300, 300);
        setVisible(true);

        code = new String[100];
        codeIndexCounter = 0;
        codeDisplay = "";

        float[] memAddress = new float[50];
    }

    public void actionPerformed(ActionEvent aEvent) {

        if (aEvent.getSource() == ok) {

            // Save a new value to the code array
            code[codeIndexCounter] = instField.getText();
            codeIndexCounter++;

            // Add to the code display, then display said string
            codeDisplay += instField.getText() + "\n";
            codeArea.setText(codeDisplay);

            // Clear the instruction box
            instField.setText("");
        }
        else if (aEvent.getSource() == run) {

            // Loop through the entire instruction set
            for (String instruction : code) {

                int optCode = 0;
                int params = 0;

                // Split the instruction into optCode and params
                try {
                    optCode = (int)instruction.substring(0, 2);
                    params = (int)instruction.subSequence(2);
                } catch (Exception e) {
                    System.out.println("Issue with instruction: " + instruction);
                    continue;
                }

                // Execute the correct instruction
                switch (optCode) {
                    case 10: {

                    }

                }

            }

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SieskoCompiler c = new SieskoCompiler();
    }
}
