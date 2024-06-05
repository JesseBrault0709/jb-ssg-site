package com.jessebrault.site.biography

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Biography', path = '/biography')
class BiographyPage extends WvcPageView {

    private final TitleMaker titleMaker
    private final Text biography

    @Inject
    BiographyPage(TitleMaker titleMaker, @InjectText('/Biography.md') Text biography) {
        this.titleMaker = titleMaker
        this.biography = biography
    }

    String renderBiography() {
        biography.render()
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
