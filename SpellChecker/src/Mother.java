import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;

public class Mother extends JFrame {

    public static JLayeredPane contentPane;
    JTextPane writeArea;
    private JTextField title;
    boolean entered = false;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static final Dimension windowSize = new Dimension(screenSize.width/2, (int) (screenSize.height/1.5));
    static final Point windowPoint = new Point(screenSize.width/4, (int) (screenSize.height/5));

    static final Dimension quickSize = new Dimension(windowSize.width/2, windowSize.height/30);
    static final Point quickPoint = new Point((windowPoint.x+windowSize.width/2)-windowSize.width/4, (windowPoint.y+windowSize.height+windowSize.height/20));

    static final Dimension toolBoxSize = new Dimension(windowSize.width/15, windowSize.height);
    static final Point toolBoxPoint = new Point(windowPoint.x+windowSize.width+windowSize.width/100,windowPoint.y);

    static final Dimension titleSize = new Dimension(windowSize.width/2, windowSize.height/15);
    static final Point titlePoint = new Point((windowPoint.x+windowSize.width/2)-windowSize.width/4, (windowPoint.y-windowSize.height/10));

    static final Dimension fmSize = new Dimension(screenSize.width/60, screenSize.height);
    static final Point fmPoint = new Point(screenSize.width-fmSize.width, 0);

    static final double writeAreaH = windowSize.height;

    int word = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mother frame = new Mother();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws java.io.IOException
     */

    public Mother() throws IOException, URISyntaxException {

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("error");
        }


        //--- frame settings ---//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, screenSize.width, screenSize.height);
        Color color= new Color(24, 25, 34, 255);
        setBackground(color);
        //--- main panel ---//
        contentPane = new JLayeredPane();
        contentPane.setBackground(Color.PINK);
        contentPane.setBounds(0, 0, screenSize.width, screenSize.height);
        contentPane.setLayout(null);
        contentPane.setOpaque(false);
        setContentPane(contentPane);

        //--- window panel ---//
        JScrollPane window = new JScrollPane();
        window.setBounds(windowPoint.x, windowPoint.y, windowSize.width, windowSize.height);
        window.setBorder(null);
        window.setHorizontalScrollBar(null);
        window.setViewportBorder(null);
        window.getViewport().setOpaque(false);
        window.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        window.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        window.setOpaque(false);
        contentPane.add(window);
        //--- writing area ---//
        writeArea = new JTextPane();
        window.setViewportView(writeArea);

        //--- scrollbar optimization ---//

        ///--- File Management ---///

        //// full screen mode code ////
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            setUndecorated(true);
            gd.setFullScreenWindow(this);
        } else {
            System.err.println("Full screen not supported");
            setSize(100, 100);
            setVisible(true);
        }
    }

    public void decoratePad(){
        //--- seperators ---//
        Color c = new Color(87, 85, 92);
        JPanel separatorL = new JPanel();
        separatorL.setBackground(c);
        separatorL.setBounds(windowPoint.x, windowPoint.y, windowSize.width / 60, windowSize.height);
        contentPane.add(separatorL,JLayeredPane.MODAL_LAYER);

        JPanel seperatorR = new JPanel();
        seperatorR.setBackground(c);
        seperatorR.setBounds(windowPoint.x + windowSize.width - separatorL.getWidth(), windowPoint.y, windowSize.width / 60, windowSize.height);
        contentPane.add(seperatorR,JLayeredPane.MODAL_LAYER);

        JPanel seperatorT = new JPanel();
        seperatorT.setBackground(c);
        seperatorT.setBounds(titlePoint.x, titlePoint.y + titlePoint.y / 3, titleSize.width, titleSize.height / 20);
        contentPane.add(seperatorT,JLayeredPane.MODAL_LAYER);
    }



}


