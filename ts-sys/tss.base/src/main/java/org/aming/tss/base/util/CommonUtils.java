package org.aming.tss.base.util;

import java.util.List;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/2/26.
 */
public class CommonUtils {

	public static boolean isEmpty(List<?> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return true;
		}
		return false;
	}
}
