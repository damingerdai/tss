package org.aming.tss.base.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class JobRequest implements Serializable {

    private static final long serialVersionUID = 414337769458305760L;

    /**
     * 任务编码，表明任务的类型
     */
    private String jobCode;
    /**
     * 任务组
     */
    private String jobGroup;
    /**
     * cron表达式
      */
    private String cronExpression;
    /**
     * 数据源
     */
    private String dataBaseName;
    /**
     * csv文件输出路径
     */
    private String csvOutPath;

    public String getJobCode() {
        return jobCode;
    }

    public JobRequest setJobCode(String jobCode) {
        this.jobCode = jobCode;
        return this;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public JobRequest setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
        return this;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public JobRequest setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
        return this;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public JobRequest setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
        return this;
    }

    public String getCsvOutPath() {
        return csvOutPath;
    }

    public JobRequest setCsvOutPath(String csvOutPath) {
        this.csvOutPath = csvOutPath;
        return this;
    }

    public JobRequest() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
