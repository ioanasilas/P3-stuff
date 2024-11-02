public class Banana extends Fruit implements Peelable
{
    private boolean isPeeledOff;
    public Banana(int w, float sugar, float water)
    {
        super(w, sugar, water, Color.YELLOW);
        isPeeledOff = false;
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


}
