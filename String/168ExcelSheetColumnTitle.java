168. Excel Sheet Column Title

public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            char c = (char)((n - 1) % 26 + 'A');
            sb.insert(0, c);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
    