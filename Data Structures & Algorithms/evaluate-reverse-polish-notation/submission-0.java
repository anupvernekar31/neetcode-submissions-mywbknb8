class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            int first, second;
            switch(c){
                case "+": 
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:     
                    stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();        
    }
}