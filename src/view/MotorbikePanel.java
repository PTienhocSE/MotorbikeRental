/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import model.Motorbike;

/**
 *
 * @author phuct
 */
public class MotorbikePanel extends javax.swing.JPanel {
    private static int MotorbikeID = 0;
    /**
     * Creates new form MotorbikePanel
     */
    public MotorbikePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BiensoxeText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BrandNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        GiaThueXeTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GiaXeTxt = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Add Motorbike");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Reset");
        jPanel2.add(jButton2);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridLayout(4, 2));

        jLabel2.setText("License Plate");
        jPanel3.add(jLabel2);
        jPanel3.add(BiensoxeText);

        jLabel3.setText("Brand Name");
        jPanel3.add(jLabel3);
        jPanel3.add(BrandNameTxt);

        jLabel4.setText("Rent Price");
        jPanel3.add(jLabel4);
        jPanel3.add(GiaThueXeTxt);

        jLabel5.setText("Price");
        jPanel3.add(jLabel5);
        jPanel3.add(GiaXeTxt);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Get the values from the text fields
    String licensePlate = BiensoxeText.getText();
    String brandName = BrandNameTxt.getText();
    double rentPrice = Double.parseDouble(GiaThueXeTxt.getText());
    double price = Double.parseDouble(GiaXeTxt.getText());

    // Create a new Motorbike object
    ++MotorbikeID;
    Motorbike motorbike = new Motorbike(MotorbikeID, licensePlate, brandName, rentPrice, price, true);
        MainGUI.shop.setMotorbikeList(motorbike);
        System.out.println(motorbike);
    // Optionally, you can clear the text fields after adding
    BiensoxeText.setText("");
    BrandNameTxt.setText("");
    GiaThueXeTxt.setText("");
    GiaXeTxt.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BiensoxeText;
    private javax.swing.JTextField BrandNameTxt;
    private javax.swing.JTextField GiaThueXeTxt;
    private javax.swing.JTextField GiaXeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
