package FFSE1702.autowrite;

public class Student {
	private StudentAddress address;
	 
    public StudentAddress getAddress() {
        return address;
    }
 
    public void setAddress(StudentAddress address) {
        this.address = address;
    }
 
    @Override
    public String toString() {
        return "Student [address = " + address + "]";
    }

}
