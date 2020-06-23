package model.base;

import java.util.Optional;

import rombo.discuss.BaseAccountImplements;

public class CommentsImplements extends BaseAccountImplements implements Comments {
	
	/* Fields. */
	private final String comment;
	private Optional<String> topic = null;
	private Optional<Integer> number = null;

	/* Builder. */
	public CommentsImplements(final int iD, final Optional<String> userName, final String comment,
			final Optional<String> topic, final Optional<Integer> numberOfComment) {
		super(iD, userName);
		this.comment = comment;
		this.topic = topic;
		this.number = numberOfComment;
	}

	/* Return methods. */

	/* @Retun the comment. */
	public final String getComment() {

		return this.comment;
	}

	/*
	 * @Return a Optional about the topic, if the topic not exist return
	 * Optional.Empty.
	 */
	public final Optional<String> getTopic() {
		if (this.topic != null) {
			return this.topic;
		} else {
			return Optional.empty();
		}
	}

	/*
	 * @Return a Optional about the number of the comment, if the number of the
	 * comment is not counted return Optional.Empty.
	 */
	public final Optional<Integer> getNumberOfCommet() {
		if (this.number != null) {
			return this.number;
		} else {
			return Optional.empty();
		}
	}
}
