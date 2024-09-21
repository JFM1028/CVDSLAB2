package edu.eci.cvds.patterns.shapes;

import edu.eci.cvds.patterns.shapes.concrete.Hexagon;
import edu.eci.cvds.patterns.shapes.concrete.Pentagon;
import edu.eci.cvds.patterns.shapes.concrete.Quadrilateral;
import edu.eci.cvds.patterns.shapes.concrete.Triangle;

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
      case Triangle:
        return new Triangle();
      case Quadrilateral:
        return new Quadrilateral();
      case Pentagon:
        return new Pentagon();
      case Hexagon:
        return new Hexagon();
      default:
        throw new IllegalArgumentException("Unknown shape type: " + type);
    }
  }
}
