package eu.inspect.rest.api.serv;

import com.google.gson.Gson;
import eu.inspect.core.messages.types.ApplicationServerResponseTypes;
import eu.inspect.core.message.ApplicationResponseMessageBase;
import eu.inspect.core.multimedia.AudioMediaFileDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eu.inspect.core.security.IAuthenticationMechanism;
import eu.inspect.core.multimedia.MediaFileDescriptor;
import eu.inspect.core.multimedia.MultimediaAnalysisResult;
import eu.inspect.core.multimedia.MultimediaFilesAnalysisDescriptor;
import eu.inspect.core.multimedia.VideoMediaFileDescriptor;
import eu.inspect.jms.IMessagingService;
import eu.inspect.jms.topic.types.TopicNameEnumeration;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MultimediaAnalyticsController
{
	@Autowired
	private IAuthenticationMechanism authService;

	@Autowired
	private IMessagingService messagingService;
                
	@RequestMapping(
			value="/serv/multimedia/analysis/init", 
			method=RequestMethod.POST,
                        consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponseMessageBase> initMultimediaAnalysis(@RequestBody MultimediaFilesAnalysisDescriptor multimediaFilesAnalysisDescriptor)
        {
            Iterator<MediaFileDescriptor> mediaIterator;
            MediaFileDescriptor mediaDescriptor;
            ApplicationResponseMessageBase response = new ApplicationResponseMessageBase();
            response.setMessageID(UUID.randomUUID());            
            HttpStatus httpStatus;
            
            if(!authService.authenticate(multimediaFilesAnalysisDescriptor.getUsername(), null))
            {
                Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Authentication error occured");                
                httpStatus = HttpStatus.FORBIDDEN;
                response.setMessage(ApplicationServerResponseTypes.AUTHENTICATION_ERROR);                
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
            }
            
            mediaIterator = multimediaFilesAnalysisDescriptor.getMediaFileDescriptorList().iterator();

            while(mediaIterator.hasNext())
            {
                mediaDescriptor = mediaIterator.next();
                
                if((mediaDescriptor.getFilesize()==null) ||
                   (mediaDescriptor.getMimeType()==null) ||
                   (mediaDescriptor.getURL()==null))
                {
                    Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Media Descriptor required fields are missing");
                    httpStatus = HttpStatus.NOT_ACCEPTABLE;
                    response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                    return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                                
                }
                
                if(mediaDescriptor.getMimeType().startsWith("audio"))
                {
                    AudioMediaFileDescriptor audioMediaFileDescriptor = (AudioMediaFileDescriptor)mediaDescriptor;
                    if(audioMediaFileDescriptor.getAudioConfigurationParameters()==null ||
                       audioMediaFileDescriptor.getAudioStreamParameters()==null ||
                       audioMediaFileDescriptor.getDataAgingProperties()==null)
                    {
                        Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Media Descriptor required fields are missing");
                        httpStatus = HttpStatus.NOT_ACCEPTABLE;
                        response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                        return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                                                    
                    }
                }
                else if(mediaDescriptor.getMimeType().startsWith("video") || 
                        mediaDescriptor.getMimeType().startsWith("image"))
                {
                    VideoMediaFileDescriptor videoMediaFileDescriptor = (VideoMediaFileDescriptor)mediaDescriptor;
                    if(videoMediaFileDescriptor.getVideoAnalysisType()==null ||
                       videoMediaFileDescriptor.getVideoConfigurationParameters()==null ||
                       videoMediaFileDescriptor.getDataAgingProperties()==null ||
                       videoMediaFileDescriptor.getVideoStreamParameters()== null)
                    {
                        Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Media Descriptor required fields are missing");
                        httpStatus = HttpStatus.NOT_ACCEPTABLE;
                        response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                        return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                                                    
                    }
                    
                }
                else
                {
                    Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Wrong required fields");
                    httpStatus = HttpStatus.NOT_ACCEPTABLE;
                    response.setMessage(ApplicationServerResponseTypes.MALFORMED_FIELDS);
                    return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
                }
            }
            
            Gson gson = new Gson();
            messagingService.publishToTopic(TopicNameEnumeration.INSPECT_MULTIMEDIA_INIT.toString(),
                                            gson.toJson(multimediaFilesAnalysisDescriptor));

            httpStatus = HttpStatus.OK;
            response.setMessage(ApplicationServerResponseTypes.FORWARDED);
            
            return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
	}
        
	@RequestMapping(
			value="/serv/multimedia/analysis/results", 
			method=RequestMethod.POST,
                        consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponseMessageBase> submitMultimediaAnalysisResults(@RequestBody MultimediaAnalysisResult multimediaAnalysisResult)
        {
            Iterator<MediaFileDescriptor> mediaIterator;
            MediaFileDescriptor mediaDescriptor;
            ApplicationResponseMessageBase response = new ApplicationResponseMessageBase();
            response.setMessageID(UUID.randomUUID());            
            HttpStatus httpStatus;
            
            if(!authService.authenticate(multimediaAnalysisResult.getUsername(), null))
            {
                Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Authentication error occured");                
                httpStatus = HttpStatus.FORBIDDEN;
                response.setMessage(ApplicationServerResponseTypes.AUTHENTICATION_ERROR);                
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
            }

            if(multimediaAnalysisResult.getMimeType()==null || 
               multimediaAnalysisResult.getURL()==null)
            {
                Logger.getLogger(MultimediaAnalyticsController.class.getName()).log(Level.SEVERE, "Media Descriptor required fields are missing");
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                response.setMessage(ApplicationServerResponseTypes.REQUIRED_FIELDS_MISSING);
                return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);                  
            }
            
            Gson gson = new Gson();
            messagingService.publishToTopic(TopicNameEnumeration.INSPECT_MULTIMEDIA_RESULTS.toString(),
                                            gson.toJson(multimediaAnalysisResult));

            httpStatus = HttpStatus.OK;
            response.setMessage(ApplicationServerResponseTypes.FORWARDED);
            
            return new ResponseEntity<ApplicationResponseMessageBase>(response, httpStatus);
	}        
}
