package grid;

import cell.GridPosition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * @author billyu
 * UI component of the cell
 * actual displaying part is Shape
 * grid position is composed of a row and a col
 * positionX and positionY determines the shape's position on UI display
 */

public class CellGraphic {
	
	public static final String SQUARE = "Square";
	public static final String TRIANGLE = "Triangle";
	public static final String HEXAGON = "Hexagon";
	
	private Shape graphic;
	private double positionX;
	private double positionY;
	private double width;
	private double height;
	private GridPosition gridPos;
	private Color shapeColor;
	
	public CellGraphic(GridPosition gp) {
		gridPos = gp;
	}

	public Shape getGraphic() {
		return graphic;
	}

	public void setGraphic(Shape graphic) {
		this.graphic = graphic;
	}
	
	public void setPosition(double x, double y) {
		positionX = x;
		positionY = y;
	}
	
	public double getPositionX() {
		return positionX;
	}
	
	public double getPositionY() {
		return positionY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setColor(Color color){
		shapeColor = color;
		graphic.setFill(shapeColor);
	}

	public GridPosition getGridPos() {
		return gridPos;
	}

	public void setGridPos(GridPosition gridPos) {
		this.gridPos = gridPos;
	}
}
