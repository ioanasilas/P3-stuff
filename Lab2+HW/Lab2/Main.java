public class Main
{
  public static void main(String[] args)
  {
    // initialize input and output devices and app
    InputDevice inputDevice = new InputDevice();
    InputDevice inputDevice2 = new InputDevice();
    OutputDevice outputDevice = new OutputDevice();
    Application application = new Application(inputDevice, inputDevice2, outputDevice);

    // print args, lab2
    // do stuff based on arg, lab2
    int argCount = args.length;
      for (int i = 0; i < argCount; i++)
      {
        outputDevice.writeMessage("Argument " + (i + 1) + ": " + args[i]);
      }
      System.out.println();

    // word histo, lab 2
    if (args[0].equals("words"))
    {
      int[] wordSizeFreq = application.wordSizeHistogram(inputDevice2.getLine());
      for (int i = 0; i < wordSizeFreq.length; i++)
      {
        if (wordSizeFreq[i] != 0)
        {
          outputDevice.writeMessage("There are " + wordSizeFreq[i] + " words of size " + i);
        }
      }
      System.out.println();
    }

    // sort rando array w quicksort, lab2
    if (args[0].equals("numbers"))
    {
      application.randomArraySort();
    }

    // play gambling game, lab 1
    if(args[0].equals("play"))
    {
      if (args.length > 1)
      {
        try
        {
          int roundsToWin = Integer.parseInt(args[1]);
          application.playGame(inputDevice, inputDevice2, roundsToWin);
        }
        catch (NumberFormatException e)
        {
          outputDevice.writeMessage("Second argument must be a valid integer");
        }
      }
      else
      {
        outputDevice.writeMessage("Please provide no of rounds as second argument");
      }
    }
  }
}
