import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            List<Round> rounds = new ArrayList<>();
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine())
            {
                String[] sor = reader.nextLine().split(" ");
                Round tmp = new Round();
                tmp.Opponent=sor[0].charAt(0);
                tmp.Me=sor[1].charAt(0);
                rounds.add(tmp);
            }

            reader.close();

            int myPoints = 0;
            int asYouSayPoints = 0;
            for (var item : rounds)
            {
                switch (item.Opponent)
                {
                    // A - rock, B - paper, C - scissors
                    // X,           Y,          Z
                    // 1,           2,          3,
                    // w - 6, d - 3, l - 0
                    // X - l, Y - d, Z - w
                    case 'A' :
                        switch (item.Me)
                        {
                            case 'X':
                                myPoints+=4;
                                asYouSayPoints+=3;
                                break;
                            case 'Y':
                                myPoints+=8;
                                asYouSayPoints+=4;
                                break;
                            case 'Z':
                                myPoints+=3;
                                asYouSayPoints+=8;
                                break;
                        }
                        break;
                    case 'B':
                        switch (item.Me)
                        {
                            case 'X':
                                myPoints+=1;
                                asYouSayPoints+=1;
                                break;
                            case 'Y':
                                myPoints+=5;
                                asYouSayPoints+=5;
                                break;
                            case 'Z':
                                myPoints+=9;
                                asYouSayPoints+=9;
                                break;
                        }
                        break;
                    case 'C':
                        switch (item.Me)
                        {
                            case 'X':
                                myPoints+=7;
                                asYouSayPoints+=2;
                                break;
                            case 'Y':
                                myPoints+=2;
                                asYouSayPoints+=6;
                                break;
                            case 'Z':
                                myPoints+=6;
                                asYouSayPoints+=7;
                                break;
                        }
                        break;
                }
            }
            System.out.print("1.: "+myPoints+"\n"+"2.: "+asYouSayPoints);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
class Round
{
    char Opponent;
    char Me;
}