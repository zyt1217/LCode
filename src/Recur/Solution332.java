package Recur;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution332 {

    List<String> ans;
    List<List<String>> path;
    List<List<String>> tickets;
    int[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        ans = new ArrayList<>();
        path = new ArrayList<>();
        used = new int[tickets.size()];
        recur(0);
        return ans;
    }

    public void recur(int index){
        if(index == tickets.size()){
            for(int i = 0; i < index; i++){
                ans.add(path.get(i).get(0));
            }
            ans.add(path.get(path.size() - 1).get(1));
            return;
        }
        List<String> fly = null;
        int f = 0;
        for(int i = 0; i < tickets.size(); i++) {
            if (index == 0 && !tickets.get(i).get(0).equals("JFK"))
                continue;
//            if(index == 1 && path.get(0).get(0).equals("JFK"))
//                break;
            if (index > 0 && !tickets.get(i).get(0).equals(path.get(index - 1).get(1)))
                continue;
            if (used[i] == 1)
                continue;
            if (fly == null) {
                f = i;
                fly = tickets.get(i);
            }
            else {
                if (tickets.get(i).get(1).charAt(0) - fly.get(1).charAt(0) < 0){
                    fly = tickets.get(i);
                    f = i;
                }
            }
        }
        used[f] = 1;
        path.add(tickets.get(f));
        recur(index + 1);
        used[f] = 0;
        path.remove(path.size() - 1);
    }
}


class test{
    public  static void main(String[] args){
        Solution332 a = new Solution332();
        List<List<String>> l= new ArrayList<>();
        List<String> s = new ArrayList<>();
        s.add("JFK");
        s.add("SFO");
        l.add(new ArrayList<>(s));
        s.clear();
        s.add("JFK");
        s.add("ATL");
        l.add(new ArrayList<>(s));
        s.clear();
        s.add("SFO");
        s.add("ATL");
        l.add(new ArrayList<>(s));
        s.clear();
        s.add("ATL");
        s.add("JFK");
        l.add(new ArrayList<>(s));
        s.clear();
        s.add("ATL");
        s.add("SFO");
        l.add(new ArrayList<>(s));
        a.findItinerary(l);
    }
}