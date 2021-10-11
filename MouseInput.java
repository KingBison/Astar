package main;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
	
	private Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int cX = e.getX();
		int cY = e.getY();
		for (GameObject g : handler.object) {
			if(g.getID()==ID.Block) {
				if(g.getPathable()) {
					if(g.getX()*50<cX && g.getX()*50+50>cX && g.getY()*50<cY && g.getY()*50+50>cY) {
						System.out.println(g.getX() + "," + g.getY());
						g.setSelected(true);
					}
				}
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
