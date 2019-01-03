public class Circle2 implements Shape {
    private double radius;

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    public Circle2(){
        radius = 5;
    }

    public Circle2(double _radius){
        radius = _radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double _radius){
        radius = _radius;
    }

}//end of class
