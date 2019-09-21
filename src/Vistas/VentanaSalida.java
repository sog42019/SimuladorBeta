package Vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import simulador.de.procesos.Particion;

public class VentanaSalida extends JFrame {
    JScrollPane scrollPane, scrollPane2, scrollPanePrincipal;
    JTextPane titulo20 = new JTextPane();
    JTextPane titulo2 = new JTextPane();
    JPanel contenedor, contenedor2, contenedorPrincipal, contenedorTotal, panel, panelCPU, panelES, panelES2;
    JButton min, max, cerrar = new javax.swing.JButton();//new JButton(new ImageIcon("cerrar.png"));
    int altoContenedor = 0;
    int ant, ant2, ant3;
    boolean visible = false;
    private int x;
    private int y;
    
   public VentanaSalida(Particion particiones[], int tamMemFija, int Time) {
       Toolkit t = Toolkit.getDefaultToolkit();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       //System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
       setExtendedState(MAXIMIZED_BOTH);
       setMinimumSize(new Dimension(720,620));
       setMaximumSize(new Dimension(screenSize.width,screenSize.height));
       setUndecorated(true);
       setResizable(true);
       iniciarComponentes(particiones, tamMemFija, Time);
   }
       
   public void iniciarComponentes(Particion particiones[], int tamMemFija, int Time) {     
        
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setBackground(new java.awt.Color(107, 106, 104) );
        
        panelCPU = new JPanel();
        panelCPU.setLayout(null);
        panelCPU.setBackground(new java.awt.Color(255,255,255));
        
        panelES = new JPanel();
        panelES.setLayout(null);
        panelES.setBackground(new java.awt.Color(240,222,104));
        
        panelES2 = new JPanel();
        panelES2.setLayout(null);
        panelES2.setBackground(new java.awt.Color(240,222,104));
        
        contenedor2 = new JPanel();
        contenedor2.setLayout(null);
        contenedor2.setBackground(new java.awt.Color(0,0,51));
                
        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(null);
        contenedorPrincipal.setBackground(Color.white);
        
        contenedorTotal = new JPanel();
        contenedorTotal.setLayout(null);
        
        min = new JButton();
        min.setIcon(new ImageIcon(this.getClass().getResource("/img/minimizar.png")));
        max = new JButton();
        max.setIcon(new ImageIcon(this.getClass().getResource("/img/maximizar.png")));
   }
   
   public void dibujarMemoria (Particion particiones[], ArrayList<Particion> memoriaVariable, int tamMemFija, int Time) {
       JTextPane encabezado = new JTextPane();
       encabezado.setContentType("text/html");
       encabezado.setText("<html><body><p style='margin: 2px; text-align: center; font-size: 20; font: arial; color:##000000; '><b>Tiempo "+ (Integer.toString(Time))  + " </b></p></body></html>");
       encabezado.setBounds(5,5,190,30);
       encabezado.setEditable(false);
       
        panel = new JPanel();
        panel.add(encabezado);
        panel.setLayout(null);
        if (tamMemFija > 0) { 
            panel.setBounds((10+(Time*210)), 10, 200, ((particiones.length*85)+40));
        }else{
            panel.setBounds((10+(Time*210)), 10, 200, ((memoriaVariable.size()*85)+40));
        }
        panel.setBackground(Color.white);
        
       String estado;
       int ejey = -45;
       if (tamMemFija > 0) { 
           for (Particion lista3 : particiones){
            ejey += 85;
            if (lista3.libre) {
               estado = "Libre";
            }else{
               estado = "Ocupado";
            }
            JTextPane etiqueta = new JTextPane();
            etiqueta.setContentType("text/html");
            etiqueta.setText("<html><body><p style='margin: 2px; text-align: center; font: serif; font-size: 12pt;color:#000000;'><b> Particion nro: " + (Integer.toString(lista3.NroPart)) + "</b>" + 
                   "<br/> Proceso Cargado: " + (lista3.ProCargado) + 
                   " <br/> Tamaño de particion: " + (Integer.toString(lista3.TamPart))+
                   " <br/> Estado: " + estado + "\n \n" + "</p></body></html>");
            etiqueta.setBounds(5, ejey, 190, 80);
            etiqueta.setOpaque(true);
            //etiqueta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            
            if (lista3.libre) {
               etiqueta.setBackground(new java.awt.Color(153,153,255));
            }else{
               etiqueta.setBackground(Color.getHSBColor(255,255,153));
            }
            etiqueta.setEditable(false);
            
            panel.add(etiqueta);
            contenedor.add(panel);
            contenedor.setPreferredSize(new Dimension(((Time*210)+220),((particiones.length*85)+45)));
           }  
            
        }else{
           for (Particion lista3 : memoriaVariable){
                ejey += 85;
                if(ejey>altoContenedor){
                    altoContenedor=ejey;
                }
                if (lista3.libre) {
                   estado = "Libre";
                }else{
                   estado = "Ocupado";
                }
                JTextPane etiqueta = new JTextPane();
                etiqueta.setContentType("text/html");
                etiqueta.setText("<html><body><p style='margin: 2px; text-align: center; font: serif; font-size: 12pt;color:##000000;'> <br/> Proceso Cargado: " + (lista3.ProCargado) + 
                       " <br/> Tamaño de particion: " + (Integer.toString(lista3.TamPart))+
                       " <br/> Estado: " + estado + "\n \n" + "</p></body></html>");
                etiqueta.setBounds(5, ejey, 190, 80);
                etiqueta.setOpaque(true);
                //etiqueta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                if (lista3.libre) {
                   etiqueta.setBackground(new java.awt.Color(204,204,255));
                }else{
                   etiqueta.setBackground(Color.getHSBColor(255,102,153));
                }
                etiqueta.setEditable(false);

                panel.add(etiqueta);
                contenedor.add(panel);
                contenedor.setPreferredSize(new Dimension(((Time*210)+220),(altoContenedor+100))); 
        }  
       } 
       
   }
   
   public void dibujarCPU(int Time, int PID){
       JTextPane cuadro = new JTextPane();
       cuadro = dibujarBloques(Time, PID,ant);
       ant=PID;
       
       JLabel tituloCPU = new JLabel("CPU");
       tituloCPU.setBounds(50, 20, 50, 30);
       tituloCPU.setFont(new java.awt.Font("SansSerif", 0, 15));
       tituloCPU.setForeground(Color.black);
       
       JLabel tiempo = new JLabel();
       tiempo.setText(Integer.toString(Time));
       tiempo.setBounds((45+(Time*55)),100,25,20);
       tiempo.setForeground(Color.GRAY);
       
       panelCPU.add(tituloCPU);
       panelCPU.add(tiempo);
       panelCPU.add(cuadro);
       
   }
   
   public void dibujarES(int Time, int PID){
       JTextPane cuadro = new JTextPane();
       cuadro = dibujarBloques(Time, PID,ant2);
       ant2 = PID;
       
       JLabel tituloES = new JLabel("E/S 1");
       tituloES.setBounds(50, 20, 50, 30);
       tituloES.setFont(new java.awt.Font("SansSerif", 0, 15));
       tituloES.setForeground(Color.gray);
       
       JLabel tiempo = new JLabel();
       tiempo.setText(Integer.toString(Time));
       tiempo.setBounds((45+(Time*55)),100,25,20);
       tiempo.setForeground(Color.GRAY);
       
       panelES.add(tituloES);
       panelES.add(tiempo);
       panelES.add(cuadro);
       
   }
   
   public void dibujarES2(int Time, int PID){
       JTextPane cuadro = new JTextPane();
       cuadro = dibujarBloques(Time, PID,ant3);
       ant3 = PID;
       
       JLabel tituloES = new JLabel("E/S 2");
       tituloES.setBounds(50, 20, 50, 30);
       tituloES.setFont(new java.awt.Font("SansSerif", 0, 15));
       tituloES.setForeground(Color.gray);
       
       JLabel tiempo = new JLabel();
       tiempo.setText(Integer.toString(Time));
       tiempo.setBounds((45+(Time*55)),100,25,20);
       tiempo.setForeground(Color.GRAY);
       
       panelES2.add(tituloES);
       panelES2.add(tiempo);
       panelES2.add(cuadro);
   }
   
   public void mostrarSalida(int Time, float tr, float te, int cantCPU){
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
    contenedor2.setPreferredSize(new Dimension(((Time*55)+250),650));   
       
    panelCPU.setBounds(50, 50, (150+(Time*55)), 150);
    contenedor2.add(panelCPU);
    
    panelES.setBounds(50, 250, (150+(Time*55)), 150);
    if (cantCPU>1){
        contenedor2.add(panelES);
    }
    panelES2.setBounds(50, 450, (150+(Time*55)), 150);
    if(cantCPU==3){
        contenedor2.add(panelES2);
    }
    scrollPane = new JScrollPane(contenedor);
    scrollPane.setBounds(0,0,(screenSize.width),((screenSize.height)/2));
        
    scrollPane2 = new JScrollPane(contenedor2);
    scrollPane2.setBounds(0, ((screenSize.height)/2), (screenSize.width), (screenSize.height)/2);
    
    
    
    JPanel barra = new JPanel();
    barra.setLayout(null);
    barra.setBounds(0, 0, 1920, 50);
    barra.setBackground(new java.awt.Color(255,255,255));
    barra.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            barraMouseClicked(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            barraMousePressed(evt);
        }

        private void barraMouseClicked(MouseEvent evt) {
            if(evt.getClickCount() == 2){
                if(getExtendedState() == JFrame.MAXIMIZED_BOTH){
                    setExtendedState(JFrame.NORMAL);
                    min.setBounds(720-90, 5, 20, 20);
                    max.setBounds(720-60, 5, 20, 20);    
                    cerrar.setBounds(720-30, 5, 20, 20);
                    scrollPanePrincipal.setBounds(0, 50, (720), 570);
                }else{
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    min.setBounds(screenSize.width-90, 5, 20, 20);
                    max.setBounds(screenSize.width-60, 5, 20, 20);    
                    cerrar.setBounds(screenSize.width-30, 5, 20, 20);
                    scrollPanePrincipal.setBounds(0, 50, (screenSize.width), (screenSize.height-50));
            }
            }
        }

        private void barraMousePressed(MouseEvent evt) {
            x = evt.getX();
            y = evt.getY();
        }
    });
    barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            barraMouseDragged(evt);
        }
        private void barraMouseDragged(MouseEvent evt) {
            if(getExtendedState() != JFrame.MAXIMIZED_BOTH){
                Point ubicacion = MouseInfo.getPointerInfo().getLocation();
                setLocation(ubicacion.x - x, ubicacion.y - y);
            }
        }
    });
    
        
    JLabel icono = new JLabel();
    icono.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
    icono.setBounds(5, 10, 30, 30);
    barra.add(icono);
    
    
    JTextPane titulo1 = new JTextPane();
    titulo1.setContentType("text/html");
    titulo1.setText("<html><body><p style='text-align:center; font-size: 8; margin-top: 1px; font: sans-serif; color:#000000; '><b>ASIGNACIONES DE MEMORIA</b></p></body></html>");
    titulo1.setBounds(30, 25, 300, 20);
    titulo1.setEditable(false);
    titulo1.setOpaque(false);
    titulo1.getBorder();
    contenedorTotal.add(titulo1);
    //barra.add(titulo1);
    JTextPane titulo10 = new JTextPane();
    titulo10.setBounds(80,48, 200, 2);
    titulo10.setBackground(new java.awt.Color(0,153,153));
    barra.add(titulo10);
    
    
    min.setBounds(screenSize.width-90, 5, 20, 20);
    min.setOpaque(false);
    min.setContentAreaFilled(false);
    min.setBorderPainted(false);
    ActionListener oyenteDeAccion1 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            setExtendedState(JFrame.ICONIFIED);
        }
    };
    min.addActionListener(oyenteDeAccion1);
    barra.add(min);
    
    max.setBounds(screenSize.width-60, 5, 20, 20);
    max.setOpaque(false);
    max.setContentAreaFilled(false);
    max.setBorderPainted(false);
    ActionListener oyenteDeAccion2 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getExtendedState() == JFrame.MAXIMIZED_BOTH){
                    setExtendedState(JFrame.NORMAL);
                    min.setBounds(720-90, 5, 20, 20);
                    max.setBounds(720-60, 5, 20, 20);    
                    cerrar.setBounds(720-30, 5, 20, 20);
                    scrollPanePrincipal.setBounds(0, 50, (720), 570);
                }else{
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    min.setBounds(screenSize.width-90, 5, 20, 20);
                    max.setBounds(screenSize.width-60, 5, 20, 20);    
                    cerrar.setBounds(screenSize.width-30, 5, 20, 20);
                    scrollPanePrincipal.setBounds(0, 50, (screenSize.width), (screenSize.height-50));
            }
        }
    };
    max.addActionListener(oyenteDeAccion2);
    barra.add(max);
    
    cerrar.setIcon(new ImageIcon(this.getClass().getResource("/img/cerrar.png")));
    cerrar.setBounds(screenSize.width-30, 5, 20, 20);
    cerrar.setOpaque(false);
    cerrar.setContentAreaFilled(false);
    cerrar.setBorderPainted(false);
    ActionListener oyenteDeAccion = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
                dispose();
        }
    };
    cerrar.addActionListener(oyenteDeAccion);
    barra.add(cerrar);
    
    JTextPane tiempoRetorno = new JTextPane(); 
    JTextPane tiempoEspera = new JTextPane();
    
    tiempoRetorno.setContentType("text/html");
    tiempoRetorno.setText("<html><body><p style='margin: 2px; 	text-align:center; margin-top:1px; font-size: 12; font: arial; color:#ffffff;'>Tiempo de Retorno Promedio: " + Float.toString(tr) +"</p></body></html>");
    tiempoRetorno.setEditable(false);
    tiempoRetorno.setBackground(new java.awt.Color(135,200,122));
    contenedorTotal.add(tiempoRetorno); 
    
    tiempoEspera.setContentType("text/html");
    tiempoEspera.setText("<html><body><p style='text-align:center; margin-top:1px; font-size: 8; font: arial; color:#ffffff;'>Tiempo de Espera Promedio: " + Float.toString(te) +"</p></body></html>");
    tiempoEspera.setEditable(false);
    tiempoEspera.setBackground(new java.awt.Color(135,200,122));
    contenedorTotal.add(tiempoEspera);
    
    JButton reloj = new JButton();
    reloj.setIcon(new ImageIcon(this.getClass().getResource("/img/reloj.png")));
    reloj.setBounds(385, 17, 30, 30);
    reloj.setOpaque(false);
    reloj.setContentAreaFilled(false);
    reloj.setBorderPainted(false);
    ActionListener oyenteDeAccion3 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
             if(visible) {
                tiempoEspera.setBounds(425, -15, 130, 12);    
                tiempoRetorno.setBounds(425, -15, 130, 12);
                visible = false;
             }else{
                tiempoEspera.setBounds(280, 50, 240, 30);    
                tiempoRetorno.setBounds(280, 80, 240, 30);
                visible = true;
             }
        }
    };
    reloj.addActionListener(oyenteDeAccion3);
    barra.add(reloj);
    
    
    titulo2.setContentType("text/html");
    titulo2.setText("<html><body><p style='text-align:left; font-size: 10; margin-top: 1px; font: sans-seriff; color:#ffffff; '><b>DIAGRAMAS DE GANTT DE LOS RECURSOS</b></p></body></html>");
    titulo2.setBounds(30, ((screenSize.height)/2)+70, (screenSize.width), (screenSize.height)/2);
    titulo2.setEditable(false);
    titulo2.setOpaque(false);
    //barra.add(titulo2);
    JTextPane titulo20 = new JTextPane();
    titulo20.setBounds(520,48, 295, 2);
    titulo20.setBackground(new java.awt.Color(1,131,41));
    barra.add(titulo20);
    
    
    contenedorPrincipal.add(scrollPane);
    contenedorPrincipal.add(scrollPane2);
    contenedorPrincipal.setPreferredSize(new Dimension((screenSize.width-10), (screenSize.height-68)));
    
    scrollPanePrincipal = new JScrollPane(contenedorPrincipal);
    scrollPanePrincipal.setBounds(0, 50, (screenSize.width), (screenSize.height-50));
    
    contenedorTotal.add(barra);
     contenedorTotal.add(titulo2);
    contenedorTotal.add(scrollPanePrincipal);
    getContentPane().add(contenedorTotal);
   }
   //private javax.swing.JLabel cerrar;

    private JTextPane dibujarBloques(int Time, int PID, int anterior) {
        JTextPane cuadro = new JTextPane();
       cuadro.setContentType("text/html");
       if (PID ==0){            
            cuadro.setText("<html><body><p style='margin: 2px; 	text-align:center; margin-top:10px; font-size: 12; font: arial; color:"
                    + "#000000; '>------ </p></body></html>");
            cuadro.setOpaque(false);
            cuadro.setBounds((50+(Time*55)), 50, 50, 50);
        }else{
            switch (PID){
               case 1:cuadro.setBackground(new java.awt.Color(150,184,189)); break;
               case 5:cuadro.setBackground(Color.getHSBColor(120, 33, 60)); break;
               case 8:cuadro.setBackground(new java.awt.Color(150,147,218)); break;
               case 6:cuadro.setBackground(new java.awt.Color(135,200,122)); break;
               case 2:cuadro.setBackground(new java.awt.Color(242,147,239)); break;
               case 4:cuadro.setBackground(new java.awt.Color(242,147,149)); break;
               case 7:cuadro.setBackground(new java.awt.Color(147,148,242)); break;
               case 3:cuadro.setBackground(new java.awt.Color(105,180,103)); break;
               case 9:cuadro.setBackground(new java.awt.Color(204,255,204)); break;
            }
            cuadro.setOpaque(true);         
            if (PID!= anterior){
                cuadro.setBounds((50+(Time*55)), 50, 50, 50);
            }else{
                cuadro.setBounds((45+(Time*55)), 50, 55, 50);
            }
            cuadro.setText("<html><body><p style='margin: 2px; 	text-align:center; margin-top:10px; font-size: 20; font: arial; color:#000000; '><b>"+ (Integer.toString(PID))  + " </b></p></body></html>");

        }
       cuadro.setEditable(false);   
        return cuadro;

    }
}
