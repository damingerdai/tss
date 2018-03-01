package org.aming.tss.base.ds;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/27.
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -3363342528062113856L;

	private int pageSize;
	private int pageNo;

	public void next() {
		pageNo++;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPage() {
		return (pageNo -1) * pageSize;
	}

	public Page(int pageSize) {
		super();
		this.pageSize = pageSize;
		this.pageNo = 1;
	}


}
