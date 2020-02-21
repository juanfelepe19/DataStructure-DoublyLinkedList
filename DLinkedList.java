public class DLinkedList{
 int count;
 DNode head;
 DNode tail;
 
 //initialize the list
 public static DLinkedList initialize(){
  return new DLinkedList();
 }
 
 //determine whether the list is empty
 public boolean isEmpty(){
  return count == 0;
 }
 
 //find the length of the list
 public int getCount(){
   return count;
 }
 
 //output the list
 public String toString(){
  StringBuffer sb = new StringBuffer();
  sb.append("{");
  DNode p = head;
  while( p!= null){
   sb.append(p.getItem() + " ");
   p = p.getRight();
  }
  sb.append("}");
  return sb.toString();
 }
 
 public String reversetoString(){
  StringBuffer sb = new StringBuffer();
  sb.append("{");
  DNode p = tail;
  while( p!= null){
   sb.append(p.getItem() + " ");
   p = p.getLeft();
  }
  sb.append("}");
  return sb.toString();
 }
 
 //search the list for a given item
 public boolean search(int item){
   DNode p = head;
   while(p!=null){
      if(p.getItem()==item)
      return true;
      p = p.getRight();
   }
   return false;
 }
 //retrieve the firt element of the list
 public int getFirstElement(){
   if(head!=null)
   return head.getItem();
   else
   return 0;
 }
 //retrieve the last elemnt of the list
 public int getLastElement(){
   if(tail!=null)
   return tail.getItem();
   return 0;
 }
 //insert an item in the list
   //addFront
   public void addFront(int item){
    if(isEmpty())
     head = tail = new DNode(item);
    else
     {
      DNode temp = new DNode(item,null, head);
      head.setLeft(temp);
      head = temp;
     }
     count++;
   }
   //addLast
   public void addLast(int item){
    if(isEmpty())
     head = tail = new DNode(item);
    else{
      DNode temp = new DNode(item,tail,null);
      tail.setRight(temp);
      tail = temp;
    }
    count++;
   }
   //insertItemAt
    public void insertItemAt(int pos, int item){
     if(pos >= 0 && pos <= count){
       if(pos == 0)
        addFront(item);
       else if(pos == count)
        addLast(item);
       else{
        DNode p = head;
        int c = 0;
        while(c<pos-1){
         p = p.getRight();
         c++;
        }
        DNode p2 = p.getRight();
        DNode temp = new DNode(item,p,p2);
        p.setRight(temp);
        p2.setLeft(temp);
        count++;
       }
     }
    else
     System.out.println("Invalid position!'");
    }
   //delete an item from the list
   public void deleteFront(){
      if(count==1){
         head = tail = null;
         count--;
      }
      else{
         head = head.getRight();
         head.setLeft(null);
         count--;
      }
   }
   
   public void deleteLast(){
      if(count==1){
         tail = head = null;
         count--;
      }
      else{
         tail = tail.getLeft();
         tail.setRight(null);
         count--;
      }
   }
   
   public void delete(int item){
   DNode p = head;
   if(count==1){
      if(head.getItem()==item){
         head = tail = null;
         count--;
      }
   }
   else if(head.getItem()==item){
      deleteFront();
   }
   else if(tail.getItem()==item){
      deleteLast();
   }
   else{
      while(p!=tail){
         if(p.getItem()==item){
            DNode p2 = p.getRight();
            p = p.getLeft();
            p.setRight(p2);
            p2.setLeft(p);
            count--;
         }
         p = p.getRight();
      }
   }
 }
 
 //for testing
 public static void main(String [] args){
 
  DLinkedList list = initialize();
  
  list.addFront(6);
  list.addFront(5);
  list.addFront(4);
  list.addFront(3);
  list.addFront(2);
  list.addLast(8);
  list.addLast(9);
  list.delete(6);
  list.delete(3);
  list.delete(4);
  list.delete(5);
  list.delete(2);
  list.addFront(2);
  list.addFront(2);
  list.delete(2);
  list.delete(2);
  list.deleteLast();
  list.deleteLast();
  System.out.println("List -> :" + list);
  System.out.println("List <- :" + list.reversetoString());
  System.out.println("First element: " + list.getFirstElement());
  System.out.println("Last element: " + list.getLastElement());
  System.out.println("Search for 6: " + list.search(6));
  System.out.println("Count of elements: " + list.getCount());
 
 }
}