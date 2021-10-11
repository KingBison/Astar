package main;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
	
	int width,height;
	double blockable_percent;
	ArrayList<Node> nodeList;
	
	
	public Grid(int width, int height, double blockable_percent) {
		this.width = width;
		this.height = height;
		
		this.nodeList = new ArrayList<Node>();
		Random rnd = new Random();
		
		for(int i = 0; i<this.width;i++) {
			for(int k = 0; k<this.height;k++) {
				int pth = rnd.nextInt(100);
				if(pth<blockable_percent) {
					this.nodeList.add(new Node(i,k,false));
				} else {
					this.nodeList.add(new Node(i,k,true));
				}
			}
		}
		
	}
	public void printGrid() {
		String out = "";
		for(int i = 0; i<this.width;i++) {
			for(int k = 0; k<this.height;k++) {
				if(nodeList.get(width*i+k).pathable) {
					out+="- ";
				}else {
					out+="X ";
				}
			}
			out+="\n";
		}
		System.out.println(out);
	}
	
	public Node findNode(int x, int y) {
		for(Node n : this.nodeList) {
			if(n.x == x && n.y == y) {
				return n;
			}
		}
		return null;
	}
}
