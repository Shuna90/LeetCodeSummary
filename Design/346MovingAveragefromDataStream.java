346. Moving Average from Data Stream

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

Deque<Integer> dq;
    int count;
    int capacity;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        dq = new ArrayDeque<Integer>();
        count = 0;
        capacity = size;
    }
    
    public double next(int val) {
        count += val;
        dq.addLast(val);
        if (dq.size() > capacity){
            count = count - dq.removeFirst();
        }
        return (double)count / dq.size();
    }