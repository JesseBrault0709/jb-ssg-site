package com.jessebrault.site

import groowt.view.component.web.BaseWebViewComponent

class Head extends BaseWebViewComponent {

    final String title
    final Object openGraph

    Head(Map attr) {
        title = attr.title
        openGraph = attr.openGraph?.call() ?: ''
    }

}
