public class Vector2D implements Iterator<Integer> {
    Iterator<Integer> iter;
    Iterator<List<Integer>> iterall;
    
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null || vec2d.size() == 0){
            return;
        }
        iterall = vec2d.iterator();
        findNextIter();
    }
    
    public void findNextIter(){
        while (iterall.hasNext()){
            List<Integer> list = iterall.next();
            if (list != null && list.size() != 0){
                iter = list.iterator();
                return;
            }
        }
    }
    
    @Override
    public Integer next() {
        Integer res = iter.next();
        if (!iter.hasNext()){
            findNextIter();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return iter != null && iter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */