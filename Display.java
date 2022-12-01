package Com.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Display{
	private Board game = new Board();
	JFrame frame;
	
	public Rectangle newGame = new Rectangle(900, 100, 120, 50);
	public Rectangle leaderBoard= new Rectangle(900, 200, 120, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 15);
		g.setFont(fnt0);
		g.drawString("New Game", newGame.x + 20, newGame.y + 30);
		g.drawString("Leader Board", leaderBoard.x + 10, leaderBoard.y + 30);
		g2d.draw(newGame);
		g2d.draw(leaderBoard);
		
	}

}
