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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class CustomScroll extends JPanel {

    private Image imageThumb, imageTrack;
    private JPanel thumb;
    int y;
    int x;
    int py;
    int px;

   	public CustomScroll(int X, int Y) throws IOException {
    	if(new File("/Images/thumb.jpg").exists() && !new File("/Images/thumb.jpg").isDirectory()) {System.out.println("can't find");};
    	setLayout(null);
        imageThumb = ImageIO.read(getClass().getResource("Images/thumb.png"));
        imageTrack = ImageIO.read(getClass().getResource("Images/track.png"));
        thumb = new JPanel();
        thumb.setBackground(Color.BLACK);
        add(thumb);
        
        y= Y;
		py = getY();
		
		x= X;
		px = getX();
        
        thumb.setBounds(px, py, x, y);
        revalidate();
        repaint();
        
    }
	
	public void updateGraphic(int position) {
		
		py = position/7;
		
		thumb.setBounds(px, py, x, y);
		//System.out.println("x value: " + x);
		revalidate();
		repaint();
	}

}
