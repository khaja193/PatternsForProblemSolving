import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    int windowstart=0;
    int n=str.length();
    char key=' ';
    int max=0;
    HashMap<Character,Integer> h=new HashMap<>();
    for(int windowend=0;windowend<n;windowend++)
    {
         key=str.charAt(windowend);
          if(h.containsKey(key))
          {
               h.put(key,h.get(key)+1);
          }
          else
            h.put(key,1);

          if(h.size()>k)
          {
            if(h.containsKey(str.charAt(windowstart)))
            {
                  h.put(str.charAt(windowstart),h.get(str.charAt(windowstart))-1);
            }
            if(h.get(str.charAt(windowstart))==0)
              h.remove(str.charAt(windowstart));    
            windowstart++;         
          }
          max=Math.max(max,windowend-windowstart+1);
    }
    return max;
  }
}
