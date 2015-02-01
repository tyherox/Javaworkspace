package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class TPanel extends JButton {

  private Image img;


  public TPanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
  }

  public void paintComponent(Graphics g) {
	  g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }

}