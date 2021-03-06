package WaTor;

import java.util.ResourceBundle;

import init.Initializer;
import javafx.scene.Node;
import ui.Controls;

public class WaTorControls extends Controls {

	public WaTorControls(Initializer initializer, ResourceBundle myResource) {
		super(initializer, myResource);
	}

	public Node sharkStarveRateSlider(int rate) {
		return makeSliderBox(rate, 0, 25, this.getResource().getString("SharkStarve"), 
				(observable, old_val, new_val) -> {
					((WTParameters) this.getInitializer().getParameters()).setSharkStarve(new_val.intValue());
				});
	}

	public Node fishReproductionRateSlider(int rate) {
		return makeSliderBox(rate, 0, 25, this.getResource().getString("FishRep"), 
				(observable, old_val, new_val) -> {
					int fishReproductionRate = new_val.intValue();
					((WTParameters) this.getInitializer().getParameters()).setFishRate(fishReproductionRate);
				});
	}


	public Node sharkReproductionRateSlider(int rate) {
		return makeSliderBox(rate, 0, 25, this.getResource().getString("SharkRep"), 
				(observable, old_val, new_val) -> {
					int sharkReproductionRate = new_val.intValue();
					((WTParameters) this.getInitializer().getParameters()).setSharkRate(sharkReproductionRate);
				});
	}

	public Node sharkEnergyGainedFromEatingSlider(int rate) {
		return makeSliderBox(rate, 0, 25, this.getResource().getString("SharkGain"), 
				(observable, old_val, new_val) -> {
					int energy = new_val.intValue();
					((WTParameters) this.getInitializer().getParameters()).setEnergyFromEating(energy);

				});
	}

	public Node initRatioSlider(double ratio) {
		return makeSliderBox((int) (ratio/(ratio + 1) * 100), 0, 100, this.getResource().getString("SharkFish"), 
				(observable, old_val, new_val) -> {
					int newNumShark = new_val.intValue();
					int newNumFish = 100 - newNumShark;
					double newRatio;
					if (newNumFish == 0) {
						newRatio = Double.MAX_VALUE;
					}
					else {
						newRatio = ((double)newNumShark) / newNumFish;
					}
					((WTParameters) this.getInitializer().getParameters()).setRatio(newRatio);
					this.getInitializer().update();

				});
	}

	public Node initEmptySlider(double empty) {
		return makeSliderBox((int) (empty*100), 0, 100, this.getResource().getString("Empty"), 
				(observable, old_val, new_val) -> {
					int newEmptyPercent = new_val.intValue();
					double newEmpty = newEmptyPercent / 100.0;
					((WTParameters) this.getInitializer().getParameters()).setEmptyRatio(newEmpty);
					this.getInitializer().update();
				});
	}
}