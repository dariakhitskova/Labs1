package Task10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GUIApp extends JFrame {
    JLabel welcome;
    JButton read;
    JButton write;
    JButton solve;
    JButton addRow;
    JButton deleteRow;
    JTable table;
    DefaultTableModel model;

    public GUIApp() {
        setTitle("Task10");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcome = new JLabel("Task10 - Объекты", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(welcome);

        String[] header = { "Район", "Кол-во комнат", "Общая площадь", "Площадь кухни", "Цена" };
        model = new DefaultTableModel(header, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        read = new JButton("Считать из файла");
        write = new JButton("Записать в файл");
        solve = new JButton("Решить задачу");
        addRow = new JButton("Добавить строку");
        deleteRow = new JButton("Удалить строку");
        buttonPanel.add(read);
        buttonPanel.add(write);
        buttonPanel.add(solve);
        welcomePanel.add(addRow);
        welcomePanel.add(deleteRow);

        setLayout(new BorderLayout());
        add(welcomePanel, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        read.addActionListener(this::readListener);
        write.addActionListener(this::writeListener);
        solve.addActionListener(this::solveListener);
        addRow.addActionListener(this::addListener);
        deleteRow.addActionListener(this::deleteListener);
    }

    private void deleteListener(ActionEvent actionEvent) {
        int ind = table.getSelectedColumn();
        table.removeColumn(table.getColumn(ind));
    }

    private void addListener(ActionEvent actionEvent) {
        model.addRow(new Object[]{"", "", "", "", ""});
    }

    public static void main(String[] args) {
        GUIApp app = new GUIApp();
        app.setVisible(true);
    }

    public void solveListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, miniSolve(), "Результат",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String miniSolve() {
        List<Flat> lst = readFlatsTable();
        Map<String, DistrictRooms> map = Solver.solve(lst);
        StringBuilder sb = new StringBuilder();
        for (DistrictRooms dr : map.values()) {
            sb.append("Район: ").append(dr.district)
                    .append(", комнат: ").append(dr.numRooms)
                    .append(", средняя цена за квадратный метр: ").append(dr.avg())
                    .append("\n");
        }
        return sb.toString();
    }

    public void readListener(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./src/Task10/Tests"));
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            List<Flat> lst = FileUtils.readFromFile(fc.getSelectedFile());
            model.setRowCount(0);
            for (Flat f : lst) {
                model.addRow(new Object[]{
                        f.district,
                        f.numRooms,
                        f.square,
                        f.squareKitchen,
                        f.price
                });
            }
        }
    }

    public void writeListener(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./src/Task10"));
        int ch = fc.showOpenDialog(this);
        if (ch == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(fc.getSelectedFile());
                fw.write(miniSolve());
                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public List<Flat> readFlatsTable() {
        List<Flat> res = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            String district = model.getValueAt(i, 0).toString();
            int numRooms = Integer.parseInt(model.getValueAt(i, 1).toString());
            double square = Double.parseDouble(model.getValueAt(i, 2).toString());
            double squareKitchen = Double.parseDouble(model.getValueAt(i, 3).toString());
            int price = Integer.parseInt(model.getValueAt(i, 4).toString());
            res.add(new Flat(district, numRooms, square, squareKitchen, price));
        }
        return res;
    }
}
