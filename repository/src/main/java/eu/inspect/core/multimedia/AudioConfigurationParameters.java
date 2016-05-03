package eu.inspect.core.multimedia;

/**
 *
 * @author panos
 */
public class AudioConfigurationParameters {
    private String model;
    private boolean noiseFilter;
    private float confidenceThreshold;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isNoiseFilter() {
        return noiseFilter;
    }

    public void setNoiseFilter(boolean noiseFilter) {
        this.noiseFilter = noiseFilter;
    }

    public float getConfidenceThreshold() {
        return confidenceThreshold;
    }

    public void setConfidenceThreshold(float confidenceThreshold) {
        this.confidenceThreshold = confidenceThreshold;
    }
    
    
}
