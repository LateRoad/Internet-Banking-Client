package logic.security;

public class HashMessage {
    private static String key;
    private static final HashMessage instance = new HashMessage();
    private HashMessage() {
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        HashMessage.key = key;
    }

    public static HashMessage getInstance() {
        return instance;
    }

    public byte[] encode(String pText) {
        byte[] txt = pText.getBytes();
        byte[] pKey = key.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; ++i) {
            res[i] = (byte) (txt[i] ^ pKey[i % pKey.length]);
        }
        return res;
    }


    public String decode(byte[] pText) {
        byte[] res = new byte[pText.length];
        byte[] pKey = key.getBytes();

        for (int i = 0; i < pText.length; ++i) {
            res[i] = (byte) (pText[i] ^ pKey[i % pKey.length]);
        }
        return new String(res);
    }
}
