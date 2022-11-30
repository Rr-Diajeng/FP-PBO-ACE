package Com.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener{
	
	private Board game = new Board();
	private static Game newGame = new Game();
	private Color c;
	
	static JFrame frame = new JFrame("2048");;
	
	public static void setUpGUI() {
			
		frame = new JFrame("2048");
		
		frame.addKeyListener(newGame);
		frame.getContentPane().add(newGame);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setResizable(false);

	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		g.drawString("2048", 250, 20);
		g.drawString( "Score: " + game.getScore(), 200 - 4 * String.valueOf( game.getScore() ).length(), 40);
		g.drawString("Highest Tile: " + game.getHighTile(), 280 - 4 * String.valueOf(game.getHighTile()).length(), 40);
		g.drawString("Press 'Enter' to Start", 210, 315);
		g.drawString("Use 'wasd' or Arrow Keys to move", 180, 335);
		
		if(game.blackOut()) g.drawString("Press 'Enter' to restart", 200, 355);
		
		g.setColor(Color.gray);
		g.fillRect(140, 50, 250, 250);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				drawTiles(g, game.board[i][j], j * 60 + 150, i * 60 + 60);
			}
		}
		
		if(game.gameOver()) {
			
			g.setColor(Color.gray);
			g.fillRect(140, 50, 250, 250);
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					
					g.setColor(Color.RED);
					g.fillRoundRect(j * 60 + 150, i * 60 + 60, 50, 50, 5, 5);
					g.setColor(Color.BLACK);
					g.drawString("GAME", j * 60 + 160, i * 60 + 75);
					g.drawString("OVER", j * 60 + 160, i * 60 + 95);
				}
			}
		}
	}
	
	public void drawTiles(Graphics g, Tile tile, int x, int y) {
		
		int tileValue = tile.getValue();
		int length = String.valueOf(tileValue).length();
		
		g.setColor(Color.lightGray);
		g.fillRoundRect(x, y, 50, 50, 5, 5);
		g.setColor(Color.BLACK);
		
		if(tileValue > 0) {
			
			g.setColor(tile.getColor());
			g.fillRoundRect(x, y, 50, 50, 5, 5);
			g.setColor(Color.BLACK);
			g.drawString("" + tileValue, x + 25 - 3 * length, y + 25);
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
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
		
		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			game = new Board();
			game.spawn();
			game.spawn();
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
	
	public static void main(String[] args) {
		
		setUpGUI();
	}
	
	
}
