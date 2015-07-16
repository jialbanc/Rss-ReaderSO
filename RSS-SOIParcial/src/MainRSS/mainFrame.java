package MainRSS;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import poolThread.RssThreadConsumer;
import poolThread.RssThreadProducer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanessa
 */
public class mainFrame  extends JFrame{
    
    private Stack stackPrincipal;
    private ExecutorService executor;
    private JFrame inicio;
    private JPanel panelPrincipal;
    private JPanel panelRSS;
    private JPanel panelP;
    private JPanel panelFeeds;
    private JScrollPane scrool ;
    private JPanel imagen;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private String url;
    private BufferRss bufferP;
    private JButton close;
    private JLabel consu;
    private JLabel consulb;
    private JLabel prod;
    private JLabel prodlb;
    public JTextField tf1;
    public JTextField tf2;
    private int configTimeP;
    private int configTimeC;
    
    private Thread threadP;
    
    
    
    public mainFrame(){
        //tiempo entre pool de Feeds en segundos
        this.configTimeP=4;
        this.configTimeC=4;
        setTitle("RSS READER");
        JLabel lb = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/rssfeedPart1.png")));
       
        JPanel p1 = new JPanel(new GridLayout(1,2));
        JPanel p2 = new JPanel(new GridLayout(1,2));
        JPanel p3 = new JPanel(new GridLayout(1,2));
        JPanel p4 = new JPanel(new GridLayout(1,2));
        JPanel p5 = new JPanel(new GridLayout(1,2));
        JPanel p6 = new JPanel(new GridLayout(1,2));
        JLabel lb1 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/UniversonNoticias.png")));
        JLabel lb2 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/UniversoDeporte1.png")));
        JLabel lb3 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/comercioActualidad.png")));
        JLabel lb4 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/comercioTendencias.png")));
        JLabel lb5 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/UniversonVidayEstilo.png")));
        JLabel lb6 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/comercioOpinion.png")));
        JLabel lb7 = new JLabel();
        JLabel lb8 = new JLabel();
        JLabel lb9 = new JLabel();
        JLabel lb10 = new JLabel();
        JLabel lb11= new JLabel();
        JLabel lb12= new JLabel(new ImageIcon(getClass().getResource("/Imagenes/rssfeedPart2.png")));
        JPanel panelconfiguracion = new JPanel();
        btn1 =  new JButton();
        btn1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn1.setBackground(Color.white);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.eluniverso.com/rss/noticias.xml");
                btn1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn1.setEnabled(false);
            }
        });
        btn2 =  new JButton();
        btn2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.eluniverso.com/rss/deportes.xml");
                btn2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn2.setEnabled(false);
            }
        });
        btn3 =  new JButton();
        btn3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.elcomercio.com/rss/actualidad");
                btn3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn3.setEnabled(false);
            }
        });
        btn4 =  new JButton();
        btn4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.elcomercio.com/rss/tendencias");
                btn4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn4.setEnabled(false);
            }
        });
        btn5 =  new JButton();
        btn5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.eluniverso.com/rss/vida-y-estilo.xml");
                btn5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn5.setEnabled(false);
            }
        });
        btn6 =  new JButton();
        btn6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscribirse.jpg")));
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFeedT("http://www.elcomercio.com/rss/opinion");
                btn6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonSuscrito.jpg")));
                btn6.setEnabled(false);
                
            }
        });
        panelPrincipal = new JPanel(new GridLayout(1,2));
        panelRSS =new JPanel();
        panelRSS.setBackground(Color.white);
        
        panelFeeds =new JPanel(new GridLayout(9,2));
        panelRSS.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "--Rss--"));
        panelconfiguracion.setLayout(new FlowLayout());
        panelconfiguracion.setSize(200, 200);
        prod = new JLabel("Productor :");
        tf1 = new JTextField(5);
        prodlb = new JLabel("/s");
        consu= new JLabel("Consumidor:");
        tf2 = new JTextField(5);
        consulb = new JLabel("/s");
        close= new JButton("Enviar");
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setConfigTimeC(tf2.getText());
                setConfigTimeP(tf1.getText());
            }
        });
        panelconfiguracion.add(prod);
        panelconfiguracion.add(tf1);
        panelconfiguracion.add(prodlb);
        panelconfiguracion.add(consu);
        panelconfiguracion.add(tf2);
        panelconfiguracion.add(consulb);
        panelconfiguracion.add(close);
        

        panelPrincipal.add(panelRSS);
        p1.add(lb1);
        p1.add(btn1);
        p2.add(lb2);
        p2.add(btn2);
        p3.add(lb3);
        p3.add(btn3);
        p4.add(lb4);
        p4.add(btn4);
        p5.add(lb5);
        p5.add(btn5);
        p6.add(lb6);
        p6.add(btn6);
        panelFeeds.add(lb);
        panelFeeds.add(lb12);
        panelFeeds.add(p1);
        panelFeeds.add(p2);
        panelFeeds.add(p3);
        panelFeeds.add(p4);
        panelFeeds.add(p5);
        panelFeeds.add(p6);
        panelFeeds.add(lb7);
        panelFeeds.add(lb8);
        panelFeeds.add(lb9);
        panelFeeds.add(lb10);
        panelFeeds.add(lb11);
        panelFeeds.add(panelconfiguracion);
        panelPrincipal.add(panelFeeds);
        
        
        add(panelPrincipal);
        
        
        setSize(900, 700);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getConfigTimeP() {
        return configTimeP;
    }

    public void setConfigTimeP(String configTimeP) {
        System.out.println('P'+configTimeP);
        this.configTimeP = Integer.parseInt(configTimeP);
    }

    public int getConfigTimeC() {
        return configTimeC;
    }

    public void setConfigTimeC(String configTimeC) {
        System.out.println('C'+configTimeC);
        this.configTimeC = Integer.parseInt(configTimeC);
    }
    
    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
    
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelRSS() {
        return panelRSS;
    }

    public void setPanelRSS(JPanel panelRSS) {
        this.panelRSS = panelRSS;
    }

    public JPanel getPanelFeeds() {
        return panelFeeds;
    }

    public void setPanelFeeds(JPanel panelFeeds) {
        this.panelFeeds = panelFeeds;
    }

    public Stack getStackPrincipal() {
        return stackPrincipal;
    }

    public void setStackPrincipal(Stack stackPrincipal) {
        this.stackPrincipal = stackPrincipal;
    }

    public BufferRss getBufferP() {
        return bufferP;
    }

    public void setBufferP(BufferRss bufferP) {
        this.bufferP = bufferP;
    }
    
     public static void main(String[] args) {
        mainFrame a =new mainFrame();
        a.bufferP= new BufferRss();
        a.threadP = new Thread(new RssThreadConsumer(a.bufferP, a.getPanelRSS(),a.configTimeP),"Principal");
//        Thread productor = new Thread(new RssThreadProducer(a.bufferP, "http://www.eluniverso.com/rss/vida-y-estilo.xml"),"Productor");
        a.executor = Executors.newFixedThreadPool(6);
//        productor.start();     
        a.threadP.start();
//        while (!a.executor.isTerminated()) {
//        }
        
      
        
     }
     
     public void  createFeedT(String ruta){
         Runnable worker = new RssThreadProducer(bufferP,ruta,configTimeP);
         getExecutor().execute(worker);
     }
     
 
}
