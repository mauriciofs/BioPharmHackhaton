package com.medtrack.medtrack;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mauriciofs on 17/09/16.
 */
public class Resource {
    public int id;
    public String name;
    public String created_at;
    public String description;

    @Override
    public String toString() {
        return created_at + "\n" + name + "\n" + description;
    }
}
