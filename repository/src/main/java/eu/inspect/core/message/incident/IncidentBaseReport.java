package eu.inspect.core.message.incident;

import eu.inspect.core.message.MessagePreable;
import eu.inspect.core.messages.types.IncidentStatus;
import eu.inspect.core.messages.types.ReportType;
import eu.inspect.core.messages.types.ReporterType;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author panos
 */
public class IncidentBaseReport
extends MessagePreable
{
    
    private UUID incidentID;
    private UUID reportID;
    private IncidentStatus incidentStatus;
    private String suspectDescription;
    private ReporterType reporterType;
    private ReportType reportType;    
    private String locationDescription;
    private String reportDescription;
    private boolean anonymousUser;
    private Date timeOccured;
    private int latitude;
    private int longitude;

    public UUID getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(UUID incidentID) {
        this.incidentID = incidentID;
    }

    public UUID getReportID() {
        return reportID;
    }

    public void setReportID(UUID reportID) {
        this.reportID = reportID;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public String getSuspectDescription() {
        return suspectDescription;
    }

    public void setSuspectDescription(String suspectDescription) {
        this.suspectDescription = suspectDescription;
    }

    public ReporterType getReporterType() {
        return reporterType;
    }

    public void setReporterType(ReporterType reporterType) {
        this.reporterType = reporterType;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public boolean isAnonymousUser() {
        return anonymousUser;
    }

    public void setAnonymousUser(boolean anonymousUser) {
        this.anonymousUser = anonymousUser;
    }

    public Date getTimeOccured() {
        return timeOccured;
    }

    public void setTimeOccured(Date timeOccured) {
        this.timeOccured = timeOccured;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }


}
