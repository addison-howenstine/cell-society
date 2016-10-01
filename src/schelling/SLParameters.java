package schelling;

import grid.Parameters;

public class SLParameters extends Parameters {
    
        private double emptyRatio; // vacant ratio
        private double ratio; // red-blue ratio
        private double idealRatio; // the ratio for the cell to become satisfied
        
       
    	public SLParameters (Parameters p) {
            super(p);
        }
    	
    	public SLParameters (Parameters p, double ideal, double redBlue, double empty){
    	    super(p);
    	    this.idealRatio = ideal;
    	    this.ratio = redBlue;
    	    this.emptyRatio = empty;
    	    setByLocations(false);
    	}

     
	public double getEmptyRatio() {
		return emptyRatio;
	}
	
	public void setEmptyRatio(double emptyRatio) {
		this.emptyRatio = emptyRatio;
	}
	
	public double getRatio() {
		return ratio;
	}
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public double getIdealRatio() {
		return idealRatio;
	}

	public void setIdealRatio(double idealRatio) {
		this.idealRatio = idealRatio;
	}
    
   
}
