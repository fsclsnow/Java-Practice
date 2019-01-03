public class Rectangle implements Shape{
    private double length, width;

    @Override
    public double area() {
        return length*width;
    }

    public Rectangle(){
        length = 10;
        width = 8;
    }

    public Rectangle(double _length, double _width){
        length = _length;
        width = _width;
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    public void setLength(double _length){
        length = _length;
    }

    public void setWidth(double _width){
        width = _width;
    }

}//end of class

