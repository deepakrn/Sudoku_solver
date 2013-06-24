
package sudoku;


public class pos {      //class for current position in array
   public int i,j;
   public pos()
   { i=0; j=0;
   }
   public void next()   //points to the next element to be processed...
   {
        if(j==8)
        {
           j = 0;
           i++;
           return;
        }
        j++;
   }
   public void prev()
   {
      if(j==0)
      {
         i--;
         j=8;
         return;
      }
      j--;
   }
   public void reset()
   {
         i=j=0;
   }
}
