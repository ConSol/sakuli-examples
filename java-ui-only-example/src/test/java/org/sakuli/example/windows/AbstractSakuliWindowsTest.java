package org.sakuli.example.windows;

import org.apache.commons.exec.OS;
import org.sakuli.actions.environment.Application;
import org.sakuli.example.AbstractSakuliUiTest;

public abstract class AbstractSakuliWindowsTest extends AbstractSakuliUiTest {

    @Override
    protected Application getEditorApp() {
        return new Application("notepad");
    }

    @Override
    protected Application getCalculatorApp() {
        return new Application("calc");
    }

    @Override
    protected boolean isTargetEnvironment() {
        return OS.isFamilyWindows() && System.getProperty("os.name", "").contains(getWinIdentifier());
//        final String distro = getWinIdentifier();
//        try {
//            if (env.runCommand("cat /etc/lsb-release", false).getOutput()
//                    .contains(distro)) {
//                Logger.logInfo("Execute test under " + distro);
//                return true;
//            }
//            Logger.logWarning("Skip test: " + this.getClass().getSimpleName());
//        } catch (SakuliException e) {
//            //just log
//            e.printStackTrace();
//        }
//        return false;

    }

    protected abstract String getWinIdentifier();

}
