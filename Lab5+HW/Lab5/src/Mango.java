public class Mango extends Fruit implements Peelable, SeedRemovable
{
    private boolean isPeeledOff;
    private boolean isSeedless;

    public Mango(int w, float sugar, float water, Color color)
    {
        super(w, sugar, water, color);
        isPeeledOff = false;
        isSeedless = false;
    }

    public boolean hasPeel()
    {
        return !isPeeledOff;
    }

    public void peelOff()
    {
        if (!isPeeledOff)
        {
            isPeeledOff = true;
        }
        else
        {
            System.out.println("Is already peeled off");
        }
    }

    public boolean hasSeeds()
    {
        return !isSeedless;
    }

    public void removeSeeds()
    {
        if (!isSeedless)
        {
            isSeedless = true;
        }
        else
        {
            System.out.println("Seeds have already been removed");
        }
    }

}
