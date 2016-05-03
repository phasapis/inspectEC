package eu.inspect.core.multimedia;

import eu.inspect.core.messages.types.VideoViewType;
import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class VideoConfigurationParameters
{
    private VideoViewType videoViewType;
    private String model;
    private boolean noiseFilter;
    private float blurThreshold;
    private float shakeThreshold;
    private LinkedList<Integer> minSize;
    private LinkedList<Integer> maxSize;
    private int topNranking;
    private float confidenceThreshold;

    public VideoViewType getVideoViewType() {
        return videoViewType;
    }

    public void setVideoViewType(VideoViewType videoViewType) {
        this.videoViewType = videoViewType;
    }

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

    public float getBlurThreshold() {
        return blurThreshold;
    }

    public void setBlurThreshold(float blurThreshold) {
        this.blurThreshold = blurThreshold;
    }

    public float getShakeThreshold() {
        return shakeThreshold;
    }

    public void setShakeThreshold(float shakeThreshold) {
        this.shakeThreshold = shakeThreshold;
    }

    public LinkedList<Integer> getMinSize() {
        return minSize;
    }

    public void setMinSize(LinkedList<Integer> minSize) {
        this.minSize = minSize;
    }

    public LinkedList<Integer> getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(LinkedList<Integer> maxSize) {
        this.maxSize = maxSize;
    }

    public int getTopNranking() {
        return topNranking;
    }

    public void setTopNranking(int topNranking) {
        this.topNranking = topNranking;
    }

    public float getConfidenceThreshold() {
        return confidenceThreshold;
    }

    public void setConfidenceThreshold(float confidenceThreshold) {
        this.confidenceThreshold = confidenceThreshold;
    }
    
    
}
