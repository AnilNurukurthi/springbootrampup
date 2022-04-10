package com.data;

import java.util.Objects;

public class Item {
    private Integer Id;
    private String Name;
    private Integer Value;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(Id, item.Id) && Objects.equals(Name, item.Name) && Objects.equals(Value, item.Value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Value);
    }
}
