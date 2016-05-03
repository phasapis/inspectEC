package eu.inspect.core.multimedia;

import eu.inspect.core.messages.types.AudioAnalysisType;
import eu.inspect.core.multimedia.annotations.AudioAnnotation;
import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class AudioMultimediaAnalysisResult
extends MultimediaAnalysisResult
{
    private AudioAnalysisType audioAnalysisType;
    private LinkedList<AudioAnnotation> annotations;

    public AudioAnalysisType getAudioAnalysisType() {
        return audioAnalysisType;
    }

    public void setAudioAnalysisType(AudioAnalysisType audioAnalysisType) {
        this.audioAnalysisType = audioAnalysisType;
    }

    public LinkedList<AudioAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(LinkedList<AudioAnnotation> annotations) {
        this.annotations = annotations;
    }
    
    
}
