package Task10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIApp extends JFrame {
    JLabel welcome;
    JButton read;
    JButton write;
    JButton solve;

    public GUIApp() {
        setTitle("Task10");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcome = new JLabel("Task10 - Объекты", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        JTable inputTable = new JTable();
        inputTable.setSize(5, 10);
        centerPanel.add(inputTable);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        read = new JButton("Считать из файла");
        write = new JButton("Записать в файл");
        solve = new JButton("Решить задачу");
        buttonPanel.add(read);
        buttonPanel.add(write);
        buttonPanel.add(solve);

        setLayout(new BorderLayout());
        add(welcome, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        read.addActionListener(this::readListener);
        write.addActionListener(this::writeListener);
        solve.addActionListener(this::solveListener);
    }
    public static void main(String[] args) {
        GUIApp app = new GUIApp();
        app.setVisible(true);
    }

    public void solveListener(ActionEvent e) {

    }

    public void readListener(ActionEvent e) {

    }

    public void writeListener(ActionEvent e) {

    }
}
