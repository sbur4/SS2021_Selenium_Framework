package dataProvider;

public enum ValidInput implements CharSequence {

    CORRECTMAIL("*****@gmail.com"),
    CORRECTPASS("***");

    ValidInput(String vi) {
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}




