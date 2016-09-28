package gameOfLife;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import cell.Cell;
import cell.GridPosition;
import grid.Builder;
import grid.Parameters;
import grid.Runner;
import ui.ErrorPop;

public class GameOfLifeBuilder extends Builder{

	private GLParameters pars;
	private Set<GridPosition> predefinedAlives;
	private ResourceBundle myResource;

	public GameOfLifeBuilder(Parameters param, ResourceBundle myResource) {
		super(param);
		this.myResource = myResource;
	}

	@Override
	protected Runner initRunner() {
		return new GameOfLifeRunner(cells, cellGrid);
	}

	@Override
	protected void readParameters() {
		if (!(param instanceof GLParameters)) {
			ErrorPop error = new ErrorPop(300, 200, myResource.getString("LifeError"), myResource);
			error.popup();
		}
		pars = (GLParameters) param;
	}
	
	@Override
	protected void addAllNeighbors(Cell c) {
		this.addSidesAsNeighbors(c);
		this.addCornersAsNeighbors(c);
		this.addCornersAcrossBoardAsNeighbors(c);
		this.addSidesAcrossBoardAsNeighbors(c);
	}

	@Override
	protected Cell initCell(GridPosition gp) {
		GameOfLifeCell glCell;
		if (pars.isModifiedStart()) {
			if (predefinedAlives.contains(gp)) {
				glCell = new GameOfLifeCell(gp, GameOfLifeCell.alive);
			}
			else {
				glCell = new GameOfLifeCell(gp, GameOfLifeCell.dead);
			}
		}
		else {
			double rnd = Math.random();
			if (rnd < pars.getRatioOfAlive()) {
				glCell = new GameOfLifeCell(gp, GameOfLifeCell.alive);
			}
			else {
				glCell = new GameOfLifeCell(gp, GameOfLifeCell.dead);
			}
		}
		return glCell;
	}

	@Override
	protected void prepareForInitCells() {
		if (pars.isModifiedStart()){
			predefinedAlives = new HashSet<GridPosition>(pars.getListOfAlive());
		}
	}
}
