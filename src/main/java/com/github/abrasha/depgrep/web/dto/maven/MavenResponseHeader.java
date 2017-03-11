package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenResponseHeader {
    
    private Integer status;
    
    @JsonProperty("QTime")
    private Integer queryTime;
    
    @JsonProperty("params")
    private MavenSearchParams mavenSearchParams;
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getQueryTime() {
        return queryTime;
    }
    
    public void setQueryTime(Integer queryTime) {
        this.queryTime = queryTime;
    }
    
    public MavenSearchParams getMavenSearchParams() {
        return mavenSearchParams;
    }
    
    public void setMavenSearchParams(MavenSearchParams mavenSearchParams) {
        this.mavenSearchParams = mavenSearchParams;
    }
}
