package com.jessebrault.site.biography

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Biography', path = '/')
class BiographyPage extends WvcPageView {

    final Text biography
    private final TitleMaker titleMaker

    @Inject
    BiographyPage(TitleMaker titleMaker, @InjectText('/Biography.md') Text biography) {
        this.biography = biography
        this.titleMaker = titleMaker
    }

    String renderBiography() {
        biography.render()
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
