class Solution {
    public String minWindow(String s, String t) {
        // =====================================================
        // STRIVER'S METHOD
        // =====================================================
        // int hash[] = new int[256];
        // int l = 0, r = 0, mini = Integer.MAX_VALUE, count = 0;
        // int st = -1;
        
        // for (int i = 0; i < t.length(); i++) {
        //     hash[t.charAt(i)]++;
        // }
        
        // while(r < s.length()){
        //     if(hash[s.charAt(r)] > 0){
        //         count++;
        //     }
        //     hash[s.charAt(r)]--;
            
        //     while(count == t.length()){
        //         if(r-l+1 < mini){
        //             mini = r - l + 1;
        //             st = l;
        //         }
        //         hash[s.charAt(l)]++;
        //         if(hash[s.charAt(l)] > 0){
        //             count--;
        //         }
        //         l++;
        //     }
        //     r++;
        // }
        // return st == -1 ? "" : s.substring(st, st + mini);




        // =====================================================
        // ADITYA VERMA'S METHOD
        // =====================================================
        int l=0, r=0, ans = Integer.MAX_VALUE, st =-1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<t.length();i++){
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count =hm.size();

        while(r<s.length()){
            if(hm.containsKey(s.charAt(r))){
                hm.put(s.charAt(r), hm.get(s.charAt(r)) - 1);
                if(hm.get(s.charAt(r)) == 0){
                    count--;
                }
            }
            while(count == 0){
                
                if(ans > r-l+1){
                    System.out.println("h"+ st);
                    ans = r-l+1;
                    st = l;
                }
                if(hm.containsKey(s.charAt(l))){
                    hm.put(s.charAt(l), hm.get(s.charAt(l))+1);
                    if(hm.get(s.charAt(l)) == 1){
                        count++;
                    }
                }
                l++;
            }
            r++;
        }
        return st == -1 ? "" : s.substring(st, st + ans);
    }
}