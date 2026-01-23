package core.drivers.browseroptions;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeOptionsProvider implements BrowserOptionsProvider{
    @Override
    public EdgeOptions getBrowserOptions() {
        EdgeOptions options = new EdgeOptions();
        return options;
    }
}
