package ants;

import java.util.Collection;
import cell.GridPosition;
import grid.Parameters;

/**
 * 
 * @author Brian
 * Contains parameters for Ant Foraging Simulation. These parameters include:
 * maxNumAnts : maximum number of ants
 * maxAmountOfPheromone : maximum amount of pheromone per cell
 * antsBornPerTimeStep : number of ants born during each time-step
 * maxAntAge : maximum age that an ant can live to
 * evaporationRatio : ratio of evaporation
 * diffusionRatio : ratio of diffusion of ants
 * K and N: parameters used to calculate the likelihood of movement
 * nestCells : initial nest cells
 * foodCells : initial food cells
 * obstacleCells : initial obstacle cells
 */
public class AntParameters extends Parameters {
	
	private int maxNumAnts;
	private int maxAmountOfPheromone;
	private int antsBornPerTimeStep;
	private int maxAntAge;
	private double evaporationRatio;
	private double diffusionRatio;
	private double K;
	private double N;
	
	private Collection<GridPosition> nestCells;
	private Collection<GridPosition> foodCells;
	private Collection<GridPosition> obstacleCells;


	public AntParameters(Parameters p) {
		super(p);
	}

	public AntParameters(Parameters p, int maxNumAnts, int maxAmountOfPheromone, 
	                     int antsBornPerTimeStep, int maxAntAge, 
	                     double evaporationRatio, double diffusionRatio, double K, double N,
	                     Collection<GridPosition> nestCells, Collection<GridPosition> foodCells,
	                     Collection<GridPosition> obstacleCells) {
		super(p);
		this.maxNumAnts = maxNumAnts;
		this.maxAmountOfPheromone = maxAmountOfPheromone;
		this.antsBornPerTimeStep = antsBornPerTimeStep;
		this.setMaxAntAge(maxAntAge);
		this.evaporationRatio = evaporationRatio;
		this.diffusionRatio = diffusionRatio;
		this.K = K;
		this.N = N;
		this.nestCells = nestCells;
		this.foodCells = foodCells;
		this.obstacleCells = obstacleCells;
		setByLocations(false);
	}

	public int getMaxNumAnts() {
		return maxNumAnts;
	}

	public void setMaxNumAnts(int maxNumAnts) {
		this.maxNumAnts = maxNumAnts;
	}


	public int getMaxAmountOfPheromone() {
		return maxAmountOfPheromone;
	}

	public void setMaxAmountOfPheromone(int maxAmountOfPheromone) {
		this.maxAmountOfPheromone = maxAmountOfPheromone;
	}

	public int getAntsBornPerTimeStep() {
		return antsBornPerTimeStep;
	}

	public void setAntsBornPerTimeStep(int antsBornPerTimeStep) {
		this.antsBornPerTimeStep = antsBornPerTimeStep;
	}

	public int getMaxAntAge() {
		return maxAntAge;
	}

	public void setMaxAntAge(int maxAntAge) {
		this.maxAntAge = maxAntAge;
	}

	public double getEvaporationRatio() {
		return evaporationRatio;
	}

	public void setEvaporationRatio(double evaporationRatio) {
		this.evaporationRatio = evaporationRatio;
	}

	public double getDiffusionRatio() {
		return diffusionRatio;
	}

	public void setDiffusionRatio(double diffusionRatio) {
		this.diffusionRatio = diffusionRatio;
	}

	public double getK() {
		return K;
	}

	public void setK(double k) {
		K = k;
	}

	public double getN() {
		return N;
	}

	public void setN(double n) {
		N = n;
	}
	
	public Collection<GridPosition> getListOfNest(){
	    return nestCells;
	}
	
	public Collection<GridPosition> getListOfFood(){
	    return foodCells;
	}
	
	public Collection<GridPosition> getListOfObstacle(){
		return obstacleCells;
	}

}
