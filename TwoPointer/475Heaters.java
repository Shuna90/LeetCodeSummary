475. Heaters

 public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0, sizeH = heaters.length;
        for (int house : houses){
            while (i < sizeH - 1 && heaters[i + 1] - house <= house - heaters[i]){
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }