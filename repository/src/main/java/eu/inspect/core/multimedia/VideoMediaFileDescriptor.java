package eu.inspect.core.multimedia;

import eu.inspect.core.messages.types.VideoAnalysisType;

/**
 *
 * @author panos
 */
public class VideoMediaFileDescriptor
extends MediaFileDescriptor
{
    private VideoAnalysisType videoAnalysisType;
    private VideoStreamParameters videoStreamParameters;
    private DataAgingProperties dataAgingProperties;
    private UserParameters userParameters;
    private VideoConfigurationParameters videoConfigurationParameters;

    public VideoAnalysisType getVideoAnalysisType() {
        return videoAnalysisType;
    }

    public void setVideoAnalysisType(VideoAnalysisType videoAnalysisType) {
        this.videoAnalysisType = videoAnalysisType;
    }

    public VideoStreamParameters getVideoStreamParameters() {
        return videoStreamParameters;
    }

    public void setVideoStreamParameters(VideoStreamParameters videoStreamParameters) {
        this.videoStreamParameters = videoStreamParameters;
    }

    public DataAgingProperties getDataAgingProperties() {
        return dataAgingProperties;
    }

    public void setDataAgingProperties(DataAgingProperties dataAgingProperties) {
        this.dataAgingProperties = dataAgingProperties;
    }

    public UserParameters getUserParameters() {
        return userParameters;
    }

    public void setUserParameters(UserParameters userParameters) {
        this.userParameters = userParameters;
    }

    public VideoConfigurationParameters getVideoConfigurationParameters() {
        return videoConfigurationParameters;
    }

    public void setVideoConfigurationParameters(VideoConfigurationParameters videoConfigurationParameters) {
        this.videoConfigurationParameters = videoConfigurationParameters;
    }

    
}
