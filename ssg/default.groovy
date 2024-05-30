import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.buildscript.BuildScriptBase
import groovy.transform.BaseScript

import static groowt.util.di.BindingUtil.toSelf

@BaseScript
BuildScriptBase base

build {
    siteName 'Jesse R. Brault'
    baseUrl 'https://jessebrault.com'
    objectFactoryBuilder.configure {
        configureRegistry {
            bind(TitleMaker, toSelf())
        }
    }
}
