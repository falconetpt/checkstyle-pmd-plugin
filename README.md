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
