
package transversal_vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import transversal_accesoDeDatos.AlumnoData;
import transversal_accesoDeDatos.InscripcionData;
import transversal_accesoDeDatos.MateriaData;
import transversal_entidades.Alumno;
import transversal_entidades.Inscripcion;
import transversal_entidades.Materia;


public class FormularioInscripcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioInscripcion
     */
    
    private List<Materia> listaMateria;
    private List<Alumno> listaAlumno;
    
    private InscripcionData inscripcionData;
    private AlumnoData alData;
    private MateriaData materiaData;
    private DefaultTableModel modeloTabla;
    
    public FormularioInscripcion() {
        initComponents();
        
        alData = new AlumnoData();
        listaAlumno=  alData.listarAlumnos();
        
        modeloTabla = new DefaultTableModel();
        inscripcionData = new InscripcionData();
        materiaData = new MateriaData();
        
        //agregacion a la lista de los alumnos
        cargarAlumnos();
        armarCabeceraTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_tituloInscripcionFormulario = new javax.swing.JLabel();
        jLabel1_alumno = new javax.swing.JLabel();
        jcomboBoxAlumno = new javax.swing.JComboBox<>();
        jRadioButton_materiasInscriptas = new javax.swing.JRadioButton();
        jRadioButton_materiasNOInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_listadoMateria = new javax.swing.JTable();
        jButton_anularInscripcion = new javax.swing.JButton();
        jButton2_inscribir = new javax.swing.JButton();
        jButton_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Inscripción");

        jLabel_tituloInscripcionFormulario.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel_tituloInscripcionFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/inscripcion.png"))); // NOI18N
        jLabel_tituloInscripcionFormulario.setText("Manejo de inscripción");

        jLabel1_alumno.setText("Seleccione un alumno:");

        jcomboBoxAlumno.setToolTipText("");

        jRadioButton_materiasInscriptas.setText("Materias inscriptas");
        jRadioButton_materiasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_materiasInscriptasActionPerformed(evt);
            }
        });

        jRadioButton_materiasNOInscriptas.setText("Materias no inscriptas");
        jRadioButton_materiasNOInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_materiasNOInscriptasActionPerformed(evt);
            }
        });

        jTable1_listadoMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1_listadoMateria);

        jButton_anularInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/borrador.png"))); // NOI18N
        jButton_anularInscripcion.setText("Anular inscripción");
        jButton_anularInscripcion.setEnabled(false);
        jButton_anularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anularInscripcionActionPerformed(evt);
            }
        });

        jButton2_inscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/inscribir.png"))); // NOI18N
        jButton2_inscribir.setText("Inscribir");
        jButton2_inscribir.setEnabled(false);
        jButton2_inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_inscribirActionPerformed(evt);
            }
        });

        jButton_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal_accesoDeDatos/recursos/salir.png"))); // NOI18N
        jButton_salir.setText("Salir");
        jButton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salirActionPerformed(evt);
            }
        });

        jLabel1.setText("Listado de materias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel1_alumno)
                            .addGap(40, 40, 40)
                            .addComponent(jcomboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton_materiasInscriptas)
                                        .addGap(163, 163, 163)
                                        .addComponent(jRadioButton_materiasNOInscriptas)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2_inscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jButton_anularInscripcion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel_tituloInscripcionFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel_tituloInscripcionFormulario)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1_alumno)
                    .addComponent(jcomboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_materiasInscriptas)
                    .addComponent(jRadioButton_materiasNOInscriptas))
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_salir)
                    .addComponent(jButton_anularInscripcion)
                    .addComponent(jButton2_inscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_materiasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_materiasInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        //deseleccionar el otro radioboton
        jRadioButton_materiasNOInscriptas.setSelected(false);
        datosInscriptas();
        jButton_anularInscripcion.setEnabled(true);
        jButton2_inscribir.setEnabled(false);
        
    }//GEN-LAST:event_jRadioButton_materiasInscriptasActionPerformed

    private void jRadioButton_materiasNOInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_materiasNOInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        //deseleccionar el otro radioboton
        jRadioButton_materiasInscriptas.setSelected(false);
        datosDeNoInscriptos();
        jButton_anularInscripcion.setEnabled(false);
        jButton2_inscribir.setEnabled(true);
    }//GEN-LAST:event_jRadioButton_materiasNOInscriptasActionPerformed

    private void jButton2_inscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_inscribirActionPerformed
        // TODO add your handling code here:
        
        int filaSeleccionadaTabla = jTable1_listadoMateria.getSelectedRow();
        if (filaSeleccionadaTabla!=-1) {
           Alumno al = (Alumno)jcomboBoxAlumno.getSelectedItem();
           int idMateria = (Integer) modeloTabla.getValueAt(filaSeleccionadaTabla, 0);
           String nombreMateria = (String) modeloTabla.getValueAt(filaSeleccionadaTabla, 1);
           int anio = (Integer) modeloTabla.getValueAt(filaSeleccionadaTabla, 2);
           
           Materia materia = new Materia(idMateria, nombreMateria, anio, true);
           Inscripcion ins = new Inscripcion(0, al, materia);
           inscripcionData.guardarInscripcion(ins);
           borrarFilas();
        }
    }//GEN-LAST:event_jButton2_inscribirActionPerformed

    private void jButton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_salirActionPerformed

    private void jButton_anularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anularInscripcionActionPerformed
        // TODO add your handling code here:
        int filaSeleccionadaTabla = jTable1_listadoMateria.getSelectedRow();

        if (filaSeleccionadaTabla !=-1) {
            Alumno al = (Alumno) jcomboBoxAlumno.getSelectedItem();
            int idMateria = (Integer) modeloTabla.getValueAt(filaSeleccionadaTabla, 0);
            inscripcionData.borrarInscripcion(al.getIdAlumno(), idMateria);
            borrarFilas();
        }else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una materia, para poder anular la inscripción");
        }
    }//GEN-LAST:event_jButton_anularInscripcionActionPerformed
    
    
    
    private void datosInscriptas() {
        Alumno alumnoSeleccionado = (Alumno) jcomboBoxAlumno.getSelectedItem();
        List<Materia> lista = inscripcionData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());
        for (Materia m : lista) {
            modeloTabla.addRow(new Object[]{
                m.getIdMateria(),
                m.getNombre(), 
                m.getAnioMateria()
            });
        }
    }
    

    private void datosDeNoInscriptos() {
        Alumno selAlumnoNoInscripto = (Alumno) jcomboBoxAlumno.getSelectedItem();
        listaMateria = (ArrayList) inscripcionData.materiasNoCursadasPorAlumno(selAlumnoNoInscripto.getIdAlumno());
         for (Materia m : listaMateria) {
           modeloTabla.addRow(new  Object[]{
               m.getIdMateria(), 
               m.getNombre(),
               m.getAnioMateria()});
        }
    }
    
    
    private void cargarAlumnos () {
         for ( Alumno aux : listaAlumno) {
             jcomboBoxAlumno.addItem(aux);
         }
     }
    
    
    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("id");
        filaCabecera.add("Nombre");
        filaCabecera.add("Año");
        for (Object item : filaCabecera) {
            modeloTabla.addColumn(item);
        }
        jTable1_listadoMateria.setModel(modeloTabla);
    }
    
    
    private void borrarFilas () {
        //devuelve la cant de fila = getRowCount, que va a ser usada como indice por eso se resta -1
        int indiceFila = modeloTabla.getRowCount()-1;
        for(int i=indiceFila; i>0;  i--) {
            modeloTabla.removeRow(i);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_inscribir;
    private javax.swing.JButton jButton_anularInscripcion;
    private javax.swing.JButton jButton_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_alumno;
    private javax.swing.JLabel jLabel_tituloInscripcionFormulario;
    private javax.swing.JRadioButton jRadioButton_materiasInscriptas;
    private javax.swing.JRadioButton jRadioButton_materiasNOInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1_listadoMateria;
    private javax.swing.JComboBox<Alumno> jcomboBoxAlumno;
    // End of variables declaration//GEN-END:variables
}
