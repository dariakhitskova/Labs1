package Task9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GUIApp extends JFrame {
    JLabel welcome;
    JLabel greeting;
    JTextField inputField;
    JButton read;
    JButton write;
    JButton solve;

    public GUIApp() {
        setTitle("Task9");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcome = new JLabel("Task9 - Списки", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        greeting =  new JLabel("Введите элементы списка:");
        greeting.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField = new JTextField(30);
        inputPanel.add(greeting);
        inputPanel.add(inputField);

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
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        solve.addActionListener(this::solveListener);
        read.addActionListener(this::readListener);
        write.addActionListener(this::writeListener);
    }
    public static void main(String[] args) {
        GUIApp app = new GUIApp();
        app.setVisible(true);
    }

    public void solveListener(ActionEvent e) {
        String input = inputField.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Вы ничего не ввели",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] strArr = input.split(" ");
        List<Integer> lst = new ArrayList<>();
        for (String s : strArr) {
            lst.add(Integer.parseInt(s));
        }
        Solver.solve(lst);
        StringBuilder sb = new StringBuilder();
        for (Integer el : lst) {
            sb.append(el).append(" ");
        }
        inputField.setText(sb.toString());
    }
    public void readListener(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите файл для ввода");
        fileChooser.setCurrentDirectory(new File("./src/Task9/Tests"));
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            List<Integer> lst = FileUtils.readFromFile(fileChooser.getSelectedFile());
            StringBuilder sb = new StringBuilder();
            for (Integer el : lst) {
                sb.append(el).append(" ");
            }
            inputField.setText(sb.toString());
            JOptionPane.showMessageDialog(this,
                    "Успешно считаны данные", "Успех!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void writeListener(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите файл для вывода");
        fileChooser.setCurrentDirectory(new File("./src/Task9"));
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            String input = inputField.getText();
            String[] strArr = input.split(" ");
            List<Integer> lst = new ArrayList<>();
            for (String s : strArr) {
                lst.add(Integer.parseInt(s));
            }
            FileUtils.writeToFile(lst, fileChooser.getSelectedFile());
            JOptionPane.showMessageDialog(this,
                    "Успешно записаны данные", "Успех!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
