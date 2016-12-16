import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class cph_crawler
{
    public static class HtmlHelper
    {
        public static List<String> parseUrls(String url)
        {
            return null;
        }
    }

    public static class CrawlerThread extends Thread
    {
        private static BlockingQueue<String> bq = new LinkedBlockingQueue<>();
        private static Map<String, Boolean> map = new HashMap<>();
        private static List<String> result = new ArrayList<>();

        public static void setFirstUrl(String url)
        {
            try {
                bq.put(url);
            } catch (InterruptedException ite) {

            }
        }

        public static List<String> getResults()
        {
            return result;
        }

        @Override
        public void run()
        {
            while (true) {
                String url = "";
                try {
                    url = bq.take();
                } catch (Exception e) {
                    break;
                }

                String domain = "";
                try {
                    URL netUrl = new URL(url);
                    domain = netUrl.getHost();
                } catch (MalformedURLException e) {

                }

                if (!map.containsKey(url) && domain.endsWith("wikipedia.org")) {
                    map.put(url, true);
                    result.add(url);
                    List<String> urls = HtmlHelper.parseUrls(url);
                    for (String u : urls) {
                        try {
                            bq.put(u);
                        } catch (InterruptedException ie) {

                        }
                    }
                }
            }
        }
    }

    public List<String> crawler(String url)
    {
        CrawlerThread.setFirstUrl(url);

        ExecutorService pool = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            pool.submit(new CrawlerThread());
        }

        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CrawlerThread.getResults();
    }
}
