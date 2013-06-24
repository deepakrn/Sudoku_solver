/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.io.IOException;


public class Main {

    
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)throws IOException {
        int [][]a;   //array holding the matrix...
        a=new int[9][9];
        FileHandler f=new FileHandler();
        f.read(a);
        boolean [][]b=new boolean[9][9];
      for(int i=0; i<9; i++)
         for(int j=0; j<9; j++)
            if(a[i][j]!=0)
               b[i][j]=true;
            else
               b[i][j]=false;
        Array sud=new Array(a);
        sudoku s=new sudoku(sud);
        s.b=b;
        s.fix();
        s.p.reset();
        for(int i=0; i<9; i++)
         for(int j=0; j<9; j++)
            if(s.arr.a[i][j]!=0)
               b[i][j]=true;
            else
               b[i][j]=false;
        //s.b=b;
        s.rec(s.arr,s.p);
        for(int i=0; i<9; i++)
           for(int j=0; j<9; j++)
              a[i][j]=(int)s.arr.a[i][j];
        f.write(a);
     
    }
    
}
