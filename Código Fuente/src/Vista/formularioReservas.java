package Vista;

import Entidad.ReservaEntidad;
import Servicios.ReservaServicio;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Martin Lana
 */
public class formularioReservas extends javax.swing.JFrame {

    public formularioReservas() {
        initComponents();
        mostrar("");
        inhabilitar();
    }

    //Declaro esta variable, que sera llamada si la accion es guardar o editar una reserva.
    private String accion = "guardar";

    //Metodo para ocultar las que no quiero mostrar, en este caso no quiero mostrar la columna id.
    void ocultarColumnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    //Le doy tamaños preferidos a las demas columnas
    void tamañoColumnas() {
        //Ademas le seteo tamaños preferidos a las demas columnas
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(25);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(25);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(25);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(100);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(25);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(25);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(15);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(15);
    }

//Metodo para inhabilitar los botones
    void inhabilitar() {
        txtidreserva.setVisible(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtdocumento.setEnabled(false);
        txtemail.setEnabled(false);
        combosala.setEnabled(false);
        datachooser_fecha_reserva.setEnabled(false);
        combohora_inicio.setEnabled(false);
        combohora_fin.setEnabled(false);

        botonguardar.setEnabled(false);
        botoncancelar.setEnabled(false);
        botoneliminar.setEnabled(false);

        //Dejo las cajas de texto en blanco
        txtidreserva.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtdocumento.setText("");
        txtemail.setText("");
    }

//Metodo para habilitar botones.
    void habilitar() {
        txtidreserva.setVisible(false);

        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtdocumento.setEnabled(true);
        txtemail.setEnabled(true);
        combosala.setEnabled(true);
        datachooser_fecha_reserva.setEnabled(true);
        combohora_inicio.setEnabled(true);
        combohora_fin.setEnabled(true);

        botonguardar.setEnabled(true);
        botoncancelar.setEnabled(true);
        botoneliminar.setEnabled(true);

        //Dejo las cajas de texto en blanco
        txtidreserva.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtdocumento.setText("");
        txtemail.setText("");
    }

//Meotodo para mostrar lo que busco. Recibe el parametro buscar.
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ReservaServicio funcion = new ReservaServicio();

            //Le envio a la funcion mostrar como parametro de busca lo que escribi en el txt buscar
            modelo = funcion.mostrar(buscar);

            //Lo que obtengo en modelo lo envio a mi lista de reservas.
            tablalistado.setModel(modelo);
            ocultarColumnas();
            tamañoColumnas();
            labeltotalregistros.setText("Total Registros " + Integer.toString(funcion.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);

        }

    }

    // Metodo para validar email
    public static boolean ValidarMail(String email) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combosala = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        datachooser_fecha_reserva = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        combohora_inicio = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        combohora_fin = new javax.swing.JComboBox<>();
        botonagregar = new javax.swing.JButton();
        botonguardar = new javax.swing.JButton();
        botoncancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        botonbuscar = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        botonsalir = new javax.swing.JButton();
        labeltotalregistros = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Reservas");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserva de Salas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Documento:");

        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });

        jLabel5.setText("Email:");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel6.setText("Sala a Reservar:");

        combosala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sala 1", "Sala 2", "Sala computación", "Sala 3", "Sala SUM", "Sala Reuniones", "Sala Silenciosa", "Sala Comedor", "Sala Estudio", "Laboratorio" }));
        combosala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosalaActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de Reserva:");

        jLabel8.setText("Hora Inicio de Reserva:");

        combohora_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8 Hs", "9 Hs", "10 Hs", "11 Hs", "12 Hs", "13 Hs", "14 Hs", "15 Hs", "16 Hs", "17 Hs", "18 Hs", "19 Hs" }));
        combohora_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohora_inicioActionPerformed(evt);
            }
        });

        jLabel9.setText("Hora Fin de Reserva:");

        combohora_fin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8 Hs", "9 Hs", "10 Hs", "11 Hs", "12 Hs", "13 Hs", "14 Hs", "15 Hs", "16 Hs", "17 Hs", "18 Hs", "19 Hs", "20 Hs" }));
        combohora_fin.setKeySelectionManager(null);
        combohora_fin.setLightWeightPopupEnabled(false);
        combohora_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohora_finActionPerformed(evt);
            }
        });

        botonagregar.setBackground(new java.awt.Color(153, 153, 153));
        botonagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonagregar.setText("Agregar Nueva Reserva");
        botonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarActionPerformed(evt);
            }
        });

        botonguardar.setBackground(new java.awt.Color(153, 153, 153));
        botonguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonguardar.setText("Guardar ");
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });

        botoncancelar.setBackground(new java.awt.Color(153, 153, 153));
        botoncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botoncancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonagregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(botonguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botoncancelar)
                                .addGap(35, 35, 35))
                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combosala, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datachooser_fecha_reserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combohora_inicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combohora_fin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(combosala, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(datachooser_fecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(combohora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(combohora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonagregar)
                    .addComponent(botonguardar)
                    .addComponent(botoncancelar))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista De Reservas"));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Buscar por apellido");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        botonbuscar.setBackground(new java.awt.Color(153, 153, 153));
        botonbuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonbuscar.setText("Buscar");
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });

        botoneliminar.setBackground(new java.awt.Color(153, 153, 153));
        botoneliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botoneliminar.setText("Eliminar");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        botonsalir.setBackground(new java.awt.Color(153, 153, 153));
        botonsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonsalir.setText("Salir");
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });

        labeltotalregistros.setBackground(new java.awt.Color(204, 204, 255));
        labeltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labeltotalregistros.setText("Registros");

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(botonbuscar)
                .addGap(18, 18, 18)
                .addComponent(botoneliminar)
                .addGap(18, 18, 18)
                .addComponent(botonsalir)
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labeltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonbuscar)
                    .addComponent(botoneliminar)
                    .addComponent(botonsalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(labeltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        txtapellido.transferFocus();
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        txtdocumento.transferFocus();
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void botonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarActionPerformed
        habilitar();
        botonguardar.setText("Guardar");
        accion = "guardar";

    }//GEN-LAST:event_botonagregarActionPerformed

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed

//Verifico que todos los datos ingresados sean válidos
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el nombre de la persona que realizó la reserva.");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellido.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el apellido de la persona que realizó la reserva.");
            txtapellido.requestFocus();
            return;
        }
        if (txtdocumento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el numero de documento de la persona que realizó la reserva.");
            txtdocumento.requestFocus();
            return;
        }

        if ((ValidarMail(txtemail.getText())) || (txtemail.getText().length() == 0)) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el email de la persona que realizó la reserva.");
            txtemail.requestFocus();
            return;
        }

        int comboSalaNumero = combosala.getSelectedIndex();
        String comboSalaCadena = String.valueOf(comboSalaNumero);
        if (comboSalaCadena.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una sala para reservar");
            combosala.requestFocus();
            return;
        }

        //Forma para verificar fecha
        Calendar calendario;
        int dia, mes, año;
        calendario = datachooser_fecha_reserva.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        //Le resto -1900 para obtener un formato correcto de año
        año = calendario.get(Calendar.YEAR);
        //Traigo la fecha del sistema para validar la fecha
        Calendar fecha = new GregorianCalendar();

        if ((dia < fecha.get(Calendar.DAY_OF_MONTH) && mes >= fecha.get(Calendar.MONTH) && año >= fecha.get(Calendar.YEAR)) || (año < fecha.get(Calendar.YEAR)) || (año < fecha.get(Calendar.YEAR) && mes < fecha.get(Calendar.MONTH))) {

            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una fecha válida");
            datachooser_fecha_reserva.requestFocus();
            return;
        }

        ReservaEntidad datos = new ReservaEntidad();
        ReservaServicio funcion = new ReservaServicio();

        //Envio los datos de las cajas de textos y combobox
        datos.setNombreCliente(txtnombre.getText());
        datos.setApellidoCliente(txtapellido.getText());
        datos.setDocumentoCliente(txtdocumento.getText());
        datos.setEmailCliente(txtemail.getText());

        //Forma para poder enviar los combobox
        int seleccionado = combosala.getSelectedIndex();
        datos.setSalaReservada(combosala.getItemAt(seleccionado));

        //Envio la fecha de reserva
        datos.setFechaReserva(new Date(año, mes, dia));

        //Envio la hora de inicio de la reserva
        seleccionado = combohora_inicio.getSelectedIndex();
        datos.setHoraInicioReserva(combohora_inicio.getItemAt(seleccionado));

        //Envio la hora de inicio de la reserva
        seleccionado = combohora_fin.getSelectedIndex();
        datos.setHoraFinReserva(combohora_fin.getItemAt(seleccionado));

        if (accion.equals("guardar")) {
            if (funcion.insertar(datos)) {

                JOptionPane.showMessageDialog(rootPane, "La reserva fue registrada correctamente en la lista de reservas");

                mostrar("");
                inhabilitar();
            }

        } else if (accion.equals("editar")) {
            datos.setIdReserva(Integer.parseInt(txtidreserva.getText()));

            if (funcion.editar(datos)) {
                JOptionPane.showMessageDialog(rootPane, "Se editaron los datos de la reserva");
                mostrar("");
                inhabilitar();

            }
        }


    }//GEN-LAST:event_botonguardarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
        //Si el id no es vacio, elimino esa reserva
        if (!txtidreserva.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea eliminar la reserva?", "Confirmar", 2);

            //Si confirmacion es igual a 0, la elimino
            if (confirmacion == 0) {
                ReservaServicio funcion = new ReservaServicio();
                ReservaEntidad datos = new ReservaEntidad();

                datos.setIdReserva(Integer.parseInt(txtidreserva.getText()));
                funcion.eliminar(datos);
                mostrar("");
                inhabilitar();

            }
        }
    }//GEN-LAST:event_botoneliminarActionPerformed

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        //muestro lo que ingresé en el cuadro de busqueda
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_botonbuscarActionPerformed

    private void combosalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosalaActionPerformed
        combosala.transferFocus();
    }//GEN-LAST:event_combosalaActionPerformed

    private void combohora_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohora_inicioActionPerformed
        combohora_inicio.transferFocus();
    }//GEN-LAST:event_combohora_inicioActionPerformed

    private void combohora_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohora_finActionPerformed
        combohora_fin.transferFocus();
    }//GEN-LAST:event_combohora_finActionPerformed

    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
        int advertencia = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea cerrar el programa?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (advertencia == JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_botonsalirActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        botonguardar.setText("Guardar cambios");
        habilitar();
        botoneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint((evt.getPoint()));

        txtidreserva.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());
        txtapellido.setText(tablalistado.getValueAt(fila, 2).toString());
        txtdocumento.setText(tablalistado.getValueAt(fila, 3).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 4).toString());
        combosala.setSelectedItem(tablalistado.getValueAt(fila, 5).toString());
        datachooser_fecha_reserva.setDate(Date.valueOf(tablalistado.getValueAt(fila, 6).toString()));
        combohora_inicio.setSelectedItem(tablalistado.getValueAt(fila, 7).toString());
        combohora_fin.setSelectedItem(tablalistado.getValueAt(fila, 8).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped
        //Validar que el documento sean solo numeros
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un documento válido");
        }
    }//GEN-LAST:event_txtdocumentoKeyTyped

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
            java.util.logging.Logger.getLogger(formularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formularioReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonagregar;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JButton botoncancelar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonguardar;
    private javax.swing.JButton botonsalir;
    private javax.swing.JComboBox<String> combohora_fin;
    private javax.swing.JComboBox<String> combohora_inicio;
    private javax.swing.JComboBox<String> combosala;
    private com.toedter.calendar.JDateChooser datachooser_fecha_reserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
