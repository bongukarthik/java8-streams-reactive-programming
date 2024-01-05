package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("******* Printing the integer Stream *******");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("******* int stream <5 *******");
        //StreamSources.intNumbersStream().filter(integer -> integer<5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("******* int stream >5 and 2nd and 3rd *******");
        StreamSources.intNumbersStream().filter(i->i>5).skip(1).limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("******* int stream >5 and print first else -1 *******");
        Integer ads = StreamSources.intNumbersStream().filter(i -> i > 5).findFirst().orElse(-1);
        //System.out.println(ads);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("******* user stream first names *******");
        StreamSources.userStream().map(User::getFirstName).
                forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("******* Print first names in userStream for users that have IDs from number stream  *******");
//        StreamSources.intNumbersStream().forEach(num -> {
//            StreamSources.userStream().forEach(user->{
//                if(user.getId()==num)
//                {
//                    System.out.println(user.getFirstName());
//                }
//
//            });
//        });
        StreamSources.intNumbersStream()
                .flatMap(i->StreamSources.userStream()
                        .filter(user -> i==user.getId()))
                .forEach(user->System.out.println(user.getFirstName()));

        StreamSources.userStream()
                .filter(user->StreamSources.intNumbersStream()
                        .anyMatch(i->i==user.getId()))
                .forEach(user->System.out.println(user.getFirstName()));

    }

}
