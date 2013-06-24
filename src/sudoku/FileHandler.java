package sudoku;


import java.io.*;


public class FileHandler{

    public  void read(int arr[][])throws IOException{
        DataInputStream in=null;
        String [][]a;
        a=new String[9][9];
        try{
            int i=0;
           //arr=new int[9][9];
            in= new DataInputStream(new FileInputStream("data.txt"));
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            while(true)
            {
                String s=br.readLine();
                a[i]=s.split(" ");
                for(int j=0; j<a[i].length; j++)
                {
                arr[i][j]=Integer.parseInt(a[i][j]);
                System.out.print(arr[i][j]+" ");
                }
                System.out.print("\n");
                i++;

            }

        }
        catch(NullPointerException e)
        {}
       
        catch(EOFException e){ }
        finally{in.close();}

    }
        public void write(int arr[][])throws IOException{
         BufferedWriter out=new BufferedWriter(new FileWriter("out.txt"));
       try{

        System.out.println("Writing");
        for(int i=0; i<9; i++)
        {    for(int j=0; j<9; j++)
             {
                 out.write(Integer.toString(arr[i][j])+" ");
                 System.out.print(arr[i][j]+" ");

             }
             out.newLine();
             System.out.println();

        }
    }
    finally
    {
       out.close();
    }
   }
}

