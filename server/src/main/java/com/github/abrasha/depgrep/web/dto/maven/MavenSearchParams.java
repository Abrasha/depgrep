package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Andrii Abramov on 3/11/17.
 */
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
    
    public String getSpellCheck() {
        return spellCheck;
    }
    
    public void setSpellCheck(String spellCheck) {
        this.spellCheck = spellCheck;
    }
    
    public String getFl() {
        return fl;
    }
    
    public void setFl(String fl) {
        this.fl = fl;
    }
    
    public String getSort() {
        return sort;
    }
    
    public void setSort(String sort) {
        this.sort = sort;
    }
    
    public String getIndent() {
        return indent;
    }
    
    public void setIndent(String indent) {
        this.indent = indent;
    }
    
    public String getQ() {
        return q;
    }
    
    public void setQ(String q) {
        this.q = q;
    }
    
    public String getQf() {
        return qf;
    }
    
    public void setQf(String qf) {
        this.qf = qf;
    }
    
    public String getSpellCheckCount() {
        return spellCheckCount;
    }
    
    public void setSpellCheckCount(String spellCheckCount) {
        this.spellCheckCount = spellCheckCount;
    }
    
    public String getWt() {
        return wt;
    }
    
    public void setWt(String wt) {
        this.wt = wt;
    }
    
    public String getRows() {
        return rows;
    }
    
    public void setRows(String rows) {
        this.rows = rows;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getDefType() {
        return defType;
    }
    
    public void setDefType(String defType) {
        this.defType = defType;
    }
    
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