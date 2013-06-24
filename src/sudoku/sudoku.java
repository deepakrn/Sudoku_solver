/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.util.ArrayList;
public class sudoku {
  public boolean [][]b;                      //Table for default values...
  public pos p;                              //current postion under process...
  public ArrayList list;                     //list for all possible values at a position...
  public Array arr;                          //Holds the table to be processed...
  public boolean done;
   public sudoku(Array a)
   {
      p=new pos();
     arr=new Array(a); //Initializing the array...
     done=false;
      
   }
  void check_h(ArrayList a,int i,int j)      //removing elements in horizontal row...
   {
     Integer k=new Integer(0);
     int m;
     for(int l=0; l<9; l++)
        if(j!=l)
        {
           k=arr.a[i][l];
           a.remove(k);
           m=(int)k;
        }
  }
  void check_v(ArrayList a,int i,int j)      //removing from vertical row...
   {
     Integer k=new Integer(0);
     for(int l=0; l<9; l++)
        if(i!=l)
        {
           k=arr.a[l][j];
           a.remove(k);
        }
  }
  int quad(int i,int j)                      //returns the value of the quadrant
  {
     if(i<3)
     {
        if(j<3)
           return 1;
        if(j<6)
           return 2;
        if(j<9)
           return 3;
     }
     if(i<6)
     {
        if(j<3)
           return 4;
        if(j<6)
           return 5;
        if(j<9)
           return 6;
     }
     if(i<9)
     {
        if(j<3)
           return 7;
        if(j<6)
           return 8;
        if(j<9)
           return 9;
     }
     return -1;
  }
  void reduce(ArrayList a,int q,int l,int m)             //For each quadrant...
  {
     Integer k=new Integer(0);
     switch(q)
     {
        case 1: for(int i=0; i<3; i++)
                  for(int j=0; j<3; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 2: for(int i=0; i<3; i++)
                  for(int j=3; j<6; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 3: for(int i=0; i<3; i++)
                  for(int j=6; j<9; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 4: for(int i=3; i<6; i++)
                  for(int j=0; j<3; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 5: for(int i=3; i<6; i++)
                  for(int j=3; j<6; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 6: for(int i=3; i<6; i++)
                  for(int j=6; j<9; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 7: for(int i=6; i<9; i++)
                  for(int j=0; j<3; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 8: for(int i=6; i<9; i++)
                  for(int j=3; j<6; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
        case 9: for(int i=6; i<9; i++)
                  for(int j=6; j<9; j++)
                     if(i!=l&&j!=m)
                     {
                        k=arr.a[i][j];
                        a.remove(k);
                     }
                break;
     }

  }
   public void fix()        //function to fix the obvious values..
   {
      boolean flag=false;
       ArrayList a;
       a=new ArrayList();
       Integer k;
       k=new Integer(1);
       while(p.i<9)
       {
          if(!b[p.i][p.j])
          {
               for (int i = 1; i <= 9; i++)
                {
                   k = i;
                   a.add(k);        //Initializing the array list...
                }
                  check_h(a,p.i,p.j);
                 check_v(a,p.i,p.j);
                 int q=quad(p.i,p.j);
                  if(q==-1)
                   System.out.print("error");
                 else
                   reduce(a,q,p.i,p.j);
                Integer f=new Integer(0);
         
                 if(a.size()==1)
                 f=(Integer) a.get(0);
                 arr.a[p.i][p.j]=(int)f;
                 b[p.i][p.j]=true;
                 flag=true;
           }
                 p.next();
                 if(flag)
                    fix();
        }

         
   }
   public void display(Array c)
   {
      System.out.println("Output inside class");
       for(int i=0; i<9; i++)
       {
          for (int j = 0; j < 9; j++)
          System.out.print(c.a[i][j]);
           System.out.println();
       }


   }
  public int check_h1(Array c,int i,pos p1)
   {
      for(int k=0; k<9; k++)
         if(c.a[p.i][k]==i && k!=p.j)
            return 1;
      return 0;
   }
  public int check_v1(Array c,int i,pos p1)
   {
      for(int k=0; k<9; k++)
         if(c.a[k][p.j]==i && k!=p.i)
            return 1;
      return 0;
   }
  int checkquad(int q,pos p1,Array c,int g)             //For each quadrant...
  {
     Integer k=new Integer(0);
     switch(q)
     {
        case 1: for(int i=0; i<3; i++)
                  for(int j=0; j<3; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;

        case 2: for(int i=0; i<3; i++)
                  for(int j=3; j<6; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 3: for(int i=0; i<3; i++)
                  for(int j=6; j<9; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 4: for(int i=3; i<6; i++)
                  for(int j=0; j<3; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 5: for(int i=3; i<6; i++)
                  for(int j=3; j<6; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 6: for(int i=3; i<6; i++)
                  for(int j=6; j<9; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 7: for(int i=6; i<9; i++)
                  for(int j=0; j<3; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 8: for(int i=6; i<9; i++)
                  for(int j=3; j<6; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
        case 9: for(int i=6; i<9; i++)
                  for(int j=6; j<9; j++)
                     if(i!=p1.i&&j!=p1.j)
                     {
                        if(c.a[i][j]==g)
                           return 1;
                     }
                return 0;
     }
     return 1;

  }
   public void rec(Array c,pos p1)
   {
      if(p1.i==9)
      {
         done = true;  /*print and stop*/
         display(c);
         return;
      }
      if(!b[p1.i][p1.j])
      {
         int q=quad(p1.i,p1.j);  //quadrant...
         for(int i=1; i<=9; i++)
         {            
            
            if(check_h1(c,i,p1)!=1&&check_v1(c,i,p1)!=1&&checkquad(q,p1,c,i)!=1)
            {
               c.a[p1.i][p1.j] = i;
               p1.next();
               rec(c,p1);
               p1.prev();
               if(done)
               return;
               c.a[p1.i][p1.j]=0;
            }
         }
      }
      else
      {
         p1.next();
         rec(c,p1);
         p1.prev();
         if(done)
            return;

      }

   }
}
