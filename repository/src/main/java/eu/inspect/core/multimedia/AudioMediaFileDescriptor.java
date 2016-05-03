/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.inspect.core.multimedia;

import eu.inspect.core.messages.types.AudioAnalysisType;

/**
 *
 * @author panos
 */
public class AudioMediaFileDescriptor 
extends MediaFileDescriptor
{
    private AudioAnalysisType audioAnalysisType;
    private AudioStreamParameters audioStreamParameters;
    private DataAgingProperties dataAgingProperties;
    private UserParameters userParameters;
    private AudioConfigurationParameters audioConfigurationParameters;

    public AudioAnalysisType getAudioAnalysisType() {
        return audioAnalysisType;
    }

    public void setAudioAnalysisType(AudioAnalysisType audioAnalysisType) {
        this.audioAnalysisType = audioAnalysisType;
    }

    public AudioStreamParameters getAudioStreamParameters() {
        return audioStreamParameters;
    }

    public void setAudioStreamParameters(AudioStreamParameters audioStreamParameters) {
        this.audioStreamParameters = audioStreamParameters;
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

    public AudioConfigurationParameters getAudioConfigurationParameters() {
        return audioConfigurationParameters;
    }

    public void setAudioConfigurationParameters(AudioConfigurationParameters audioConfigurationParameters) {
        this.audioConfigurationParameters = audioConfigurationParameters;
    }

    
}
