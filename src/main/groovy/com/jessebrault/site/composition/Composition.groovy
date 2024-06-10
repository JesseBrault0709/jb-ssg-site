package com.jessebrault.site.composition

import com.jessebrault.ssg.text.Text
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.jetbrains.annotations.Nullable

import java.time.LocalDate

@EqualsAndHashCode
@ToString
class Composition {
    Text text
    String title
    String slug
    @Nullable String subTitle
    @Nullable String version
    String instrumentation
    @Nullable String premiere
    @Nullable String pdfUrl
    Map<String, String> recordings
    Map<String, String> externalLinks
    @Nullable String shortInfo
    LocalDate date
    Set<String> categories
}
