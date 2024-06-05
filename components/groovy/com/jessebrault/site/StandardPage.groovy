package com.jessebrault.site


import groowt.view.component.web.BaseWebViewComponent
import groowt.view.component.web.WebViewComponent
import org.jetbrains.annotations.Nullable

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StandardPage extends BaseWebViewComponent {

    final String title
    final Closure<WebViewComponent> banner

    StandardPage(Map attr) {
        this.title = attr.title
        this.banner = attr.banner ?: { '' }
    }

    List getMainChildren() {
        this.children
    }

    String getCopyrightYear() {
        LocalDate.now().format(DateTimeFormatter.ofPattern('yyyy'))
    }

}
