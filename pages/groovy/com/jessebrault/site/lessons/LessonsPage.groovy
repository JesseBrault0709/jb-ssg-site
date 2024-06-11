package com.jessebrault.site.lessons

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.di.InjectTexts
import com.jessebrault.ssg.di.SelfPage
import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Lessons', path = '/lessons')
class LessonsPage extends WvcPageView {

    static final String description = 'Information about lessons offered by Jesse Brault.'

    final Page selfPage
    private final TitleMaker titleMaker
    private final Text lessonsText

    @Inject
    LessonsPage(@SelfPage Page selfPage, TitleMaker titleMaker, @InjectText('/Lessons.md') Text lessonsText) {
        this.selfPage = selfPage
        this.titleMaker = titleMaker
        this.lessonsText = lessonsText
    }

    String getPageTitle() {
        titleMaker.makeTitle(selfPage.name)
    }

    String renderLessons() {
        this.lessonsText.render()
    }

}
