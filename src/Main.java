import module2_exercise2_1_datatypesAndOperators.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        BookAcquisitionRunner bookAcquisitionRunner = new BookAcquisitionRunner();
        bookAcquisitionRunner.orderBook = true;
        bookAcquisitionRunner.orderBooks();

        frame.dispose();
    }


}