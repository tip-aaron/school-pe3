package module2_exercise2_1_datatypesAndOperators;

import javax.swing.*;

public class Utils {
    public static int getNumFromJOptionPane(String msg) {
        return Utils.getNumFromJOptionPane(msg, 0);
    }

    public static int getNumFromJOptionPane(String msg, int limit) {
        while (true) {
            String input = JOptionPane.showInputDialog(msg);

            if (input != null) {
                try {
                    int number = Integer.parseInt(input);

                    if (limit == 0) {
                        return number;
                    }

                    if (limit < number) {
                        JOptionPane.showMessageDialog(null, "Number must be < " + number, "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    return number;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
