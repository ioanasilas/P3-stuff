public class A
{
    String name;

    public A(String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getDescription()
    {
        return "This is an instance of A called " + this.name;
    }


    @Override
    public String toString()
   {
       return "A{name='" + name + "'}";
   }

}
