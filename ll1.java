package linked_list;

public class ll1{
    private Node head;
    private Node tail;
    private int size;

    public ll1()
    {
        this.size=0;
    }
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        head=node;

        if(tail==null)
        {
            tail=head;
        }
        size+=1;
    }
    public void insert(int val,int index)
    {
         if(index==0)
         {
            insertFirst(val);
            return;
         }
         if(index==size)
         {
            insertlast(val);
            return;
         } 
         Node temp=head;
         for(int i=1;i<index;i++)
         {
            temp=temp.next;
         }
         Node node=new Node(val,temp.next);
         temp.next=node;
         size++; 
         
    }
     public void insertlast(int val)
    {
        Node node=new Node(val);
          if(tail==null)
        {
            insertFirst(val);
            return;
        }
        tail.next=node;
        tail=node;

      
        size+=1;
    }
    
     public int deleteFirst()
    {
       int val=head.val;
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast()
    {
      if(size<=1)
      {
        return deleteFirst(); 
      }
      Node slast=get(size-2);
      int value=tail.val;
      tail=slast;
      tail.next=null;
      size--;
      return value;
    }


    public int deleteIndex(int index)
    {
        if(index==0)
        {
            return deleteFirst();
           
        }
        if(index==size)
        {
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.val;
        prev.next=prev.next.next;
        size--;
        return val;

       
    }

    public Node get(int index)
    {
        Node node=head;
    
        for(int i=0;i<index;i++)
        {
            node=node.next;
        }
        return node;
    }
    
    public Node find(int value)
    {
        Node node=head;
    
      while(node!=null)
      {
        if(node.val==value)
        {
            return node;
        }
        node=node.next;
      }
      return null;
    }
   

    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
        System.out.print(temp.val+ "->");
        temp=temp.next;
        }
        System.out.println("EOL");


    }
    public static ll1 merge(ll1 first,ll1 second)
    {
        Node a=first.head;
        Node b=second.head;
        ll1 ans=new ll1();
        while(a.next!=null && b.next!=null)
        {
            if(a.val<b.val)
            {
                ans.insertlast(a.val);
                a=a.next;
            }
            else {
                ans.insertlast(b.val);
                b=b.next;
            }
        }
        while(a.next!=null)
        {
            ans.insertlast(a.val);
            a=a.next;
        }
        while(b.next!=null)
        {
            ans.insertlast(b.val);
            b=b.next;
        }
        return ans;

    }

    private class Node
    {
        private int val;
       private Node next;
       public Node(int value)
       {
        this.val=value;
       }

        public Node(int value,Node next)
    {
        this.val=value;
        this.next=next;
    }
    }
     public static void main(String[] args) {
            ll1 a=new ll1();
            a.insertlast(1);
            a.insertlast(3);
            a.insertlast(5);
            a.display();
            ll1 b=new ll1();
             b.insertlast(1);
            b.insertlast(2);
            b.insertlast(9);
            b.insertlast(14);
            b.display();
            ll1 ans=ll1.merge(a,b);
            ans.display();


   
}
}

