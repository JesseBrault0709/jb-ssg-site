package com.jessebrault.site.util

import groowt.view.component.web.BaseWebViewComponent
import jakarta.inject.Inject
import jakarta.inject.Named
import org.jetbrains.annotations.Nullable

class OpenGraph extends BaseWebViewComponent {

    final String title
    final String type
    final String image
    final @Nullable String description

    private final String baseUrl
    private final String path

    @Inject
    OpenGraph(@Named('baseUrl') String baseUrl, Map attr) {
        this.baseUrl = baseUrl
        title = attr.title
        type = attr.type
        image = attr.image
        description = attr.description
        path = attr.path
    }

    String getUrl() {
        baseUrl + path
    }

}
