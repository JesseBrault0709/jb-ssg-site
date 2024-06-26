package com.jessebrault.site.videos

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectText
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
    final Text videos
    private final TitleMaker titleMaker

    @Inject
    VideosPage(@SelfPage Page selfPage, TitleMaker titleMaker, @InjectText('/Videos.md') Text videos) {
        this.selfPage = selfPage
        this.titleMaker = titleMaker
        this.videos = videos
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

    String renderVideos() {
        videos.render()
    }

}
