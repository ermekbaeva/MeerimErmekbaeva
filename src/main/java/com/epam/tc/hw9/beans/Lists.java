package com.epam.tc.hw9.beans;

import com.google.gson.annotations.SerializedName;

public class Lists {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("pos")
    private String pos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Board.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null) ? "<null>" : this.pos));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Board)) {
            return false;
        }
        Lists rhs = ((Lists) object);
        return ((((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))
                && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.pos == rhs.pos) || ((this.pos != null) && this.pos.equals(rhs.pos)))));
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.pos == null) ? 0 : this.pos.hashCode()));
        return result;
    }
}
