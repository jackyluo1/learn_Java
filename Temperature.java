/**
 * Represents a temperature.
 */
public abstract class Temperature {
  /**
   * Absolute zero, in degrees Celsius. For our purposes, no temperature can be
   * below
   * this value.
   */
  final double ABS_ZERO_C = -273.15f;
  private double value;

  public Temperature() {
    this.value = 0;
  }

  public Temperature(double value) {
    this.value = value;
  }

  public abstract double getValue();

  /**
   * The temperature in degrees Celsius.
   *
   * @return the temperature in degrees Celsius
   */
  public abstract double inCelsius();

  /**
   * The temperature in degrees Fahrenheit.
   *
   * @return the temperature in degrees Fahrenheit
   */

  public abstract double inFahrenheit();
  // you can create some getters and setters here if you need

  /**
   * The temperature in degrees Kelvin.
   *
   * @return the temperature in degrees Kelvin
   */

  public abstract double inKelvin();
  // return this.value + ABS_ZERO_C;
  // return (this.value - 32) * 5 / 9 + ABS_ZERO_C;

  /**
   * Add two temperatures together and return the resulting temperature.
   * 
   * @param i
   *
   * @return the new temperature
   */
  public abstract Temperature add(Temperature t);

  /**
   * Check two temperatures are equal.
   *
   * @param t Temperature object
   * @return boolean value indicate whether two temperature is equal
   */
  public boolean equals(Object obj) {
    if (!(obj instanceof Temperature))
      return false;
    Temperature another = (Temperature) obj;
    return this.value == another.value;
  }

  public static String format(double value) {
    return String.format("%.1f", value).toString();
  }

  /**
   * display the temperature
   *
   * @return return a String as follows: "NN.N° Fahrenheit"
   */

  public String toString() {
    return "The temperature is " + format(this.value) + "°";
  }

  public static void main(String[] args) {
    Temperature[] Ts = new Temperature[5];
    FahrenheitTemperature t1 = new FahrenheitTemperature(41);
    FahrenheitTemperature t2 = new FahrenheitTemperature(50, true);
    CelsiusTemperature c1 = new CelsiusTemperature(5);
    CelsiusTemperature c2 = new CelsiusTemperature(100, true);
    CelsiusTemperature c3 = new CelsiusTemperature(100);
    Ts[0] = t1;
    Ts[1] = t2;
    Ts[2] = c1;
    Ts[3] = c2;
    Ts[4] = c3;
    System.out.println(t1.equals(t2));
    Temperature t3 = t2.add(t1);
    System.out.println("t3: " + t3);
    Temperature t4 = t2.add(c2);
    System.out.println("t4: " + t4);

    Temperature t5 = t2.add(c1);
    System.out.println("t5: " + t5);
    System.out.println(c1.equals(c2));
    System.out.println(t1.equals(c1));
    System.out.println(c2.equals(c3));
    for (Temperature T : Ts) {
      System.out.println(T.getValue());
      System.out.println(T.toString());
    }
  }
}

class CelsiusTemperature extends Temperature {
  private double C;
  private boolean key;

  public CelsiusTemperature(double C) {
    super();
    this.C = C;
  }

  public CelsiusTemperature(double F, boolean key) {
    super();
    if (key == false) {
      System.out.println("Key must be true");
      System.exit(0);
    }
    this.C = F;
    this.key = key;
  }

  public boolean getKey() {
    return this.key;
  }

  public double getValue() {
    return this.C;
  }

  public void setCT(double C) {
    this.C = C;
  }

  public String toString() {
    return format1(this.getValue()) + "° Celsius";
  }

  public static String format1(double value) {
    return String.format("%.1f", value).toString();
  }

  public double inCelsius() {
    return this.C;
  }

  public double inFahrenheit() {
    return this.C * 9 / 5 + 32;
  }

  public double inKelvin() {
    return this.C + ABS_ZERO_C;
  }

  public Temperature add(Temperature obj) {

    if ((obj instanceof FahrenheitTemperature)) {
      FahrenheitTemperature ft = (FahrenheitTemperature) obj;
      CelsiusTemperature newt = new CelsiusTemperature(0);
      newt.C = this.C + ft.inCelsius();
      return newt;
    }

    CelsiusTemperature ct = (CelsiusTemperature) obj;
    CelsiusTemperature newt = new CelsiusTemperature(0);
    newt.C = this.C + ct.inCelsius();
    return newt;

  }

  public boolean equals(Object obj) {
    if (!(obj instanceof CelsiusTemperature)) {
      if ((obj instanceof FahrenheitTemperature)) {
        FahrenheitTemperature ft = (FahrenheitTemperature) obj;
        double a = Math.abs((this.C - ft.inCelsius()));
        if (a <= 0.01)
          return true;
        return false;
      } else {
        System.err.println("only work for Celsius and Fahrenheit");
        System.exit(0);
      }
    }
    CelsiusTemperature ct = (CelsiusTemperature) obj;
    double a = Math.abs((this.C - ct.C));
    if (a <= 0.01)
      return true;
    return false;
  }

  public static void main(String[] args) {
    CelsiusTemperature a = new CelsiusTemperature(4.4);
    System.out.println(a);
    System.out.println(a.inCelsius());
    System.out.println(a.inFahrenheit());
    System.out.println(a.inKelvin());
    CelsiusTemperature b = new CelsiusTemperature(30, true);
    System.out.println(b);
    CelsiusTemperature c = new CelsiusTemperature(40, true);
    System.out.println(c);
    System.out.println(a.equals(c));
  }
}

class FahrenheitTemperature extends Temperature {
  private double F;
  private boolean key;

  public FahrenheitTemperature(double F) {
    super();
    this.F = F;
  }

  public FahrenheitTemperature(double C, boolean key) {
    super();
    this.F = C;
    if (key == false) {
      System.out.println("Key must be true1");
      System.exit(0);
    }
    this.key = key;
  }

  public double getValue() {
    return this.F;
  }

  public void setFT(double F) {
    this.F = F;
  }

  public boolean getKey() {
    return this.key;
  }

  public String toString() {
    return format(this.getValue()) + "° Fahrenheit";
  }

  public static String format(double value) {
    return String.format("%.1f", value).toString();
  }

  public double inCelsius() {
    return (this.F - 32) * 5 / 9;
  }

  public double inFahrenheit() {
    return this.F;
  }

  public double inKelvin() {
    return (this.F - 32) * 5 / 9 + ABS_ZERO_C;
  }

  public Temperature add(Temperature obj) {

    if ((obj instanceof CelsiusTemperature)) {
      CelsiusTemperature ct = (CelsiusTemperature) obj;
      FahrenheitTemperature newt = new FahrenheitTemperature(0);
      newt.F = this.F + ct.inFahrenheit();
      return newt;
    }

    FahrenheitTemperature ft = (FahrenheitTemperature) obj;
    FahrenheitTemperature newt = new FahrenheitTemperature(0);
    newt.F = this.F + ft.inFahrenheit();
    return newt;

  }

  public boolean equals(Object obj) {
    if (!(obj instanceof FahrenheitTemperature)) {
      if ((obj instanceof CelsiusTemperature)) {
        CelsiusTemperature ct = (CelsiusTemperature) obj;
        double a = Math.abs((this.F - ct.inFahrenheit()));
        if (a <= 0.01)
          return true;
        return false;
      } else {
        System.err.println("only work for Celsius and Fahrenheit");
        System.exit(0);
      }
    }
    FahrenheitTemperature ct = (FahrenheitTemperature) obj;
    double a = Math.abs((this.F - ct.F));
    if (a <= 0.01)
      return true;
    return false;
  }

  public static void main(String[] args) {
    FahrenheitTemperature a = new FahrenheitTemperature(4.4);
    System.out.println(a);
    System.out.println(a.inCelsius());
    System.out.println(a.inFahrenheit());
    System.out.println(a.inKelvin());
    FahrenheitTemperature b = new FahrenheitTemperature(100, true);
    System.out.println(b);
    FahrenheitTemperature c = new FahrenheitTemperature(40, true);
    System.out.println(c);
    System.out.println(a.equals(c));
  }
}
