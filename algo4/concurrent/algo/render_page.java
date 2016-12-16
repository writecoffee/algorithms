package algo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class render_page
{
    ExecutorService executor = Executors.newCachedThreadPool();

    public void renderImage(ImageData data) {

    }

    public void renderPage(CharSequence source)
    {
        List<ImageInfo> info = scanForImageInfo(source);
        Callable<List<ImageData>> task = 
                () -> info.stream()
                          .map(ImageInfo::downloadImage)
                          .collect(Collectors.toList());

        Future<List<ImageData>> images = executor.submit(task);

        try {
            final List<ImageData> imageData = images.get();
            imageData.forEach(this::renderImage);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            images.cancel(true);
        } catch (ExecutionException e) {
            // throw
        }
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
