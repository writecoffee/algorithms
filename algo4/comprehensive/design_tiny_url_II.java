import java.util.HashMap;

public class design_tiny_url_II
{
    public static class TinyUrl2
    {
        private static final int LENGTH = 6;
        private HashMap<String, String> s2lStore = new HashMap<>();
        private HashMap<String, String> l2sStore = new HashMap<>();

        /**
         * Custom shortened id can be any ascii-url-safe character.
         */
        private HashMap<String, String> s2lCustomStore = new HashMap<>();
        private HashMap<String, String> l2sCustomStore = new HashMap<>();

        private final String TINY_PREFIX = "http://tiny.url/";
        private static long generator = 0;

        private String toShortKey(long n)
        {
            StringBuffer shortKey = new StringBuffer();
            char[] c = new char[62];
            c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

            for (int i = 0; i < LENGTH; i++) {
                shortKey.append(c[(int) (n % 62)]);
                n = n / 62L;
            }

            return shortKey.reverse().toString();
        }

        private boolean isNormalKey(String short_key)
        {
            if (short_key.length() != 6) {
                return false;
            }

            for (int i = 0; i < 6; i++) {
                char c = short_key.charAt(i);

                if (c >= '0' && c <= '9') {
                    continue;
                }

                if (c >= 'a' && c <= 'z') {
                    continue;
                }

                if (c >= 'A' && c <= 'Z') {
                    continue;
                }

                return false;
            }

            return true;
        }

        /**
         * @param longUrl
         *            a long url
         * @param a
         *            short key
         * @return a short url starts with http://tiny.url/
         */
        String createCustom(String longUrl, String shortKey)
        {
            String shortUrl = TINY_PREFIX + shortKey;

            if (isNormalKey(shortKey)) {
                if (s2lStore.containsKey(shortKey) && !s2lStore.get(shortKey).equals(longUrl)) {
                    return "error";
                }

                if (l2sStore.containsKey(longUrl) && !l2sStore.get(longUrl).equals(shortKey)) {
                    return "error";
                }

                if (s2lStore.containsKey(shortKey) || l2sStore.containsKey(longUrl)) {
                    return shortUrl;
                }
            }

            if (s2lCustomStore.containsKey(shortKey) && !s2lCustomStore.get(shortKey).equals(longUrl)) {
                return "error";
            }

            if (l2sCustomStore.containsKey(longUrl) && !l2sCustomStore.get(longUrl).equals(shortKey)) {
                return "error";
            }

            s2lCustomStore.put(shortKey, longUrl);
            l2sCustomStore.put(longUrl, shortKey);
            return shortUrl;
        }

        /**
         * @param longUrl
         *            a long url
         * @return a short url starts with http://tiny.url/
         */
        public String longToShort(String longUrl)
        {
            if (l2sCustomStore.containsKey(longUrl)) {
                return TINY_PREFIX + l2sCustomStore.get(longUrl);
            }

            if (l2sStore.containsKey(longUrl)) {
                return TINY_PREFIX + l2sStore.get(longUrl);
            }

            String shortKey = toShortKey(generator);
            generator++;
            s2lStore.put(shortKey, longUrl);
            l2sStore.put(longUrl, shortKey);
            return TINY_PREFIX + shortKey;
        }

        /**
         * @param shortUrl
         *            a short url starts with http://tiny.url/
         * @return a long url
         */
        public String shortToLong(String shortUrl)
        {
            String shortKey = shortUrl.substring(TINY_PREFIX.length());

            if (s2lCustomStore.containsKey(shortKey)) {
                return s2lCustomStore.get(shortKey);
            }

            return s2lStore.get(shortKey);
        }
    }
}
