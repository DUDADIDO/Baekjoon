import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int length = callings.length;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            hm.put(players[i], i);
        }
        for(int i=0; i<length; i++) {
            int index = hm.get(callings[i]);
            String tmpPlayer = players[index-1];
            players[index-1] = players[index];
            players[index] = tmpPlayer;
            hm.put(callings[i], index-1);
            hm.put(tmpPlayer, index);
        }
        
        return players;
    }
}