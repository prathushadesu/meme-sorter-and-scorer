package com.comcast.dto;

/**
 * DTO that holds the properties that defines a meme.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public class Meme {

	private String name;
	private Integer lulzScore;

	public Meme(){
		
	}
	
	/**
	 * @param name
	 * @param lulzScore
	 */
	public Meme(String name, Integer lulzScore) {
		super();
		this.name = name;
		this.lulzScore = lulzScore;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lulzScore
	 */
	public Integer getLulzScore() {
		return lulzScore;
	}

	/**
	 * @param lulzScore
	 *            the lulzScore to set
	 */
	public void setLulzScore(Integer lulzScore) {
		this.lulzScore = lulzScore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meme [name=");
		builder.append(name);
		builder.append(", lulzScore=");
		builder.append(lulzScore);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lulzScore == null) ? 0 : lulzScore.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meme other = (Meme) obj;
		if (lulzScore == null) {
			if (other.lulzScore != null)
				return false;
		} else if (!lulzScore.equals(other.lulzScore))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
