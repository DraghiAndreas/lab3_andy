package Ex1;

public class Parabola {
    private final int a;
    private final int b;
    private final int c;

    public Parabola(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] VarfParabola(){
        double x = -((b)/(2.0*a));
        double y = (-(double)(b*b) + (4*a*c))/(4.0*a);
        return new double[]{x,y};
    }

    @Override
    public String toString() {
        return a + "x^2 + " + b + "x + " + c;
    }

    public double[] MijlocParabola (Parabola par){
        double[] v1 = this.VarfParabola();
        double[] v2 = par.VarfParabola();

        double x = (v1[0] + v2[0])/2;
        double y = (v1[1] + v2[1])/2;

        return new double[] {x,y};
    }

    public static double[] MijlocParabolaStatic(Parabola par1, Parabola par2){
        double[] v1 = par1.VarfParabola();
        double[] v2 = par2.VarfParabola();

        double x = (v1[0] + v2[0])/2;
        double y = (v1[1] + v2[1])/2;

        return new double[] {x,y};
    }

    public double LungimeaSegmentului(Parabola par){
        double[] v1 = this.VarfParabola();
        double[] v2 = par.VarfParabola();

        return Math.hypot(v2[0] - v1[0], v2[1] - v1[1]);
    }

    public static double LungimeaSegmentuluiStatica(Parabola par1, Parabola par2){
        double[] v1 = par1.VarfParabola();
        double[] v2 = par2.VarfParabola();

        return Math.hypot(v2[0] - v1[0], v2[1] - v1[1]);
    }


}
