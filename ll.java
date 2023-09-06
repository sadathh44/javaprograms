package linked_list;


public class ll {
    private Node head;
    private Node tail;
    private int size;

    public ll()
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
    // not working
    public void insertRecursion(int val,int index)
    {
        head=insertRecursion(val, index, head);
    }
    private Node insertRecursion(int val,int index,Node node)
    {
        if(index==0)
        {
            Node temp=new Node(val,node);
            size++;
            return temp;
        }
        else{
            
        }
        node.next= insertRecursion(val, index--, node.next);
        return node;
        
    }
    public void duplicates()
    {
        Node node=head;
        while(node.next!=null)
        {
            if(node.next!=null && node.val==node.next.val)
            {
                node.next=node.next.next;
                size--;
            }
            else
            {
                node=node.next; 
            }
            
        }
        tail=node;
        tail.next=null;
    }
    public void bubblesort()
    {
        bubblesort(size-1, 0);
    }
    private void bubblesort(int row,int col)
    {
       if(row==0)
       {
        return;
       } 
        if(row<col)
        {
            Node first=get(col);
            Node second=get(col+1);
            if(first.val>second.val)
            {
                if(first==head)
                {
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }   
                else if(second==tail)
                {
                    Node prev=get(col-1);
                    prev.next=second;
                    tail=first;
                    first.next=null;
                    second.next=tail;
                }
                else{
                    Node prev=get(col-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;


                }
            }
            bubblesort(row, col+1);
        }
        else
        {
         bubblesort(row-1, 0);
        }
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
    private void reverse(Node node)
    {
        if(node==tail)
        {
            head=tail;
            System.out.println(head.val);
            return;
        }
        reverse(node.next);
        System.out.println(node.val);
        tail.next=node;
        tail=node;
        tail.next=null;

    }
    public void reversal()
    {
        reverse(head);
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
        ll a=new ll();
        a.insertFirst(14);
        a.insertFirst(2);
        a.insertFirst(118);

        a.display();
    
        a.insert(22, 3);
        a.display();
        a.reversal();
        a.display();


    }

    
   
}

