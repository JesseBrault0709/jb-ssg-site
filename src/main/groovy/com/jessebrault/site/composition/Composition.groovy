package com.jessebrault.site.composition

import com.jessebrault.ssg.text.Text
import groovy.transform.EqualsAndHashCode
import groovy.transform.NullCheck
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@TupleConstructor(defaults = false)
@NullCheck(includeGenerated = true)
@EqualsAndHashCode
@ToString
class Composition {
    final Text text
    final String title
}
