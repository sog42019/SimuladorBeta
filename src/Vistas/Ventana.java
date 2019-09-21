package Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import simulador.de.procesos.Particion;
import simulador.de.procesos.Proceso;
import simulador.de.procesos.Recurso;


public class Ventana extends javax.swing.JFrame {

    //La clase Ventana es la que contiene toda la interfaz gráfica
    
    //Variables globales
    int PID = 0;
    int quantum;
    int tamMemFija = 0;
    int tamMemVar = 0;
    int cantPart = 0;
    int tamPart;
    int mayorProceso = 0;
    int procesosVivos, div = 0; 
    float tr, te;
    int ts = 0;
    int ta = 0; 
    int ti = 0;
    Recurso CPU, ES1, ES2;
    Proceso proceso, procesoCPU, procesoES1, procesoES2;
    Particion particiones[];
    ArrayList<Particion> memoriaVariable; //variable global de lista que simula ser la memoria en particion variable
    int Time = -1;
    ArrayList<Proceso> lista = new ArrayList<Proceso>();      //Crea una lista con objetos de la clase Proceso
    ArrayList<Proceso> colaListo = new ArrayList<Proceso>();    //Aquí estan los procesos que esperam por la CPU
    ArrayList<Proceso> colaNuevo = new ArrayList<Proceso>();    //Lista con los procesos que esperan por ingresar a la cola de listo y a memoria
    ArrayList<Proceso> colaBloqueado1 = new ArrayList<Proceso>();    //Lista que contiene los procesos que esperan por ES
    ArrayList<Proceso> colaBloqueado2 = new ArrayList<Proceso>();    //Lista que contiene los procesos que esperan por ES
    VentanaSalida ventanaSalida;
    
    public Ventana() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acercaDe = new javax.swing.JDialog();
        acercaDe.setSize(275,275);
        jPanel6 = new javax.swing.JPanel();
        jPanel6.setLayout(null);  
 jPanel6.setOpaque(true);
 jPanel6.setBackground(new java.awt.Color(135,200,122));  
 jPanel6.setBounds(0,0,275,50);
        jLabel1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        BtnRegistrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTA = new javax.swing.JTextField();
        txtTam = new javax.swing.JTextField();
        txtCPU1 = new javax.swing.JTextField();
        txtES = new javax.swing.JTextField();
        txtCPU2 = new javax.swing.JTextField();
        txtES2 = new javax.swing.JTextField();
        txtCPU3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxCantCPU = new javax.swing.JComboBox<String>();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxGesMemVar = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoPart = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxNroPart = new javax.swing.JComboBox<String>();
        jComboBoxPlan = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        Quantum = new javax.swing.JTextField();
        jComboBoxGesmemFija = new javax.swing.JComboBox<String>();
        jComboBoxGesmemFija.setVisible(false);
        jTextFieldTamMV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProceso = new javax.swing.JTable();
        jButtonEjecutar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNuevo = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuAcercaDe = new javax.swing.JMenuItem();

        acercaDe.setTitle("Acerca de...");
        acercaDe.setIconImage(new ImageIcon("logo.png").getImage());
        acercaDe.setLocation(new java.awt.Point(500, 100));
        acercaDe.setResizable(false);
        acercaDe.setSize(new java.awt.Dimension(300, 300));

        jPanel6.setPreferredSize(new java.awt.Dimension(325, 52));

        jLabel1.setBackground(new java.awt.Color(135, 200, 122));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SiPro");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(" Sistema desarrolado por un grupo de alumnos\n del tercer año de la carrera Ingeniería en \n Sistemas de Información, de la UTN - FRRe.\n\n Equipo:\n Ferreyra, Eduardo\n Invernizzi, Gerardo\n Ledesma, Ramiro\n Ramírez, Joselina\n");
        jTextArea1.setAlignmentY(this.LEFT_ALIGNMENT);
        jTextArea1.setPreferredSize(new java.awt.Dimension(265, 184));

        javax.swing.GroupLayout acercaDeLayout = new javax.swing.GroupLayout(acercaDe.getContentPane());
        acercaDe.getContentPane().setLayout(acercaDeLayout);
        acercaDeLayout.setHorizontalGroup(
            acercaDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acercaDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        acercaDeLayout.setVerticalGroup(
            acercaDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acercaDeLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SiPro");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        setLocation(new java.awt.Point(500, 100));
        setMinimumSize(new java.awt.Dimension(800, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        BtnRegistrar.setBackground(new java.awt.Color(51, 153, 255));
        BtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar.setText("Añadir ");
        BtnRegistrar.setToolTipText("");
        BtnRegistrar.setBorderPainted(false);
        BtnRegistrar.setFocusPainted(false);
        BtnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegistrarMouseClicked(evt);
            }
        });
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tiempo de arribo");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tamaño");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("CPU");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("E/S 1");
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel5KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("CPU ");

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        txtTA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTAActionPerformed(evt);
            }
        });
        txtTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAKeyTyped(evt);
            }
        });

        txtTam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTamKeyTyped(evt);
            }
        });

        txtCPU1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCPU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPU1ActionPerformed(evt);
            }
        });
        txtCPU1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPU1KeyTyped(evt);
            }
        });

        txtES.setEditable(false);
        txtES.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtESActionPerformed(evt);
            }
        });
        txtES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtESKeyTyped(evt);
            }
        });

        txtCPU2.setEditable(false);
        txtCPU2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCPU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPU2ActionPerformed(evt);
            }
        });
        txtCPU2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPU2KeyTyped(evt);
            }
        });

        txtES2.setEditable(false);
        txtES2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtES2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtES2ActionPerformed(evt);
            }
        });
        txtES2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtES2KeyTyped(evt);
            }
        });

        txtCPU3.setEditable(false);
        txtCPU3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCPU3.setDragEnabled(true);
        txtCPU3.setEnabled(false);
        txtCPU3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPU3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTA, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtTam)
                    .addComponent(txtCPU1)
                    .addComponent(txtES)
                    .addComponent(txtCPU2)
                    .addComponent(txtES2)
                    .addComponent(txtCPU3)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPU1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPU2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtES2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPU3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("E/S 2");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CPU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Carga de procesos");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Cantidad ráfagas CPU");

        jComboBoxCantCPU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jComboBoxCantCPU.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCantCPUItemStateChanged(evt);
            }
        });
        jComboBoxCantCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCantCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBoxCantCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 18, Short.MAX_VALUE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCantCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRegistrar)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 250, 370));

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));
        jPanel7.setForeground(new java.awt.Color(0, 0, 51));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setText(" PLANIFICADOR DE PROCESOS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -10, 290, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Algoritmo planificación de proceso");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 4, 200, -1));

        jComboBoxGesMemVar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First-Fit", "Worst-Fit" }));
        jComboBoxGesMemVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGesMemVarActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxGesMemVar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 190, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tipo de partición");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, -1));

        jComboBoxTipoPart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Variable", "Fija" }));
        jComboBoxTipoPart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoPartItemStateChanged(evt);
            }
        });
        jComboBoxTipoPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPartActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxTipoPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, -1));
        jComboBoxNroPart.setVisible(false);
        jLabel11.setVisible(false);

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tamaño de memoria");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 190, 17));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Numero de particiones");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 190, -1));

        jComboBoxNroPart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8" }));
        jComboBoxNroPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNroPartActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxNroPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 190, -1));

        jComboBoxPlan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FCFS", "Round Robin", "SJF", "SRTF" }));
        jComboBoxPlan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPlanItemStateChanged(evt);
            }
        });
        jComboBoxPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlanActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 26, 190, -1));
        jComboBoxPlan.getAccessibleContext().setAccessibleName("");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Algoritmo de asignación de memoria");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 190, -1));

        Quantum.setEditable(false);
        Quantum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Quantum.setToolTipText("");
        Quantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantumActionPerformed(evt);
            }
        });
        Quantum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QuantumKeyTyped(evt);
            }
        });
        jPanel3.add(Quantum, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 73, 190, 18));

        jComboBoxGesmemFija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First-Fit", "Best-Fit" }));
        jComboBoxGesmemFija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGesmemFijaActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxGesmemFija, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 190, -1));

        jTextFieldTamMV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTamMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTamMVActionPerformed(evt);
            }
        });
        jTextFieldTamMV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTamMVKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldTamMV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 190, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quantum");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 57, 190, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("MEMORIA");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, 180, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 290, 340));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PID", "TA", "Tamaño", "CPU ", "E / S", "CPU ", "E / S", "CPU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableProceso.setFocusable(false);
        jTableProceso.setGridColor(new java.awt.Color(204, 204, 255));
        jTableProceso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableProcesoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProceso);
        if (jTableProceso.getColumnModel().getColumnCount() > 0) {
            jTableProceso.getColumnModel().getColumn(0).setHeaderValue("PID");
            jTableProceso.getColumnModel().getColumn(1).setHeaderValue("TA");
            jTableProceso.getColumnModel().getColumn(2).setHeaderValue("Tamaño");
            jTableProceso.getColumnModel().getColumn(3).setHeaderValue("CPU ");
            jTableProceso.getColumnModel().getColumn(4).setHeaderValue("E / S");
            jTableProceso.getColumnModel().getColumn(5).setHeaderValue("CPU ");
            jTableProceso.getColumnModel().getColumn(6).setHeaderValue("E / S");
            jTableProceso.getColumnModel().getColumn(7).setHeaderValue("CPU");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 600, -1));

        jButtonEjecutar.setBackground(new java.awt.Color(0, 204, 102));
        jButtonEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEjecutar.setMnemonic('e');
        jButtonEjecutar.setText(" Ejecutar");
        jButtonEjecutar.setToolTipText("");
        jButtonEjecutar.setFocusPainted(false);
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 612, 260, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo-de-pantalla-Sistemas-Operativos-16.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 800, 800));

        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuBar1MousePressed(evt);
            }
        });

        jMenu1.setText("Archivo");
        jMenu1.setMinimumSize(new java.awt.Dimension(70, 19));

        jMenuNuevo.setBackground(new java.awt.Color(255, 255, 255));
        jMenuNuevo.setText("Nuevo");
        jMenuNuevo.setMinimumSize(new java.awt.Dimension(70, 0));
        jMenuNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuNuevoMousePressed(evt);
            }
        });
        jMenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNuevo);

        jMenuSalir.setBackground(new java.awt.Color(255, 255, 255));
        jMenuSalir.setText("Salir");
        jMenuSalir.setMinimumSize(new java.awt.Dimension(70, 0));
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuAcercaDe.setBackground(new java.awt.Color(255, 255, 255));
        jMenuAcercaDe.setText("Acerca de...");
        jMenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void mostrar() {     //Este proceso sólo se va utilizar para mostrar los procesos en la tabla
        String matriz [][] = new String [lista.size()][8];
        for (int i = 0; i < lista.size(); i++) {
                matriz[i][0] = Integer.toString(lista.get(i).getPID());
                matriz[i][1] = Integer.toString(lista.get(i).getTA());
                matriz[i][2] = Integer.toString(lista.get(i).getTam());
                matriz[i][3] = Integer.toString(lista.get(i).getCPU1());
                matriz[i][4] = Integer.toString(lista.get(i).getES1());
                matriz[i][5] = Integer.toString(lista.get(i).getCPU2());
                matriz[i][6] = Integer.toString(lista.get(i).getES2());
                matriz[i][7] = Integer.toString(lista.get(i).getCPU3());
        }
        jTableProceso.setModel(new javax.swing.table.DefaultTableModel(
            matriz, new String [] {"PID", "TA", "Tamaño", "CPU", "E/S", "CPU","E/S", "CPU"}
        ));
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jTableProceso.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jTableProceso.getColumnModel().getColumn(7).setCellRenderer(tcr);
    }
    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        jComboBoxCantCPU.setEnabled(false);
        if(txtTA.getText().equals("")||(txtTam.getText().equals(""))||(txtCPU1.getText().equals(""))){
            JOptionPane.showMessageDialog(rootPane, "No se puede dejar un campo vacío");
        }else if((txtTam.getText().contentEquals("0")) ||(txtCPU1.getText().contentEquals("0"))){
            JOptionPane.showMessageDialog(rootPane, "Sólo el tiempo de arribo puede ser cero");
        }else if((jComboBoxCantCPU.getSelectedIndex()==1)&((txtCPU2.getText().equals(""))||(txtES.getText().equals("")))){ 
            JOptionPane.showMessageDialog(rootPane, "No se puede dejar un campo vacío");
        }else if((jComboBoxCantCPU.getSelectedIndex()==1)&((txtCPU2.getText().contentEquals("0"))||(txtES.getText().contentEquals("0")))){ 
            JOptionPane.showMessageDialog(rootPane, "Sólo el tiempo de arribo puede ser cero");
        }else if((jComboBoxCantCPU.getSelectedIndex()==2)&((txtCPU2.getText().equals(""))||(txtES.getText().equals(""))||(txtES2.getText().equals(""))||(txtCPU3.getText().equals("")))){ 
            JOptionPane.showMessageDialog(rootPane, "No se puede dejar un campo vacío");
        }else if((jComboBoxCantCPU.getSelectedIndex()==2)&((txtCPU2.getText().contentEquals("0"))||(txtES.getText().contentEquals("0"))||(txtES2.getText().contentEquals("0"))||(txtCPU3.getText().contentEquals("0")))){ 
            JOptionPane.showMessageDialog(rootPane, "Sólo el tiempo de arribo puede ser cero");
        }else{
            PID++;  //incrementar el identificador
            if (jComboBoxCantCPU.getSelectedIndex() == 0){ //Carga los procesos con una rafaga de CPU
                proceso = new Proceso(PID, Integer.parseInt(txtTA.getText()),Integer.parseInt(txtTam.getText()),
                Integer.parseInt(txtCPU1.getText()),0,0,0,0);      //Carga los datos ingresados al obejto "proceso"
            } else   
            if (jComboBoxCantCPU.getSelectedIndex()==1){    //Carga los procesos con 2 rafagas de CPU
                proceso = new Proceso(PID, Integer.parseInt(txtTA.getText()),Integer.parseInt(txtTam.getText()),
                Integer.parseInt(txtCPU1.getText()), Integer.parseInt(txtES.getText()),
                Integer.parseInt(txtCPU2.getText()),0,0);      //Carga los datos ingresados al obejto "proceso"
            } else
            if (jComboBoxCantCPU.getSelectedIndex()==2){    //Carga los procesos con 2 rafagas de CPU
                proceso = new Proceso(PID, Integer.parseInt(txtTA.getText()),Integer.parseInt(txtTam.getText()),
                Integer.parseInt(txtCPU1.getText()), Integer.parseInt(txtES.getText()),
                Integer.parseInt(txtCPU2.getText()),Integer.parseInt(txtES2.getText()),Integer.parseInt(txtCPU3.getText()));      //Carga los datos ingresados al obejto "proceso"

            }
            ta += proceso.TA;
            ti += (proceso.CPU1+proceso.CPU2+proceso.CPU3);
            lista.add(proceso);     //Agrega el objeto proceso a la lista
            mostrar();              //Llama a la función que muestra los datos en la tabla
         }
        txtTA.setText("");      //Vacía los campos para ingresar el siguiente proceso
        txtTam.setText("");
        txtCPU1.setText("");
        txtES.setText("");
        txtCPU2.setText("");
        txtES2.setText("");
        txtCPU3.setText("");

    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void txtCPU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPU2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPU2ActionPerformed

    private void txtESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtESActionPerformed

    private void txtCPU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPU1ActionPerformed

    private void txtTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTAActionPerformed

    private void jMenuNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuNuevoMousePressed
        
        String matriz [][] = new String [1][8];
        
            matriz[0][0] = null;
            matriz[0][1] = null;
            matriz[0][2] = null;
            matriz[0][3] = null;
            matriz[0][4] = null;
            matriz[0][5] = null;
            matriz[0][6] = null;
            matriz[0][7] = null;
        
       
        jTableProceso.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "PID", "TA", "Tamaño", "CPU", "E / S", "CPU","E / S", "CPU"
            }
        ));
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTableProceso.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(4).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(5).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(6).setCellRenderer(tcr);
            jTableProceso.getColumnModel().getColumn(7).setCellRenderer(tcr);
        lista.clear();
        colaListo.clear();
        colaNuevo.clear();
        PID = 0;
        Time = -1;
        particiones = null;
        memoriaVariable = null;
        CPU = new Recurso(0,0,0,0,0,0,0,0,true);
        ES1 = new Recurso(0,0,0,0,0,0,0,0,true);        
        ES2 = new Recurso(0,0,0,0,0,0,0,0,true);
        jComboBoxCantCPU.setEnabled(true);
        jButtonEjecutar.setEnabled(true);
        BtnRegistrar.setEnabled(true);
        tr=0;
        te=0;
        ts=0;
        ta=0;
        ti=0;
    }//GEN-LAST:event_jMenuNuevoMousePressed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
       System.exit(0); //Cierra el programa
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcercaDeActionPerformed
    acercaDe.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuAcercaDeActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
       int tama;
       div = lista.size();
       procesosVivos = lista.size(); //Guarda la cantidad de procesos que ingresó el usuario, se irá decrementando a medida que cada proceso finalice
       cantPart = jComboBoxNroPart.getSelectedIndex() + 2;
       
       for (Proceso lista1 : lista) {  //Recorre la lista para saber cual es
            tama = lista1.getTam();     //el tamaño del proceso mayor
            if (tama > mayorProceso) {
                mayorProceso = tama;
            }
       }
       
        if (jTextFieldTamMV.getText().isEmpty()) {  //Si el usuario no designó el tamaño de la memoria variable, el tamaño por defecto será el triple del tamaño del proceso mayor
            tamMemVar = mayorProceso*3;
        }else{
            tamMemVar = Integer.parseInt(jTextFieldTamMV.getText());
        }
        
        
        
        if (jComboBoxTipoPart.getSelectedIndex() == 1){    
          crearMemFija(cantPart); 
        } else {
          if (mayorProceso > tamMemVar) {    //Error si un proceso es mayor que la memoria o particion
            JOptionPane.showMessageDialog(null, "Uno o más procesos no podrán ejecutarse por su tamaño", "Alerta", JOptionPane.WARNING_MESSAGE);
          }else{
              crearMemVar();
          }
        }
        ventanaSalida = new VentanaSalida(particiones, tamMemFija, Time);
        ejecutar();
    }//GEN-LAST:event_jButtonEjecutarActionPerformed
    public void ejecutar() {
        jButtonEjecutar.setEnabled(false);
        BtnRegistrar.setEnabled(false);
        CPU = new Recurso(0, 0, 0, 0, 0, 0, 0,0,true);
        ES1 = new Recurso(0, 0, 0, 0, 0, 0, 0,0,true);
        ES2 = new Recurso(0, 0, 0, 0, 0, 0, 0,0,true);
        
        Collections.sort(lista); //Ordena la lista por TA
        colaNuevo = lista;
        
        
        while (procesosVivos > 0) {  //itera hasta que no hayan mas procesos vivos
            Time++;  

            tratarColaNuevo(); //Recorre la cola de Nuevo y carga los procesos que cumplan las condiciones a la cola de Listo y a la memoria, con el tipo de asignacion que haya elegido el usuario
            tratarAlgoritmo();
            tratarES();  
            
            ventanaSalida.dibujarMemoria(particiones, memoriaVariable, tamMemFija, Time);   //Por cada unidad de tiempo dibuja una memoria en ese instante
            ventanaSalida.dibujarCPU(Time, CPU.getPID());
            ventanaSalida.dibujarES(Time,ES1.getPID());
            ventanaSalida.dibujarES2(Time,ES2.getPID());
        }
        tr = ts - ta;
        te = tr - ti;
        tr = Math.round((tr/div) * 100) / 100f;
        te = Math.round((te/div) * 100) / 100f;
        ventanaSalida.mostrarSalida(Time, tr, te, (jComboBoxCantCPU.getSelectedIndex()+1));
        ventanaSalida.setVisible(true); //Cuando ya finalizaron todos los procesos, muestra la salida
        
    }
    
    public void tratarAlgoritmo(){
        switch (jComboBoxPlan.getSelectedIndex()) 
        {
            case 0: algoritmoFCFS();
            break;
            case 1: algoritmoRR();
            break;
            case 2: algoritmoSJF();
            break;
            case 3: algoritmoSRTF();
            break;
        }
    }
    
    public void tratarES(){
        if (!ES1.isLibre()){ //Si esta ocupada la primer E/S descuenta una unidad de tiempo
            ES1.ES1--;
        } 
        if (!ES2.isLibre()){    //Si esta ocupada la segunda E/S descuenta una unidad de tiempo
            ES2.ES2--;
        }
        cargarES1conCB1();  //Si la primer E/S está libre, la carga con un proceso que este en la colaBloqueado1, si lo tuviese
        cargarES2conCB2();  //Si la segunda E/S está libre, la carga con un proceso que este en la colaBloqueado2, si lo tuviese
        if ((!ES1.isLibre())&&(ES1.ES1 == 0)) { //Si la primer E/S está ocupada y se le acabó el tiempo, debe abandonar el recurso y volver a la colaListo
                procesoES1 = new Proceso(ES1.PID,ES1.TA,ES1.Tam,ES1.CPU1,ES1.ES1,ES1.CPU2,ES1.ES2,ES1.CPU3);
                colaListo.add(procesoES1);
                ES1 = new Recurso(0,0,0,0,0,0,0,0,true);
                cargarES1conCB1();
        }
        if ((!ES2.isLibre())&&(ES2.ES2 == 0)) { //Si la segunda E/S está ocupada y se le acabó el tiempo, debe abandonar el recurso y volver a la colaListo
                procesoES2 = new Proceso(ES2.PID,ES2.TA,ES2.Tam,ES2.CPU1,ES2.ES1,ES2.CPU2,ES2.ES2,ES2.CPU3);
                colaListo.add(procesoES2);
                ES2 = new Recurso(0,0,0,0,0,0,0,0,true);
                cargarES2conCB2();
        }
        tratarColaNuevo();    //Siempre hacer esto antes de preguntar por colaListo, porque puede ser haya un proceso que este esperando que finalice otro para ocupar ese espacio de memoria
        if((jComboBoxPlan.getSelectedIndex()==2)||(jComboBoxPlan.getSelectedIndex()==3)){
            ordenarCLporCPU();
            if((jComboBoxPlan.getSelectedIndex()==3)&&(!colaListo.isEmpty())){
                Proceso pro_menor = colaListo.get(0);
                int tiempoProceso = menorTiempoCpuProceso(pro_menor); //obtento el tiempo de CPU del Proceso mas quequeño
                //creo una clase proceso auxiliar y almaceno los datos del proceso actual en CPU
                Proceso pro_CPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                //obtento el tiempo de CPU del proceso en CPU
                int tiempoCPU = menorTiempoCpuProceso(pro_CPU);
                if(tiempoProceso < tiempoCPU){ 
                    //pregunta si el tiempo del proceso que arriva es menor al tiempo del proceso que esta en CPU
                    //el proceso que está primero en la cola de listo se apropia de CPU
                    desalojarProcesoDeCPU();
                }
            }
        }
        if((quantum==0)&&(!CPU.isLibre())&&(jComboBoxPlan.getSelectedIndex()==1)){
            desalojarProcesoDeCPU();
        }
        if((CPU.isLibre()) && (!colaListo.isEmpty())){
            cargarCPUconCL();   //Si CPU está libre y hay un elemento en la colaListo, lo asigna a la CPU
            if (Quantum.getText().isEmpty()) {  //Si el usuario no designó ningún quantum, el valor por defecto será 2
                quantum = 2;
            }else{
                quantum = Integer.parseInt(Quantum.getText()); 
            }
        }
    }
    
    public void algoritmoFCFS(){
        if (!CPU.isLibre()){
                switch (jComboBoxCantCPU.getSelectedIndex()){
                    case 0: CPU.CPU1--;break;
                    case 1: if (CPU.CPU1 == 0){
                                CPU.CPU2--;
                            }else{
                               CPU.CPU1--; 
                            }break;
                    case 2: if (CPU.CPU1 > 0){
                                CPU.CPU1--;
                            }else{
                                if(CPU.CPU2>0){
                                   CPU.CPU2--;
                                }else{
                                CPU.CPU3--;
                                }
                            }break;
                }
        }else{  
            cargarCPUconCL();
        }
        if ((CPU.CPU1 == 0)&(!CPU.isLibre())) {   
            if(jComboBoxCantCPU.getSelectedIndex()==0){ //Pregunta si eligio trabajar con una sola rafaga de CPU, 
                finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
            } else { 
                    if(CPU.ES1>0) {//Si tiene 2 rafagas de CPU y la primera ya está en cero, entra acá
                        procesoCPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                        CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                        colaBloqueado1.add(procesoCPU);
                    }else{
                        if(CPU.CPU2 ==0){
                            if(jComboBoxCantCPU.getSelectedIndex()==1){
                                finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
                            } else{
                                if(CPU.ES2>0){
                                    procesoCPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                                    colaBloqueado2.add(procesoCPU);
                                    CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                                }else{
                                    if(CPU.CPU3==0){
                                        finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
                                    }
                                }
                            }
                        }
                    }
            } 
        }
    }
    
    public void algoritmoRR(){
        if (!CPU.isLibre()){
                switch (jComboBoxCantCPU.getSelectedIndex()){
                    case 0: CPU.CPU1--;break;
                    case 1: if (CPU.CPU1 == 0){
                                CPU.CPU2--;
                            }else{
                               CPU.CPU1--; 
                            }break;
                    case 2: if (CPU.CPU1 > 0){
                                CPU.CPU1--;
                            }else{
                                if(CPU.CPU2>0){
                                   CPU.CPU2--;
                                }else{
                                CPU.CPU3--;
                                }
                            }break;
                }
                quantum--;
        }else{  
            cargarCPUconCL();
            if (Quantum.getText().isEmpty()) {  //Si el usuario no designó ningún quantum, el valor por defecto será 2
                quantum = 2;
            }else{
                quantum = Integer.parseInt(Quantum.getText()); 
            }
        }
        algoritmoBase();
    }
    
    public void algoritmoSJF(){
        if (!CPU.isLibre()){
                switch (jComboBoxCantCPU.getSelectedIndex()){
                    case 0: CPU.CPU1--;break;
                    case 1: if (CPU.CPU1 == 0){
                                CPU.CPU2--;
                            }else{
                               CPU.CPU1--; 
                            }break;
                    case 2: if (CPU.CPU1 > 0){
                                CPU.CPU1--;
                            }else{
                                if(CPU.CPU2>0){
                                   CPU.CPU2--;
                                }else{
                                CPU.CPU3--;
                                }
                            }break;
                }
        }else{ 
            ordenarCLporCPU();
            cargarCPUconCL();
        }
        algoritmoBase();
    }
    
    public void algoritmoSRTF(){
        if (!CPU.isLibre()){
                switch (jComboBoxCantCPU.getSelectedIndex()){
                    case 0: CPU.CPU1--;break;
                    case 1: if (CPU.CPU1 == 0){
                                CPU.CPU2--;
                            }else{
                               CPU.CPU1--; 
                            }break;
                    case 2: if (CPU.CPU1 > 0){
                                CPU.CPU1--;
                            }else{
                                if(CPU.CPU2>0){
                                   CPU.CPU2--;
                                }else{
                                CPU.CPU3--;
                                }
                            }break;
                }
                ordenarCLporCPU();
                
        }else{ 
            ordenarCLporCPU();
            cargarCPUconCL();
            
        }
        algoritmoBase();
        if((!colaListo.isEmpty())&&(!CPU.isLibre())){
                    ordenarCLporCPU();
                    Proceso pro_menor = colaListo.get(0);
                    int tiempoProceso = menorTiempoCpuProceso(pro_menor); //obtento el tiempo de CPU del Proceso mas quequeño
                    //creo una clase proceso auxiliar y almaceno los datos del proceso actual en CPU
                    Proceso pro_CPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                    //obtento el tiempo de CPU del proceso en CPU
                    int tiempoCPU = menorTiempoCpuProceso(pro_CPU);
                    if(tiempoProceso < tiempoCPU){ 
                        //pregunta si el tiempo del proceso que arriva es menor al tiempo del proceso que esta en CPU
                        //el proceso que está primero en la cola de listo se apropia de CPU
                        desalojarProcesoDeCPU();
                        cargarCPUconCL();
                    }
        }
    }
    
    public void algoritmoBase(){
        if ((CPU.CPU1 == 0)&(!CPU.isLibre())) {   
            if(jComboBoxCantCPU.getSelectedIndex()==0){ //Pregunta si eligio trabajar con una sola rafaga de CPU, 
                finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
            } else { 
                    if(CPU.ES1>0) {//Si tiene 2 rafagas de CPU y la primera ya está en cero, entra acá
                        procesoCPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                        CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                        colaBloqueado1.add(procesoCPU);
                    }else{
                        if(CPU.CPU2 ==0){
                            if(jComboBoxCantCPU.getSelectedIndex()==1){
                                finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
                            } else{
                                if(CPU.ES2>0){
                                    procesoCPU = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
                                    colaBloqueado2.add(procesoCPU);
                                    CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                                }else{
                                    if(CPU.CPU3==0){
                                        finalizarProceso(CPU.PID);  //en ese caso cuando CPU1 llegue a cero el proceso finaliza
                                    }
                                }
                            }
                        }
                    }
            } 
        } 
    }
    
    public void crearMemFija(int cantPart) {
        particiones = new Particion[cantPart];
        tamMemFija = 0;
        for (int i=0; i < particiones.length; i++){
            int nroPart = i+1;
            do{
                String TamPart = (JOptionPane.showInputDialog(null, "Ingrese el tamaño de la partición nro " + nroPart));
                try {
                    tamPart = Integer.parseInt(TamPart);
                    if(tamPart<1){ 
                        JOptionPane.showMessageDialog(this, "Cada partición debe tener un tamaño mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }while(tamPart<1);
            particiones[i] = new Particion(nroPart, 0, tamPart, true);
            tamMemFija = tamMemFija + tamPart;
        }
        int x;
        int mayorPart = 0;
        for (Particion lista2 : particiones) {  //Recorre la lista para saber cual es
            x = lista2.getTamPart();     //el tamaño de la particion mayor
            if (x > mayorPart) {
                mayorPart = x;
            }
        }
        if (mayorProceso > mayorPart) {
           JOptionPane.showMessageDialog(null, "Uno o más procesos no podrán ejecutarse por su tamaño, ingrese nuevamente los tamaños de las particiones", "Alerta", JOptionPane.WARNING_MESSAGE);
           crearMemFija(cantPart);
        }
    }
    
    public void crearMemVar(){
        memoriaVariable = new ArrayList<Particion>();
        Particion p = new Particion(0,0,tamMemVar,true);
        memoriaVariable.add(p);
    }
    
    public void tratarColaNuevo() {    
        int index = 0;
        while (index < (colaNuevo.size())) {    //Recorre todos los procesos que estan en la cola de nuevo
            boolean cargo = false;
            if (colaNuevo.get(index).TA <= Time) {
                switch (jComboBoxTipoPart.getSelectedIndex()) {
                    case 0 : 
                        switch (jComboBoxGesMemVar.getSelectedIndex()) {
                            case 0: cargo = cargaFirstFit(colaNuevo.get(index));    //Si el proceso cumple las condiciones, lo carga en memoria
                                    break;
                            case 1: cargo = cargaWorstFit(colaNuevo.get(index));
                                    break;
                        } 
                    break;
                    case 1 : 
                        switch (jComboBoxGesmemFija.getSelectedIndex()) {
                            case 0: cargo = cargaFirstFit(colaNuevo.get(index));    //Si el proceso cumple las condiciones, lo carga en memoria
                                    break;
                            case 1: cargo = cargaBestFit(colaNuevo.get(index));    //Si el proceso cumple las condiciones, lo carga en  en memoria
                                    break;
                        }
                    break;
                }
            }
            if (cargo){ 
                colaListo.add(colaNuevo.get(index));
                colaNuevo.remove(index);
                index--;    //Si cargo un proceso se resta, porque como se elimino un elemento de la colaNuevo, entonces el siguiente elemente va ocupar ese lugar,
            }
            index++;
        } 
        
    }
    
    public void ordenarCLporCPU(){
        ArrayList<Proceso> colaOrdenada = new ArrayList<Proceso>();
        while(!colaListo.isEmpty()){
            int mayor = 0;        
            Proceso aux = null;
            for(Proceso x: colaListo){
                if(x.getCPU1() == 0){
                    if(x.getCPU2() == 0){
                        if(x.getCPU3() > mayor){
                            aux = x;
                            mayor = x.getCPU3();
                        }
                    }else{
                        if(x.getCPU2() > mayor){
                            aux = x;
                            mayor = x.getCPU2();
                        }
                    }
                }else{
                    if(x.getCPU1() > mayor){
                        aux = x;
                        mayor = x.getCPU1();
                    }
                }
            }
            colaOrdenada.add(0,aux);
            colaListo.remove(aux);
        }
        colaListo = colaOrdenada;
    }
    
    public int menorTiempoCpuProceso(Proceso aux){
        //procedimiento para obtener el menor tiempo de cpu del proceso
        int menor;
        if (aux.CPU1 == 0){
            if (aux.CPU2 == 0){
                menor = aux.CPU3;
            }else{
                menor = aux.CPU2;
            }
        }else{
            menor = aux.CPU1;
        }
        return menor;
    }
    
    public void desalojarProcesoDeCPU(){
        Proceso pro = new Proceso(CPU.PID,CPU.TA,CPU.Tam,CPU.CPU1,CPU.ES1,CPU.CPU2,CPU.ES2,CPU.CPU3);
        colaListo.add(pro);
        CPU.libre = true;
    }
    
    public boolean cargaFirstFit(Proceso proceso) {
        boolean cargo = false;
            if (jComboBoxTipoPart.getSelectedIndex()==0) {
                for(int i=0; i<memoriaVariable.size(); i++){
                    if((memoriaVariable.get(i).isLibre())&&(memoriaVariable.get(i).TamPart>=proceso.Tam)&&(!cargo)){
                        Particion nuevo = new Particion(0,proceso.PID,proceso.Tam,false);
                        memoriaVariable.add(i, nuevo);
                        memoriaVariable.get(i+1).setTamPart((memoriaVariable.get(i+1).getTamPart())-(proceso.Tam));
                        cargo = true; 
                    }
                }
                if(memoriaVariable.get(memoriaVariable.size()-1).getTamPart()==0){
                    memoriaVariable.remove(memoriaVariable.size()-1);
                }
            } else{
                for (Particion x: particiones){
                    if ((x.libre) & (x.TamPart >= proceso.Tam) &(!cargo)) {
                        x.setProCargado(proceso.PID);
                        x.setLibre(false);
                        cargo = true;
                    }
                }
            }
        return cargo;
    }
    
    public boolean cargaBestFit(Proceso proceso) {
        boolean cargo = false;
        int menor = 0;
        int pos = 0;
        boolean existe = false;
        for (int i = 0; i < particiones.length; i++) { //Recorro las particiones hasta encontrar la primera que pueda ser asignada
            if ((particiones[i].libre) &(particiones[i].TamPart >= proceso.Tam)){
                menor = particiones[i].TamPart;     //La guardo para comparar si hay otras menores
                pos = i;    //Guardo la posicion, porque de no haber otra particion menor, sera asignada a esta
                existe = true;  //Afirma que existe por lo menos una particion disponible para ser asignada
                break;
            }
        }
        for (int i = 0; i < particiones.length; i++){
            if ((particiones[i].libre) & (particiones[i].TamPart >= proceso.Tam)) {
                if (particiones[i].TamPart < menor) {   //Busco si hay otra particion menor disponible que pueda ser asignada
                    menor = particiones[i].TamPart;
                    pos = i;
                }
            }
        }
        if (existe) {
            particiones[pos].ProCargado = proceso.PID;
            particiones[pos].libre = false;
            cargo = true;
        }
        return cargo;
    }
    
    public boolean cargaWorstFit(Proceso proceso){
        int mayor = 0;
        int index = 0;
        boolean cargo = false;
        boolean existe = false;
        for (int i = 0; i < memoriaVariable.size(); i++) {
            if((memoriaVariable.get(i).isLibre()) && (memoriaVariable.get(i).TamPart >= proceso.Tam) && (memoriaVariable.get(i).TamPart >= mayor)) {   
                mayor = memoriaVariable.get(i).TamPart;
                index = i;
                existe = true;
            }
        }
        if (existe) {
            Particion nuevo = new Particion(0,proceso.PID,proceso.Tam,false);
            memoriaVariable.add(index, nuevo);
            memoriaVariable.get(index+1).setTamPart((memoriaVariable.get(index+1).getTamPart())-(proceso.Tam));
            cargo = true;
            if(memoriaVariable.get(memoriaVariable.size()-1).getTamPart()==0){
                memoriaVariable.remove(memoriaVariable.size()-1);
            }
        }  
        return cargo;
    }
    
    public void cargarCPUconCL() {
        if ((CPU.isLibre())&(colaListo.size()>0)){  //Si hay otro proceso en la cola de listo esperando, lo cargo en CPU
                        CPU.PID = colaListo.get(0).getPID();
                        CPU.Tam = colaListo.get(0).getTam();
                        CPU.TA = colaListo.get(0).getTA();
                        CPU.CPU1 = colaListo.get(0).getCPU1();
                        CPU.ES1 = colaListo.get(0).getES1();
                        CPU.CPU2 = colaListo.get(0).getCPU2();
                        CPU.ES2 = colaListo.get(0).getES2();
                        CPU.CPU3 = colaListo.get(0).getCPU3();
                        CPU.libre = false;
                        colaListo.remove(0);
                }
    }
    
    public void cargarES1conCB1(){
        if((ES1.isLibre())&(colaBloqueado1.size()>0)) {
           ES1.PID = colaBloqueado1.get(0).getPID();
           ES1.Tam = colaBloqueado1.get(0).getTam();
           ES1.TA = colaBloqueado1.get(0).getTA();
           ES1.CPU1 = colaBloqueado1.get(0).getCPU1();
           ES1.ES1 = colaBloqueado1.get(0).getES1();
           ES1.CPU2 = colaBloqueado1.get(0).getCPU2();
           ES1.ES2 = colaBloqueado1.get(0).getES2();
           ES1.CPU3 = colaBloqueado1.get(0).getCPU3();
           ES1.libre = false;
           colaBloqueado1.remove(0);
        }
    }
    
    public void cargarES2conCB2(){
        if((ES2.isLibre())&(colaBloqueado2.size()>0)) {
           ES2.PID = colaBloqueado2.get(0).getPID();
           ES2.Tam = colaBloqueado2.get(0).getTam();
           ES2.TA = colaBloqueado2.get(0).getTA();
           ES2.CPU1 = colaBloqueado2.get(0).getCPU1();
           ES2.ES1 = colaBloqueado2.get(0).getES1();
           ES2.CPU2 = colaBloqueado2.get(0).getCPU2();
           ES2.ES2 = colaBloqueado2.get(0).getES2();
           ES2.CPU3 = colaBloqueado2.get(0).getCPU3();
           ES2.libre = false;
           colaBloqueado2.remove(0);
        }
    }
    
    public void finalizarProceso(int PID){
        ts += Time;
        if (jComboBoxTipoPart.getSelectedIndex() == 0) {
            int pos=0;
            for (int i=0; i < memoriaVariable.size(); i++) {
               if((memoriaVariable.get(i).ProCargado)==(PID)){
                   memoriaVariable.get(i).ProCargado = 0;
                   memoriaVariable.get(i).libre = true;
                   CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                   procesosVivos--;
                   pos = i;
               }
            }
            if ((pos>0)&&(memoriaVariable.get(pos-1).isLibre())){
                memoriaVariable.get(pos).setTamPart((memoriaVariable.get(pos).getTamPart())+(memoriaVariable.get(pos-1).getTamPart()));
                memoriaVariable.remove(pos-1);
                pos--;
            }
            if ((pos<(memoriaVariable.size()-1))&&(memoriaVariable.get(pos+1).isLibre())){
                memoriaVariable.get(pos).setTamPart((memoriaVariable.get(pos).getTamPart())+(memoriaVariable.get(pos+1).getTamPart()));
                memoriaVariable.remove(pos+1);
            }
            if(memoriaVariable.get(memoriaVariable.size()-1).getTamPart()==0){
                memoriaVariable.remove(memoriaVariable.size()-1);
            }
            
        }else{
           for (Particion x: particiones) {
               if((x.ProCargado)==(PID)){
                   x.ProCargado = 0;
                   x.libre = true;
                   CPU = new Recurso(0,0,0,0,0,0,0,0,true);
                   procesosVivos--;
               }
           }
        }
    }
    
    private void jTableProcesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableProcesoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProcesoFocusLost

    private void txtTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtTAKeyTyped

    private void txtTamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTamKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtTamKeyTyped
    
    private void txtCPU1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPU1KeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCPU1KeyTyped

    private void txtESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtESKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtESKeyTyped

    private void txtCPU2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPU2KeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCPU2KeyTyped

    private void jMenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuNuevoActionPerformed

    private void txtES2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtES2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtES2ActionPerformed

    private void jTextFieldTamMVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTamMVKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldTamMVKeyTyped

    private void jComboBoxGesmemFijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGesmemFijaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGesmemFijaActionPerformed
    
    private void jComboBoxNroPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNroPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNroPartActionPerformed

    private void jComboBoxTipoPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoPartActionPerformed

    private void jComboBoxTipoPartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoPartItemStateChanged
        if (jComboBoxTipoPart.getSelectedIndex() == 1) {
            jComboBoxGesmemFija.setVisible(true);
            jComboBoxGesMemVar.setVisible(false);
            jComboBoxNroPart.setVisible(true);
            jLabel11.setVisible(true);
            jLabel10.setVisible(false);
            jTextFieldTamMV.setVisible(false); //Si es con particiones fijas, el tamaño de la memoria será la suma de todas las particiones
        } else {
            jComboBoxGesMemVar.setVisible(true);
            jComboBoxGesmemFija.setVisible(false);
            jComboBoxNroPart.setVisible(false);
            jLabel11.setVisible(false);
            jLabel10.setVisible(true);
            jTextFieldTamMV.setVisible(true); //Si es con particones variable, el tamaño de la memoria la elige el usuario
        }
    }//GEN-LAST:event_jComboBoxTipoPartItemStateChanged

    private void jComboBoxGesMemVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGesMemVarActionPerformed

    }//GEN-LAST:event_jComboBoxGesMemVarActionPerformed

    private void jTextFieldTamMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTamMVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTamMVActionPerformed

    private void jComboBoxCantCPUItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCantCPUItemStateChanged
     if(jComboBoxCantCPU.getSelectedIndex()==0){
            txtCPU2.setEditable(false);
            txtCPU3.setEditable(false);
            txtES.setEditable(false);
            txtES2.setEditable(false);
        }
        if(jComboBoxCantCPU.getSelectedIndex()==1){
            txtCPU2.setEditable(true);
            txtCPU3.setEditable(false);
            txtES.setEditable(true);
            txtES2.setEditable(false);
        }
        if(jComboBoxCantCPU.getSelectedIndex()==2){
            txtCPU2.setEditable(true);
            txtCPU3.setEditable(true);
            txtCPU3.setEnabled(true);
            
            txtES.setEditable(true);
            txtES2.setEditable(true);
        }
    }//GEN-LAST:event_jComboBoxCantCPUItemStateChanged

    private void jLabel5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5KeyTyped

    private void BtnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegistrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRegistrarMouseClicked

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void jMenuBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1MousePressed

    private void txtCPU3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPU3KeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCPU3KeyTyped

    private void txtES2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtES2KeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtES2KeyTyped

    private void jComboBoxCantCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCantCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCantCPUActionPerformed

    private void QuantumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantumKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese sólo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_QuantumKeyTyped

    private void QuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantumActionPerformed

    private void jComboBoxPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlanActionPerformed

    }//GEN-LAST:event_jComboBoxPlanActionPerformed

    private void jComboBoxPlanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPlanItemStateChanged
        if (jComboBoxPlan.getSelectedIndex() == 1) {
            Quantum.setEditable(true);    //Si eligio RR habilita la elección del Quantum
        } else {
            Quantum.setEditable(false); //Sino, deshabilita
        }
    }//GEN-LAST:event_jComboBoxPlanItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JTextField Quantum;
    private javax.swing.JDialog acercaDe;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JComboBox<String> jComboBoxCantCPU;
    private javax.swing.JComboBox<String> jComboBoxGesMemVar;
    private javax.swing.JComboBox<String> jComboBoxGesmemFija;
    private javax.swing.JComboBox<String> jComboBoxNroPart;
    public javax.swing.JComboBox<String> jComboBoxPlan;
    public javax.swing.JComboBox<String> jComboBoxTipoPart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuNuevo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProceso;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTamMV;
    private javax.swing.JTextField txtCPU1;
    private javax.swing.JTextField txtCPU2;
    private javax.swing.JTextField txtCPU3;
    private javax.swing.JTextField txtES;
    private javax.swing.JTextField txtES2;
    private javax.swing.JTextField txtTA;
    private javax.swing.JTextField txtTam;
    // End of variables declaration//GEN-END:variables

    

}
