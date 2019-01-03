public class GraphDriver {
    public static void main(String[] args){
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        Circle c3 = new Circle (9);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        RtTriangle r1 = new RtTriangle();
        RtTriangle r2 = new RtTriangle(4,3);
        RtTriangle r3 = new RtTriangle(5,12);
        System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r3));
        System.out.println("The area of r1 is " + r1.getArea());
        System.out.println("The area of r3 is " + r3.getArea());
        System.out.println("The area of c1 is " + c1.getArea());
        System.out.println("The area of c3 is " + c3.getArea());
    }
}
