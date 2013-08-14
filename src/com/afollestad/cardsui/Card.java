package com.afollestad.cardsui;

import android.content.Context;
import android.view.MenuItem;
import com.afollestad.silk.cache.SilkComparable;

/**
 * @author Aidan Follestad (afollestad)
 */
public class Card implements SilkComparable<Card> {

    protected Card() {
    }

    protected Card(String title, boolean isHeader) {
        this.title = title;
        this.isHeader = isHeader;
    }

    public Card(Context context, int titleRes, String content) {
        this.title = context.getString(titleRes);
        this.content = content;
    }

    public Card(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public interface CardMenuListener {
        public void onMenuItemClick(Card card, MenuItem item);
    }

    private String title;
    private String content;
    private boolean isHeader;
    private int mPopupMenu;
    private CardMenuListener mPopupListener;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public int getPopupMenu() {
        return mPopupMenu;
    }

    public CardMenuListener getPopupListener() {
        return mPopupListener;
    }

    public Card setPopupMenu(int menuRes, CardMenuListener listener) {
        mPopupMenu = menuRes;
        mPopupListener = listener;
        return this;
    }

    @Override
    public boolean isSameAs(Card another) {
        boolean equal = getTitle().equals(another.getTitle()) &&
                isHeader() == another.isHeader();
        if (getContent() != null) equal = equal && getContent().equals(another.getContent());
        return equal;
    }

    @Override
    public boolean shouldIgnore() {
        return isHeader;
    }
}