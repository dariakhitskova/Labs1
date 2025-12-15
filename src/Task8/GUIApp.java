package Task8;

import javax.swing.*;
import java.awt.*;

public class GUIApp extends JFrame {
    JLabel welcome;
    JButton read;
    JButton write;
    JButton solve;

    public GUIApp() {
        setTitle("Task8");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcome = new JLabel("Task8 - Двумерные массивы", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));

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
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        GUIApp app = new GUIApp();
        app.setVisible(true);
    }
}
