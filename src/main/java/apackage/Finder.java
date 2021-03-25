package apackage;

import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScopeBuilderImpl;
import com.intellij.psi.search.PsiShortNamesCache;
import org.jetbrains.annotations.NotNull;

public class Finder {

    private final JavaPsiFacade psiFacade;
    private final PsiShortNamesCache shortNamesCache;
    private final @NotNull GlobalSearchScope globalSearchScope;

    public Finder(final Project project) {
        globalSearchScope = new ProjectScopeBuilderImpl(project).buildProjectScope();
        psiFacade = JavaPsiFacade.getInstance(project);
        shortNamesCache = PsiShortNamesCache.getInstance(project);
    }

    public boolean methodFound(String methodName) {
        return shortNamesCache.getMethodsByName(methodName, this.globalSearchScope).length > 0;
    }

    public boolean classFound(String className) {
        return shortNamesCache.getClassesByName(className, this.globalSearchScope).length > 0;
    }

    public boolean qualifiedClassFound(String className) {
        return psiFacade.findClass(className, this.globalSearchScope) != null;
    }
}
