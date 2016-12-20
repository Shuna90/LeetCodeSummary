/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> s;
    Integer ans = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        s = new Stack<Iterator<NestedInteger>>();
        s.push(nestedList.iterator());
        changeNext();
    }


private void changeNext() {
    while (!s.isEmpty()) {
        if (!s.peek().hasNext()) {  // iterator is empty. Another situation could be that iterator for the list is empty at all
            s.pop();
            continue;
        }
        NestedInteger curr = s.peek().next();  // get next of top iterator
        if (curr.isInteger()) {
            ans = curr.getInteger();
            return;
        }
        // comes to here, it means it is a list
        s.push(curr.getList().iterator());
    }
}

@Override
public Integer next() {
    Integer tmp = ans;
    ans = null;
    changeNext();
    return tmp;
}

@Override
public boolean hasNext() {
    return ans != null;
}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */