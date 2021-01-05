CodeQuality Plugin
========================

Basic plugin to abstract company wide CodeQuality configuration.

Basic functionality of this plugin are:
- This plugin reuse checkstyle plugin and inject the checkstyle task ans checkstyleMain + pmdMain to execute Checkstyle and pmd on an android project so there is no need of additional configuration.
- Included in the jar and use as configuration includes the checkstyle.xml, supressions.xml and java.xml

Usage
-----

You can place this in your root build.gradle or you app build.gradle.

Build script snippet for use in all Gradle versions:

```
buildscript {
    repositories {
         mavenLocal()
    }
    dependencies {
         classpath 'com.currencycloud:checkstyle-plugin:1.57'
    }
}

repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'com.currencycloud.checkstyle-plugin'

```

Build script snippet for new, incubating, plugin mechanism introduced in Gradle 2.1:

```
plugins {
  id "om.currencycloud.checkstyle-plugin" version "1.57"
}
```


## Overview

### US Link


### Type of change
- [ ] Bug fix (non-breaking change which fixes an issue)
- [x] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] Refactoring
- [ ] This change requires a documentation update

### What is the solution?
Creates the plugin so that checkstyle and pmd are used across projects
simply by including the plugin

### What are the main changes this MR?
Creates plugin, adds checkstyle, suppression and pmd convenctions to the resources


## Reviewing

### Which order of files makes the most sense for the reviewer?
CheckstylePlugin

## Other Notes
we added:

~~~
<module name="SuppressionFilter">
        <property name="file" value="${suppressionFile}" default="suppressions.xml"/>
    </module>
~~~

in order to override the suppression xml file in order to be able to load it in any project
