/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entity.*;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;

/**
 * Oak Donuts - main GUI
 */
public class Main extends javax.swing.JFrame {
    private static MenuItemDAO menuDAO;
    private static OrderDAO orderDAO;

    public Main() {
        initComponents();
        menuDAO = new MenuItemDAO();
        orderDAO = new OrderDAO();
        loadMenu();
        refreshOrdersTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbMenu = new javax.swing.JComboBox<>();
        jLabelTitle = new javax.swing.JLabel();
        jLabelMenu = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabelQty = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oak Donuts - Order");
        setResizable(false);

        jLabelTitle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelTitle.setText("Oak Donuts");

        jLabelMenu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelMenu.setText("Menu");

        txtQuantity.setText("1");

        jLabelQty.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelQty.setText("Quantity");

        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Item", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContacts.setCellSelectionEnabled(true);
        tblContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContacts);
        if (tblContacts.getColumnModel().getColumnCount() > 0) {
            tblContacts.getColumnModel().getColumn(2).setResizable(false);
        }

        btnInsert.setText("Add to Order");
        btnInsert.setActionCommand("Add");
        btnInsert.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsert.setIconTextGap(0);
        btnInsert.setInheritsPopupMenu(true);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Clear Order");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("Checkout");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle) // Added title to horizontal group so it's attached
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelQty, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelMenu.getAccessibleContext().setAccessibleName("Menu");
        btnInsert.getAccessibleContext().setAccessibleName("Add");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // Add selected menu item to Orders
        MenuItem selected = (MenuItem) cmbMenu.getSelectedItem();
        if (selected == null) {
            alert("No menu item selected");
            return;
        }
        int qty = 1;
        try {
            qty = Integer.parseInt(txtQuantity.getText().trim());
        } catch (NumberFormatException ex) {
            alert("Quantity must be a number");
            return;
        }
        if (qty <= 0) {
            alert("Quantity must be at least 1");
            return;
        }
        addToOrder(selected.getId(), qty);
        refreshOrdersTable();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Clear current order
        int option = JOptionPane.showConfirmDialog(rootPane, "Clear current order?", "Clear Order", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            clearOrders();
            refreshOrdersTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    //set the values of a row to the textfields (not used for now)
    private void tblContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMouseClicked
        // optional: could implement select-and-remove
    }//GEN-LAST:event_tblContactsMouseClicked

    //handles checkout button action
    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        List<OrderItem> orders = orderDAO.getAll();
        if (orders.isEmpty()) {
            alert("No items in order.");
            return;
        }
        double total = 0.0;
        StringBuilder summary = new StringBuilder();
        for (OrderItem item : orders) {
            summary.append(item.toString()).append("\n");
            total += item.getTotal();
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Confirm Checkout:\n" + summary.toString() + "\nTotal: $" + String.format("%.2f", total), "Checkout", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            alert("Thank you for your order! Total: $" + String.format("%.2f", total));
            clearOrders();
            refreshOrdersTable();
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    //method to show an info alert
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    //method to show an error alert
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private static void addToOrder(int menuItemId, int quantity) {
        // find menu item
        Optional<MenuItem> mi = menuDAO.get(menuItemId);
        if (!mi.isPresent()) {
            System.err.println("Menu item not found: " + menuItemId);
            return;
        }
        MenuItem item = mi.get();
        OrderItem order = new OrderItem(menuItemId, item.getName(), quantity, item.getPrice());
        orderDAO.insert(order);
    }

    private static void clearOrders() {
        List<OrderItem> orders = orderDAO.getAll();
        for (OrderItem o : orders) {
            orderDAO.delete(o);
        }
    }

    private void loadMenu() {
        List<MenuItem> items = menuDAO.getAll();
        DefaultComboBoxModel<MenuItem> model = new DefaultComboBoxModel<>();
        for (MenuItem mi : items) model.addElement(mi);
        cmbMenu.setModel(model);
        if (model.getSize() > 0) cmbMenu.setSelectedIndex(0);
    }

    //fetch orders and display in table
    private void refreshOrdersTable() {
        List<OrderItem> orders = orderDAO.getAll();
        DefaultTableModel model = (DefaultTableModel) tblContacts.getModel();
        //Clear all items in table
        for(int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        for (OrderItem order : orders) {
                Object[] row = new Object[5];
                row[0] = order.getId();
                row[1] = order.getName();
                row[2] = order.getQuantity();
                row[3] = String.format("$%.2f", order.getPrice());
                row[4] = String.format("$%.2f", order.getTotal());
                model.addRow(row);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        menuDAO = new MenuItemDAO();
        orderDAO = new OrderDAO();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<MenuItem> cmbMenu;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelQty;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContacts;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
