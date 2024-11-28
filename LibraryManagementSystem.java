import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LibraryManagementSystem {
    private JFrame frame;
    private JTextField bookIdField, titleField, authorField;
    private JButton insertButton, updateButton, deleteButton;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    // MySQL connection details
    private final String url = "jdbc:mysql://localhost:3306/library_db";
    private final String user = "root";  
    private final String password = "drish@013";  

    public LibraryManagementSystem() {
        // Initialize GUI components
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // Create input fields with labels
        JPanel bookIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bookIdPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField(20);
        bookIdPanel.add(bookIdField);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        titlePanel.add(titleField);

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(new JLabel("Author:"));
        authorField = new JTextField(20);
        authorPanel.add(authorField);

        // Add the panels to the inputPanel
        inputPanel.add(bookIdPanel);
        inputPanel.add(titlePanel);
        inputPanel.add(authorPanel);

        // Create buttons and add to inputPanel
        insertButton = new JButton("Insert");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        inputPanel.add(insertButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table for displaying books
        tableModel = new DefaultTableModel(new String[]{"Book ID", "Title", "Author"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        // Load initial data from database
        loadBooksFromDatabase();

        // Add event listeners
        insertButton.addActionListener(new InsertButtonListener());
        updateButton.addActionListener(new UpdateButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());

        frame.pack();
        frame.setVisible(true);
    }

    // Load books from MySQL database into the table
    private void loadBooksFromDatabase() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                tableModel.addRow(new Object[]{bookId, title, author});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateTable() {
        // Clear the table model
        tableModel.setRowCount(0);
        // Reload data from the database
        loadBooksFromDatabase();
    }

    // Insert a new book into the MySQL database
    private class InsertButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();
            String title = titleField.getText();
            String author = authorField.getText();

            if (bookId.isEmpty() || title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");
                return;
            }

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "INSERT INTO books (book_id, title, author) VALUES (?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, bookId);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.executeUpdate();
                updateTable(); // Ensure the table is updated

                // Display book details in a single line
                JOptionPane.showMessageDialog(frame,
                        String.format("Book Added Successfully! Book ID: %s, Title: %s, Author: %s", bookId, title, author));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Update a book in the MySQL database
    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();
            String title = titleField.getText();
            String author = authorField.getText();

            if (bookId.isEmpty() || title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");
                return;
            }

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "UPDATE books SET title = ?, author = ? WHERE book_id = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, author);
                ps.setString(3, bookId);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    updateTable();
                    JOptionPane.showMessageDialog(frame,
                            String.format("Book Updated Successfully! Book ID: %s, Title: %s, Author: %s", bookId, title, author));
                } else {
                    JOptionPane.showMessageDialog(frame, "Book ID not found!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Delete a book from the MySQL database
    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();

            if (bookId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Book ID must be provided!");
                return;
            }

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "DELETE FROM books WHERE book_id = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, bookId);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    updateTable();
                    JOptionPane.showMessageDialog(frame, "Book deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Book ID not found!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                new LibraryManagementSystem();
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error initializing Library Management System.");
                e.printStackTrace();
            }
        });
    }
}
