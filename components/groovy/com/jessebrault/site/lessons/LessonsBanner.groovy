package com.jessebrault.site.lessons

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class LessonsBanner extends DelegatingWebViewComponent {

    private static final String lessonsBannerText = LessonsBanner.getResource('LessonsBanner.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w -> w << lessonsBannerText }
    }

}
