119. Pascals Triangle II
public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0){
            return res;
        }
        res.add(1);
        while (rowIndex-- > 0){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int i = 1; i < res.size(); i++){
                tmp.add(res.get(i) + res.get(i - 1));
            }
            tmp.add(1);
            res = tmp;
        }
        return res;
    }