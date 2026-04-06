package atariopener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

public class OpenerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 8756070569137026857L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
		
	private static final List<Color> colors = List.of(
			Color.LIGHT_GRAY,
			Color.CYAN,
			Color.WHITE,
			new Color(173, 216, 230),
			new Color(167, 224, 242),
			Color.YELLOW,
			Color.WHITE);

	private static final List<Color> swooshColors = List.of(
			Color.MAGENTA,
			Color.RED,
			Color.PINK,
			Color.ORANGE,
			Color.YELLOW,
			new Color(144, 238, 144),
			Color.GREEN,
			new Color(167, 224, 242),
			Color.CYAN,
			new Color(173, 216, 230),
			Color.BLUE,
			new Color(0, 0, 128), // dark blue
			new Color(95, 74, 139), // violet
			new Color(128, 00, 255), // purple
			new Color(192, 00, 255)); // dark purple

	
	private final int fPS = 60;

	private int swooshColorIndex = 0;
	private int letterColorIndex = 0;
	
	private Thread panelThread;
	
	public OpenerPanel() {
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		
		panelThread = Thread.ofVirtual()
				.name("AtariOpenerPanelThread")
				.unstarted(this);
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int sWidth = 30;
		//int sMidWidth = sWidth + 40;
		int sMidWidth = sWidth + 30;
		int sFarWidth = sWidth;
		int sHeight = 15;
		
		//int widthMultiplier = 1;
		
		int x = 420;
		int midX = x + 45;
		//int midX = x + 30;
		int farX = x + 120;
		int y = 100;
		
		// Atari "swoosh"
		for (int counter = 0; counter < 14; counter++) {

			if (counter > 5) {
				x -= 10;
				farX += 10;
				sFarWidth += 10;
				
				if (counter < 9) {
					sWidth += 10;
					farX -=10;
				} else {
					sFarWidth -= 10;
				}
			}
			
			y += 20;

			swooshColorIndex = incrementSwooshColor(swooshColorIndex);
			g2.setColor(swooshColors.get(swooshColorIndex));
			g2.fillRect(x, y, sWidth, sHeight);
			g2.fillRect(midX, y, sMidWidth, sHeight);
			g2.fillRect(farX, y, sFarWidth, sHeight);
		
		}

		// letters
		y += 30;
		x = 240;
		int lBlockHeight = 25;
		
		// line 1
		g2.setColor(colors.get(letterColorIndex));
		g2.fillRect(x + 20, y, 60, lBlockHeight);
		g2.fillRect(x + 120, y, 100, lBlockHeight);
		g2.fillRect(x + 260, y, 60, lBlockHeight);
		g2.fillRect(x + 360, y, 80, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		// line 2
		y += lBlockHeight;
		g2.setColor(colors.get(getColorIndex(letterColorIndex + 1)));
		g2.fillRect(x, y, 20, lBlockHeight);
		g2.fillRect(x + 80, y, 20, lBlockHeight);
		g2.fillRect(x + 160, y, 20, lBlockHeight);
		g2.fillRect(x + 240, y, 20, lBlockHeight);
		g2.fillRect(x + 320, y, 20, lBlockHeight);
		g2.fillRect(x + 360, y, 20, lBlockHeight);
		g2.fillRect(x + 440, y, 20, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		// line 3
		y += lBlockHeight;
		g2.setColor(colors.get(getColorIndex(letterColorIndex + 2)));
		g2.fillRect(x, y, 20, lBlockHeight);
		g2.fillRect(x + 80, y, 20, lBlockHeight);
		g2.fillRect(x + 160, y, 20, lBlockHeight);
		g2.fillRect(x + 240, y, 20, lBlockHeight);
		g2.fillRect(x + 320, y, 20, lBlockHeight);
		g2.fillRect(x + 360, y, 20, lBlockHeight);
		g2.fillRect(x + 440, y, 20, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		// line 4
		y += lBlockHeight;
		g2.setColor(colors.get(getColorIndex(letterColorIndex + 3)));
		g2.fillRect(x, y, 20, lBlockHeight);
		g2.fillRect(x + 80, y, 20, lBlockHeight);
		g2.fillRect(x + 160, y, 20, lBlockHeight);
		g2.fillRect(x + 240, y, 20, lBlockHeight);
		g2.fillRect(x + 320, y, 20, lBlockHeight);
		g2.fillRect(x + 360, y, 80, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		// line 5
		g2.setColor(colors.get(getColorIndex(letterColorIndex + 4)));
		y += lBlockHeight;
		g2.fillRect(x, y, 100, lBlockHeight);
		g2.fillRect(x + 160, y, 20, lBlockHeight);
		g2.fillRect(x + 240, y, 100, lBlockHeight);
		g2.fillRect(x + 360, y, 20, lBlockHeight);
		g2.fillRect(x + 440, y, 20, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		// line 6
		g2.setColor(colors.get(getColorIndex(letterColorIndex + 5)));
		y += lBlockHeight;
		g2.fillRect(x, y, 20, lBlockHeight);
		g2.fillRect(x + 80, y, 20, lBlockHeight);
		g2.fillRect(x + 160, y, 20, lBlockHeight);
		g2.fillRect(x + 240, y, 20, lBlockHeight);
		g2.fillRect(x + 320, y, 20, lBlockHeight);
		g2.fillRect(x + 360, y, 20, lBlockHeight);
		g2.fillRect(x + 440, y, 20, lBlockHeight);
		g2.fillRect(x + 480, y, 20, lBlockHeight);
		
		g2.dispose();
	}

	@Override
	public void run() {

		while (panelThread.isAlive()) {
			letterColorIndex = incrementColor(letterColorIndex);
			repaint();
			
			try {
				Thread.sleep(1000/fPS*5);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void start() {
		panelThread.start();
	}
	
	private int incrementSwooshColor(int index) {
		
		index++;
		
		if (index >= swooshColors.size()) {
			index = 0;
		}
		
		return index;
	}
	
	private int incrementColor(int index) {
		
		index++;
		
		if (index >= colors.size()) {
			index = 0;
		}
		
		return index;
	}
	
	private int getColorIndex(int index) {
		
		if (index >= colors.size()) {
			return index - colors.size();
		}
		
		return index;
	}
}
