package eu.inspect.core.multimedia;

import eu.inspect.core.message.MessagePreable;
import java.util.LinkedList;

/**
 *
 * @author panos
 */
public class MultimediaFilesAnalysisDescriptor
extends MessagePreable
{
    private LinkedList<MediaFileDescriptor> mediaFileDescriptorList;

    public LinkedList<MediaFileDescriptor> getMediaFileDescriptorList() {
        return mediaFileDescriptorList;
    }

    public void setMediaFileDescriptorList(LinkedList<MediaFileDescriptor> mediaFileDescriptorList) {
        this.mediaFileDescriptorList = mediaFileDescriptorList;
    }
    
    
}
