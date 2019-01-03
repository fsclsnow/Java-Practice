public class DiverClass {
    public static void main(String[] args){
        Circle2 c = new Circle2(4);
        Rectangle r = new Rectangle(4,3);
        showArea(c);
        showArea(r);
    }//end main
    public static void showArea(Shape s){
        Double area = s.area();
        System.out.println ("The area of the shape is " + area);
    }//end showArea
}//end DriverClass
