118. Pascal Triangle

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0){
            return res;
        }
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        res.add(arr);
        while (numRows-- > 1){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int i = 1; i < arr.size(); i++){
                tmp.add(arr.get(i) + arr.get(i - 1));
            }
            tmp.add(1);
            arr = tmp;
            res.add(arr);
        }
        return res;
    }