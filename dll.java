package linked_list;

public class dll {
    private int size;
    private Node head;
    private Node tail;
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null)
        {
            head.prev=node;
        }

        if(tail==null)
        {
            tail=head;
        }
        head=node;
        size++;


    }  
     public void inserLast(int val)
    {
        Node node=new Node(val);
        if(head==null)
        {
            node.prev=null;
            head=node;
            return;
        }
        tail.next=node;
        
        if(tail!=null)
        {
            node.prev=tail;
        }
        tail=node;
        size++;

    }

    public void insertIndex(int index,int val)
    {
       Node p=get(index);
       System.out.println(p);
        if(p==null)
        {
            System.out.println("Node doesnt exits");
            return;
        }
        Node node=new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null)
        {

            node.next.prev=node;
        }

    }
    public Node get(int value)
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
        Node last=null;
     while(temp!=null)
     {
            System.out.print(temp.val+" -> ");
            last=temp;
            temp=temp.next;
        }
        System.out.println("END");
        while(last!=null)
        {
            System.out.print(last.val+" -> ");
            last=last.prev;
        }
        System.out.println("Start");
    }
   
    public dll()
    {
        this.size=0;
    }
    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val)
        {
           this.val=val;  
        }
    }
    public static void main(String[] args) {
        dll a=new dll();
        a.insertFirst(10);
                a.insertFirst(20);

                a.inserLast(200);
                a.insertIndex(200, 300);
                a.display();


    }

    
   
}

