/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.ConversationController.ui;

/**
 *
 * @author gj
 */
public class JInterfaceToggleButtonsFIVE extends javax.swing.JFrame {

    
    JInterfaceMenuButtonsReceiverInterface jimbr;
    
    /**
     * Creates new form JMenuButtons
     */
    public JInterfaceToggleButtonsFIVE() {
        initComponents();
        this.setVisible(true);
        this.jToggleButton1.setSelected(true);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
      
    }
    
    public JInterfaceToggleButtonsFIVE(JInterfaceMenuButtonsReceiverInterface jimbr) {
        initComponents();
        this.setVisible(true);
        this.jimbr=jimbr;
        this.jToggleButton1.setSelected(true);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
       
    }
    
    public JInterfaceToggleButtonsFIVE(JInterfaceMenuButtonsReceiverInterface jimbr, String name1, String name2, String name3, String name4, String name5) {
        initComponents();
        this.setTitle("Please choose:");
        this.jToggleButton1.setText(name1);
        this.jToggleButton2.setText(name2);
        this.jToggleButton3.setText(name3);
        this.jToggleButton4.setText(name4);
        this.jToggleButton5.setText(name5);
        
        
        
        this.setVisible(true);
        this.jimbr=jimbr;
        this.jToggleButton1.setSelected(true);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(false);
        this.setAlwaysOnTop (true); 
        this.pack();
       
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText(" ");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText(" ");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText(" ");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText(" ");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setText(" ");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()){
              jimbr.performActionTriggeredByUI(jToggleButton1.getText());
              jToggleButton2.setSelected(false);
              jToggleButton3.setSelected(false);
              jToggleButton4.setSelected(false);
              jToggleButton5.setSelected(false);
             
        }
        
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton2.isSelected()){
              jimbr.performActionTriggeredByUI(jToggleButton2.getText());
              jToggleButton1.setSelected(false);
              jToggleButton3.setSelected(false);
              jToggleButton4.setSelected(false);
              jToggleButton5.setSelected(false);
                
        }
        
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
         if(jToggleButton3.isSelected()){
              jimbr.performActionTriggeredByUI(jToggleButton3.getText());
              jToggleButton1.setSelected(false);
              jToggleButton2.setSelected(false);
              jToggleButton4.setSelected(false);
              jToggleButton5.setSelected(false);
                   
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
         if(jToggleButton4.isSelected()){
              jimbr.performActionTriggeredByUI(jToggleButton4.getText());
              jToggleButton1.setSelected(false);
              jToggleButton2.setSelected(false);
              jToggleButton3.setSelected(false);
              jToggleButton5.setSelected(false);
              
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
       if(jToggleButton5.isSelected()){
              jimbr.performActionTriggeredByUI(jToggleButton5.getText());
              jToggleButton1.setSelected(false);
              jToggleButton2.setSelected(false);
              jToggleButton3.setSelected(false);
              jToggleButton4.setSelected(false);
              
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(JInterfaceToggleButtonsFIVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JInterfaceToggleButtonsFIVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JInterfaceToggleButtonsFIVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JInterfaceToggleButtonsFIVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JInterfaceToggleButtonsFIVE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables
}
