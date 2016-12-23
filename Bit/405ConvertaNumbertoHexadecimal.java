405. Convert a Number to Hexadecimal
char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int cur = num & 0x0000000f;
            sb.insert(0, map[cur]);
            num = (num >>> 4);
        }
        return sb.toString();
    }