package org.sakuli.example.linux;

import org.sakuli.actions.environment.Application;
import org.sakuli.actions.logging.Logger;
import org.sakuli.example.AbstractSakuliUiTest;
import org.sakuli.exceptions.SakuliException;

public abstract class AbstractSakuliLinuxTest extends AbstractSakuliUiTest {

    @Override
    protected Application getEditorApp() {
        return new Application("gedit");
    }

    @Override
    protected Application getCalculatorApp() {
        return new Application("gnome-calculator");
    }

    @Override
    protected boolean isTargetEnvironment() {
        final String distro = getDistroName();
        try {
            if (env.runCommand("cat /etc/lsb-release", false).getOutput()
                    .contains(distro)) {
                Logger.logInfo("Execute test under " + distro);
                return true;
            }
            Logger.logWarning("Skip test: " + this.getClass().getSimpleName());
        } catch (SakuliException e) {
            //just log
            e.printStackTrace();
        }
        return false;

    }

    protected abstract String getDistroName();

}
