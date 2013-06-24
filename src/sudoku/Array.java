

package sudoku;


public class Array {
public Integer [][]a;

public Array(int [][]a1)
{
            a=new Integer[9][9];
              for(int i=0; i<9; i++)
                for(int j=0; j<9; j++)
                    a[i][j]=a1[i][j];
 }
public Array(Array b)
 {
         a=new Integer[9][9];
      for(int i=0; i<9; i++)
                for(int j=0; j<9; j++)
                    a[i][j]=b.a[i][j];
   }
public void copy(Integer [][]b)
{
    for(int i=0; i<9; i++)
        for(int j=0; j<9; j++)
                    a[i][j]=b[i][j];

}
}
