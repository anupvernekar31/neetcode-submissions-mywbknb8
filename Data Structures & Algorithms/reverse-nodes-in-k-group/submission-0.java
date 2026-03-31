/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;  
        ListNode prev = null;  
        while(curr != null){  
           ListNode next = curr.next;  
           curr.next = prev;  
           prev = curr;  
           curr = next; 
       }
       return prev;  

    }
    
    public ListNode findKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        for(int i=1;i<k;i++){
            if(temp == null){
                break;
            }
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode lastPrev = null;
        
        while(curr!=null){
            ListNode kthNode = findKthNode(curr, k);
            
            if(kthNode == null){                    // this if is not required for version - 2
                if(lastPrev != null){
                    lastPrev.next = curr;
                }
                break;
            }
            
            ListNode nextNode = kthNode.next;
            kthNode.next =null;
            reverseLinkedList(curr);
            if(curr == head){
                head = kthNode;
            } else {
                lastPrev.next = kthNode;
            }
            lastPrev = curr;
            curr = nextNode;
        }
        return head;
    }
}