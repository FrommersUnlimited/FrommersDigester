package com.wiley.frommers.feedunmarshaller.query;

public class PaginatedFeedQuery extends FeedQuery {

    public void setNPerPage(int i) {
        queryParams.put("nPerPage", String.valueOf(i));
    }

    public void setPage(int page) {
        queryParams.put("page", String.valueOf(page));
    }

    public void showMax(boolean showMax) {
        queryParams.put("showMax", String.valueOf(showMax));
    }

}
