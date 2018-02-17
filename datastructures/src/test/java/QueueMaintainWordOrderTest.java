import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.InjectableStepsFactory;

public class QueueMaintainWordOrderTest extends JUnitStory {

    private StoryBuilder builder = new StoryBuilder();

    @Override
    public Configuration configuration() {
        return builder.BuildConfiguration(this.getClass());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return builder.BuildStepsFactory(configuration(), new QueueMaintainWordOrderSteps());
    }
}
