import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class GUI extends JFrame {
    public GUI(){
        //Opens a window
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize (400, 300);
        frame.setLayout (new FlowLayout());

        //Contains a menu for quitting the program
        JMenuBar menuBar = new JMenuBar();
        JMenuItem quitItem = new JMenuItem ("Quit");
        menuBar.add(quitItem);

        //Asks for confirmation before exiting
        quitItem.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
        }
    });

        //Has an integer "state" variable in its application, initialized with 0
        final int[] state = {0};

        //Contains a label which shows the value of the integer variable
        JLabel stateLabel =   new JLabel();

        //Increment in the value of the "state" variable
        java.util.Timer t = new java.util.Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                state[0]++;
                stateLabel.setText(String.valueOf(state[0]));
            }
        }, 100, 100);


        frame.add(panel);
        panel.add(menuBar);
        panel.add(stateLabel);
        frame.setTitle("Homework_1_GUI");
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        panel.setVisible(true);
        stateLabel.setVisible(true);
    }
}
