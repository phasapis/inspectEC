package eu.inspect.core.message.incident;

import eu.inspect.core.messages.types.ActionableInfType;
import eu.inspect.core.messages.types.IncidentPriority;
import eu.inspect.core.multimedia.MediaFileDescriptor;
import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class IncidentReportLEO 
extends IncidentBaseReport
{
    private IncidentPriority incidentPriority;
    private ActionableInfType action;
    private LinkedList<MediaFileDescriptor> mediaList;

    public IncidentPriority getIncidentPriority() {
        return incidentPriority;
    }

    public void setIncidentPriority(IncidentPriority incidentPriority) {
        this.incidentPriority = incidentPriority;
    }

    public ActionableInfType getAction() {
        return action;
    }

    public void setAction(ActionableInfType action) {
        this.action = action;
    }

    public LinkedList<MediaFileDescriptor> getMediaList() {
        return mediaList;
    }

    public void setMediaList(LinkedList<MediaFileDescriptor> mediaList) {
        this.mediaList = mediaList;
    }


}
