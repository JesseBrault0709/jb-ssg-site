package com.jessebrault.site.util

import groowt.util.fp.provider.Provider

class TitleMaker {

    private final Provider<String> siteTitleProvider

    TitleMaker(Provider<String> siteTitleProvider) {
        this.siteTitleProvider = siteTitleProvider
    }

    String makeTitle(String pageTitle) {
        this.siteTitleProvider.get() + " — " + pageTitle
    }

}
