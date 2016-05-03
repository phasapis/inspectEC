package eu.inspect.core.multimedia;

import java.util.HashSet;

/**
 *
 * @author panos
 */
public class UserParameters {
    private String language;
    private HashSet<String> keywordList;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public HashSet<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(HashSet<String> keywordList) {
        this.keywordList = keywordList;
    }
    
    
}
