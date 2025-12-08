public class ZigZag {
    public String zigZag(String s,int rows){
        if(rows == 1 || s == null || s.isEmpty()){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int increment = 2 * (rows-1);

        for(int r = 0;r < rows;r++){
            for(int i = r; i < s.length();i+= increment){
                result.append(s.charAt(i)); // for first and last rows
                if(r > 0 && r < rows -1){
                    // for between rows
                    int intermediate = i + increment -2 * r;

                    if(intermediate < s.length()){
                        result.append(s.charAt(intermediate));
                    }
                }
            }
        }
        return result.toString();
    }
}
