package net.vidageek.games.regex.task;

import java.util.regex.Pattern;

import net.vidageek.games.task.JudgedTask;
import net.vidageek.games.task.Task;

final public class PerfectMatchRegexTask implements Task {

	private final int index;
	private final String matchingTarget;

	public PerfectMatchRegexTask(final String matchingTarget, final int index) {
		this.matchingTarget = matchingTarget;
		this.index = index;
	}

	public JudgedTask judge(final String challenge) {
		try {
			if (Pattern.compile(challenge).matcher(matchingTarget).matches()) {
				return new Ok();
			}
			return new Failed("[" + challenge + "] não dá match em [" + matchingTarget + "]");
		} catch (Exception e) {
			return new Error(e);
		}
	}

	public String getDescription() {
		return "Matching simples de letras";
	}

	public String getChallenge() {
		return "Qual regex dá match em [" + matchingTarget + "]?";
	}

	public int getIndex() {
		return index;
	}

}
