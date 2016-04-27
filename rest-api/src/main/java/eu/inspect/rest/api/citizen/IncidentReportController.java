package eu.inspect.rest.api.citizen;

import com.google.gson.Gson;
import eu.inspect.core.messages.types.ApplicationServerResponseTypes;
import eu.inspect.core.message.ApplicationResponseMessageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eu.inspect.core.security.IAuthenticationMechanism;
import eu.inspect.core.message.incident.IncidentReportRegisteredUser;
import eu.inspect.jms.IMessagingService;
import eu.inspect.jms.MessagingService;
import eu.inspect.jms.topic.types.TopicNameEnumeration;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class IncidentReportController
{
	@Autowired
	private IAuthenticationMechanism authService;

	@Autowired
	private IMessagingService messagingService;
                
	@RequestMapping(
			value="/citizen/report/", 
			method=RequestMethod.PUT,
                        consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponseMessageBase> submitNewIncidentReport(@RequestBody IncidentReportRegisteredUser incidentReport)
        {
            ApplicationResponseMessageBase response = new ApplicationResponseMessageBase();
            response.setMessageID(UUID.randomUUID());            
            HttpStatus httpStatus;
            
            if(!authService.authenticate(null, null))
            {
                Logger.getLogger(IncidentReportController.class.getName()).log(Level.SEVERE, "Authentication error occured");                
                httpStatus = HttpStatus.FORBIDDEN;
                response.setMessage(ApplicationServerResponseTypes.AUTHENTICATION_ERROR);                
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
            }
            
            if(incidentReport.getIncidentID()==null)
            {
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                response.setMessage(ApplicationServerResponseTypes.INCIDENTID_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                
            }
            else if(incidentReport.getReportID()==null)
            {
                httpStatus = HttpStatus.NOT_ACCEPTABLE;                
                response.setMessage(ApplicationServerResponseTypes.REPORTID_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                
            }
            else if((incidentReport.getOriginatingService()==null) ||
                    (incidentReport.getLocationDescription()==null) || 
                    (incidentReport.getReportType()==null) ||
                    (incidentReport.getReporterType()==null) ||
                    (incidentReport.getSuspectDescription()==null) ||
                    (incidentReport.getReportDescription()==null) ||
                    (incidentReport.getTimeOccured()==null) ||
                    (incidentReport.getUserID()==null) ||
                    (incidentReport.getReportDescription()==null))
            {
                Logger.getLogger(IncidentReportController.class.getName()).log(Level.SEVERE, "Report required fields are missing");
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                response.setMessage(ApplicationServerResponseTypes.REPORT_REQUIRED_FIELDS_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);            
            }

            Gson gson = new Gson();
            messagingService.publishToTopic(TopicNameEnumeration.INSPECT_REPORTS.toString(),
                                            gson.toJson(incidentReport));

            httpStatus = HttpStatus.OK;
            response.setMessage(ApplicationServerResponseTypes.FORWARDED);
            
            return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
	}	
}
