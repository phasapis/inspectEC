package eu.inspect.rest.api.serv;

import com.google.gson.Gson;
import eu.inspect.core.correlation.CorrelationResult;
import eu.inspect.core.messages.types.ApplicationServerResponseTypes;
import eu.inspect.core.message.ApplicationResponseMessageBase;
import eu.inspect.core.message.incident.IncidentReportRegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eu.inspect.core.security.IAuthenticationMechanism;
import eu.inspect.core.multimedia.MediaFileDescriptor;
import eu.inspect.jms.IMessagingService;
import eu.inspect.jms.topic.types.TopicNameEnumeration;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CorrelationEngineController
{
	@Autowired
	private IAuthenticationMechanism authService;

	@Autowired
	private IMessagingService messagingService;
                
	@RequestMapping(
			value="/serv/correlate/init", 
			method=RequestMethod.POST,
                        consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponseMessageBase> initCorrelationAnalysis(@RequestBody IncidentReportRegisteredUser incidentReport)
        {
            Iterator<MediaFileDescriptor> mediaIterator;
            MediaFileDescriptor mediaDescriptor;
            ApplicationResponseMessageBase response = new ApplicationResponseMessageBase();
            response.setMessageID(UUID.randomUUID());            
            HttpStatus httpStatus;
            
            if(!authService.authenticate(incidentReport.getUsername(), null))
            {
                Logger.getLogger(CorrelationEngineController.class.getName()).log(Level.SEVERE, "Authentication error occured");                
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
                Logger.getLogger(CorrelationEngineController.class.getName()).log(Level.SEVERE, "Report required fields are missing");
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);            
            }
            
            Gson gson = new Gson();
            messagingService.publishToTopic(TopicNameEnumeration.INSPECT_CORRELATION_INIT.toString(),
                                            gson.toJson(incidentReport));

            httpStatus = HttpStatus.OK;
            response.setMessage(ApplicationServerResponseTypes.FORWARDED);
            
            return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
	}	
        
	@RequestMapping(
			value="/serv/correlate/results", 
			method=RequestMethod.POST,
                        consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponseMessageBase> submitCorrelationAnalysis(@RequestBody CorrelationResult correlationResult)
        {
            Iterator<MediaFileDescriptor> mediaIterator;
            MediaFileDescriptor mediaDescriptor;
            ApplicationResponseMessageBase response = new ApplicationResponseMessageBase();
            response.setMessageID(UUID.randomUUID());            
            HttpStatus httpStatus;
            
            if(!authService.authenticate(correlationResult.getUsername(), null))
            {
                Logger.getLogger(CorrelationEngineController.class.getName()).log(Level.SEVERE, "Authentication error occured");                
                httpStatus = HttpStatus.FORBIDDEN;
                response.setMessage(ApplicationServerResponseTypes.AUTHENTICATION_ERROR);                
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
            }
            
            if((correlationResult.getIncidentIDSet()==null) ||
               (correlationResult.getRulesList()==null))
            {
                Logger.getLogger(CorrelationEngineController.class.getName()).log(Level.SEVERE, "Required fields are missing");
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);            
            }
            
            Gson gson = new Gson();
            messagingService.publishToTopic(TopicNameEnumeration.INSPECT_CORRELATION_RESULTS.toString(),
                                            gson.toJson(correlationResult));

            httpStatus = HttpStatus.OK;
            response.setMessage(ApplicationServerResponseTypes.FORWARDED);
            
            return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
	}	
        
}
