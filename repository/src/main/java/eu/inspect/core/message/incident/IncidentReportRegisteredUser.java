/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.inspect.core.message.incident;

import eu.inspect.core.multimedia.MultimpleFilesUpload;

/**
 *
 * @author panos
 */
public class IncidentReportRegisteredUser 
extends IncidentBaseReport
{
    private MultimpleFilesUpload multimpleFilesUpload;

    public MultimpleFilesUpload getMultimpleFilesUpload() {
        return multimpleFilesUpload;
    }

    public void setMultimpleFilesUpload(MultimpleFilesUpload multimpleFilesUpload) {
        this.multimpleFilesUpload = multimpleFilesUpload;
    }        
}
