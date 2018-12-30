package World;


public class Vector {

    public float x, y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(float v) {
        this.x = v;
        this.y = v;
    }

    public Vector mult(float m) {
        return new Vector(this.x * m, this.y * m);
    }

    public static boolean collision(Vector pos1, Vector size1, Vector pos2, Vector size2) {
        float tw = size1.x;
        float th = size1.y;
        float rw = size2.x;
        float rh = size2.y;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        float tx = pos1.x;
        float ty = pos1.y;
        float rx = pos2.x;
        float ry = pos2.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    public String toString() {
        return String.format("Vector(X: %s, Y: %s)", this.x, this.y);
    }

}
