package com.wiley.frommers.digester;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration("/feedContext.xml")
public abstract class AbstractFeedTest extends
        AbstractJUnit38SpringContextTests {

}
