/*
Problem 1 [Rational Numbers] 50 pts

Define a class named "Ratinal" for rational numbers. A rational number is a number that can
be represented as the quotient of two integers. For example, 1/2, 344, 6422, and so
forth are all rational numbers. (By 1/2 and so forth, we mean the everyday meaning of
the fraction, not the integer division this expression would produce in a Java program.)

Represent rational numbers as two values of type int, one for the "numerator" and one
for the "denominator". Your class should have two instance variables of type int. Call the
class Rational.

Requirements:
A. A copy constructor

B. Include a constructor with two arguments that can be used to set the instance
variables of an object to any values.

C. Also include a constructor that has only a single parameter of type int; call this
single parameter "wholeNumber" and define the constructor so that the object
will be initialized to the rational number wholeNumber/1.

D. Create a copy constructor to get a deep copy of an existed Ratinal object.

E. Define accessor and mutator methods as well as the methods "equals" and
"toString". You should include a method "normalize" to normalize the sign of the rational
number so that the denominator is positive and the numerator is either positive or
negative. For example, after normalization, 4/-8 would be represented the same
as -4/8. (Hints: Two rational numbers a/b and c/d are equal if a*d equals c*b.)

F. Add a second version of the methods for "addition", "subtraction",
"multiplication", and "division". These methods should have the same names as
the static version but should use a calling object and a single argument. For example,
this version of the add method (for addition) has a calling object and one argument. So
r1.add(r2) returns the result of adding the rationals r1 and r2. Note that your class
should have all these methods; for example, there should be two methods named "addition".

Good luck!
*/

class Ratinal {
    private int numerator;
    private int denominator;

    public Ratinal(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("denominator != 0 !");
            System.exit(1);
        }
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Ratinal(Ratinal deepCopy) {
        if (deepCopy == null) {
            System.exit(0);
        }
        this.numerator = deepCopy.getNumerator();
        this.denominator = deepCopy.getDenominator();
    }

    public Ratinal() {
        this(0, 1);
    }

    public Ratinal(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int setNumerator(int numerator) {
        return this.numerator = numerator;
    }

    public int setDenominator(int denominator) {
        if (denominator == 0) {
            System.exit(0);
        }
        return this.denominator = denominator;
    }

    public Ratinal normalize() {

        // simply the number
        int gcd = gcd(this.denominator, this.numerator % this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;

        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
            return this;
        }
        return this;
    }

    public boolean equals(Ratinal another) {
        return this.numerator * another.denominator == another.numerator * this.denominator;
    }

    private int gcd(int numerator1, int denominator1) {
        if (denominator1 == 0) {
            return numerator1;
        }
        return gcd(denominator1, numerator1 % denominator1);
    }

    public String toString() {

        // if denominator == 1 ,then return a integer;
        if (this.denominator == 1) {
            return this.numerator + "";
        }
        return this.numerator + "/" + this.denominator;
    }

    public Ratinal addition(Ratinal another) {
        if (another == null) {
            System.exit(0);
        }
        Ratinal res1 = new Ratinal();
        res1.numerator = this.numerator * another.denominator + another.numerator * this.denominator;
        res1.denominator = this.denominator * another.denominator;
        return res1.normalize();
    }

    public static Ratinal addition(Ratinal a, Ratinal another) {
        Ratinal res = new Ratinal();
        res.numerator = a.numerator * another.denominator + a.denominator * another.numerator;
        res.denominator = a.denominator * another.denominator;
        return res.normalize();
    }

    public Ratinal subtraction(Ratinal another) {
        if (another == null) {
            System.exit(0);
        }
        Ratinal res2 = new Ratinal();
        res2.numerator = this.numerator * another.denominator - another.numerator * this.denominator;
        res2.denominator = this.denominator * another.denominator;
        return res2.normalize();
    }

    public static Ratinal subtraction(Ratinal a, Ratinal another) {
        Ratinal res = new Ratinal();
        res.numerator = a.numerator * another.denominator - a.denominator * another.numerator;
        res.denominator = a.denominator * another.denominator;
        return res.normalize();
    }

    public Ratinal multiplication(Ratinal another) {
        if (another == null) {
            System.exit(0);
        }
        Ratinal res3 = new Ratinal();
        res3.numerator = this.numerator * another.numerator;
        res3.denominator = this.denominator * another.denominator;
        return res3.normalize();
    }

    public static Ratinal multiplication(Ratinal a, Ratinal another) {
        Ratinal res = new Ratinal();
        res.numerator = a.numerator * another.numerator;
        res.denominator = a.denominator * another.denominator;
        return res.normalize();
    }

    public Ratinal division(Ratinal another) {
        if (another == null) {
            System.exit(0);
        }
        Ratinal res4 = new Ratinal();
        res4.numerator = this.numerator * another.denominator;
        res4.denominator = this.denominator * another.numerator;
        return res4.normalize();
    }

    public static Ratinal division(Ratinal a, Ratinal another) {
        Ratinal res = new Ratinal();
        res.numerator = a.numerator * another.denominator;
        res.denominator = a.denominator * another.numerator;
        return res.normalize();
    }
}

class RatinalTest {
    private String name;
    private Ratinal ratinalnumber;

    public RatinalTest(RatinalTest copy) {
        this(copy.name, copy.ratinalnumber);
    }

    public RatinalTest(String name, Ratinal ratinalnumber) {
        this.setName(name);
        this.setRational(ratinalnumber);
    }

    public String getName() {
        return this.name;
    }

    public Ratinal getRatinalnumber() {
        return this.ratinalnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRational(Ratinal ratinalnumber) {
        this.ratinalnumber = new Ratinal();
        this.ratinalnumber.setDenominator(ratinalnumber.getDenominator());
        this.ratinalnumber.setNumerator(ratinalnumber.getNumerator());
    }

    public String toString() {
        return "Name: " + this.name + ", Number: " + this.getRatinalnumber().toString();
    }
}

public class Problem1 {

    public static void main(String[] args) {
        Ratinal a = new Ratinal(2, -3);
        System.out.println("a: " + a);

        RatinalTest a_test = new RatinalTest("Jing Luo", a);
        RatinalTest a_testcopy = new RatinalTest(a_test);
        a.setNumerator(5);
        System.out.println("we do this: a.setNumerator(5)");
        System.out.println("a is :" + a);
        System.out.println("the copy is :" + a_testcopy.getRatinalnumber());
        System.out.println(a_testcopy.getRatinalnumber().equals(a));
        System.out.println("");

        Ratinal b = new Ratinal(a);
        b.setNumerator(7);
        System.out.println("b: " + b);

        Ratinal c = new Ratinal(3);
        System.out.println("c: " + c);

        System.out.println("Before a normalized: " + a);
        System.out.println("After a normalized: " + a.normalize());

        Ratinal a1 = new Ratinal(-2, 3);
        System.out.println("a1: " + a1);
        System.out.println("a1 is equal to a: " + a1.equals(a));

        Ratinal a2 = new Ratinal(-3, 3);
        System.out.println("");
        System.out.println("a2 is : " + a2);
        System.out.println("c is: " + c);

        System.out.println("a2 add c: " + a2.addition(c));
        System.out.println("a2 sub c: " + a2.subtraction(c));
        System.out.println("a2 multiply c: " + a2.multiplication(c));
        System.out.println("a2 div c: " + a2.division(c));

        System.out.println("");
        System.out.println("Static method:");
        System.out.println("a2 add c: " + Ratinal.addition(a2, c));
        System.out.println("a2 sub c: " + Ratinal.subtraction(a2, c));
        System.out.println("a2 multiply c: " + Ratinal.multiplication(a2, c));
        System.out.println("a2 div c: " + Ratinal.division(a2, c));

    }
}