package models;

public class Unit extends Miniature {
	int size;
	boolean hasAttachment;
	UnitAttachment attachment;
	
	public String toString() {
		String retVal = super.toString() + " unit size: " + size +" hasAttachment: " + hasAttachment + "; ";
		if(attachment != null) {
			retVal += "Attachment: " + attachment.toString();
		}
		return retVal;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public UnitAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(UnitAttachment attachment) {
		this.attachment = attachment;
	}
	
}
