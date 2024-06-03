package com.jessebrault.site

import groowt.view.component.web.BaseWebViewComponent

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StandardPage extends BaseWebViewComponent {

    final String title

    StandardPage(Map attr) {
        this.title = attr.title
    }

    List getPageChildren() {
        this.children
    }

    String getCopyrightYear() {
        LocalDate.now().format(DateTimeFormatter.ofPattern('yyyy'))
    }

}
