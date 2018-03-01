package org.aming.tss.base.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class CsvJobRequest extends JobRequest implements Serializable {

    private static final long serialVersionUID = 414337769458305760L;

    private String dataBaseName;
    private String csvOutPath;
    private String sender;

	public String getDataBaseName() {
		return dataBaseName;
	}

	public CsvJobRequest setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
		return this;
	}

	public String getCsvOutPath() {
		return csvOutPath;
	}

	public CsvJobRequest setCsvOutPath(String csvOutPath) {
		this.csvOutPath = csvOutPath;
		return this;
	}

	public String getSender() {
		return sender;
	}

	public CsvJobRequest setSender(String sender) {
		this.sender = sender;
		return this;
	}

	public CsvJobRequest() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
