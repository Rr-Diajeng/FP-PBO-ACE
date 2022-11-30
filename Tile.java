package Com.Game;

import java.awt.Color;

public class Tile {
	
	int value;
	
	private int number;
	private Color angkaColor;
	
	public Tile() {
		
		this.value = 0;
	}
	
	public Tile(int number) {
		
		this.number = number;
		
		this.value = this.number;
	}
	
	public int getValue() {
		
		return this.value;
	}
	
	public void setValue(int value) {
		
		this.value = value;
	}
	
	public String toString() {
		
		return "" + this.value;
	}
	
	public void setColor() {
		
		if (this.getValue() == 2 )
		{
			angkaColor = new Color( 45, 133, 197 );
		}
		
		else if (this.getValue() == 4 ){
			angkaColor = new Color( 60, 169, 238 );
		}
		
		else if (this.getValue() == 8 ){
		    angkaColor = new Color( 97, 189, 238 );
		}
		
		else if (this.getValue() == 16 ){
		    angkaColor = new Color( 165, 211, 235 );
		}
		
		else if (this.getValue() == 32 ){
		    angkaColor = new Color( 226, 226, 226 );
		}
		
		else if (this.getValue() == 64 ){
		    angkaColor = new Color( 223, 166, 147 );
		}
		
		else if (this.getValue() == 128 ){
		    angkaColor = new Color( 220, 110, 85 );
		}
		
		else if (this.getValue() == 256 ){
		    angkaColor = new Color( 225, 75, 50 );
		}
		
		else if (this.getValue() == 512 ){
		    angkaColor = new Color( 195, 55, 38 );
		}
		
		else if (this.getValue() == 1024 ){
		    angkaColor = new Color( 157, 42, 28 );
		}
		
		 else{
		    angkaColor = new Color( 237, 194, 46 );
		}
	}
	
	public Color getColor() {
		this.setColor();
		return angkaColor;
	}
}
