package com.jessebrault.site.biography

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class BiographyBanner extends DelegatingWebViewComponent {

    private static final String biographyBannerSrc = BiographyBanner.getResource('BiographyBanner.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w -> w << biographyBannerSrc }
    }

}
