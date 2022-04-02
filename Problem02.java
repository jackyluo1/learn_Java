/**
 * In this problem, you will be using the Rational class.
 * The goal is to design a class called Line which represents a line on a plane.
 * Recall that the equation for a line can be written as y = rx + q, where r and
 * q, both rational numbers, are the slope and intercept respectively.
 * Now, given a point p = (a,b), where a and b are rational numbers,we would
 * like to know if p is on the line.
 * Fortunately, the method for doing so is easy: just plug in a for x and see if
 * y = b or not. For example, consider the line y = 1/3(x) + 1.
 * The point p = (1, 2) is not on the line (the line does not pass through it)
 * since setting x = 1 and computing y = 1/3 * 1 + 1 we get 4/3 != 2.
 * On the other hand, the point p = (3, 1) is on the line since y = 1/3 * 3 + 1
 * = 2.
 * Required methods are
 * * A copy constructor
 *
 * * A constructor Line(Rational, Rational),
 * 
 * * A pair of accessors getSlope() and getIntercept(),
 * 
 * * A pair of mutators setSlope(Rational) and setIntercept(Rational),
 * 
 * * A method includes(Rational, Rational) which takes the coordinates of a
 * point and returns a boolean (true if the line passes through the point),
 * 
 * * toString() which returns the equation of the line like Equation (1)–that
 * is, “y=slopex + intercept”,
 * 
 * * equals(Line) which returns true if and only if the two lines are identical.
 */

class Line {
    private Ratinal r;
    private Ratinal q;

    public Line(Ratinal r, Ratinal q) {
        this.setSlope(r);
        this.setIntercep(q);
    }

    public Line(Line copy) {
        this(copy.r, copy.q);
    }

    public Ratinal getSlope() {
        return this.r;
    }

    public Ratinal getIntercept() {
        return this.q;
    }

    public void setSlope(Ratinal r1) {
        this.r = r1;
    }

    public void setIntercep(Ratinal q1) {
        this.q = q1;
    }

    public boolean includes(Ratinal x, Ratinal y) {
        Ratinal rightSide = x.multiplication(this.r).addition(this.q);
        return y.equals(rightSide);
    }

    public String toString() {
        return "y = " + this.r.toString() + "x + " + this.q.toString();
    }

    public boolean equals(Line another) {
        return this.r.equals(another.r) && this.q.equals(another.q);
    }

    public static void main(String[] args) {
        Ratinal r1 = new Ratinal(1, 2);
        Ratinal q1 = new Ratinal(6, 6);
        Line xs = new Line(r1, q1);
        System.out.println("Line xs: " + xs);

        System.out.println(xs.getSlope());
        System.out.println(xs.getIntercept());

        Ratinal x = new Ratinal(2, 1);
        Ratinal y = new Ratinal(2, 1);
        System.out.println("p(2,2) in line xs? Ans:");
        System.out.println(xs.includes(x, y));

        Ratinal r2 = new Ratinal(2, 4);
        Ratinal q2 = new Ratinal(6, 6);
        Line sx = new Line(r2, q2);
        System.out.println("Line sx: " + sx);
        System.out.println("xs == sx ? Ans: ");
        System.out.println(xs.equals(sx));

        sx.setIntercep(x);
        System.out.println(sx);
        sx.setSlope(y);
        System.out.println(sx);

    }
}

/*
 * Problem 1 [Rational Numbers] 50 pts
 * 
 * Define a class named "Ratinal" for rational numbers. A rational number is a
 * number that can
 * be represented as the quotient of two integers. For example, 1/2, 344, 6422,
 * and so
 * forth are all rational numbers. (By 1/2 and so forth, we mean the everyday
 * meaning of
 * the fraction, not the integer division this expression would produce in a
 * Java program.)
 * 
 * Represent rational numbers as two values of type int, one for the "numerator"
 * and one
 * for the "denominator". Your class should have two instance variables of type
 * int. Call the
 * class Rational.
 * 
 * Requirements:
 * A. A copy constructor
 * 
 * B. Include a constructor with two arguments that can be used to set the
 * instance
 * variables of an object to any values.
 * 
 * C. Also include a constructor that has only a single parameter of type int;
 * call this
 * single parameter "wholeNumber" and define the constructor so that the object
 * will be initialized to the rational number wholeNumber/1.
 * 
 * D. Create a copy constructor to get a deep copy of an existed Ratinal object.
 * 
 * E. Define accessor and mutator methods as well as the methods "equals" and
 * "toString". You should include a method "normalize" to normalize the sign of
 * the rational
 * number so that the denominator is positive and the numerator is either
 * positive or
 * negative. For example, after normalization, 4/-8 would be represented the
 * same
 * as -4/8. (Hints: Two rational numbers a/b and c/d are equal if a*d equals
 * c*b.)
 * 
 * F. Add a second version of the methods for "addition", "subtraction",
 * "multiplication", and "division". These methods should have the same names as
 * the static version but should use a calling object and a single argument. For
 * example,
 * this version of the add method (for addition) has a calling object and one
 * argument. So
 * r1.add(r2) returns the result of adding the rationals r1 and r2. Note that
 * your class
 * should have all these methods; for example, there should be two methods named
 * "addition".
 * 
 * Good luck!
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
        this(deepCopy.getNumerator(), deepCopy.getDenominator());
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