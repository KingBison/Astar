package main;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x,y;
	protected ID id;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public ID getID() {
		return this.id;
	}

	protected abstract void setSelected(boolean b);

	protected abstract boolean getPathable();

	protected abstract boolean getSelected();

	

}