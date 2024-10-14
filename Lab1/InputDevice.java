import java.util.Random;

public class InputDevice 
{
  String getType()
  {
    return "random";
  }

  Integer nextInt()
  {
    Random rand = new Random();
    return rand.nextInt(100) + 1;
  }
  
}
