package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Launcher extends Canvas implements Runnable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private Grid grid;
	private Handler handler;
	
	public Launcher() {
		grid = new Grid(15,15,40);
		handler = new Handler();
		this.addMouseListener(new MouseInput(handler));
		new Window(this);
		for(Node n : grid.nodeList) {
			handler.addObject(new Block(n.x,n.y,ID.Block, n.pathable));
		}
	}


	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer=System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta+= (now - lastTime) /ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			int selectCounter = 0;
			for(GameObject g : handler.object) {
				if(g.getSelected()) {
					selectCounter++;
				}
			}
			if(selectCounter == 2) {
				ArrayList<GameObject> blocks = new ArrayList<GameObject>();
				for(GameObject g : handler.object) {
					if(g.getSelected()) {
						selectCounter++;
						blocks.add(g);
					}
				}
				PathFinder pf = new PathFinder( this.grid, new int[] {blocks.get(0).getX(),blocks.get(0).getY()}, new int[] {blocks.get(1).getX(),blocks.get(1).getY()});
				if(pf.findPath()==null) {
					selectCounter=0;
					for(GameObject g : handler.object) {
						g.setSelected(false);
					}
				}else {
					handler.addObject(new PathLine(0,0,ID.PathLine,pf.findPath()));
				}
			
			}
			
			if(selectCounter == 3) {
				ArrayList<GameObject> lines = new ArrayList<GameObject>();
				selectCounter=0;
				for(GameObject g : handler.object) {
					g.setSelected(false);
					if(g.id == ID.PathLine) {
						lines.add(g);
					}
				}
				for(GameObject line : lines) {
					handler.removeObject(line);
				}
				
			}
			
			
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer >1000) {
				timer +=1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick(){
		handler.tick();
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 800,800);
		
		handler.render(g);
		
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Launcher();
		
	}
	

}
