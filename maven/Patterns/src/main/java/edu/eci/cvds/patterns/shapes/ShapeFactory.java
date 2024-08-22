package edu.eci.cvds.patterns.shapes;

import edu.eci.cvds.patterns.shapes.concrete.Triangle;
import edu.eci.cvds.patterns.shapes.concrete.Quadrilateral;
import edu.eci.cvds.patterns.shapes.concrete.Pentagon;
import edu.eci.cvds.patterns.shapes.concrete.Hexagon;

public class ShapeFactory {
    
    /**
     * Crea una instancia de Shape basada en el tipo de forma proporcionado.
     *
     * @param type El tipo de forma que se desea crear.
     * @return Una instancia de Shape correspondiente al tipo proporcionado.
     * @throws IllegalArgumentException Si el tipo de forma no es reconocido.
     */
    public static Shape create(RegularShapeType type) {
        switch (type) {
            case TRIANGLE:
                return new Triangle();
            case QUADRILATERAL:
                return new Quadrilateral();
            case PENTAGON:
                return new Pentagon();
            case HEXAGON:
                return new Hexagon();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
