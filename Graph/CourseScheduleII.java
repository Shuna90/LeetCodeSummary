public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[0];
        if (numCourses <= 0){
            return arr;
        }
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            graph.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }
        arr = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        while (!q.isEmpty()){
            int course = q.poll();
            visited[course] = true;
            arr[count++] = course;
            for (int i : graph.get(course)){
                if (--indegree[i] == 0 && !visited[i]){
                    q.offer(i);
                }
            }
        }
        if (count == numCourses){
            return arr;
        }
        return new int[0];
    }
}