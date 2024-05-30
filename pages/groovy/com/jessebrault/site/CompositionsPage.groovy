package com.jessebrault.site

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Compositions', path = '/compositions')
class CompositionsPage extends WvcPageView {

    private final TitleMaker titleMaker

    @Inject
    CompositionsPage(TitleMaker titleMaker) {
        this.titleMaker = titleMaker
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
