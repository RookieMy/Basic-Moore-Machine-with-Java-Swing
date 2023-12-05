/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uups._otomataodev;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class OutputFrame extends javax.swing.JFrame {

    Graph mooreGraph;
    String alph[];
    
    
    public OutputFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Text :");

        jButton1.setText("Finish");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)))
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText()=="")
            JOptionPane.showMessageDialog(null,"Not Valid!","ERROR!",JOptionPane.ERROR_MESSAGE);
        else
        {
            jTextField1.setEditable(false);
            jButton1.setVisible(false);
            Moore(jTextField1.getText().toCharArray());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //final
    private void Moore(char[] text)
    {
        if(!IsValid(text))
        {
                JOptionPane.showMessageDialog(null, "Not Valid!","ERROR!",JOptionPane.ERROR_MESSAGE);
                jButton1.setVisible(true);
                jTextField1.setEditable(true);
                return ;
        }
        
        jDialog1.setSize(450,250);
        jPanel1.setLayout(new GridLayout(3,2+text.length));
        jPanel1.add(new JLabel("Input:"));
        jPanel1.add(new JLabel("     "));
        for(char c:text)
            jPanel1.add(new JLabel(String.valueOf(c)));
        jPanel1.add(new JLabel("State:"));
        State Current=mooreGraph.states[0];
        jPanel1.add(new JLabel("Q"+Current.state));
        for(char c: text)
        {
            Current=StateFinder(String.valueOf(c),Current);
            jPanel1.add(new JLabel("Q"+Current.state));
        }
        Current=mooreGraph.states[0];
        
        jPanel1.add(new JLabel("Output:"));
        jPanel1.add(new JLabel(String.valueOf(Current.output)));
        for(char c:text)
        {
            Current=StateFinder(String.valueOf(c),Current);
            jPanel1.add(new JLabel(String.valueOf(Current.output)));
        }
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
    }
    
    //find the next state
    private State StateFinder(String c,State cs)
    {
        for(int i=0;i<alph.length;i++)
        {
            if(c.equals(alph[i]))
            {
                return cs.transitions[i].target;
            }
        }
        return null;
    }
    
    //control the text if it's valid for given alphabet
    private boolean IsValid(char[] text)
    {
        for(char i : text)
        {
            boolean ctrl=false;
            inner: for(String j : alph)
            {
                if(String.valueOf(i).equals(j))
                {
                    ctrl=true;
                    break inner;
                }
            }
            if(!ctrl)
                return ctrl;
        }
        return true;
    }
    
    //setting outputframe's basic props
    public void SetOutputFrame(Graph graf,String alph[])
    {
        this.mooreGraph=graf;
        this.alph=alph;
        this.setLocationRelativeTo(null);
        this.setSize(500,200);
        this.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
}
