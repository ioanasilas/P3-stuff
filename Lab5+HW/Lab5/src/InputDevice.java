import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collection;
import java.util.Scanner;

public class InputDevice
{
    // lab 4
    private InputStream is;
    private final Scanner scanner;

    public InputDevice(InputStream is)
    {
        this.is = is;
        scanner = new Scanner(is);
    }

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
        return scanner.nextLine();
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

    //Lab5
    boolean isTerminal()
    {
        return this.is == System.in;
    }

}