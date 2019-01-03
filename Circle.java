public class Circle {
    private double radius;

    public Circle(){
        radius = 5;
    }
    public Circle(double _radius){
        radius = _radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        double area = Math.PI * radius * radius;
        return area;
    }


    public boolean equals(Circle other) {
        if (other == null)
            return false;
        if (getClass()!= other.getClass())
            return false;
        return radius == other.getRadius();
    }

    public static void main(String[] args){
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        Circle c3 = new Circle (9);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
    }
}

