package quarkusrest.service;

import quarkusrest.dto.UserResponse;

import java.util.Comparator;

public class CustomComparator implements Comparator<UserResponse> {

    @Override
    public int compare(UserResponse o,UserResponse o2) {
        return o.getId().compareTo(o2.getId());
    }
}
