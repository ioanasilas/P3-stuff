import java.util.Collection;
import java.util.Map;

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
        if (args.length > 0 && args[0].equals("words"))
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
        if (args.length > 0  && args[0].equals("numbers"))
        {
            application.randomArraySort();
        }

        // play gambling game, lab 1
        if(args.length > 0  && args[0].equals("play"))
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
     // lab 3
        if (args.length > 0 && args[0].equals("fruits-array"))
        {
            // read fruit array
            Fruit [] fruits = inputDevice.readFruitArray();

            for (Fruit fruit : fruits) {
                System.out.println(fruit);
            }

            // total weight of fruits
            int totalWeight = application.computeWeight(fruits);
            outputDevice.writeMessage("Total weight of fruits: " + totalWeight + " grams");

            // total sugar content of fruits
            float totalSugarContent = application.computeSugarContent(fruits);
            outputDevice.writeMessage("Total sugar content of fruits: " + totalSugarContent + " grams");

            // prepare the fruits (peel or remove seeds if necessary)
            application.prepareFruit(fruits);

            outputDevice.writeMessage("Fruits have been prepared.");
        }

        // lab 4 - collection
        if (args.length > 0 && args[0].equals("fruits-collection"))
        {
            // read fruit collection
            Collection<Fruit> fruits = inputDevice.readFruitCollection();

            for (Fruit fruit : fruits) {
                System.out.println(fruit);
            }

            // total weight of fruits
            int totalWeight = application.computeWeight(fruits);
            outputDevice.writeMessage("Total weight of fruits: " + totalWeight + " grams");

            // total sugar content of fruits
            float totalSugarContent = application.computeSugarContent(fruits);
            outputDevice.writeMessage("Total sugar content of fruits: " + totalSugarContent + " grams");

            // prepare the fruits (peel or remove seeds if necessary)
            application.prepareFruit(fruits);

            outputDevice.writeMessage("Fruits have been prepared.");
        }

        // add 4 count fruit
        if (args.length > 0 && args[0].equals("count-fruits"))
        {
            Collection<Fruit> fruits = inputDevice.readFruitCollection();

            for (Fruit fruit : fruits) {
                System.out.println(fruit);
            }

            Map<String, Integer> fruitsNumbers = application.countFruit(fruits);
            outputDevice.writeMessage("The fruits we have are the following:\n ");
            for (Map.Entry<String, Integer> entry : fruitsNumbers.entrySet())
            {
                outputDevice.writeMessage(entry.getKey() + ": " + entry.getValue());
            }
        }

        if (args.length > 0 && args[0].equals("test-compare"))
        {
            Collection<Fruit> fruits = inputDevice.readFruitCollection();
            for (Fruit fruit : fruits)
            {
                System.out.println(fruit);
            }

            application.testFruitComparison(fruits);
            outputDevice.writeMessage("Fruits have been compared.");

        }

        if (args.length > 0 && args[0].equals("fruit-with-most-sugar"))
        {
            Collection<Fruit> fruits = inputDevice.readFruitCollection();
            for (Fruit fruit : fruits)
            {
                System.out.println(fruit);
            }
            application.findFruitWithMostSugar(fruits);
        }

    }
}