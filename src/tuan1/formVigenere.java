/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tuan1;

/**
 *
 * @author Hieu Pham
 */
public class formVigenere extends javax.swing.JFrame {

    int[][] vig;

    /**
     * Creates new form formVigenere
     */
    public formVigenere() {
        initComponents();
        vig = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                vig[i][j] = (i + j) % 26;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBanRo = new javax.swing.JLabel();
        jLabelKhoa = new javax.swing.JLabel();
        jLabelBanMa = new javax.swing.JLabel();
        jTextFieldBanRo = new javax.swing.JTextField();
        jTextFieldKey = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBanMa = new javax.swing.JTextArea();
        jButtonMaHoa = new javax.swing.JButton();
        jButtonGiaiMa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabelBanRo.setText("Bản rõ");

        jLabelKhoa.setText("Khóa");

        jLabelBanMa.setText("Bản mã");

        jTextAreaBanMa.setColumns(20);
        jTextAreaBanMa.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBanMa);

        jButtonMaHoa.setText("Mã hóa");
        jButtonMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaHoaActionPerformed(evt);
            }
        });

        jButtonGiaiMa.setText("Giải mã");
        jButtonGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGiaiMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelBanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKhoa)
                    .addComponent(jLabelBanRo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMaHoa)
                        .addGap(54, 54, 54)
                        .addComponent(jButtonGiaiMa))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldBanRo)
                        .addComponent(jTextFieldKey)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldBanRo)
                    .addComponent(jLabelBanRo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldKey)
                    .addComponent(jLabelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMaHoa)
                    .addComponent(jButtonGiaiMa))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private char maHoa(char x, char k) {
        int xn = Character.toUpperCase(x) - 'A';
        int kn = Character.toUpperCase(k) - 'A';
        int yn = vig[kn][xn];
        return (char) (yn + 'A');
    }

    private String maHoa(String banRo, String key) {
        int n = banRo.length();
        String banMa = "";
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(banRo.charAt(i))) {
                banMa += maHoa(banRo.charAt(i), key.charAt(k));
                k++;
                k = k % key.length();
            } else {
                banMa += banRo.charAt(i);
            }
        }
        return banMa;
    }

    private void jButtonMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaHoaActionPerformed
        // TODO add your handling code here:
        String banRo = this.jTextFieldBanRo.getText();
        String k = this.jTextFieldKey.getText();
        String banMa = maHoa(banRo, k);
        this.jTextAreaBanMa.setText(banMa);
    }//GEN-LAST:event_jButtonMaHoaActionPerformed

    private void jButtonGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGiaiMaActionPerformed
        // TODO add your handling code here:
        String banMa = this.jTextAreaBanMa.getText();
        String k = this.jTextFieldKey.getText();
        String kt1 = "";
        int kn = k.length();
        for (int i = 0; i < kn; i++) {
            kt1 += (char) (((26 - (Character.toUpperCase(k.charAt(i)) - 'A')) % 26) + 'A');
        }
        jTextFieldKey.setText(kt1);
        String banRo = maHoa(banMa, kt1);
        jTextFieldBanRo.setText(banRo);
    }//GEN-LAST:event_jButtonGiaiMaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(formVigenere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formVigenere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formVigenere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formVigenere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formVigenere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGiaiMa;
    private javax.swing.JButton jButtonMaHoa;
    private javax.swing.JLabel jLabelBanMa;
    private javax.swing.JLabel jLabelBanRo;
    private javax.swing.JLabel jLabelKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaBanMa;
    private javax.swing.JTextField jTextFieldBanRo;
    private javax.swing.JTextField jTextFieldKey;
    // End of variables declaration//GEN-END:variables
}
