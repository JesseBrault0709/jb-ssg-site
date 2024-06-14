package com.jessebrault.site.resume

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.di.SelfPage
import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Résumé', path = '/resume')
class ResumePage extends WvcPageView {

    final Text resume
    final Page selfPage
    private final TitleMaker titleMaker

    @Inject
    ResumePage(@InjectText('/Resume.md') Text resume, TitleMaker titleMaker, @SelfPage Page selfPage) {
        this.resume = resume
        this.titleMaker = titleMaker
        this.selfPage = selfPage
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

    String getDescription() {
        resume.frontMatter.description
    }

}
