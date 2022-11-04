// https://www.geeksforgeeks.org/golomb-sequence/
// Completed
import java.util.*;
class GolombSeq
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        int count = 0;
        int no = s.nextInt();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i = 1;
        int j = 1;
        map.put(i,j);
        i++;
        j++;
        map.put(i,j);
        i++;
        map.put(i,j);
        count = 3;
        int an = 3;
        while(count <= no)
        {
            for(int a = 0; a < map.get(an); a++)
            {
                count++;
                i++;
                map.put(i,an);
            }
            an++;
        }
        for(int ii = 1; ii <= no; ii++)
            System.out.print(Integer.toString(map.get(ii)) + " ");
    }
}
