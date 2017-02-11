
public class Main {

    public static void main(String arg[]){

        Figure cube = new Cube(3);
        Figure sphere = new Sphere( 3);

        System.out.println( cube.getVolume());
        System.out.println( sphere.getVolume());
    }

}
