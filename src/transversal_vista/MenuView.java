 
package transversal_vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
        this.setLocationRelativeTo(null);
        //tam por defecto 
        this.setSize(700, 620);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        ImageIcon iconoEscritorio = new ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/logoULPfull.jpg"));
        Image escritorioImagen = iconoEscritorio.getImage();
        jDesktopPrincipal = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(escritorioImagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_alumno = new javax.swing.JMenu();
        jMenu_alumnoAlta = new javax.swing.JMenuItem();
        jMenu_materia = new javax.swing.JMenu();
        jMenuAltaMateria = new javax.swing.JMenuItem();
        jMenu_inscripcion = new javax.swing.JMenu();
        jMenuManejoInscripcion = new javax.swing.JMenuItem();
        jMenuManejoNota = new javax.swing.JMenuItem();
        jMenu_inscripcion1 = new javax.swing.JMenu();
        jMenuManejoNota1 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPrincipal.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jMenu_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/alumno.png"))); // NOI18N
        jMenu_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_alumnoActionPerformed(evt);
            }
        });

        jMenu_alumnoAlta.setText("Alta alumno");
        jMenu_alumnoAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_alumnoAltaActionPerformed(evt);
            }
        });
        jMenu_alumno.add(jMenu_alumnoAlta);

        jMenuBar1.add(jMenu_alumno);

        jMenu_materia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/materia.png"))); // NOI18N
        jMenu_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_materiaActionPerformed(evt);
            }
        });

        jMenuAltaMateria.setText("Alta materia");
        jMenuAltaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAltaMateriaActionPerformed(evt);
            }
        });
        jMenu_materia.add(jMenuAltaMateria);

        jMenuBar1.add(jMenu_materia);

        jMenu_inscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/inscripcion.png"))); // NOI18N

        jMenuManejoInscripcion.setText("Modificar inscripción");
        jMenuManejoInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManejoInscripcionActionPerformed(evt);
            }
        });
        jMenu_inscripcion.add(jMenuManejoInscripcion);

        jMenuManejoNota.setText("Modificar nota");
        jMenuManejoNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManejoNotaActionPerformed(evt);
            }
        });
        jMenu_inscripcion.add(jMenuManejoNota);

        jMenuBar1.add(jMenu_inscripcion);

        jMenu_inscripcion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/cerrar-sesion.png"))); // NOI18N
        jMenu_inscripcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_inscripcion1ActionPerformed(evt);
            }
        });

        jMenuManejoNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManejoNota1ActionPerformed(evt);
            }
        });
        jMenu_inscripcion1.add(jMenuManejoNota1);

        jMenuBar1.add(jMenu_inscripcion1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_alumnoActionPerformed
        // TODO add your handling code here:
        jDesktopPrincipal.removeAll();
        jDesktopPrincipal.repaint();
        
    }//GEN-LAST:event_jMenu_alumnoActionPerformed

    private void jMenuManejoInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManejoInscripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuManejoInscripcionActionPerformed

    private void jMenuManejoNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManejoNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuManejoNotaActionPerformed

    private void jMenu_alumnoAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_alumnoAltaActionPerformed
        // TODO add your handling code here:
        jDesktopPrincipal.removeAll();
        jDesktopPrincipal.repaint();
        FormularioAlumnoJIF formularioAlumJIF = new FormularioAlumnoJIF();
        formularioAlumJIF.setVisible(true);
        jDesktopPrincipal.add(formularioAlumJIF);
        jDesktopPrincipal.moveToFront(formularioAlumJIF);
        //el color de la ventana del form alumno se setea desde el menu principal, escala RGB
        formularioAlumJIF.getContentPane().setBackground(new Color(240, 244, 195  ));
    }//GEN-LAST:event_jMenu_alumnoAltaActionPerformed

    private void jMenuManejoNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManejoNota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuManejoNota1ActionPerformed

    private void jMenu_inscripcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_inscripcion1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenu_inscripcion1ActionPerformed

    private void jMenu_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_materiaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu_materiaActionPerformed

    private void jMenuAltaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAltaMateriaActionPerformed
        // TODO add your handling code here:
        jDesktopPrincipal.removeAll();
        jDesktopPrincipal.repaint();
        FormularioMateria fm = new FormularioMateria();
        fm.setVisible(true);
        jDesktopPrincipal.add(fm);
        jDesktopPrincipal.moveToFront(fm);
    }//GEN-LAST:event_jMenuAltaMateriaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JMenuItem jMenuAltaMateria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuManejoInscripcion;
    private javax.swing.JMenuItem jMenuManejoNota;
    private javax.swing.JMenuItem jMenuManejoNota1;
    private javax.swing.JMenu jMenu_alumno;
    private javax.swing.JMenuItem jMenu_alumnoAlta;
    private javax.swing.JMenu jMenu_inscripcion;
    private javax.swing.JMenu jMenu_inscripcion1;
    private javax.swing.JMenu jMenu_materia;
    // End of variables declaration//GEN-END:variables
}
