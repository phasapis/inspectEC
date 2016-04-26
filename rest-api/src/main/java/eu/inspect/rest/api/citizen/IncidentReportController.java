package eu.inspect.rest.api.citizen;

import eu.inspect.core.message.ResponseMessageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import eu.inspect.core.security.IAuthenticationMechanism;
import eu.inspect.core.message.incident.IncidentReportRegisteredUser;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class IncidentReportController
{
	@Autowired
	private IAuthenticationMechanism authService;

	@RequestMapping(
			value="/citizen/report/", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncidentReportRegisteredUser> submitIncidentReport(@RequestBody IncidentReportRegisteredUser incidentReport)
        {	
            ResponseMessageBase response = new ResponseMessageBase();
            response.setMessage("Forwarded");
            
            return new ResponseEntity<IncidentReportRegisteredUser>(incidentReport, HttpStatus.OK);
	}	
}
