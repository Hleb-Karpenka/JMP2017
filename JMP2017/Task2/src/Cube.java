/**
 * Created by Gleb88 on 11.02.2017.
 */
public class Cube implements Figure {

    private double side;


    public Cube(){
        super();
    }
    public Cube(double side){
        super();
        this.side = side;
    }

    public double getVolume(){
        return this.side*this.side*this.side;
    }
}
