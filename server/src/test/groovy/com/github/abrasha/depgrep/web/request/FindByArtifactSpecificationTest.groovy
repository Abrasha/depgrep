package com.github.abrasha.depgrep.web.request

import com.github.abrasha.depgrep.service.specification.impl.FindByArtifactSpecification
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andrii Abramov on 3/11/17.
 */
class FindByArtifactSpecificationTest extends Specification {

    @Unroll
    def "test creating artifact specification"() {

        when:
        def spec = new FindByArtifactSpecification(artifact)

        then:
        spec.query == expected

        where:
        artifact  || expected
        'guice'   || 'a:guice'
        'asd.asd' || 'a:asd.asd'
        'qwe_qwe' || 'a:qwe_qwe'
        'asd-asd' || 'a:asd-asd'

    }
}
