public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0 || path.charAt(0) != '/'){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = path.split("/+");
        if (arr.length == 0){
            return "/";
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals("..")){
                int last = sb.lastIndexOf("/");
                if (last != -1){
                    sb.delete(last, sb.length());
                }
            }else if (!arr[i].equals(".") && !arr[i].equals("")){
                sb.append("/");
                sb.append(arr[i]);
            }
        }
        if (sb.length() == 0){
            return "/";
        }
        return sb.toString();
    }
}