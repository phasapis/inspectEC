package eu.inspect.core.multimedia;

/**
 *
 * @author panos
 */
public class VideoStreamParameters
extends MediaFileDescriptor
{
    private int bitrate;
    private float duration;
    private float startTime;
    private float endTime;
    private int resolutionWidth;
    private int resolutionLength;

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
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

    public int getResolutionWidth() {
        return resolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    public int getResolutionLength() {
        return resolutionLength;
    }

    public void setResolutionLength(int resolutionLength) {
        this.resolutionLength = resolutionLength;
    }
    
    
}
