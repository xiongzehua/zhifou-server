package com.xiongzehua.freetalk.utils;

import com.xiongzehua.freetalk.entity.User;
import org.junit.Test;

import java.util.*;

public class CollectionUtilsTest {

    @Test
    public void tset1() {
        User person = new User();
        Optional<User> personOpt = Optional.ofNullable(person);
        personOpt.orElse(null);
        Optional.ofNullable(person);
    }

}
