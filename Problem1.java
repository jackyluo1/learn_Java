/* Problem1 [40 pts]
 *
 * introduction:
 * 
 * Vectors are commonly used in mathematics and physics. A 3D vector is
 * represented as three components: x, y and z. It is signified by a
 * direction and a length(magnitude).
 *
 * Some operations on vectors include:
 *
 * 1. Magnitude: for a vector v, this is denoted as
 * |v| = Math.sqrt(x^2 + y^2 + z^2)
 * 
 * 2. Dot product: The dot product of two vectors v = (x1 , y1 , z1) and
 * w = (x2, y2, z2) is defined as a number v * w = x1 * x2 + y1 * y2 + z1 * z2
 * 
 * 3. Angle between two vectors: This is defined as cos(θ) = v * w / (|v| * |w|)
 * 
 * Technically given two vectors, there are two angles between them. This
 * returns the smaller of the two angles. For example, if the two vectors align
 * with the clock hands at 3pm, this would return 90 degrees (not 270 degrees).
 * 
 * 
 * Implementation:
 * 
 * Write a class Vector3D that represents a 3D vector. This class should contain
 * the following:
 * 1. A constructor that takes in x, y, z components of the vector.
 * 2. Methods to get the values of individual components (e.g. getX ,etc.).
 * 3. A toString method that returns a string that describes this vector. This
 * string should be of the form “(x,y,z)” replacing the letters with their values.
 * Each component should be formatted to round to exactly two decimal places.
 * 4. A method getMagnitude that returns its magnitude.
 * 5. A method dotProduct that returns the dot product of this vector and
 * another vector. It should not change the two vectors.
 * 6. A method angleBetween that returns the angle between two vectors in
 * degrees. It should not change the two vectors. It should throw an IllegalStateException
 * if this operation cannot be completed.
 * 
 * You may find some useful method in the Math class for this assignment.
 */

class Vector3D {
    private double x;
    private double y;
    private double z;
    private java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");

    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public String toString() {
        // java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        return "(" + df.format(this.x) + "," + df.format(this.y) + "," + df.format(this.z) + ")";
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.y, 2));
    }

    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public double angleBetween(Vector3D other) {
        if (this.getMagnitude() == 0 || other.getMagnitude() == 0) {
            System.out.println("IllegalStateException, -1 means it is Illegal");
            return -1;
        }

        double value = this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude()); // get the value of cos(θ)
        double angle = Math.acos(value) * 180 / Math.PI; // get the angle

        if (angle >= 180) {
            angle -= 180; // get the small one
        }
        return angle;
    }

    public static void main(String[] args) {
        Vector3D a = new Vector3D(10, 5, 1);
        Vector3D b = new Vector3D(10, 0, 0);
        System.out.println("a.toString: " + a.toString());
        System.out.println("a.x: " + a.getX());
        System.out.println("a.getMagnitude: " + a.getMagnitude());
        System.out.println("dotProduct(a, b): " + a.dotProduct(b));
        System.out.println("angleBetween(a, b):  " + a.angleBetween(b));
    }
}
