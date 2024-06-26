package com.jessebrault.site

import com.jessebrault.ssg.di.Global
import groowt.view.component.web.BaseWebViewComponent
import groowt.view.component.web.WebViewComponent
import jakarta.inject.Inject
import org.jetbrains.annotations.Nullable

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StandardPage extends BaseWebViewComponent {

    final String spotifyUrl
    final String youtubeUrl
    final String title
    final @Nullable String description
    final @Nullable Closure<WebViewComponent> openGraph
    final Closure<WebViewComponent> banner
    final List<String> pageScripts

    @Inject
    StandardPage(@Global('spotifyUrl') String spotifyUrl, @Global('youtubeUrl') String youtubeUrl, Map attr) {
        this.spotifyUrl = spotifyUrl
        this.youtubeUrl = youtubeUrl
        this.title = attr.title
        this.description = attr.description
        this.openGraph = attr.openGraph
        this.banner = attr.banner ?: { '' }
        this.pageScripts = attr.pageScripts ?: []
    }

    List getMainChildren() {
        this.children
    }

    String getCopyrightYear() {
        LocalDate.now().format(DateTimeFormatter.ofPattern('yyyy'))
    }

}
