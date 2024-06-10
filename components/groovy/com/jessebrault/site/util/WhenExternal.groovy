package com.jessebrault.site.util

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.runtime.DefaultComponentWriter
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class WhenExternal extends DelegatingWebViewComponent {

    private final String href
    private final Closure render

    WhenExternal(Map attr) {
        href = attr.href
        render = attr.render
    }

    @Override
    protected View getDelegate() {
        return { Writer w ->
            if (href.startsWith('https://')) {
                def cw = new DefaultComponentWriter(w, context.renderContext, context)
                cw << render.call()
            }
        }
    }

}
