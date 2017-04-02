package org.qamation.jmeter.config.data.provider.excel;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.beans.PropertyDescriptor;

/**
 * Created by Pavel.Gouchtchine on 03/10/2017.
 */
public class ExcelDataProviderBeanInfo extends BeanInfoSupport {

    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final String FILENAME = "fileName";

    protected ExcelDataProviderBeanInfo() {
        super(ExcelDataProvider.class);

        log.info("Bean Info super is done.");
        log.info("creating group");
        createPropertyGroup("file_properties", new String[] {FILENAME});

        PropertyDescriptor p = property(FILENAME);
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "<ENTER FILE NAME HERE>");
        p.setValue(NOT_EXPRESSION,Boolean.TRUE);

    }


}
