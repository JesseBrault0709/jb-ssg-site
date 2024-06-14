package com.jessebrault.site.lessons

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
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
    final Text lessons
    private final TitleMaker titleMaker

    @Inject
    LessonsPage(@SelfPage Page selfPage, TitleMaker titleMaker, @InjectText('/Lessons.md') Text lessons) {
        this.selfPage = selfPage
        this.titleMaker = titleMaker
        this.lessons = lessons
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

    String renderLessons() {
        this.lessons.render()
    }

}
