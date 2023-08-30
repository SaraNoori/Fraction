public class Fraction
{
    private int numerator;
    private int denominator;

    // constructors
    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // greatest common denominator
    static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }

    // least common multiple
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    Fraction add(Fraction other)
    {
        Fraction added = new Fraction(0, 0);
        int commonDen = lcm(this.denominator, other.denominator);
        added.denominator = commonDen;

        int needMult = commonDen / this.denominator;
        added.numerator += this.numerator * needMult;

        needMult = commonDen / other.denominator;
        added.numerator += other.numerator * needMult;
        
        added.reduce();

        return added;
    }

    Fraction multiply(Fraction other)
    {
        Fraction multiplied = new Fraction(0, 0);
        multiplied.numerator = this.numerator * other.numerator;
        multiplied.denominator = this.denominator * other.denominator;

        multiplied.reduce();

        return multiplied;
    }

    private void reduce()
    {
        int commonDev = gcd(numerator, denominator);

        numerator /= commonDev;
        denominator /= commonDev;
    }

    public String toString()
    {
        return numerator + "/" + denominator;
    }

}