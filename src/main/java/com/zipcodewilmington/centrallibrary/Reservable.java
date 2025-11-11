package com.zipcodewilmington.centrallibrary;

public interface Reservable {
    void reserve(LibraryMember libraryMember); // "Promisies" I can be reserved by a library member
    void cancelReserve(LibraryMember libraryMember); // "Promises" a library member can cancel their reservation on me
    boolean isReserved(); // asks if it is currently reserved
}


