package com.jessebrault.site.util

import groowt.view.component.web.BaseWebViewComponent

class MaybeExternalLink extends BaseWebViewComponent {

    final String href

    MaybeExternalLink(Map attr) {
        href = attr.href
    }

    Object getLinkChildren() {
        children
    }

    boolean getIsExternal() {
        !href.startsWith('https://jessebrault')
    }

}
