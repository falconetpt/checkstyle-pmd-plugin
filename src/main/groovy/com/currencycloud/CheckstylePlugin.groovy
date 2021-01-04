package com.currencycloud

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.plugins.quality.PmdPlugin
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CheckstylePlugin implements Plugin<Project> {

    final Logger log = LoggerFactory.getLogger('TengioCheckstylePlugin')

    void apply(Project project) {
        log.debug("Applying TengioCheckstylePlugin to " + project)
        project.extensions.create("ExtensionCheckstyle", CheckstylePluginExtension)
        project.plugins.withType(org.gradle.api.plugins.quality.CheckstylePlugin) {
            project.checkstyle {
                toolVersion = "8.38"
                config = project.resources.text.fromString(getClass().getResourceAsStream("checkstyle.xml").text)
                configProperties = [ "suppressionFile" : project.file(project.resources.text.fromString(getClass().getResourceAsStream("suppressions.xml").text))]
            }
        }

        project.plugins.withType(PmdPlugin) {
            project.pmd {
                consoleOutput = true
                toolVersion = "6.30.0"
                ruleSetConfig = project.resources.text.fromString(getClass().getResourceAsStream("java.xml").text)
            }
        }

        project.pluginManager.apply('checkstyle')
        project.pluginManager.apply('pmd')

        if(!project.pluginManager.hasPlugin('checkstyle')) {
            throw new RuntimeException("Didn't apply checkstyle plugin");  
        }

        if(!project.pluginManager.hasPlugin('pmd')) {
            throw new RuntimeException("Didn't apply pmd plugin");
        }

        log.debug(project.tasks.toString())
    }

    def boolean hasTask(Project project, String taskName) {
        try {
            project.tasks.getByName(taskName)
            return true
        } catch(Exception e) {
            return false
        }
    }
}

class CheckstylePluginExtension {
    // for now not used
}