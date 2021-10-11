package main;

public class Node {
	
	public int x,y,f,g,h;
	public boolean pathable;
	public Node parent;
	
	public Node(int x, int y, boolean pathable) {
		this.x=x;
		this.y=y;
		this.pathable = pathable;
	}
	
}
