# Homework7 (100 pts)
The purpose of this exercise is to give you practice with the new concepts introduced through the Shape example, such as inheritance and interface polymorphism, along with the default (no keyword) and protected access modifiers. We are also introducing a new concept, the idea of static and static methods.

 

## Representing Temperature
In the starter code, you are given an abstract class representing a temperature value. Your task is to extend the Temperature abstract class in two different ways:
* using a field to represent the temperature in degrees Celsius.
* using a field to represent the temperature in degrees Fahrenheit.


You will need two separate classes: a public classed named *CelsiusTemperature*, and a public class named *FahrenheitTemperature*. Each class will need two constructors:
* *CelsiusTemperature* will have one constructor that takes a single double representing temperature in Celsius; the other constructor will take a double representing temperature in Fahrenheit and a boolean whose value **must be true** (in other words, you need to incidate whether the object is Celsius or Fahrenheit).

* *FahrenheitTemperature* will have one constructor that takes a single double representing temperature in Fahrenheit; its other constructor will take a double representing temperature in Celsius and a boolean whose value **must be true**.

- You should add getters and setters for each attributes in your class, because it is better to access class attributes only by these methods instead of directly call them.

- All implementations should override **toString()**. The toString() method should return a String as follows: "NN.N° Fahrenheit", namely, the temperature to one decimal place precision followed by the degree symbol and Fahrenheit, e.g., "30.1° Fahrenheit", for the *FahrenheitTemperature* class, and similarly for the *CelsiusTemperature* class but substituting "Celsius" for "Fahrenheit". You may want to copy and paste the degree symbol (°) from this Web page. You may find it useful to use String.format("%.1f") to convert a double to a String with one decimal place.

- We also need a **equals()** method to compare two objects. Obviously, 100 Celsius degree is not equal to 100 Fahrenheit degree. You need to handle this unit difference.

- Because interface implement Comparable interface, you also need to overwrite **compareTo(Temperature t1)** method. This method help us to compare two temperatures which may be not in same temperature unit.

The formulas for converting between **Celsius** and **Fahrenheit** are as follows:

From Celsius to Fahrenheit, C * 9/5 + 32 From Fahrenheit to Celsius, (F - 32) * 5/9

The formula for converting from **Celsius (C)** to **Kelvin (K)** is:

K = C - ABS_ZERO_C

Where ABS_ZERO_C represents absolute zero in degress Celsius, namely -273.1°C. This value is provided for you as a (static) constant in the Temperature interface.

Note about the **add()** method: Adding temperatures together has no clear interpretation physically; you may decide what the most appropriate behaviour for this method is. Document the behaviour of your add() method by modifying its JavaDoc in Temperature.java as necessary.

## Notes to Keep in Mind
* Avoid duplicating code as much as possible. Think about the ways the modules have discussed doing this (inheritance and composition). Consider also using non-public methods as means of creating reusable pieces of functionality. Consider also making these static as appropriate.

* Be sure to use access modifiers, private, default (no keyword), protected, and public appropriately.

## Tests
Some basic *JUnit* tests are supplied as part of the starter code. Use these to verify that your implementation is correct, and write additional tests of your own.

