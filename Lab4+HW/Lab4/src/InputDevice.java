import java.util.ArrayList;
import java.util.Random;
import java.util.Collection;

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

    public Fruit[] readFruitArray()
    {
        Fruit[] fruits = new Fruit[10];
        fruits[0] = new Apple(100, 10.2f, 80.0f, Fruit.Color.RED);
        fruits[1] = new Banana(150, 13.0f, 89.0f);
        fruits[2] = new Mango(140, 14.0f, 79.0f, Fruit.Color.PURPLE);
        return fruits;
    }

    // lab 4 stuff, change from array to ArrayList?
    public Collection<Fruit> readFruitCollection() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple(150, 10.5f, 85.0f, Fruit.Color.RED));
        fruits.add(new Banana(120, 12.0f, 88.0f));
        fruits.add(new Mango(200, 15.0f, 80.0f, Fruit.Color.YELLOW));
        return fruits;
    }

}