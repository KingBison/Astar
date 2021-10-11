package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PathLine extends GameObject{
	private ArrayList<int[]> path;

	public PathLine(int x, int y, ID id, ArrayList<int[]> path) {
		super(x,y,id);
		this.path = path;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(this.path != null) {
			g.setColor(Color.red);
			for(int i = 0; i<path.size()-1;i++) {
				g.drawLine(path.get(i)[0]*50+25, path.get(i)[1]*50+25, path.get(i+1)[0]*50+25, path.get(i+1)[1]*50+25);
					
				
			}
		}
		
		
		
	}

	@Override
	protected void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean getPathable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean getSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}