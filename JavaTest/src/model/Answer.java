package model;

public class Answer {

	private int id;
	private String content;
	private boolean isCorrect;
	
	public Answer(int id, String content, boolean isCorrect) {
		this.id = id;
		this.content = content;
		this.isCorrect = isCorrect;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + ", isCorrect=" + isCorrect;
	}
	
	
}