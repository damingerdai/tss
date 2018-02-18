package org.aming.tss.base.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class JobRequest implements Serializable {

    private static final long serialVersionUID = 414337769458305760L;


    public JobRequest() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
