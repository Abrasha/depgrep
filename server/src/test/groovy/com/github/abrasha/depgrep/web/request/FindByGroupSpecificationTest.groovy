package com.github.abrasha.depgrep.web.request

import com.github.abrasha.depgrep.service.specification.impl.FindByGroupSpecification
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Andrii Abramov on 3/11/17.
 */
class FindByGroupSpecificationTest extends Specification {

    @Unroll
    def "test creating group specification"() {

        when:
        def spec = new FindByGroupSpecification(groupId)

        then:
        spec.query == expected

        where:
        groupId   || expected
        'guice'   || 'g:guice'
        'asd.asd' || 'g:asd.asd'
        'qwe:qwe' || 'g:qwe:qwe'
        'asd-asd' || 'g:asd-asd'

    }

}
