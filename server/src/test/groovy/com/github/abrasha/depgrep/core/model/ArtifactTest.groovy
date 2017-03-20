package com.github.abrasha.depgrep.core.model

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andrii Abramov on 3/20/17.
 */
class ArtifactTest extends Specification {

    @Unroll
    def "should make valid group id"() {
        when: "create new artifact"
        def a = new Artifact()
        a.group = group
        a.artifact = artifact
        then: "should match artifact id"
        a.artifactId == expected
        where:
        group         | artifact      | expected
        'g'           | 'a'           | 'g:a'
        'com-example' | 'a'           | 'com-example:a'
        'random'      | 'a'           | 'random:a'
        'com_example' | 'a'           | 'com_example:a'
        'g'           | 'com_example' | 'g:com_example'
        'g'           | 'com-example' | 'g:com-example'
        'g'           | 'a'           | 'g:a'
    }
}
