package com.github.abrasha.depgrep.web.request

import com.github.abrasha.depgrep.service.specification.FindByQuerySpecification
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andrii Abramov on 3/11/17.
 */
class FindByQuerySpecificationTest extends Specification {

    @Unroll
    def "test creating composite specification"() {

        when:
        def spec = new FindByQuerySpecification(query)

        then:
        spec.query == expected

        where:
        query     || expected
        '123'     || '123'
        'qwe-qwe' || 'qwe-qwe'
        'qwe.qwe' || 'qwe.qwe'
        'qwe+qwe' || 'qwe+qwe'

    }

}
