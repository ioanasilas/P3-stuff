import java.util.Random;

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

  // lets do qs :DDDDDDDDDDD
  int partition(int array[], int N)
  {
    // pivot selection, median of 3
    int low = array[0];
    int high = array[N-1];
    int mid = array[(N-1) / 2];
    int pivot_index;

    if ((low <= high) ^ (low > mid))
    {
      pivot_index = 0;
    }
    else if ((high < low) ^ (high > mid))
    {
      pivot_index = N-1;
    }
    else
    {
      pivot_index = (N-1)/2;
    }

    // place pivot as last element
    // so partitioning is easier
    int temp = array[pivot_index];
    array[pivot_index] = array[N-1];
    array[N-1] = temp;
    
    //partition
    int i = 0, j = N-2;
    while (i < j)
    {
      if (array[i] >= array[N-1] && array[j] < array[N-1])
      {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++; j--;
      }
      else if (array[i] < array[N-1])
      {
        i++;
      }
      else if (array[j] > array[N-1])
      {
        j--;
      }
    }
    // put pivot el in correct position
    temp = array[i];
    array[i] = array[N-1];
    array[N-1] = temp;

    return i;
  }

  void sortNumbers(int array[], int lower_bound, int N)
  {
    if (lower_bound >= N -1)
    {
      return;
    }
    int pivot_index = partition(array, N);
    sortNumbers(array, lower_bound, pivot_index - 1);
    sortNumbers(array, pivot_index + 1, N);
  }

  void randomArraySort()
  {
    Random rand = new Random();
    int N = rand.nextInt(20) + 1;
    int[] array = new int[N];

    for (int i = 0; i < N; i++)
    {
      array[i] = rand.nextInt(100) + 1;
    }

    //print og array
    System.out.println("Original array: ");
    for (int num : array)
    {
      System.out.println(num + " ");
    }
    System.out.println();

    sortNumbers(array, 0, N-1);
    System.out.println("Sorted array: ");
    

    // print sorted array
    for (int num : array)
    {
      System.out.println(num + " ");
    }
    System.out.println();
  }
}