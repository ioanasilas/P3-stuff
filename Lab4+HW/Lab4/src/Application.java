import java.util.*;
import java.util.stream.Collectors;

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
        od.writeMessage("Application started!\n");
        playGame(id, id2, 5);
        // od.writeMessage("Application started!\nToday's lucky nos are: ");
        // // System.out.println("Application started!\n");
        // // System.out.println("Today's lucky nos are: ");

        // System.out.println(id.nextInt());
        // System.out.println(id.nextInt());
    }

    int playGame(InputDevice h, InputDevice s, int roundsToWin)
    {
        int noFromH = 0, noFromS = 0;
        int points4H = 0, points4S = 0;

        while (points4H < roundsToWin && points4S < roundsToWin)
        {
            // better perform and no null possibility we're good
            noFromH = h.nextInt();
            noFromS = s.nextInt();

            // print stuff 2 see
            od.writeMessage("H is " + noFromH);
            od.writeMessage("S is " + noFromS);

            if (noFromH > noFromS && noFromH % noFromS == 0 && noFromS >= 10)
            {
                points4S++;
                od.writeMessage("S won this round!\nS total points: " + points4S + "\n");
            }
            else if (noFromH > noFromS)
            {
                points4H++;
                od.writeMessage("H won this round!\nH total points: " + points4H + "\n");
            }
            else if (noFromS > noFromH)
            {
                points4S++;
                od.writeMessage("S won this round!\nS total points: " + points4S + "\n");
            }
            else
            {
                points4S++;
                points4H++;
                od.writeMessage("S and H chose the same number!\n");
                od.writeMessage("S total points: " + points4S);
                od.writeMessage("H total points: " + points4H + "\n");
            }
        }
        if (points4S == roundsToWin)
        {
            od.writeMessage("S won the game!\n");
            return noFromS;
        }
        else
        {
            od.writeMessage("H won the game!\n");
            return noFromH;
        }
    }
    // lab 2
    // lets do qs :DDDDDDDDDDD
    int partition(int array[], int lower_bound, int upper_bound)
    {
        // pivot selection, median of 3
        int low = array[lower_bound];
        int high = array[upper_bound];
        int mid = array[(lower_bound + upper_bound)/ 2];
        int pivot_index;

        if ((low >= high) ^ (low > mid))
        {
            pivot_index = lower_bound;
        }
        else if ((high >= low) ^ (high > mid))
        {
            pivot_index = upper_bound;
        }
        else
        {
            pivot_index = (lower_bound + upper_bound) / 2;
        }

        // place pivot as last element
        // so partitioning is easier
        int temp = array[pivot_index];
        array[pivot_index] = array[upper_bound];
        array[upper_bound] = temp;

        //partition
        int i = lower_bound, j = upper_bound-1;
        while (i <= j)
        {
            if (array[i] >= array[upper_bound] && array[j] < array[upper_bound])
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++; j--;
            }
            else
            {
                if (array[i] < array[upper_bound])
                {
                    i++;
                }
                if (array[j] >= array[upper_bound])
                {
                    j--;
                }
            }
        }
        // put pivot el in correct position
        temp = array[i];
        array[i] = array[upper_bound];
        array[upper_bound] = temp;

        return i;
    }

    void sortNumbers(int array[], int lower_bound, int upper_bound)
    {
        if (lower_bound >= upper_bound)
        {
            return;
        }
        else
        {
            int pivot_index = partition(array, lower_bound, upper_bound);
            sortNumbers(array, lower_bound, pivot_index - 1);
            sortNumbers(array, pivot_index + 1, upper_bound);
        }

    }

    void randomArraySort()
    {
        Random rand = new Random();
        int N = rand.nextInt(31);
        int[] array = new int[N];

        for (int i = 0; i < N; i++)
        {
            array[i] = rand.nextInt(100) + 1;
        }

        //print og array
        od.writeMessage("Original array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        sortNumbers(array, 0, (N-1));
        od.writeMessage("Sorted array: ");

        // print sorted array
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    int[] wordSizeHistogram(String sentence)
    {
        String[] words = sentence.split(" ");
        int[] wordFrequency = new int[words.length];

        for (String word : words)
        {
            wordFrequency[word.length()]++;
        }
        return wordFrequency;
    }
    // lab 3 stuff + lab 4 w collection

    public int computeWeight(Fruit[] fruits) {
        int totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public int computeWeight(Collection<Fruit> fruits) {
        int totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public float computeSugarContent(Fruit[] fruits) {
        float totalSugarContent = 0.0f;
        for (Fruit fruit : fruits) {
            totalSugarContent += fruit.getSugarContent();
        }
        return totalSugarContent;
    }

    public float computeSugarContent(Collection<Fruit> fruits) {
        float totalSugarContent = 0.0f;
        for (Fruit fruit : fruits) {
            totalSugarContent += fruit.getSugarContent();
        }
        return totalSugarContent;
    }

    public void prepareFruit(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
            if (fruit instanceof Peelable peelableFruit && peelableFruit.hasPeel()) {
                peelableFruit.peelOff();
            }
            if (fruit instanceof SeedRemovable seedRemovableFruit && seedRemovableFruit.hasSeeds()) {
                seedRemovableFruit.removeSeeds();
            }
        }
    }

    public void prepareFruit(Collection<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            if (fruit instanceof Peelable peelableFruit && peelableFruit.hasPeel()) {
                peelableFruit.peelOff();
            }
            if (fruit instanceof SeedRemovable seedRemovableFruit && seedRemovableFruit.hasSeeds()) {
                seedRemovableFruit.removeSeeds();
            }
        }
    }


    public Map<String, Integer> countFruit(Collection <Fruit> fruits) {
        int bCount = 0, aCount = 0, mCount = 0;
        Map<String, Integer> fruitCountMap = new HashMap<>();
        for (Fruit fruit : fruits) {
            if (fruit instanceof Banana)
            {
                bCount++;
            }
            else if (fruit instanceof Apple)
            {
                aCount++;
            }
            else
            {
                mCount++;
            }
        }

        fruitCountMap.put("Banana", bCount);
        fruitCountMap.put("Apple", aCount);
        fruitCountMap.put("Mango", mCount);

        return fruitCountMap;

    }

    public void testFruitComparison(Collection <Fruit> fruits)
    {
        // create new arrayList from fruits collection, regardless of OG type
        List<Fruit> fruityList = new ArrayList<>(fruits);

        // use compareTo interface
        Collections.sort(fruityList);
        od.writeMessage("Sorted fruits by weight and sugar content:\n");
        for (Fruit fruit : fruityList) {
            System.out.println(fruit);
        }

        //max, min
        Fruit minFruit = Collections.min(fruityList);
        Fruit maxFruit = Collections.max(fruityList);

        od.writeMessage("Lightest fruit: " + minFruit);
        od.writeMessage("Heaviest fruit" + maxFruit);
    }

    // bounded type parameters to restrict types
    // that could be passed as args to the method
    // avoid runtime errors
    public <W extends Fruit> void findFruitWithMostSugar(Collection<W> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }

        W maxSugarFruit = null;
        for (W fruit : fruits) {
            if (maxSugarFruit == null || fruit.getSugarContent() > maxSugarFruit.getSugarContent()) {
                maxSugarFruit = fruit;
            }
        }

        System.out.println("Fruit with the most sugar content: " + maxSugarFruit);
    }

    // streams?
    public List<Fruit> filterFruitsBySugarContent(Collection<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.getSugarContent() <= 20)
                .collect(Collectors.toList());
    }

    public double sumSugarContent(Collection<Fruit> fruits) {
        return fruits.stream()
                .mapToDouble(Fruit::getSugarContent) // maps each fruit to its sugar content
                .sum();
    }

    public List<Float> computeSugarToWaterRatios(Collection<Fruit> fruits) {
        return fruits.stream()
                .map(fruit -> fruit.getSugarContent() / fruit.getWaterContent()) // sugar/water ratio
                .collect(Collectors.toList()); // collects ratios into a List
    }




}