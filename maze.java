package backtracking;

import java.util.ArrayList;

//ways to go from point a to point b
public class maze 
{
    public static void main(String[] args) {
        // System.out.println(maize(3,3));
        // path("",3,3);
        System.out.println(pathret("", 3, 3));
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
            ans2.addAll(pathret(p+'D',r-1,c));
        }
        if(c>1)
        {
            ans2.addAll(pathret(p+'R',r,c-1));
 
        }
        return ans2;
    }
}
