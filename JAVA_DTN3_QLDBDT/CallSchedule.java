package JAVA_DTN3_QLDBDT;

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
}