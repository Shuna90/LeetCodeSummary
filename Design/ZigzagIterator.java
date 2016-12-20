public class ZigzagIterator {
    List<Iterator<Integer>> iterall;
    int index = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterall = new ArrayList<Iterator<Integer>>();
        iterall.add(v1.iterator());
        iterall.add(v2.iterator());
    }

    public int next() {
        if (hasNext()){
            Integer res = iterall.get(index).next();
            index = (index + 1) % iterall.size();
            return res;
        }else{
            return 0;
        }
        
    }

    public boolean hasNext() {
        while (!iterall.isEmpty() && !iterall.get(index).hasNext()){
            iterall.remove(index);
            if (index == iterall.size()){
                index = 0;
            }
        }
        return !iterall.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */