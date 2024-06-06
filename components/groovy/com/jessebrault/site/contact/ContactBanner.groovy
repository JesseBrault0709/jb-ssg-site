package com.jessebrault.site.contact

import com.jessebrault.ssg.di.Global
import groowt.view.component.web.BaseWebViewComponent
import jakarta.inject.Inject

class ContactBanner extends BaseWebViewComponent {

    final String spotifyUrl
    final String youtubeUrl
    final String linkedInUrl
    final String githubUrl

    @Inject
    ContactBanner(
            @Global('spotifyUrl') String spotifyUrl,
            @Global('youtubeUrl') String youtubeUrl,
            @Global('linkedInUrl') String linkedInUrl,
            @Global('githubUrl') String githubUrl
    ) {
        this.youtubeUrl = youtubeUrl
        this.spotifyUrl = spotifyUrl
        this.linkedInUrl = linkedInUrl
        this.githubUrl = githubUrl
    }

}
