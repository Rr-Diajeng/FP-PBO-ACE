package Com.Game;

import java.awt.Color;
	
public class Tile{
	    
	int value;

	Color TileColor;


	public Tile(){
	    value = 0;
	}

	public Tile( int number ){
	    value = number;
	}

	public int getValue(){
	    return value;
	}

	public void setValue( int value ){
	    this.value = value;
	}

	public String toString(){
	    return "" + value;
	}


	public void setColor(){
	if ( this.getValue() == 2 ){
		TileColor = new Color( 241, 198, 151 );
	}
	
	else if ( this.getValue() == 4 ){
		TileColor = new Color( 213, 246, 246 );
	}
	
	else if ( this.getValue() == 8 ){
		TileColor = new Color( 5, 100, 113 );
	}
	
	else if ( this.getValue() == 16 ){
		TileColor = new Color( 16, 137, 167 );
	}
	
	else if ( this.getValue() == 32 ){
		TileColor = new Color( 89, 213, 233 );
	}
	
	else if ( this.getValue() == 64 ){
		TileColor = new Color( 151, 234, 242 );
	}
	
	else if ( this.getValue() == 128 ){
		TileColor = new Color( 227, 172, 99 );
	}
	
	else if ( this.getValue() == 256 ){
		TileColor = new Color( 44, 201, 180 );
	}
	
	else if ( this.getValue() == 512 ){
		TileColor = new Color( 20, 187, 220 );
	}
	
	else if ( this.getValue() == 1024 ){
		TileColor = new Color( 82, 82, 20 );
	}
	
	 else{
		 TileColor = new Color( 49, 49, 12 );
	}
}


	public Color getColor(){
		this.setColor();
	        return TileColor;
	        }
	}
