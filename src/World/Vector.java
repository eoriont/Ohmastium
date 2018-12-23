package World;

public class Vector {

    public float x, y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector y, Vector z) {
        return new Vector(y.x + z.x, y.y + z.y);
    }

}
