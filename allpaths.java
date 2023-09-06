package backtracking;
//back ttracking
import java.util.ArrayList;

public class allpaths {
    public static void main(String[] args) {
        boolean[][] board={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
       
        System.out.println( pathretblock("",board,0,0));
    }

           static ArrayList<String> pathretblock(String p,boolean[][] board,int r,int c)
    {
        if(r==board.length-1 && c==board[0].length-1)
        {
            ArrayList<String> ans=new ArrayList<>();
            ans.add(p);
                                    board[r][c]=true;

            return ans;
        }
        ArrayList<String> ans2=new ArrayList<>();
 if(!board[r][c])
        {
            return ans2;
        }
         board[r][c]=false;

        if(r<board.length-1)
        {
            ans2.addAll(pathretblock(p+'D',board,r+1,c));

        }
       
        if(c<board[0].length-1)
        {

            ans2.addAll(pathretblock(p+'R',board,r,c+1));

        }
        /*  if(r<board.length-1 && c<board[0].length-1)
        {
            ans2.addAll(pathretblock(p+'V',board,r+1,c+1));

        }*/
        if(r>0)
        {

            ans2.addAll(pathretblock(p+'U',board,r-1,c));

        }
        if(c>0)
        {

            ans2.addAll(pathretblock(p+'L',board,r,c-1));

        }
        board[r][c]=true;
        return ans2;
    }
}
