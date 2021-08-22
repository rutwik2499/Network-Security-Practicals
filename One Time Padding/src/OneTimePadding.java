import java.util.Scanner;

public class OneTimePadding
{
    public static void main(String[] args) {
        int choice=0;
        String strInput,strPadding;
        OneTimePadding o1=new OneTimePadding();
        Scanner sc=new Scanner(System.in);
        System.out.println("*************** One Time Padding (XOR) ***************");
        System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Exit");
        System.out.print("\nEnter your choice: ");
        choice=sc.nextInt();

        while(choice!=3)
        {
            if (choice==1)
            {
                sc.nextLine();
                System.out.print("\nEnter a string to encrypt: ");
                strInput=sc.nextLine();
                System.out.print("\nEnter another string for padding: ");
                strPadding=sc.nextLine();
                System.out.println("\nEncrypted Text is: "+o1.Encrypt(strInput,strPadding));
            }
            else if(choice==2)
            {
                sc.nextLine();
                System.out.print("\nEnter a string to decrypt: ");
                strInput=sc.nextLine();
                System.out.print("\nEnter the string to pad (key): ");
                strPadding=sc.nextLine();
                System.out.println("\nDecrypted Text is: "+o1.Decrypt(strInput,strPadding));
            }
            else System.out.println("Invalid choice, Please try again!");
            System.out.println("\n*************** One Time Padding (XOR) ***************");
            System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
        }
    }

    private String Encrypt(String OrgText,String PadText)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < OrgText.length(); i++) {
            sb.append(getBinaryXor(getCharBinary(OrgText.charAt(i)),getCharBinary(PadText.charAt(i))));
        }
        return sb.toString();
    }

    private String Decrypt(String encBinaryString,String PadText)
    {
        String decryptedBinaryString=getBinaryXor(encBinaryString,getStringBinary(PadText));
        return BinaryToString(decryptedBinaryString);
    }

    private String BinaryToString(String decryptedBinaryString)
    {
        StringBuffer sb=new StringBuffer();
        int limit=0;
        for (int i = 0; i < decryptedBinaryString.length()/7; i++) {
            sb.append((char)Integer.parseInt(decryptedBinaryString.substring(limit,limit+7),2));
            limit+=7;
        }
        return sb.toString();
    }

    private String getBinaryXor(String OrgBinary,String PadBinary)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < OrgBinary.length(); i++)
            sb.append(OrgBinary.charAt(i)^PadBinary.charAt(i));
        return sb.toString();
    }

    private String getStringBinary(String val)
    {
        StringBuffer binary=new StringBuffer();
        for(int i=0; i<val.length(); i++)
            binary.append(getCharBinary(val.charAt(i)));
        return binary.toString();
    }

    private String getCharBinary(char val)
    {
        StringBuffer binary=new StringBuffer();
        while(val!=0)
        {
            binary.append(val%2);
            val/=2;
        }
        return binary.reverse().toString();
    }
}
