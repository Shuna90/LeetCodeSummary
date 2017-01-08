38. Count and Say
public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++){
            StringBuilder tmp = sb;
            int j = 0, size = sb.length();
            sb = new StringBuilder();
            while (j < size){
                int count = 0;
                char pre = tmp.charAt(j);
                while (j < size && tmp.charAt(j) == pre){
                    j++;
                    count++;
                }
                sb.append(count).append(pre);
            }
        }
        return sb.toString();
    }