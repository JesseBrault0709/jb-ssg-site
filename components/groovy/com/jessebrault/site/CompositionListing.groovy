package com.jessebrault.site

import com.jessebrault.site.composition.Composition
import groowt.view.component.web.BaseWebViewComponent

import java.time.format.DateTimeFormatter

class CompositionListing extends BaseWebViewComponent {

    final Composition composition

    CompositionListing(Composition composition) {
        this.composition = composition
    }

    String renderDate() {
        composition.date.format(DateTimeFormatter.ofPattern('yyyy'))
    }

}
