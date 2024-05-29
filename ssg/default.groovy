import com.jessebrault.ssg.buildscript.BuildScriptBase
import groovy.transform.BaseScript
import com.jessebrault.site.util.TitleMaker

import static groowt.util.di.BindingUtil.toSingleton

@BaseScript
BuildScriptBase base

build {
    siteName 'Jesse R. Brault'
    baseUrl 'https://jessebrault.com'
    objectFactoryBuilder.configure {
        configureRegistry {
            bind(TitleMaker, toSingleton(new TitleMaker(siteName)))
        }
    }
}
