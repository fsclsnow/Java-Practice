public class RtTriangle {
    private double base;
    private double height;

    public RtTriangle(){
        base = 3;
        height = 4;
    }

    public RtTriangle(double _base, double _height){
        base = _base;
        height = _height;
    }

    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }

    public double getArea(){
        return base*height/2;
    }

    public boolean equals(Object other){
        if (other == null)
            return false;
        if (getClass()!= other.getClass())
            return false;
        RtTriangle o = (RtTriangle)other;
        return (base == o.getBase() && height == o.getHeight())||
                (base == o.getHeight() && height == o.getBase());
    }
}


