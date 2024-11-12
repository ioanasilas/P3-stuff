public class Apple extends Fruit implements SeedRemovable
{
    private boolean isSeedless;
    public Apple(int w, float sugar, float water, Color color)
    {
        super(w, sugar, water, color);
        isSeedless = false;
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
