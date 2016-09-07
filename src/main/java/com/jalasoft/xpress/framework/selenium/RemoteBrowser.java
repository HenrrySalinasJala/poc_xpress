package com.jalasoft.xpress.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import com.jalasoft.xpress.framework.util.Environment;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteBrowser implements IDriver {

    private static final Logger LOGGER = Logger.getLogger(RemoteBrowser.class.getSimpleName());

    private static final Environment PROPERTIES_INFO = Environment.getInstance();

    private static final String CAPABILITY_NAME = "name";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, PROPERTIES_INFO.getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, PROPERTIES_INFO.getBrowserVersion());
        caps.setCapability(CapabilityType.PLATFORM, PROPERTIES_INFO.getPlatform());
        caps.setCapability(CAPABILITY_NAME, PROPERTIES_INFO.getRemoteTestName());
        final String remoteTestHostUri = String.format(PROPERTIES_INFO.getRemoteTestHostUrl(),
                PROPERTIES_INFO.getRemoteUser(), PROPERTIES_INFO.getRemoteAccessKey());
        URL url = null;
        try {
            url = new URL(remoteTestHostUri);
        } catch (MalformedURLException e) {
            LOGGER.warn("The url is not correct" + e);
        }
        return new RemoteWebDriver(url, caps);
    }
}
