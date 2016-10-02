package xml;

import java.util.Collection;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ants.AntParameters;
import cell.GridPosition;
import grid.Parameters;

public class AntSimulationFactory extends SimulationFactory{

    public AntSimulationFactory (Element rootElement) {
        super(rootElement);
    }

    @Override
    public Parameters createParameters (Parameters basicParams, NodeList listOfNodes) {
        int maxNumAnts = getIntegerValue("maxNumAnts");
        int maxAmountOfPheromone = getIntegerValue("maxAmountOfPheromone");
        int antsBornPerTimeStep = getIntegerValue("antsBornPerTimeStep");
        int maxAntAge = getIntegerValue("maxAntAge");
        double evaporationRatio = getDoubleValue("evaporationRatio");
        double diffusionRatio = getDoubleValue("diffusionRatio");
        double K = getDoubleValue("K");
        double N = getDoubleValue("N");
        Collection<GridPosition> nestCell = createListOfLocations("nestCell", listOfNodes);
        Collection<GridPosition> foodCell = createListOfLocations("foodCell", listOfNodes);
        
        return new AntParameters(basicParams, maxNumAnts, maxAmountOfPheromone, antsBornPerTimeStep,
                                 maxAntAge, evaporationRatio, diffusionRatio, K, N, nestCell, foodCell);
       
    }

}
