package spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

// import java.io.File;
// import java.io.IOException;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javax.imageio.ImageIO;

// import java.awt.RenderingHints;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	// Graphics2D bi;
	// private BufferedImage image;

	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		
		// super.paintComponent(bi);
		// Graphics2D big = (Graphics2D) bi;

		big = (Graphics2D) bi.getGraphics();
		
		// big.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// myBackgroundRoutine(big);

		// try {                
  //         image = ImageIO.read(new File("bg.jpg"));
  //       } catch (IOException ex) {}

		big.setBackground(Color.DARK_GRAY);
	}

	// @Override
 //    protected void paintComponent(Graphics g) {
 //        super.paintComponent(g);
 //        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
 //    }

	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		
		big.setColor(Color.WHITE);		
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20);

		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
