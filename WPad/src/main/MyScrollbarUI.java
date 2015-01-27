package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class MyScrollbarUI extends MetalScrollBarUI {

    private Image imageThumb, imageTrack;
    private JButton b = new JButton() {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    

    MyScrollbarUI() throws IOException {
    	if(new File("/Images/thumb.jpg").exists() && !new File("/Images/thumb.jpg").isDirectory()) {System.out.println("can't find");};
        imageThumb = ImageIO.read(getClass().getResource("Images/thumb.png"));
        imageTrack = ImageIO.read(getClass().getResource("Images/track.png"));
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        ((Graphics2D) g).drawImage(imageThumb,
            r.x, r.y, r.width, r.height, null);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    	 ((Graphics2D) g).drawImage(imageTrack,
    	            r.x, r.y, r.width, r.height, null);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return b;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return b;
    }
}