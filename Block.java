package main;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject{
	private boolean pathable;
	private boolean selected;

	public Block(int x, int y, ID id, boolean pathable) {
		super(x,y,id);
		this.pathable = pathable;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(this.pathable) {
			g.setColor(Color.white);
			g.fillRect(this.x*50+5,this.y*50+5, 40,40);
		} else {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(this.x*50+5,this.y*50+5, 40,40);
		}
		if(this.selected) {
			g.setColor(Color.RED);
			g.drawRect(this.x*50+5,this.y*50+5, 40,40);
		}
		
	}
		
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean s) {
		this.selected = s;
	}
	
	public boolean getPathable() {
		return this.pathable;
	}
	

		
		
		
	
	
	
	
}
