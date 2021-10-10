/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Gia Naicker
 */
public class CyberBooksHome extends javax.swing.JFrame {

    /**
     * Creates new form LibraryApp
     */
    public CyberBooksHome() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        reviewBooksButton = new javax.swing.JButton();
        addBookButton = new javax.swing.JButton();
        recommendBooksButton = new javax.swing.JButton();
        wwyltdLabel = new javax.swing.JLabel();
        rateBookButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));

        welcomeLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(0, 0, 0));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome to CyberBooks!");
        welcomeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        reviewBooksButton.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        reviewBooksButton.setText("View books");
        reviewBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewBooksButtonActionPerformed(evt);
            }
        });

        addBookButton.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        addBookButton.setText("Manage books in the library");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        recommendBooksButton.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        recommendBooksButton.setText("Rate a book");
        recommendBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendBooksButtonActionPerformed(evt);
            }
        });

        wwyltdLabel.setBackground(new java.awt.Color(255, 255, 255));
        wwyltdLabel.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        wwyltdLabel.setForeground(new java.awt.Color(0, 0, 0));
        wwyltdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wwyltdLabel.setText("What would you like to do today?");

        rateBookButton1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        rateBookButton1.setText("Search for recommended books");
        rateBookButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateBookButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home Screen 5.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(wwyltdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(reviewBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(recommendBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(rateBookButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(wwyltdLabel)
                .addGap(24, 24, 24)
                .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(reviewBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(recommendBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(rateBookButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reviewBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewBooksButtonActionPerformed
        new ChooseWhatToView().setVisible(true);
        dispose();
    }//GEN-LAST:event_reviewBooksButtonActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        new ManageBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void recommendBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendBooksButtonActionPerformed
        new RateBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_recommendBooksButtonActionPerformed

    private void rateBookButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBookButton1ActionPerformed
        new FindRecommendedBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_rateBookButton1ActionPerformed

    private void jLabel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton rateBookButton1;
    private javax.swing.JButton recommendBooksButton;
    private javax.swing.JButton reviewBooksButton;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel wwyltdLabel;
    // End of variables declaration//GEN-END:variables
}
