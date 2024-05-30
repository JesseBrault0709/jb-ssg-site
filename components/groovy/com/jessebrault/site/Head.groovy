package com.jessebrault.site

import groowt.view.component.web.BaseWebViewComponent

class Head extends BaseWebViewComponent {

    final String title

    Head(Map attr) {
        title = attr.title
    }

}
