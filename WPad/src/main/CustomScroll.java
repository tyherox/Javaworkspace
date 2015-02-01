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
    int sy;
    int sx;
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
        
        sy= Y;
		py = getY();
		
		sx= X;
		px = getX();
        
        thumb.setBounds(px, py, sx, sy);
        revalidate();
        repaint();
    }
	
	public void updateGraphic(double pChange, double sChange) {
		System.out.println("e value: " + sChange);
		System.out.println("change value: " + pChange);
		py = (int) (0+(pChange*sy));
		int ny = (int) (sChange*sy);
		System.out.println("py value: " + py);
		if(sChange==Double.POSITIVE_INFINITY)
		{
			thumb.setBounds(px, py, 0, 0);
		}
		else
		{
			thumb.setBounds(px, py, sx, ny);
		}
		repaint();
	}

}