package org.soluvas.commons;

import java.util.List;

import org.fusesource.jansi.Ansi;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 *
 */
public class NameUtils {
	
	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClass(final String name, final int targetLength) {
		String current = name;
		if (current.length() <= targetLength)
			return current;
		// Split into segments
		final List<String> split = Lists.newArrayList(Splitter.on('.').split(name));
		// get rid of first to third-from-last segment
		for (int i = 0; i < split.size() - 2; i++) {
			split.set(i, split.get(i).substring(0, 1));
			current = Joiner.on('.').join(split);
			if (current.length() <= targetLength)
				return current;
		}
		// last resort, force cut then replace with ellipsis
		return "…" + current.substring(current.length() - targetLength + 1);
	}
	
	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * 
	 * The result is right-padded with space and contain {@link Ansi}-style color instructions.
	 * 
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClassAnsi(final String name, final int targetLength) {
		final String shortened = shortenClass(name, targetLength);
		final String padding = Strings.repeat(" ", targetLength - shortened.length());
		return formatClassAnsi(shortened) + padding;
	}
	
	/**
	 * Format a class name as {@link Ansi}-style color codes.
	 * @param name
	 * @return
	 */
	public static String formatClassAnsi(final String name) {
		// Split into segments
		final List<String> split = Lists.newArrayList(Splitter.on('.').split(name));
		split.set(split.size() - 1, "@|bold " + split.get(split.size() - 1) + "|@");
//		final List<String> highlight = Lists.transform(split, new Function<String, String>() {
//			@Override
//			@Nullable
//			public String apply(@Nullable String input) {
//				if (input.substring(0, 1).equals("…")) {
//					return "@|bold,black …|@@|bold " + input.substring(1) + "|@";
//				} else {
//					return "@|bold " + input + "|@";
//				}
//			}
//		});
		return Joiner.on("@|bold,black .|@").join(split).replaceFirst("…", "@|bold,black …|@");
	}

}