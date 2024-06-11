package com.jessebrault.site.videos

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
import com.jessebrault.ssg.di.InjectTexts
import com.jessebrault.ssg.di.SelfPage
import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Videos', path = '/videos')
class VideosPage extends WvcPageView {

    static final String description = 'Conducting videos of Jesse Brault.'

    final Page selfPage
    private final TitleMaker titleMaker
    private final Text videosText

    @Inject
    VideosPage(@SelfPage Page selfPage, TitleMaker titleMaker, @InjectText('/Videos.md') Text videosText) {
        this.selfPage = selfPage
        this.titleMaker = titleMaker
        this.videosText = videosText
    }

    String getPageTitle() {
        titleMaker.makeTitle(selfPage.name)
    }

    String renderVideos() {
        videosText.render()
    }

}
