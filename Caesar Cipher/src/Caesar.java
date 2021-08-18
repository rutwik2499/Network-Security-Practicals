import java.util.Scanner;

public class Caesar
{
    public static void main(String[] args) {
        int choice;
        Caesar c1=new Caesar();
        Scanner sc=new Scanner(System.in);
        System.out.println("********* Caesar Cipher Algorithm *********");
        System.out.println("1. Cipher Text\n2. DeCipher Text\n3. Exit");
        System.out.print("\nEnter your choice: ");
        choice=sc.nextInt();

        while(choice!=3)
        {
            String OriginalText, CipherText;
            switch (choice) {
                case 1 -> {
                    System.out.print("\nEnter the text to Cipher: ");
                    sc.nextLine();
                    OriginalText = sc.nextLine();
                    CipherText = c1.getCipherText(OriginalText);
                    System.out.println("\nCiphered Text is: " + CipherText);
                }
                case 2 -> {
                    System.out.print("\nEnter the text to DeCipher: ");
                    sc.nextLine();
                    CipherText = sc.nextLine();
                    OriginalText = c1.getDeCipherText(CipherText);
                    System.out.println("\nDeCiphered Text is: " + OriginalText);
                }
                default -> System.out.println("Invalid Choice, Please try again!");
            }
            System.out.println("\n********* Caesar Cipher Algorithm *********");
            System.out.println("1. Cipher Text\n2. DeCipher Text\n3. Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
        }
    }

    private String getCipherText(String OriginalText)
    {
        String CipherText="";

        for (int i = 0; i < OriginalText.length(); i++) {
            CipherText=CipherText.concat(Character.toString(getCipherCharacter(OriginalText.charAt(i))));
        }
        return CipherText;
    }

    private String getDeCipherText(String CipherText)
    {
        String OriginalText="";

        for (int i = 0; i < CipherText.length(); i++) {
            OriginalText=OriginalText.concat(Character.toString(getDeCipherCharacter(CipherText.charAt(i))));
        }
        return OriginalText;
    }

    private char getCipherCharacter(char c)
    {
        char x=(char)(c+3);
        if((Character.isUpperCase(c) && x>'Z') || ((Character.isLowerCase(c) && x>'z')))
            x=(char)(x-26);
        return x;
    }

    private char getDeCipherCharacter(char c)
    {
        char x=(char)(c-3);
        if((Character.isUpperCase(c) && x<'A') || ((Character.isLowerCase(c) && x<'a')))
            x=(char)(x+26);
        return x;
    }
}
