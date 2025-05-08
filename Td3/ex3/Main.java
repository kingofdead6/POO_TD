package ex3;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Main {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:mm");
    private static final OutingManager manager = new OutingManager();
    private static DefaultTableModel tableModel;

    // color palette
    private static final Color PRIMARY_COLOR = new Color(103, 58, 183);
    private static final Color PRIMARY_DARK = new Color(69, 39, 160);
    private static final Color PRIMARY_LIGHT = new Color(179, 157, 219);
    private static final Color ACCENT_COLOR = new Color(255, 111, 0);
    private static final Color BACKGROUND = new Color(250, 250, 250);
    private static final Color TEXT_PRIMARY = new Color(0, 0, 0);
    private static final Color DIVIDER_COLOR = new Color(224, 224, 224);

    public static void main(String[] args) throws Exception {
        manager.addOuting(new Outing("Jardin d'essais", "El Hamma", LocalDateTime.of(2025, 4, 9, 10, 0)));
        manager.addOuting(new Outing("Museum Visit", "Algiers", LocalDateTime.of(2025, 4, 11, 15, 0)));
        manager.addOuting(new Outing("Beach Day", "Sidi Fredj", LocalDateTime.of(2025, 4, 15, 9, 30)));
        manager.addOuting(new Outing("Hiking", "Chrea", LocalDateTime.of(2025, 4, 20, 7, 0)));

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    // Creates and displays the GUI
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Outing Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.setMinimumSize(new Dimension(700, 550));
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(BACKGROUND);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.background", PRIMARY_COLOR);
            UIManager.put("Button.focus", new Color(0, 0, 0, 0));
            UIManager.put("Button.border", new LineBorder(PRIMARY_DARK, 1, true));
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.focusWidth", 0);
            UIManager.put("TextField.border", BorderFactory.createCompoundBorder(
                new LineBorder(DIVIDER_COLOR, 1),
                new EmptyBorder(5, 8, 5, 8)
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        headerPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Outing Manager");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JLabel dateLabel = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")));
        dateLabel.setForeground(TEXT_PRIMARY);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        headerPanel.add(dateLabel, BorderLayout.EAST);

        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPanel.setBackground(BACKGROUND);

        // Table setup
        String[] columns = {"Name", "Location", "Date & Time"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setRowHeight(40);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(PRIMARY_COLOR);
        table.getTableHeader().setForeground(TEXT_PRIMARY);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionBackground(PRIMARY_LIGHT);
        table.setSelectionForeground(TEXT_PRIMARY);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);
        populateTable(manager.getAllOutings());

        // Filter panel
        JPanel filterPanel = new JPanel(new GridBagLayout());
        filterPanel.setBackground(Color.WHITE);
        filterPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(DIVIDER_COLOR, 1),
            new EmptyBorder(15, 15, 15, 15)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel filterTitleLabel = new JLabel("Filter Outings");
        filterTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        filterTitleLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        filterPanel.add(filterTitleLabel, gbc);

        JLabel startLabel = createLabel("Start date (e.g., 8/4/2025 9:00):");
        JTextField startField = createTextField();
        JLabel endLabel = createLabel("End date (e.g., 10/4/2025 18:00):");
        JTextField endField = createTextField();

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        filterPanel.add(startLabel, gbc);
        gbc.gridy = 2;
        filterPanel.add(startField, gbc);
        gbc.gridy = 3;
        filterPanel.add(endLabel, gbc);
        gbc.gridy = 4;
        filterPanel.add(endField, gbc);
        gbc.gridy = 5;
        gbc.insets = new Insets(15, 5, 5, 5);

        JButton filterButton = createPrimaryButton("Filter Outings");
        filterButton.addActionListener(e -> filterOutings(startField.getText(), endField.getText()));
        filterPanel.add(filterButton, gbc);

        // Add outing panel
        JPanel addPanel = new JPanel(new GridBagLayout());
        addPanel.setBackground(Color.WHITE);
        addPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(DIVIDER_COLOR, 1),
            new EmptyBorder(15, 15, 15, 15)
        ));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel addTitleLabel = new JLabel("Add New Outing");
        addTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addTitleLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        addPanel.add(addTitleLabel, gbc);

        JLabel nameLabel = createLabel("Outing Name:");
        JTextField nameField = createTextField();
        JLabel locationLabel = createLabel("Location:");
        JTextField locationField = createTextField();
        JLabel dateTimeLabel = createLabel("Date & Time (e.g., 8/4/2025 9:00):");
        JTextField dateField = createTextField();

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(nameLabel, gbc);
        gbc.gridy = 2;
        addPanel.add(nameField, gbc);
        gbc.gridy = 3;
        addPanel.add(locationLabel, gbc);
        gbc.gridy = 4;
        addPanel.add(locationField, gbc);
        gbc.gridy = 5;
        addPanel.add(dateTimeLabel, gbc);
        gbc.gridy = 6;
        addPanel.add(dateField, gbc);
        gbc.gridy = 7;
        gbc.insets = new Insets(15, 5, 5, 5);

        JButton addButton = createPrimaryButton("Add Outing");
        addButton.addActionListener(e -> addOuting(
            nameField.getText(), locationField.getText(), dateField.getText()));
        addPanel.add(addButton, gbc);

        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        inputPanel.setBorder(new EmptyBorder(0, 0, 15, 0));
        inputPanel.setOpaque(false);
        inputPanel.add(filterPanel);
        inputPanel.add(addPanel);

        contentPanel.add(inputPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(TEXT_PRIMARY);
        return label;
    }

    private static JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(Color.WHITE);
        field.setForeground(TEXT_PRIMARY);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(DIVIDER_COLOR, 1),
            new EmptyBorder(8, 10, 8, 10)
        ));
        return field;
    }

    private static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(TEXT_PRIMARY);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(PRIMARY_DARK, 1, true),
            new EmptyBorder(8, 20, 8, 20)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(true);
        button.setOpaque(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_DARK);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });

        return button;
    }

    private static void filterOutings(String startStr, String endStr) {
        try {
            if (startStr.trim().isEmpty() || endStr.trim().isEmpty()) {
                populateTable(manager.getAllOutings());
                return;
            }
            LocalDateTime start = LocalDateTime.parse(startStr, formatter);
            LocalDateTime end = LocalDateTime.parse(endStr, formatter);
            List<Outing> filteredOutings = manager.getOutingsBetween(start, end);
            populateTable(filteredOutings);
        } catch (DateTimeParseException e) {
            showErrorDialog("Invalid Date Format",
                "Please use the format: d/M/yyyy H:mm (e.g., 8/4/2025 9:00)");
        } catch (Exception e) {
            showErrorDialog("Error", "An error occurred: " + e.getMessage());
        }
    }

    private static void addOuting(String name, String location, String dateStr) {
        try {
            if (name.trim().isEmpty() || location.trim().isEmpty()) {
                showErrorDialog("Invalid Input", "Name and location cannot be empty.");
                return;
            }
            LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
            Outing newOuting = new Outing(name, location, dateTime);
            manager.addOuting(newOuting);
            populateTable(manager.getAllOutings());

            JOptionPane pane = new JOptionPane(
                "Outing added successfully!",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{},
                null
            );
            JDialog dialog = pane.createDialog("Success");
            dialog.getContentPane().setBackground(Color.WHITE);
            for (Component c : dialog.getContentPane().getComponents()) {
                if (c instanceof JPanel) {
                    for (Component subC : ((JPanel) c).getComponents()) {
                        if (subC instanceof JLabel) {
                            subC.setForeground(TEXT_PRIMARY);
                        }
                    }
                }
            }
            dialog.setVisible(true);

            new Timer(2000, e -> dialog.dispose()).start();
        } catch (DateTimeParseException e) {
            showErrorDialog("Invalid Date Format",
                "Please use the format: d/M/yyyy H:mm (e.g., 8/4/2025 9:00)");
        } catch (Exception e) {
            showErrorDialog("Error", "Failed to add outing: " + e.getMessage());
        }
    }

    private static void showErrorDialog(String title, String message) {
        JOptionPane pane = new JOptionPane(
            message,
            JOptionPane.ERROR_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            new Object[]{},
            null
        );
        JDialog dialog = pane.createDialog(title);
        dialog.getContentPane().setBackground(Color.WHITE);
        for (Component c : dialog.getContentPane().getComponents()) {
            if (c instanceof JPanel) {
                for (Component subC : ((JPanel) c).getComponents()) {
                    if (subC instanceof JLabel) {
                        subC.setForeground(TEXT_PRIMARY);
                    }
                }
            }
        }
        dialog.setVisible(true);
    }

    private static void populateTable(List<Outing> outings) {
        tableModel.setRowCount(0);
        for (Outing outing : outings) {
            tableModel.addRow(new Object[]{
                outing.getName(),
                outing.getLocation(),
                outing.getDateTime().format(formatter)
            });
        }
    }
}

