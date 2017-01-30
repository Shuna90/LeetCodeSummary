350. Intersection of Two Arrays II
public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++; 
            }else{
                j++;
            }
        }
        int[] arr = new int[list.size()];
        int index = 0;
        for (int i : list){
            arr[index++] = i;
        }
        return arr;
    }