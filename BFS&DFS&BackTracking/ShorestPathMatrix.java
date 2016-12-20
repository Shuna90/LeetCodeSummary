import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ShorestPath {
	public static class Point{
		int x;
		int y;
		Point pre;
		int dis;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
			pre = null;
			dis = Integer.MAX_VALUE;
		}
		public String toString(){
			return "[" + x + "," + y + "]";
		}
	}
	//1 go 0 wall 3 target
	public static List<Point> findShortestPath(int[][] arr, Point start){
		int M = arr.length;
		int N = arr[0].length;
		List<Point> res = new LinkedList<Point>();
		Queue<Point> q = new LinkedList<Point>();
		start.dis = 0;
		q.add(start);
		arr[start.x][start.y] = -1;
		Point end = null;
		while (!q.isEmpty()){
			Point p = q.poll();
			if (arr[p.x][p.y] == 3){
				end = p;
				break;
			}
			addQueu(p, q, arr, p.x + 1, p.y);
			addQueu(p, q, arr, p.x - 1, p.y);
			addQueu(p, q, arr, p.x, p.y + 1);
			addQueu(p, q, arr, p.x, p.y - 1);
		}
		while (end.pre != null){
			res.add(end.pre);
			end = end.pre;
		}
		return res;
	}
	public static void addQueu(Point p, Queue<Point> q, int[][] arr, int i, int j){
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 || arr[i][j] == -1){
			return;
		}
		if (arr[i][j] == 1){
			arr[i][j] = -1;
		}
		Point cur = new Point(i, j);
		cur.pre = p;
		cur.dis = p.dis + 1;
		q.add(cur);
	}
	public static void main(String[] args){
		int[][] area = new int[][] {
                {1, 1, 1, 1, 1, 3},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
		Point start = new Point(2,0);
        List<Point> shortestPath = findShortestPath(area, start);
        System.out.println(shortestPath.get(shortestPath.size() - 1).dis);
        for (Point f : shortestPath) {
            System.out.println(f.toString());
        }
	}
}
