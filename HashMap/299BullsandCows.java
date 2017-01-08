299. Bulls and Cows

public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int b = 0, c = 0;
        for (int i = 0; i < secret.length(); i++){
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg){
                b++;
            }else{
                if (arr[cs - '0']++ < 0){
                    c++;
                }
                if (arr[cg - '0']-- > 0){
                    c++;
                }
            }
        }
        return b + "A" + c + "B";
    }