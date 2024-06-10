package com.jessebrault.site

import groowt.view.component.web.BaseWebViewComponent
import org.jetbrains.annotations.Nullable

class Head extends BaseWebViewComponent {

    final String title
    final @Nullable String description
    final Object openGraph

    Head(Map attr) {
        title = attr.title
        description = attr.description
        openGraph = attr.openGraph?.call() ?: ''
    }

}
