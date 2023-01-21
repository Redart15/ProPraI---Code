package de.propra.defense.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Feld extends JPanel {

  private final Image bgImage;

  private Image currentImage;

  public Feld(Image image) {
    this.bgImage = image;
    this.currentImage = null;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Image img = currentImage == null ? bgImage : currentImage;
    g.setColor(Color.black);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.drawImage(img,0,0,this);
  }

  public void setCurrentImage(Image image) {
    currentImage = image;
  }

  public boolean occupied() {
    return currentImage != null;
  }
}
