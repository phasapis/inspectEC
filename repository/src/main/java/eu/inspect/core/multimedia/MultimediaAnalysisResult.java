package eu.inspect.core.multimedia;

import eu.inspect.core.message.MessagePreable;
import java.util.Date;

/**
 *
 * @author panos
 */
public class MultimediaAnalysisResult
extends MessagePreable
{
    private String URL;
    private String mimeType;
    private Date annotationDate;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Date getAnnotationDate() {
        return annotationDate;
    }

    public void setAnnotationDate(Date annotationDate) {
        this.annotationDate = annotationDate;
    }
    
    
}
