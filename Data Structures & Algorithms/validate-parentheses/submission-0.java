class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);

            if(x == '{'  || x == '[' || x == '('){
                st.push(x);
                continue;
            } else{
                if(st.isEmpty()){
                    return false;
                }

                char c = st.pop();
                if(c == '{' && (x == ')' || x == ']') ||
                c == '[' && (x == ')' || x == '}')  ||
                c == '(' && (x == ']' || x == '}') )
                return false;
            }
        }

        return st.isEmpty();
        
    }
}
