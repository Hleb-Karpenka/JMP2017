
public class Sphere implements Figure{

    private double radius;
    public static double pi = 3.14;

    public Sphere(){
        super();
    }
    public Sphere(double radius){
        super();
        this.radius = radius;
    }

    public double getVolume(){
       return 4*pi*this.radius/3;
    }
}
