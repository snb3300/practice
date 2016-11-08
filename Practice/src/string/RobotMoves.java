package string;

public class RobotMoves {

	private static enum Face {
		EAST,
		WEST,
		NORTH,
		SOUTH,
		UNKNOWN
	}
	
	private static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object p) {
			Point q = (Point)p;
			if(q.x == this.x && q.y == this.y)
				return true;
			return false;
		}
	}
	
	
	private static Face getNewFace(Face currentFace, char direction) {
		switch (currentFace) {
		case EAST: 
			if(direction == 'r')
				return Face.SOUTH;
			return Face.NORTH;
		case WEST:
			if(direction == 'r')
				return Face.NORTH;
			return Face.SOUTH;
		case NORTH:
			if(direction == 'r')
				return Face.EAST;
			return Face.WEST;
		case SOUTH:
			if(direction == 'r')
				return Face.WEST;
			return Face.EAST;
		case UNKNOWN:
			return Face.UNKNOWN;
		}
		return Face.UNKNOWN;
	}
	
	private static Point getNextPoint(Point currentPoint, Face currentFace) {
		Point newPoint = new Point(-1, -1);
		switch (currentFace) {
		case NORTH:
			newPoint.x = currentPoint.x;
			newPoint.y = currentPoint.y + 1;
			break;
		case SOUTH:
			newPoint.x = currentPoint.x;
			newPoint.y = currentPoint.y - 1;
			break;
		case EAST:
			newPoint.x = currentPoint.x + 1;
			newPoint.y = currentPoint.y;
			break;
		case WEST:
			newPoint.x = currentPoint.x - 1;
			newPoint.y = currentPoint.y;
			break;
		case UNKNOWN:
			break;
		}
		return newPoint;
	}
	
	public static boolean didMoveCircular(String moves) {
		Face currentFace = Face.NORTH;
		Point startPoint = new Point(0,0);
		moves = moves.toUpperCase();
		Point p = startPoint;
		for(int i = 0; i < moves.length(); i++) {
			switch(moves.charAt(i)) {
			case 'G': 
				p = getNextPoint(p, currentFace);
				break;
			case 'L':
				currentFace = getNewFace(currentFace, 'l');
				break;
			case 'R':
				currentFace = getNewFace(currentFace, 'r');
				break;
			default: break;
			}
		}
		
		return startPoint.equals(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(didMoveCircular("GLGLGLG"));
	}

}
