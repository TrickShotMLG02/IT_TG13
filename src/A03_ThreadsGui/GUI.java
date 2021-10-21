package A03_ThreadsGui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public JFrame frame;
    public JButton btnStart;
    public JButton btnStop;
    public JPanel contentpane;
    public JLabel lbl;
    public MyThread thread;
    public JSpinner spinner;

    public static GUI _Instance;

    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.setVisible(true);


    }

    public GUI()
    {
        _Instance = this;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(250,150);
        contentpane = new JPanel();
        frame = new JFrame("ThreadExample");
        this.setContentPane(contentpane);


        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wait = 100;
                wait = (int)spinner.getValue();
                thread = new MyThread("t1", wait);
                thread.start();
                System.out.println("Start");
            }
        });
        contentpane.add(btnStart);

        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    thread.interrupt();
                System.out.println("Stop");
            }
        });
        contentpane.add(btnStop);

        lbl = new JLabel("count: ");
        contentpane.add(lbl);


        spinner = new JSpinner();
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Change");
                if (thread != null) {
                    int wait = (int) spinner.getValue();
                    thread.setWait(wait);
                }
            }
        });
        contentpane.add(spinner);
    }

}
