/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.ParticipantPartnering.ui;

import diet.server.Participant;
import diet.server.ParticipantPartnering.ParticipantPartnering;
import java.util.Date;
import java.util.Vector;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author gj
 */
public class JPanelParticipantPartneringSouth extends javax.swing.JPanel implements DocumentListener{

    //Conversation c;
    JPanelParticipantPartnering jppp;
    ParticipantPartnering pp;
    
    /**
     * Creates new form JPanelParticipantPartneringSouth
     */
    public JPanelParticipantPartneringSouth() {
        initComponents();
    }
    
    public JPanelParticipantPartneringSouth(ParticipantPartnering pp, JPanelParticipantPartnering jppp) {
        this.pp =pp;
        this.jppp=jppp;
        
        
        initComponents();
        this.jTextField2.setText("NewSubdialogue001");
        this.jTextField2.getDocument().addDocumentListener(this);
        this.jButton1.setEnabled(false);
        
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
       validateButtonEnabled();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
       validateButtonEnabled();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
       validateButtonEnabled();
    }

   
    public void stateChanged(ChangeEvent ce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        validateButtonEnabled();
    }

    
    
    public void validateButtonEnabled(){
        if(this.jTextField2.getText().length()<1){
            this.jButton1.setEnabled(false);
            return;
        }
        if(this.jppp.jppt.getSelectedRows()==null){
             this.jButton1.setEnabled(false);
             return;
        }
        if(this.jppp.jppt.getSelectedRows().length==0){
             this.jButton1.setEnabled(false);
             return;
        }
        if(this.jppp.jppt.getSelectedRows().length==1){
             this.jButton1.setEnabled(false); 
             return;
        }
        if(this.jppp.jppt.getSelectedRowCount()<2){
            this.jButton1.setEnabled(false); 
            return;
        }
        this.jButton1.setEnabled(true);
         
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Assign participants to new partner"));

        jLabel1.setText("Name of new subdialogue:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("NEW SUBDIALOGUE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Vector participantsToSelect = new Vector();
        
        int[] selectedrows = this.jppp.jppt.getSelectedRows();
        for(int i=0;i<selectedrows.length;i++){
            String pID = (String)this.jppp.jppt.getValueAt(selectedrows[i], 0);
            Participant p =    this.jppp.pp.c.getParticipants().findParticipantWithEmail(pID);
            participantsToSelect.addElement(p);
        }
        
        String subdialogueID = this.jTextField2.getText();
        if(subdialogueID.equalsIgnoreCase("")){
            subdialogueID = "CREATEDON:"+  new Date().getTime()+"";
        }
        try{
        System.err.println("DEBUGTIME");
        System.err.println("THE TOTAL NUMBER OF PARTICIPANTS BEFORE IS:" +this.jppp.pp.c.getParticipants().getAllParticipants().size());
        pp.createNewSubdialogue(subdialogueID,participantsToSelect);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        System.err.println("DEBUGTIME");
        System.err.println("THE TOTAL NUMBER OF PARTICIPANTS AFTER IS:" +this.jppp.pp.c.getParticipants().getAllParticipants().size());
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
