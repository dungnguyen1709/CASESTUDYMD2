package case_study.crawl;


import case_study.product.Sneaker;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlData {
    public static String getCrawl(File file) {
        String crawl = null;

        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                StringBuilder builder = new StringBuilder();

                while ((crawl = reader.readLine()) != null) {
                    builder.append(crawl);
                }
                crawl = builder.toString();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crawl;
    }

    public static String getCrawl(URL url) {
        String crawl = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader((url.openStream())));
            StringBuilder builder = new StringBuilder();

            while ((crawl = reader.readLine()) != null) {
                builder.append(crawl);
            }
            crawl = builder.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crawl;
    }

    public static void setCrawl(String crawl, ArrayList<Sneaker> list) {
        crawl = crawl.replaceAll("\\\\R", "");
        String regex = "title.\"(.*?)\">(.*?)value\">(.*?)₫</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(crawl);
        int sneakerID = 0;
        int amount = (int) (Math.random() * 17);
        while (matcher.find()) {
            amount = (int) (Math.random() * 17);
            Sneaker sneaker = new Sneaker();
            sneakerID++;
            sneaker.setId(String.valueOf(sneakerID));
            sneaker.setName(matcher.group(1));
            sneaker.setPrice(Integer.parseInt(matcher.group(3).replaceAll("\\.","")));
            sneaker.setAmount(amount);
            list.add(sneaker);

        }

    }

    public static void setCrawl(String crawl) {
        crawl = crawl.replaceAll("\\\\R", "");
        System.out.println(crawl);
        String regex = "title.\"(.*?)\">(.*?)value\">(.*?)₫</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(crawl);
        int sneakerID = 0;
        int amount = (int) (Math.random() * 17);
        while (matcher.find()) {
            System.out.println(matcher.group(1));

        }

    }

    public static void main(String[] args) throws IOException {
       URL url = new URL("https://sneakerhead.vn/search?text=YEEZY");
      //  File file = new File("/home/tobi/Downloads/adidas Nam - Chạy - Giày _ adidas Official Shop.html");
        InputStream in;
       Reader reader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }
}