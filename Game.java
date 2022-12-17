package Com.Game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, MouseListener{

	
	private Board game = new Board();
	private static Game newGame = new Game();
	private Color c;
	public Sound sound = new Sound();
	public Sound music = new Sound();
	
	
	static JFrame frame = new JFrame("2048");
	
	private Display display = new Display();

	public static void setUpGUI() { // untuk set up size yang tepat dan menambahkan keylistener beserta mouselistener
			
		frame = new JFrame("2048");

		frame.addKeyListener(newGame);
		frame.addMouseListener(newGame);
		frame.getContentPane().add(newGame);
		
		frame.setSize(1280, 700);
		frame.setVisible(true);
		frame.setResizable(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public void paint(Graphics g) { // untuk pewarnaan game. 
		
		super.paint(g);
		Font fnt0 = new Font("Comic Sans", Font.CENTER_BASELINE, 50);
		g.setFont(fnt0);
		g.setColor(new Color(197, 155, 48));
		g.drawString("2048", 600, 70);
		
		Font fnt1 = new Font("Comic Sans", Font.CENTER_BASELINE, 15);
		g.setFont(fnt1);
		g.setColor(new Color(197, 155, 48));
		g.drawString( "Score: " + game.getScore(), 400 - 4 * String.valueOf( game.getScore() ).length(), 70);
		g.drawString("Highest Tile: " + game.getHighTile(), 880 - 4 * String.valueOf(game.getHighTile()).length(), 70);
		g.drawString("Use 'wasd' or Arrow Keys to move", 530, 600);
		
		g.setColor(new Color (255, 226, 173));
		g.fillRect(430, 100, 450, 450);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				drawTiles(g, game.board[i][j], j * 100 + 460, i * 100 + 130);
			}
		}
		
		if(game.gameOver()) {
			
			stopMusic();
			playSE(1);
			g.setColor(new Color (114, 9, 183));
			g.fillRect(430, 100, 450, 450);
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					
					g.setColor(Color.RED);
					g.fillRoundRect(j * 100 + 460, i * 100 + 130, 95, 95, 5, 5);
					g.setColor(Color.BLACK);
					g.drawString("GAME", j * 100 + 490, i * 100 + 170);
					g.drawString("OVER", j * 100 + 490, i * 100 + 190);
				}
			}
		}
		
		display.render(g);
	}
	
	void drawTiles(Graphics g, Tile tile, int x, int y) { // untuk pewarnaan tile
		
		int tileValue = tile.getValue();
		int length = String.valueOf(tileValue).length();
		
		g.setColor(new Color (247, 240, 222));
		g.fillRoundRect(x, y, 95, 95, 5, 5); // besar kotak 95 
		g.setColor(Color.BLACK);
		
		if(tileValue > 0) {
			
			g.setColor(tile.getColor());
			g.fillRoundRect(x, y, 95, 95, 5, 5);
			g.setColor(Color.BLACK);
			g.drawString("" + tileValue, x + 48 - 3 * length, y + 49);
		}
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) { // mendeteksi arah gerak dari keyboard
		
		String gameBoard;
		if(e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP) {
			game.up();
			game.spawn();
			gameBoard = game.toString();
			frame.repaint();
		}
		
		else if(e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) {
			game.down();
			game.spawn();
			gameBoard = game.toString();
			frame.repaint();
		}
		
		else if(e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.left();
			game.spawn();
			gameBoard = game.toString();
			frame.repaint();
		}
		
		else if(e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.right();
			game.spawn();
			gameBoard = game.toString();
			frame.repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { // untuk mendeteksi saat button di pencet maka terjadi new game
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= 900 && mx <= 1020) {
			if(my >= 100 && my <= 180) {
				game = new Board();
				game.spawn();
				game.spawn();
				frame.repaint();
			}
		} playMusic(2);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
		
	}
	
	public void stopMusic() {
		sound.stop();
	}


	public void playSE(int i) {
		// TODO Auto-generated method stub
		music.setFile(i);
		music.play();
		
	}
	
}