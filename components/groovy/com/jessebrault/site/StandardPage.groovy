package com.jessebrault.site

import groowt.view.component.web.BaseWebViewComponent

class StandardPage extends BaseWebViewComponent {

    final String title

    StandardPage(Map attr) {
        this.title = attr.title
    }

    List getPageChildren() {
        this.children
    }

}
