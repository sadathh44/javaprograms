package linked_list;

public class cll {
    private int size;
    private Node head;
    private Node tail;
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        if(head==null)
        {
            head=node;
            tail=node;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;

    }
    public void delete(int value)
    {
        Node temp=head;
        if(temp==null)
        {
            return;
        }
        if(temp.val==value)
        {
            head=head.next;
            tail.next=head;
            return;
        }
        do{
            Node nex=temp.next;
            if(nex.val==value)
            {
                temp.next=nex.next;
                break;

            }
            temp=temp.next;
        }while(temp!=head);
    }
    public void display()
    {
        Node temp=head;
        if(head!=null)
        {
            do{
                System.out.print(temp.val+" -> ");
                temp=temp.next;
            }while(temp!=head);
        }
        System.out.println("HEAD");
    }
   
    public cll()
    {
        this.size=0;
    }
    private class Node{
        int val;
        Node next;
        public Node(int val)
        {
           this.val=val;  
        }
    }
    public static void main(String[] args) {
        cll a=new cll();
        a.insertFirst(99);
        a.insertFirst(220);

            a.delete(99);
        a.delete(220);
                a.insertFirst(420);

        a.display();


    }

    
   
}

