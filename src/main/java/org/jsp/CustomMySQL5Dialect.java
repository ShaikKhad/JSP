package org.jsp;

import org.hibernate.dialect.MySQL5Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMySQL5Dialect extends MySQL5Dialect {
    private static final Logger log = LoggerFactory.getLogger(CustomMySQL5Dialect.class);

    public CustomMySQL5Dialect() {
        log.info("CustomMySQL5Dialect initialized");
    }

    @Override
    public String getTableTypeString() {
        log.info("Using custom table type string: ENGINE=MyISAM");
        return " ENGINE=MyISAM";
    }
}
