package main;

import java.util.ArrayList;

public class PathFinder {
	
	Grid grid;
	Node start_node, end_node;
	
	
	public PathFinder(Grid grid, int[] start_cords, int[] end_cords) {
		this.grid=grid;
		this.start_node = this.grid.findNode(start_cords[0], start_cords[1]);
		this.end_node = this.grid.findNode(end_cords[0], end_cords[1]);
	}
	
	private Node bestChoice(ArrayList<Node> open) {
		int minF = 100000000;
		ArrayList<Node> bestFs = new ArrayList<Node>();
		for(Node n : open) {
			if(n.f < minF) {
				bestFs.clear();
				bestFs.add(n);
				minF = n.f;
			} else if(n.f == minF) {
				bestFs.add(n);
			}
		}
		
		if(bestFs.size() == 1) {
			return bestFs.get(0);
		} else {
			Node bestH = bestFs.get(0);
			for(Node n : bestFs) {
				if(n.h<bestH.h) {
					bestH = n;
				}
			}
			return bestH;
			
		}
	}
	
	
	private ArrayList<int[]> calculatePath(){
		ArrayList<int[]> best = new ArrayList<int[]>();
		Node n = this.end_node;
		while(n.parent!=null) {
			best.add(new int[] {n.x,n.y});
			n = n.parent;
		}
		best.add(new int[] {start_node.x,start_node.y});
		
		ArrayList<int[]> BEST = new ArrayList<int[]>();
		for(int i = best.size()-1; i>=0; i--) {
			BEST.add(best.get(i));
		}
		
		return BEST;
	}
	
	
	private ArrayList<Node> getNeighbors(Node current) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		neighbors.add(this.grid.findNode(current.x, current.y-1));
		neighbors.add(this.grid.findNode(current.x, current.y+1));
		neighbors.add(this.grid.findNode(current.x+1, current.y));
		neighbors.add(this.grid.findNode(current.x-1, current.y));
		ArrayList<Node> NEIGHBORS = new ArrayList<Node>();
		for(Node n : neighbors) {
			if (n != null) {
				NEIGHBORS.add(n);
			}
		}
		return NEIGHBORS;
	}
	
	private void setFGH(Node n) {
		n.h = Math.abs(this.end_node.x-n.x)+Math.abs(this.end_node.y-n.y);
		n.g = n.parent.g+10;
		n.f = n.g+n.h;
	}
	
	
	
	
	public ArrayList<int[]> findPath(){
		if(!start_node.pathable || !end_node.pathable) {
			System.out.println("Bad Starts");
			return null;
		}
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		start_node.parent = null;
		start_node.g=0;
		start_node.h=Math.abs(this.end_node.x-start_node.x)+Math.abs(this.end_node.y-start_node.y);
		start_node.f=start_node.g+start_node.h;
		open.add(start_node);
		
		while(!open.isEmpty()) {
			Node current = bestChoice(open);
			open.remove(current);
			closed.add(current);
			
			if(current == this.end_node) {
				return calculatePath();
			}
			
			ArrayList<Node> neighbors = getNeighbors(current);
			for(Node neighbor : neighbors) {
				if(neighbor.pathable && !closed.contains(neighbor)) {
					if(!open.contains(neighbor) || current.g+10<neighbor.g) {
						neighbor.parent = current;
						setFGH(neighbor);
						if(!open.contains(neighbor)) {
							open.add(neighbor);
						}
					}
				}
			}
			
		}
		System.out.println("No solution");
		return null;
	}

	



	
}

















