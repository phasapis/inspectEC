package eu.inspect.core.multimedia;

/**
 *
 * @author panos
 */
public class AudioStreamParameters {
    // all fields work under the assumption that we are not using unit prefixes
    // only the base unit. thus sampling rate is in Herth and not kHz etc
    private int channels;
    private float duration;
    private int bitrate;
    private int samplingRate;
    private float startTime;
    private float endTime;

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }
    
    
}
