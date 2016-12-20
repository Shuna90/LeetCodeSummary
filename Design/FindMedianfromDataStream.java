class MedianFinder {
    PriorityQueue<Integer> large = new PriorityQueue<Integer>();
    PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b - a;
        }
    });
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (small.isEmpty()){
            small.offer(num);
            return;
        }
        if (num < small.peek()){
            small.offer(num);
        }else{
            large.offer(num);
        }
        if (small.size() - large.size() > 1){
            large.offer(small.poll());
        }else if (large.size() - small.size() >= 1){
            small.offer(large.poll());
        }
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        if (large.size() == small.size()){
            return (double)(large.peek() + small.peek()) / 2;
        }else{
            return small.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();