165. Compare Version Numbers

public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        
        int length = Math.max(array1.length, array2.length);
        for (int i = 0; i < length; i++){
            Integer v1 = i < array1.length ? Integer.parseInt(array1[i]) : 0;
            Integer v2 = i < array2.length ? Integer.parseInt(array2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0){
                return compare;
            }
        }
        return 0;
    }
