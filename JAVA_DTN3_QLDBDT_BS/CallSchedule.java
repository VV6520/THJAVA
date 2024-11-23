package JAVA_DTN3_QLDBDT_BS;

import java.util.Date;

public class CallSchedule {
    private String contactName;
    private Date callTime;

    public CallSchedule(String contactName, Date callTime) {
        this.contactName = contactName;
        this.callTime = callTime;
    }

    public String getContactName() {
        return contactName;
    }

    public Date getCallTime() {
        return callTime;
    }
    
    public void displaySchedule() {
        System.out.println("Liên hệ: " + contactName + ", Thời gian: " + callTime);
    }
}