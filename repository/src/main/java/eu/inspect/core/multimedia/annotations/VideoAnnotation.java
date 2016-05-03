package eu.inspect.core.multimedia.annotations;

import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class VideoAnnotation {
    private int index;
    private String type;
    private float time;
    private LinkedList<Integer> ROI;
    private float confidence;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public LinkedList<Integer> getROI() {
        return ROI;
    }

    public void setROI(LinkedList<Integer> ROI) {
        this.ROI = ROI;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    
}
