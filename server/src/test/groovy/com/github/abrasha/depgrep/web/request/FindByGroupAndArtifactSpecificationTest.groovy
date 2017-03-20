package com.github.abrasha.depgrep.web.request

import com.github.abrasha.depgrep.service.specification.FindByGroupAndArtifactSpecification
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andrii Abramov on 3/11/17.
 */
class FindByGroupAndArtifactSpecificationTest extends Specification {

    @Unroll
    def "test creating composite specification"() {

        when:
        def spec = new FindByGroupAndArtifactSpecification(group, artifact)

        then:
        spec.query == expected

        where:
        group   | artifact  || expected
        'group' | 'guice'   || 'g:group+AND+a:guice'
        'group' | 'asd.asd' || 'g:group+AND+a:asd.asd'
        'group' | 'qwe:qwe' || 'g:group+AND+a:qwe:qwe'
        'group' | 'asd-asd' || 'g:group+AND+a:asd-asd'

    }

}
