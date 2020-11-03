package com.kapresoft.demo.fn;

import com.kapresoft.demo.pojo.dto.FindMovieRequest;
import com.kapresoft.demo.pojo.dto.MovieInfoResponse;
import com.kapresoft.demo.service.MovieFinder;
import com.kapresoft.demo.service.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.function.Function;

@Slf4j
public class MovieRequestFunction implements Function<FindMovieRequest, MovieInfoResponse> {

    private MovieFinder movieFinder;
    private RequestUtil requestUtil;

    public MovieRequestFunction() {
        this(new MovieFinder(), new RequestUtil());
    }

    public MovieRequestFunction(MovieFinder movieFinder, RequestUtil requestUtil) {
        this.movieFinder = movieFinder;
        this.requestUtil = requestUtil;
    }

    public MovieInfoResponse apply(FindMovieRequest request) {
        log.debug("\nFindMovieRequest: {}", requestUtil.toJsonString(request));
        val movieInfo = movieFinder.findCharacterFromMovie(request.getCharacterName());
        log.debug("\nMovie found: {}", requestUtil.toJsonString(movieInfo));
        return movieInfo;
    }

}
