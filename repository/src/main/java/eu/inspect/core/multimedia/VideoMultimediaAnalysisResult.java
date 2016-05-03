package eu.inspect.core.multimedia;

import eu.inspect.core.messages.types.VideoAnalysisType;
import eu.inspect.core.multimedia.annotations.VideoAnnotation;
import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class VideoMultimediaAnalysisResult
extends MultimediaAnalysisResult
{
    private VideoAnalysisType videoAnalysisType;
    private LinkedList<VideoAnnotation> annotation;

    public VideoAnalysisType getVideoAnalysisType() {
        return videoAnalysisType;
    }

    public void setVideoAnalysisType(VideoAnalysisType videoAnalysisType) {
        this.videoAnalysisType = videoAnalysisType;
    }

    public LinkedList<VideoAnnotation> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(LinkedList<VideoAnnotation> annotation) {
        this.annotation = annotation;
    }

    
}
