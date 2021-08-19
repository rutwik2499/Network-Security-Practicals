import java.util.Scanner;

public class mono
{
    char[] alphabets = new char[26];
    char[] key = {'P','Q','O','W','I','E','U','R','Y','T','L','A','K',
            'S','J','D','H','F','G','M','Z','N','X','B','C','V'};

    mono()
    {
        int index=0;
        for (char i = 'A'; i <= 'Z'; i++) {
            this.alphabets[index]=i;
            index++;
        }
    }

    public static void main(String[] args) {
        int choice;
        mono m1=new mono();
        Scanner sc=new Scanner(System.in);
        System.out.println("************ Monoalphabetic Substitution Cipher ************");
        System.out.println("1. Cipher Text\n2. DeCipher Text\n3. Exit");
        System.out.print("\nEnter your choice: ");
        choice=sc.nextInt();

        while(choice!=3)
        {
            String InputString;
            switch (choice) {
                case 1 -> {
                    System.out.print("\nEnter the text to Cipher: ");
                    sc.nextLine();
                    InputString = sc.nextLine();
                    InputString=InputString.replaceAll(" ","");
                    System.out.println("\nCiphered Text is: " + m1.getCipherText(InputString));
                }
                case 2 -> {
                    System.out.print("\nEnter the text to DeCipher: ");
                    sc.nextLine();
                    InputString = sc.nextLine();
                    InputString=InputString.replaceAll(" ","");
                    System.out.println("\nDeCiphered Text is: " + m1.getDeCipherText(InputString));
                }
                default -> System.out.println("Invalid choice, Please try again!");
            }
            System.out.println("\n************ Monoalphabetic Substitution Cipher ************");
            System.out.println("1. Cipher Text\n2. DeCipher Text\n3. Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
        }
    }

    private String getCipherText(String OriginalText)
    {
        String CipherText="";

        for(int i=0; i<OriginalText.length(); i++)
            CipherText=CipherText.concat(Character.toString(getAlphabetKey(OriginalText.charAt(i))));

        return CipherText;
    }

    private String getDeCipherText(String CipherText)
    {
        String OriginalText="";

        for(int i=0; i<CipherText.length(); i++)
            OriginalText=OriginalText.concat(Character.toString(getKeyChar(CipherText.charAt(i))));

        return OriginalText;
    }

    private char getAlphabetKey(char c)
    {
        mono m2=new mono();
        int idx=-1;

        for(int i=0; i<m2.alphabets.length; i++)
        {
            if(m2.alphabets[i]==Character.toUpperCase(c))
                idx=i;
        }
        return m2.key[idx];
    }

    private char getKeyChar(char c)
    {
        mono m2=new mono();
        int idx=-1;

        for(int i=0; i<m2.alphabets.length; i++)
        {
            if(m2.key[i]==Character.toUpperCase(c))
                idx=i;
        }
        return m2.alphabets[idx];
    }
}
