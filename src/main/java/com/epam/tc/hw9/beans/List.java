package com.epam.tc.hw9.beans;

import com.google.gson.annotations.SerializedName;

public class List {
    @SerializedName("id")
    private String id;
    @SerializedName("cards")
    private String cards;
    @SerializedName("card_fields")
    private String cardFields;
    @SerializedName("filter")
    private String filter;
    @SerializedName("fields")
    private String fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public String getCardFields() {
        return cardFields;
    }

    public void setCardFields(String cardFields) {
        this.cardFields = cardFields;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
