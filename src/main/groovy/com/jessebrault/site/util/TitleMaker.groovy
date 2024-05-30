package com.jessebrault.site.util

import jakarta.inject.Inject
import jakarta.inject.Named

class TitleMaker {

    private final String siteTitle

    @Inject
    TitleMaker(@Named('siteName') String siteTitle) {
        this.siteTitle = siteTitle
    }

    String makeTitle(String pageTitle) {
        this.siteTitle + " — " + pageTitle
    }

}
