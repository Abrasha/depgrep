package com.github.abrasha.depgrep.web.request

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
        'guice'   || 'a:"guice"'
        'asd.asd' || 'a:"asd.asd"'
        'qwe:qwe' || 'a:"qwe:qwe"'
        'asd-asd' || 'a:"asd-asd"'

    }

}
