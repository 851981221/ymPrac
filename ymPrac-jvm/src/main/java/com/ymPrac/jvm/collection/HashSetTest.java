package com.ymPrac.jvm.collection;

import org.assertj.core.util.Sets;

import java.util.HashSet;

/**
 * Created by Yan Meng on 2018/3/2.
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSet<A> set = Sets.newHashSet();

        set.add(new A("a"));
        set.add(new A("a"));

        System.out.println(set.size());
    }

    static class A {
        private String name;

        public A(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            int hash, i;
            for (hash = 0, i = 0; i < name.length(); ++i) {
                hash += name.charAt(i);
                hash += (hash << 10);
                hash ^= (hash >> 6);
            }
            hash += (hash << 3);
            hash ^= (hash >> 11);
            hash += (hash << 15);
            //   return (hash & M_MASK);
            return hash;

//            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

    }
}
