package com.SpringBoot.project.Entry;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Document(collection = "BatchDetails", schemaVersion = "1.0")
public class BatchEntry implements Serializable {

    @Id
    private String id;

    private String Name;
    private int Fees;

    // Manually added because Lombok sometimes skips @Id fields
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public int getFees() { return Fees; }
    public void setFees(int fees) { this.Fees = fees; }
}