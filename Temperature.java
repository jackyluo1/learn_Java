/**
 * Represents a temperature.
 */
public abstract class Temperature {
  /**
   * Absolute zero, in degrees Celsius. For our purposes, no temperature can be below
   * this value.
   */
  double ABS_ZERO_C = -273.15f;

  /**
   * The temperature in degrees Celsius.
   *
   * @return the temperature in degrees Celsius
   */
  double inCelsius();

  /**
   * The temperature in degrees Fahrenheit.
   *
   * @return the temperature in degrees Fahrenheit
   */
  double inFahrenheit();

  /**
   * The temperature in degrees Kelvin.
   *
   * @return the temperature in degrees Kelvin
   */
  double inKelvin();
  
  // you can create some getters and setters here if you need
  
  
  /**
   * Add two temperatures together and return the resulting temperature.
   *
   * @return the new temperature
   */
  Temperature add(Temperature t);
  
  /**
   * Check two temperatures are equal.
   *
   * @param t Temperature object
   * @return boolean value indicate whether two temperature is equal
   */
  public boolean equals(Object obj);
  
  /**
   * display the temperature
   *
   * @return return a String as follows: "NN.N° Fahrenheit"
   */
  public String toString();
  
  
}
