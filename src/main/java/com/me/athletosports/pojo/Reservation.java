package com.me.athletosports.pojo;
import com.me.athletosports.Helper;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long user_id; // User
    private String date; //
    private String slot; //"9 AM to 10 AM"
    private String sportType; //SQUASH, TENNIS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = Helper.convertLongToFormattedString(date);
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    // UI Related Properties
    /*
    private String getSportTypeUI() {
        switch (this.getSportType()) {
            case "SQUASH":
                return "Squash";
            case "LAWN_TENNIS":
                return "Lawn Tennis";
            case "TABLE_TENNIS":
                return "Table Tennis";
            case "BADMINTON":
                return "Badminton";
        }
        return "";
    }*/


}

