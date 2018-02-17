import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class StoryBuilder {

    protected Configuration BuildConfiguration(Class c) {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(c)
                )
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.ANSI_CONSOLE, Format.TXT)
                );
    }

    protected InjectableStepsFactory BuildStepsFactory(Configuration c, Object steps) {
        return new InstanceStepsFactory(c, steps);
    }
}
