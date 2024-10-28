import java.util.Random;

public class InputDevice
{
    String getType()
    {
        return "random";
    }

    int nextInt()
    {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    int[] getNumbers(int N)
    {
        int[] numbers = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++)
        {
            numbers[i] = rand.nextInt(100) + 1;
        }

        return numbers;
    }

    String getLine()
    {
        return "I would love to have words that are three letters in this sentence but I cannot seem to hey nevermind it happened.";
    }
    // lab 3 stuff
    public Fruit[] readFruit() {
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Apple(150, 10.5f, 85.0f, Fruit.Color.RED);
        fruits[1] = new Banana(120, 12.0f, 88.0f);
        fruits[2] = new Mango(200, 15.0f, 80.0f, Fruit.Color.YELLOW);
        return fruits;
    }

}