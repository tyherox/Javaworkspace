package Main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

public class DragableC extends JButton{
	
	private volatile int draggedAtX, draggedAtY;
	
	 public DragableC(String text){
	        super(text);
	        setDoubleBuffered(false);
	        setMargin(new Insets(0, 0, 0, 0));
	        setSize(50, 50);
	        setPreferredSize(new Dimension(25, 25));

	        addMouseListener(new MouseAdapter(){
	            public void mousePressed(MouseEvent e){
	                draggedAtX = e.getX();
	                draggedAtY = e.getY();
	            }
	        });

	        addMouseMotionListener(new MouseMotionAdapter(){
	            public void mouseDragged(MouseEvent e){
	                setLocation(e.getX() - draggedAtX + getLocation().x,
	                        e.getY() - draggedAtY + getLocation().y);
	            }
	        });
	    }

}
