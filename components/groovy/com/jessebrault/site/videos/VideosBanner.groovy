package com.jessebrault.site.videos

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class VideosBanner extends DelegatingWebViewComponent {

    private static final String videosBannerText = VideosBanner.getResource('VideosBanner.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w -> w << videosBannerText }
    }

}
