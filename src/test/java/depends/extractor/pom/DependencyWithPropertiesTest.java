package depends.extractor.pom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import depends.deptypes.DependencyType;

public class DependencyWithPropertiesTest extends MavenParserTest{
    @Before
    public void setUp() {
    	super.init();
    }
	
	@Test
	public void should_extract_dep_relation() throws IOException {
	    String[] srcs = new String[] {
	    		"./src/test/resources/maven-code-examples/dependencyWithProperties/from.pom",
	    		"./src/test/resources/maven-code-examples/dependencyWithProperties/to.pom",
	    	    };
	    
	    for (String src:srcs) {
		    PomFileParser parser = createParser(src);
		    parser.parse();
	    }
	    inferer.resolveAllBindings();
	    this.assertContainsRelation(repo.getEntity("testgroup.test_1.0_"), DependencyType.CONTAIN, "a-dep-group.a-artifact_0.2_");
	}
	
	@Test
	public void should_extract_plugin_relation() throws IOException {
	    String[] srcs = new String[] {
	    		"./src/test/resources/maven-code-examples/dependencyWithProperties/from.pom",
	    		"./src/test/resources/maven-code-examples/dependencyWithProperties/plugin.pom",
	    	    };
	    
	    for (String src:srcs) {
		    PomFileParser parser = createParser(src);
		    parser.parse();
	    }
	    inferer.resolveAllBindings();
	    this.assertContainsRelation(repo.getEntity("testgroup.test_1.0_"), DependencyType.USE, "aplugins.aplugin_0.1_");
	}
	
	
}