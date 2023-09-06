package backtracking;
import java.util.ArrayList;

public class mazeblock {
    //ways to go from point a to point b
    public static void main(String[] args) {
        // System.out.println(maize(3,3));
        boolean[][] board={
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
       
        System.out.println( pathretblock("",board,0,0));
        //path("",3,3);
        //System.out.println(pathret("", 3, 3));
    }
    static int maize(int r,int c)
    {
        if(r==1||c==1)
        {
            return 1;
        }
        int left=maize(r-1,c);
        int right=maize(r,c-1);
        return left+right;
    }
   /* static void path(String p,int r,int c)
    {
        if(r==1 && c==1)
        {
            System.out.println(p);
            return;
        }
        if(r>1)
        {
            path(p+'D',r-1,c);
        }
        if(c>1)
        {
            path(p+'R',r,c-1);
 
        }
    }
    */
//path return in array list format
   static ArrayList<String> pathret(String p,int r,int c)
    {
        if(r==1 && c==1)
        {
            ArrayList<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans2=new ArrayList<>();

        if(r>1)
        {
            ans2.addAll(pathret(p+'H',r-1,c));
        }
        if(c>1)
        {
            ans2.addAll(pathret(p+'V',r,c-1));
 
        }
        if(r>1 && c>1)
        {
            ans2.addAll(pathret(p+'D',r-1,c-1));

        }
        return ans2;
    }


//path with blockades in between
       static ArrayList<String> pathretblock(String p,boolean[][] board,int r,int c)
    {
        if(r==board.length-1 && c==board[0].length-1)
        {
            ArrayList<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans2=new ArrayList<>();
 if(!board[r][c])
        {
            return ans2;
        }
        if(r<board.length-1)
        {
            ans2.addAll(pathretblock(p+'D',board,r+1,c));
        }
       
        if(c<board[0].length-1)
        {
            ans2.addAll(pathretblock(p+'R',board,r,c+1));
 
        }
         if(r<board.length-1 && c<board[0].length-1)
        {
            ans2.addAll(pathretblock(p+'V',board,r+1,c+1));

        }
       
        return ans2;
    }
//just normal path
   static void path(String p,int r,int c)
    {
        if(r==1 && c==1)
        {
            System.out.println(p);
            return;
        }
        if(r>1)
        {
          
            path(p+'D',r-1,c);
        }
        if(c>1)
        {
           
            path(p+'R',r,c-1);
 
        }
    }

}






   

