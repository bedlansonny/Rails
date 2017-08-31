import java.io.*;
import java.util.*;
public class Rails
{
    public static void main(String args[]) throws IOException
    {
        File file = new File(System.getProperty("user.dir") + "\\src\\input.txt");
        Scanner sc = new Scanner(file);

        while(true)
        {
            int carCount = sc.nextInt();
            if(carCount == 0)
                break;

            while(true)
            {
                ArrayStack train = new ArrayStack(carCount);
                for(int i = carCount; i > 0; i--)
                {
                    train.push(i);
                }

                ArrayStack station = new ArrayStack(carCount);
                boolean works = true;

                int[] target = new int[carCount];
                target[0] = sc.nextInt();
                if (target[0]==0)
                    break;

                for(int i = 1; i < carCount; i++)
                {
                    target[i] = sc.nextInt();
                }

                for(int i = 0; i < carCount; i++)
                {

                    while(works)
                    {
                        if(station.peek() == target[i])
                        {
                            station.pop();
                            break;
                        }
                        else if(train.isEmpty() && station.isEmpty())
                        {
                            break;
                        }
                        else if(train.isEmpty())
                        {
                            works = false;
                        }
                        else
                        {
                            station.push(train.pop());
                        }
                    }
                }

                if(works)
                   System.out.println("Yes");
                else
                    System.out.println("No");
            }
            System.out.println();
        }
    }
}
