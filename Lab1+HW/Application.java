public class Application
{
  InputDevice id;
  InputDevice id2;
  OutputDevice od;

  // pass initializaiton arg thru constructor
  public Application(InputDevice inputDevice, InputDevice inputDevice2, OutputDevice outputDevice)
  {
    // constructor taking inputdev as argument
    this.id = inputDevice; // assign it to this obj
    this.id2 = inputDevice2;
    this.od = outputDevice;
  }

  void run()
  {
    System.out.println("Application started!");
    playGame(id, id2);
    // od.writeMessage("Application started!\nToday's lucky nos are: ");
    // // System.out.println("Application started!\n");
    // // System.out.println("Today's lucky nos are: ");

    // System.out.println(id.nextInt());
    // System.out.println(id.nextInt());
  }

  int playGame(InputDevice h, InputDevice s)
  {
    int noFromH = 0, noFromS = 0;
    int points4H = 0, points4S = 0;

    while (points4H < 5 && points4S < 5)
    {
      // better perform and no null possibility we're good
      noFromH = h.nextInt();
      noFromS = s.nextInt();

      // print stuff 2 see
      System.out.println("H is " + noFromH);
      System.out.println("S is " + noFromS);

      if (noFromH > noFromS && noFromH % noFromS == 0 && noFromS >= 10)
      {
        points4S++;
        System.out.println("S won this round!\n");
      }
      else if (noFromH > noFromS)
      {
        points4H++;
        System.out.println("H won this round!\n");
      }
      else if (noFromS > noFromH)
      {
        points4S++;
        System.out.println("S won this round!\n");
      }
      else
      {
        points4S++;
        points4H++;
        System.out.println(("S and H chose the same number!\n"));
      }
    }
    if (points4S == 5)
    {
      System.out.println("S won the game!");
      return noFromS;
    }
    else
    {
      System.out.println("H won the game!");
      return noFromH;
    }
  }
}