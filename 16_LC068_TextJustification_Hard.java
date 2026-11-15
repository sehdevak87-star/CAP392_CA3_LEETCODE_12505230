import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        
        while (i < n) {
            int j = i;
            int lineLength = 0;
            
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numberOfWords = j - i;
            int totalSpaces = maxWidth - lineLength;
            
            if (j == n || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int baseSpaces = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < baseSpaces; s++) {
                            sb.append(" ");
                        }
                        if (k - i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j;
        }
        
        return result;
    }
}