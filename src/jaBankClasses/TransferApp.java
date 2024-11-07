package jaBankClasses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TransferApp extends JFrame {

    private JTextField idField, fromField, toField, amountField, stateField;
    private JButton createButton, updateButton, deleteButton, listButton;
    private JTable transferTable;
    private DefaultTableModel tableModel;
    private TransferDAOImpl transferDAO;
    private JFrame marcoBase;
    
    
    public TransferApp() {
        transferDAO = new TransferDAOImpl();
        initUI();
    }

    private void initUI() {
    	marcoBase = new JFrame();
    	
    	marcoBase.setTitle("Transfer Management");
    	marcoBase.setSize(800, 600);
    	marcoBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	marcoBase.setLocationRelativeTo(null);
    	
    	
    	JPanel mainer = new JPanel();
    	mainer.setLayout(new BorderLayout());
    	
    	// Panel de inputs
    	
    	JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("From:"));
        fromField = new JTextField();
        inputPanel.add(fromField);

        inputPanel.add(new JLabel("To:"));
        toField = new JTextField();
        inputPanel.add(toField);

        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("State:"));
        stateField = new JTextField();
        stateField.setText("Pending");
        inputPanel.add(stateField);
        
    	// Panel de Botones

    	JPanel buttonPanel = new JPanel();
    	
    	buttonPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    	
    	createButton = new JButton("Create");
    	createButton.addActionListener(new CreateAction());
    	buttonPanel.add(createButton);
    	
        updateButton = new JButton("Update");
        updateButton.addActionListener(new UpdateAction());
        buttonPanel.add(updateButton);
        
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteAction());
        buttonPanel.add(deleteButton);

        listButton = new JButton("List All");
        listButton.addActionListener(new ListAction());
        buttonPanel.add(listButton);
    	
        // Tabla de listado
        tableModel = new DefaultTableModel(new String[]{"ID", "From", "To", "Amount", "State"}, 0);
        transferTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(transferTable);
        
        // Agregado de paneles a mainer
        
        
        mainer.add(inputPanel, BorderLayout.NORTH);
    	mainer.add(buttonPanel, BorderLayout.SOUTH);
    	mainer.add(tableScroll, BorderLayout.CENTER);
    	marcoBase.add(mainer);
    	marcoBase.setVisible(true);
    }

    // Action Listeners
    private class CreateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Transfer transfer = new Transfer(
                	    idField.getText(),
                	    fromField.getText(),
                	    toField.getText(),
                	    amountField.getText(),
                	    stateField.getText()
                );
                transferDAO.createTransfer(transfer);
                JOptionPane.showMessageDialog(TransferApp.this, "Transfer created.");
                clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TransferApp.this, "Error creating transfer: " + ex.getMessage());
            }
        }
    }

    private class UpdateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Transfer transfer = new Transfer(
                	    idField.getText(),
                	    fromField.getText(),
                	    toField.getText(),
                	    amountField.getText(),
                	    stateField.getText()
                );
                transferDAO.updateTransfer(transfer);
                JOptionPane.showMessageDialog(TransferApp.this, "Transfer updated.");
                clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TransferApp.this, "Error updating transfer: " + ex.getMessage());
            }
        }
    }

    private class DeleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String id = idField.getText();
                transferDAO.deleteTransfer(id);
                JOptionPane.showMessageDialog(TransferApp.this, "Transfer deleted.");
                clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TransferApp.this, "Error deleting transfer: " + ex.getMessage());
            }
        }
    }

    private class ListAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Transfer> transfers = transferDAO.listAllTransfers();
                tableModel.setRowCount(0); // Clear the table
                for (Transfer transfer : transfers) {
                    tableModel.addRow(new Object[]{
                        transfer.getId(),
                        transfer.getFrom(),
                        transfer.getTo(),
                        transfer.getAmount(),
                        transfer.getState()
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TransferApp.this, "Error listing transfers: " + ex.getMessage());
            }
        }
    }

    // Helper Methods
    private void clearFields() {
        idField.setText("");
        fromField.setText("");
        toField.setText("");
        amountField.setText("");
        stateField.setText("Pending");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransferApp app = new TransferApp();
        });
    }
}

