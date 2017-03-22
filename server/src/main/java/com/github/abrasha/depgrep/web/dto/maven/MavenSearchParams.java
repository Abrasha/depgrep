package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class MavenSearchParams {
    
    @JsonProperty("spellcheck")
    private String spellCheck;
    
    private String fl;
    private String sort;
    private String indent;
    private String q;
    private String qf;
    
    @JsonProperty("spellcheck.count")
    private String spellCheckCount;
    
    private String wt;
    private String rows;
    private String version;
    private String defType;
    
    @Override
    public String toString() {
        return "MavenSearchParams{" +
                "spellCheck='" + spellCheck + '\'' +
                ", fl='" + fl + '\'' +
                ", sort='" + sort + '\'' +
                ", indent='" + indent + '\'' +
                ", q='" + q + '\'' +
                ", qf='" + qf + '\'' +
                ", spellCheckCount='" + spellCheckCount + '\'' +
                ", wt='" + wt + '\'' +
                ", rows='" + rows + '\'' +
                ", version='" + version + '\'' +
                ", defType='" + defType + '\'' +
                '}';
    }
}