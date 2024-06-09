package com.jessebrault.site.icon

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class BarsIcon extends DelegatingWebViewComponent {

    private static final String barsText = BarsIcon.getResource('Bars.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w -> w << barsText }
    }

}
