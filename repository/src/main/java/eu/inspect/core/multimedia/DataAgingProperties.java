package eu.inspect.core.multimedia;

import java.util.Date;

/**
 *
 * @author panos
 */
public class DataAgingProperties {
    private Date TTL;
    private Date TTA;
    private Date TTP;

    public Date getTTL() {
        return TTL;
    }

    public void setTTL(Date TTL) {
        this.TTL = TTL;
    }

    public Date getTTA() {
        return TTA;
    }

    public void setTTA(Date TTA) {
        this.TTA = TTA;
    }

    public Date getTTP() {
        return TTP;
    }

    public void setTTP(Date TTP) {
        this.TTP = TTP;
    }
    
    
}
