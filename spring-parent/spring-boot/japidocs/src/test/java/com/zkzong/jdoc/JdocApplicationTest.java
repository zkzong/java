package com.zkzong.jdoc;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.junit.Test;

public class JdocApplicationTest {

    @Test
    public void main() {
        DocsConfig docsConfig = new DocsConfig();
        docsConfig.setProjectPath("/code/spring-parent/spring-boot/japidocs");
        docsConfig.setApiVersion("V1.0");
        docsConfig.setAutoGenerate(Boolean.TRUE);
        docsConfig.setDocsPath("/code/spring-parent/spring-boot/japidocs/");
        Docs.buildHtmlDocs(docsConfig);
    }

}