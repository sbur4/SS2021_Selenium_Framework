package dataProvider;

public enum InvalidInput {

    FIRSTWRONGMAIL("serhiiburchgmailcom"),
    SECONDWRONGMAIL("serhiiburchgmail.com"),
    THIRDWRONGMAIL("serhiiburch@gmailcom"),
    FOURTHWRONGMAIL("@serhiiburchgmail.com"),
    FIFTHWRONGMAIL("sssssssssseeeeeeeeerrrrrrrrrhhhhhhhhhiiiiiiiiiibbbbbbbbbburch@gmail.com"),
    SIXTHWRONGMAIL("serhiiburch@gmail.c"),
    SEVENTHWRONGMAIL("serhiiburch@gmail.commmmmmmmmm"),
    FIRSTINCORRECTPASS("abcdefg!$.");;

    InvalidInput(String ii) {
    }
}




