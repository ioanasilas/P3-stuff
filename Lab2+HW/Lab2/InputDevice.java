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


}
