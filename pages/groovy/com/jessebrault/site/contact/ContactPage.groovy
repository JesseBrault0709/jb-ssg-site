package com.jessebrault.site.contact

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Contact', path = '/contact')
class ContactPage extends WvcPageView {

    private final TitleMaker titleMaker

    @Inject
    ContactPage(TitleMaker titleMaker) {
        this.titleMaker = titleMaker
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
