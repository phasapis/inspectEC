package eu.inspect.core.correlation;

import eu.inspect.core.message.MessagePreable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;

/**
 *
 * @author panos
 */
public class CorrelationResult 
extends MessagePreable
{
    private HashSet<UUID> incidentIDSet;
    private LinkedList<CorrelationRule> rulesList;

    public HashSet<UUID> getIncidentIDSet() {
        return incidentIDSet;
    }

    public void setIncidentIDSet(HashSet<UUID> incidentIDSet) {
        this.incidentIDSet = incidentIDSet;
    }

    public LinkedList<CorrelationRule> getRulesList() {
        return rulesList;
    }

    public void setRulesList(LinkedList<CorrelationRule> rulesList) {
        this.rulesList = rulesList;
    }
    
    
}
