package com.epam.tc.hw9.beans;

import com.google.gson.annotations.SerializedName;

public class TrelloList {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("pos")
    private String pos;
    @SerializedName("closed")
    private String closed;
    @SerializedName("idBoard")
    private String idBoard;
    @SerializedName("subscribed")
    private String subscribed;
    @SerializedName("softLimit")
    private String softLimit;

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    public String getSoftLimit() {
        return softLimit;
    }

    public void setSoftLimit(String softLimit) {
        this.softLimit = softLimit;
    }

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
        sb.append(TrelloBoard.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null) ? "<null>" : this.closed));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null) ? "<null>" : this.pos));
        sb.append(',');
        sb.append("softLimit");
        sb.append('=');
        sb.append(((this.softLimit == null) ? "<null>" : this.softLimit));
        sb.append(',');
        sb.append("idBoard");
        sb.append('=');
        sb.append(((this.idBoard == null) ? "<null>" : this.idBoard));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null) ? "<null>" : this.subscribed));
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
        if (!(object instanceof TrelloBoard)) {
            return false;
        }
        TrelloList rhs = ((TrelloList) object);
        return ((((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))
                && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.closed == rhs.closed) || ((this.closed != null) && this.closed.equals(rhs.closed)))
                && ((this.pos == rhs.pos) || ((this.pos != null) && this.pos.equals(rhs.pos)))
                && ((this.softLimit == rhs.softLimit) || ((this.softLimit != null)
                && this.softLimit.equals(rhs.softLimit)))
                && ((this.idBoard == rhs.idBoard) || ((this.idBoard != null) && this.idBoard.equals(rhs.idBoard)))
                && ((this.subscribed == rhs.subscribed) || ((this.subscribed != null)
                && this.subscribed.equals(rhs.subscribed)))));
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.closed == null) ? 0 : this.closed.hashCode()));
        result = ((result * 31) + ((this.pos == null) ? 0 : this.pos.hashCode()));
        result = ((result * 31) + ((this.softLimit == null) ? 0 : this.softLimit.hashCode()));
        result = ((result * 31) + ((this.idBoard == null) ? 0 : this.idBoard.hashCode()));
        result = ((result * 31) + ((this.subscribed == null) ? 0 : this.subscribed.hashCode()));
        return result;
    }
}
