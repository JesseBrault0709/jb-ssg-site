package com.jessebrault.site.developer

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.di.SelfPage
import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Developer', path = '/developer')
class DeveloperPage extends WvcPageView {

    final Text developer
    final Page selfPage
    private final TitleMaker titleMaker

    @Inject
    DeveloperPage(
            @InjectText('/Developer.md') Text developer,
            @SelfPage Page selfPage,
            TitleMaker titleMaker
    ) {
        this.developer = developer
        this.selfPage = selfPage
        this.titleMaker = titleMaker
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

    String getDescription() {
        developer.frontMatter.description
    }

}
