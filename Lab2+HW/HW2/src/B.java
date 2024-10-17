public class B
{
    // declaration
    A instanceA;
    C[] instanceC;

    // constructor
    public B(A a, C[] c)
    {
        // either works
        instanceA = a;
        this.instanceC = c;
    }

    // function 4 c
    public int countCObjects()
    {
        return instanceC.length;
    }

    public void describeA()
    {
        String description = instanceA.getDescription();
        System.out.println(description);
    }
}
