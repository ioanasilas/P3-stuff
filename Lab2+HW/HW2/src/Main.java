public class Main {
    public static void main(String[] args)
    {
        A myA = new A("WhateverA");

        C[] myCArray = new C[3];
        myCArray[0] = new C("FirstC");
        myCArray[1] = new C("SecondC");
        myCArray[2] = new C("ThirdC");

        B myB = new B(myA, myCArray);

        if (args.length > 0)
        {
            switch (args[0])
            {
                case "describeA" -> myB.describeA();
                case "countC" ->
                {
                    int count = myB.countCObjects();
                    System.out.println("No of C objects: " + count);
                }
                case "nameA" ->
                {
                    String name = myA.toString();
                    System.out.println("Name of A: " + name);
                }
                default ->
                {
                    System.out.println("Unknown command: " + args[0]);
                    System.out.println("Valid commands: describeA, countC, nameA");
                }
            }
        }
        else
        {
            System.out.println("No commands were specified");
            System.out.println("Valid commands: describeA, countC, nameA");
        }

    }
}