/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An abstract SearchResponse that contains the results and total count.
 * 
 * @author rwatts, created 14 Sep 2009
 */
@XStreamAlias("searchResponse")
public class SearchResponse<T extends SearchResult> {

    @XStreamImplicit()
    private List<T> results;

    @XStreamAsAttribute
    private int totalResultCount;
    @XStreamAsAttribute
    private int currentPage;
    @XStreamAsAttribute
    private int currentPageResultCount;
    @XStreamAsAttribute
    private int totalPageCount;
    @XStreamAsAttribute
    private String sort;
    @XStreamAsAttribute
    private String sortDirection;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentPageResultCount() {
        return currentPageResultCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurrentPageResultCount(int currentPageResultCount) {
        this.currentPageResultCount = currentPageResultCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
