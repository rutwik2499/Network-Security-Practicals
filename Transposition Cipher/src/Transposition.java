import java.util.*;

public class Transposition
{
    public static void main(String[] args) {
        Transposition t1=new Transposition();
        String text,key,order;
        int choice,rows,cols;
        char[][] matrix;
        Scanner sc=new Scanner(System.in);

        System.out.println("*************** Transposition Cipher ***************");
        System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Exit");
        System.out.print("\nEnter your choice: ");
        choice=sc.nextInt();

        while (choice!=3)
        {
            if (choice==1)
            {
                sc.nextLine();
                System.out.print("\nEnter the plain text: ");
                text=sc.nextLine();
                System.out.print("\nEnter the key: ");
                key=sc.nextLine();
                rows=(int)Math.ceil((double)text.length()/key.length());
                cols=key.length();
                order=t1.getAlphabetOrder(key.toUpperCase());
                matrix=new char[rows][cols];
                t1.WriteRowMatrix(matrix,text,rows,cols);
                System.out.println("\nEncrypted Text is: "+t1.EncryptText(matrix,order,rows));
            }
            else if (choice==2)
            {
                sc.nextLine();
                System.out.print("\nEnter the encrypted text: ");
                text=sc.nextLine();
                System.out.print("\nEnter the key: ");
                key=sc.nextLine();
                rows=(int)Math.ceil((double)text.length()/key.length());
                cols=key.length();
                order=t1.getAlphabetOrder(key.toUpperCase());
                matrix=new char[rows][cols];
                t1.WriteColMatrix(matrix,text,order,rows,cols);
                System.out.println("\nDecrypted Text is: "+t1.DecryptText(matrix,rows,cols));
            }
            else
                System.out.println("Invalid choice, Please try again!");

            System.out.println("\n*************** Transposition Cipher ***************");
            System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
        }
    }

    private String EncryptText(char[][] matrix,String order,int rows)
    {
        String str="";
        String[] strArray;
        Map<Integer,String> lsmap=new HashMap<>();
        for(int i=0; i<order.length(); i++)
        {
            int colnum=Integer.parseInt(Character.toString(order.charAt(i)))-1;
            lsmap.put(colnum,getColumn(matrix,rows,i));
        }
        strArray=lsmap.values().toString().replaceAll(" ","").replaceAll("\\[","").replaceAll("]","").split(",");

        for (String s : strArray) str=str.concat(s);

        return str;
    }

    private String DecryptText(char[][] matrix,int rows,int cols)
    {
       String DecryptedText="";

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
                DecryptedText=DecryptedText.concat(Character.toString(matrix[i][j]));
        }
        return DecryptedText.trim();
    }

    private String getColumn(char[][] matrix,int rows,int colnum)
    {
        String fnlstr="";

        for (int row = 0; row < rows; row++)
            fnlstr=fnlstr.concat(Character.toString(matrix[row][colnum]));

        return fnlstr;
    }

    private void WriteRowMatrix(char[][] matrix,String text,int rows,int cols)
    {
        int idx=0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {

                if(idx<text.length()) {
                    if(text.charAt(idx)==' ')
                        matrix[row][column]='_';
                    else
                        matrix[row][column] = text.charAt(idx);
                }
                else
                    matrix[row][column]='_';
                idx++;
            }
        }
    }

    private void WriteColMatrix(char[][] matrix,String text,String order,int rows,int cols)
    {
        int idx=0,colnum;
        char[][] tmatrix=new char[rows][cols];

        for (int column = 0; column < cols; column++) {
            for (int row = 0; row < rows; row++) {
                if(idx<text.length()) {
                    if(text.charAt(idx)=='_')
                        tmatrix[row][column]=' ';
                    else
                        tmatrix[row][column] = text.charAt(idx);
                }
                else
                    matrix[row][column]=' ';
                idx++;
            }
        }

        for(int col=0; col<cols; col++)
        {
            colnum=Integer.parseInt(Character.toString(order.charAt(col)))-1;
            for(int row=0; row<rows; row++)
                matrix[row][col]=tmatrix[row][colnum];
        }
    }

    private String getAlphabetOrder(String Text)
    {
        String order="";

        try
        {
            order= Integer.toString(Integer.parseInt(Text));
        }
        catch (NumberFormatException e)
        {
            String txt=Text.replaceAll(" ","");
            Map<Character,Integer> m1=new HashMap<>();

            char[] sortedarr=txt.toCharArray();
            Arrays.sort(sortedarr);

            for (int i=0; i<sortedarr.length; i++)
                m1.put(sortedarr[i],i+1);

            for (int i=0; i<txt.length(); i++)
                order=order.concat(Integer.toString(m1.get(txt.charAt(i))));
        }
        return order;
    }
}
