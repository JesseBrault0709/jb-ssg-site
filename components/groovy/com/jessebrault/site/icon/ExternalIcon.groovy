package com.jessebrault.site.icon

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class ExternalIcon extends DelegatingWebViewComponent {

    private static final String externalText = ExternalIcon.getResource('External.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w -> w << externalText }
    }

}
