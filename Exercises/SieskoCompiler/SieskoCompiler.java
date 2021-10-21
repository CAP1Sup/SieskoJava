/**
 * @author Christian Piper
 * @since 10/19/21
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SieskoCompiler extends JFrame implements ActionListener {

    JLabel instLabel;
    JButton ok, run, clear, deleteLast;
    JTextField instField;
    JTextArea codeArea;

    String[] code;
    int codeIndexCounter;
    String codeDisplay;

    double[] memAddresses;
    double accumulator;

    SieskoCompiler() {
        super("Siesko Coding Language IDE");

        instLabel = new JLabel("Instruction");
        ok = new JButton("OK");
        run = new JButton("Run Program");
        clear = new JButton("Clear");
        deleteLast = new JButton("Delete last instruction");
        instField = new JTextField(20);
        codeArea = new JTextArea(20, 20);

        ok.addActionListener(this);
        run.addActionListener(this);
        clear.addActionListener(this);
        deleteLast.addActionListener(this);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(instLabel);
        c.add(instField);
        c.add(ok);
        c.add(run);
        c.add(clear);
        c.add(deleteLast);
        c.add(codeArea);

        setSize(300, 450);
        setVisible(true);

        code = new String[100];
        codeIndexCounter = 0;
        codeDisplay = "";

        memAddresses = new double[50];
        accumulator = 0;
    }

    public void actionPerformed(ActionEvent aEvent) {

        if (aEvent.getSource() == ok) {

            // Make sure that the box isn't empty
            if (instField.getText().equals("")) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Instruction box is empty!");
            }
            else {
                // Save a new value to the code array
                code[codeIndexCounter] = instField.getText();
                codeIndexCounter++;

                // Add to the code display, then display said string
                codeDisplay += instField.getText() + "\n";
                codeArea.setText(codeDisplay);

                // Clear the instruction box
                instField.setText("");
            }
        }
        else if (aEvent.getSource() == run) {

            // Integer variables (used in the for loop)
            int optCode = 0;
            int param = 0;

            // If the program is complete
            boolean programComplete = false;

            // Loop through the entire instruction set
            for (String instruction : code) {

                // Make sure that the instruction isn't null
                if (instruction == null || programComplete) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "End of program");
                    break;
                }

                // Split the instruction into optCode and params
                try {
                    optCode = Integer.parseInt(instruction.substring(0, 2));
                    param = Integer.parseInt(instruction.substring(2));
                } catch (Exception e) {
                    System.out.println("Issue with instruction: " + instruction);
                    continue;
                }

                /*
                10 - Read from the keyboard into a memory location
                11 - Print to screen from a location in memory
                20 - Load from a memory location into the accumulator
                21 - Load from accumulator into a memory location
                30 - Add a word from a memory location to the value in the accumulator. (result stays in accumulator)
                31 - Subtract a word from a memory location, from a word in the accumulator.(result stays in accumulator)
                32 - Divide a word in a memory location, into a word in the accumulator.(result stays in accumulator)
                33 - Multiply a word from a memory location and a word in the accumulator.(result stays in accumulator)
                40 - Terminate program
                */

                // Execute the correct instruction
                switch (optCode) {
                    case 10: {

                        // Create a popup for entering the number
                        JFrame frame = new JFrame();
                        String result = JOptionPane.showInputDialog(frame, "Enter number: ");
                        double num;
                        try {
                            num = Double.parseDouble(result);
                        } catch (Exception e) {
                            //TODO: handle exception
                            System.out.println("Invalid number!");
                            break;
                        }
                        memAddresses[param] = num;
                        break;
                    }
                    case 11: {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Output is: " + memAddresses[param]);
                        break;
                    }
                    case 20: {
                        accumulator = memAddresses[param];
                        break;
                    }
                    case 21: {
                        memAddresses[param] = accumulator;
                        break;
                    }
                    case 30: {
                        accumulator += memAddresses[param];
                        break;
                    }
                    case 31: {
                        accumulator -= memAddresses[param];
                        break;
                    }
                    case 32: {
                        accumulator /= memAddresses[param];
                        break;
                    }
                    case 33: {
                        accumulator *= memAddresses[param];
                        break;
                    }
                    case 40: {
                        programComplete = true;
                        break;
                    }
                }
            }
        }
        else if (aEvent.getSource() == clear) {

            // Clear the code array
            code = new String[100];

            // Clear the instruction field and code area
            instField.setText("");
            codeArea.setText("");

            // Reset the code area string and index counter
            codeDisplay = "";
            codeIndexCounter = 0;
        }
        else if (aEvent.getSource() == deleteLast) {

            // Make sure that we have an instruction to delete
            if (codeIndexCounter == 0) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "No instruction to delete");
            }
            else if (codeIndexCounter == 1) {

                // Count backward one index
                codeIndexCounter--;
                System.out.println(codeIndexCounter);

                // Set the last instruction to null
                code[codeIndexCounter] = null;

                // Fix the code display variable
                codeDisplay = "";

                // Reset the code area
                codeArea.setText(codeDisplay);
            }
            else {
                // Count backward one index
                codeIndexCounter--;
                System.out.println(codeIndexCounter);

                // Set the last instruction to null
                code[codeIndexCounter] = null;

                // Fix the code display variable
                codeDisplay = codeDisplay.substring(0, codeDisplay.substring(0, codeDisplay.lastIndexOf("\n")).lastIndexOf("\n"));

                // Reset the code area
                codeArea.setText(codeDisplay);
            }
        }
    }

    public static void main(String[] args) {
        SieskoCompiler c = new SieskoCompiler();
    }
}
