package backtracking;

import java.util.Arrays;

public class allpaths_array {
    public static void main(String[] args) {
        boolean[][] board={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] step=new int[board.length][board.length];
       
        pathretblock("",board,0,0,step,1);
    }

           static void pathretblock(String p,boolean[][] board,int r,int c,int[][] step,int count)
    {
        if(r==board.length-1 && c==board[0].length-1)
        {
            step[r][c]=count;
            board[r][c]=true;
            for(int[] arr:step)
            {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
 if(!board[r][c])
        {
            return ;
        }
         board[r][c]=false;
         step[r][c]=count;

        if(r<board.length-1)
        {
            pathretblock(p+'D',board,r+1,c,step,count+1);

        }
       
        if(c<board[0].length-1)
        {

            pathretblock(p+'R',board,r,c+1,step,count+1);
        }
        /*  if(r<board.length-1 && c<board[0].length-1)
        {
            ans2.addAll(pathretblock(p+'V',board,r+1,c+1));

        }*/
        if(r>0)
        {

            pathretblock(p+'U',board,r-1,c,step,count+1);

        }
        if(c>0)
        {

           pathretblock(p+'L',board,r,c-1,step,count+1);

        }
        board[r][c]=true;
        step[r][c]=0;
        return;
    }
}

