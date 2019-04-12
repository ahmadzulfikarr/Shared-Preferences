package com.zulfikar.notesapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Data {

    private static List<User> users;
    private static List<Note> notes;

    static {
        users = new ArrayList<>();
        users.add(new User("adi", "rahasia"));
        users.add(new User("beni", "rahasia"));
        users.add(new User("cindy", "rahasia"));

        notes = new ArrayList<>();
        notes.add(new Note("Note 1", new Date(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"));
        notes.add(new Note("Note 2", new Date(), "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"));
        notes.add(new Note("Note 3", new Date(), "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"));
        notes.add(new Note("Note 4", new Date(), "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Data.users = users;
    }

    public static List<Note> getNotes() {
        return notes;
    }

    public static void setNotes(List<Note> notes) {
        Data.notes = notes;
    }
}