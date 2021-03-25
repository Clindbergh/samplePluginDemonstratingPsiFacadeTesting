package console;

import apackage.Finder;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

public class FinderTest extends LightJavaCodeInsightFixtureTestCase {

    public FinderTest() {
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/resources";
    }

    public void testMethodFound() {
        // Arrange
        final Finder finder = new Finder(getProject());

        // Act
        final boolean methodFound = finder.methodFound("sampleMethod");

        // Assert
        assertTrue(methodFound);
    }

    public void testClassFound() {
        // Arrange
        final Finder finder = new Finder(getProject());

        // Act
        final boolean classFound = finder.classFound("SampleClass");

        // Assert
        assertTrue(classFound);
    }

    public void test() {
        // Arrange
        final Finder finder = new Finder(getProject());

        // Act
        final boolean methodFound = finder.qualifiedClassFound("sampleMethod");

        // Assert
        assertTrue(methodFound);
    }

}