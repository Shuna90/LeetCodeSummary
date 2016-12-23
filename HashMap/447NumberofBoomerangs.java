447. Number of Boomerangs
public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                if (i == j){
                    continue;
                }
                int dis = getdis(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (int value : map.values()){
                res += value * (value - 1);
            }
            map.clear();
        }
        return res;
    }
    public int getdis(int[] a,int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x *x + y * y; 
    }