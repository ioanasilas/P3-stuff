import org.w3c.dom.ls.LSOutput;

abstract public class Fruit implements Comparable<Fruit>{

    private int weight;
    private float sugarContent;
    private float waterContent;
    private Color color;

    public enum Color {
        RED,
        BLUE,
        GREEN,
        YELLOW,
        PURPLE;
    }

    // constructor that subclasses will call to set the common fields
    public Fruit(int weight, float sugarContent, float waterContent, Color color) {
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.waterContent = waterContent;
        this.color = color;
    }

    // getters
    public int getWeight() {
        return weight;
    }

    public float getSugarContent() {
        return sugarContent;
    }

    public float getWaterContent() {
        return waterContent;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Fruit other)
    {
        int weightCompaison = Integer.compare(this.weight, other.weight);
        if (weightCompaison != 0)
        {
            return weightCompaison;
        }
        return Float.compare(this.sugarContent, other.sugarContent);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + " - Weight: " + weight + " grams, Sugar: " + sugarContent + " grams, Water: " + waterContent + " grams, Color: " + color;
    }
}
