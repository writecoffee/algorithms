package algo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class render_page_with_completable_future
{
    ExecutorService executor = Executors.newCachedThreadPool();

    public void renderImage(ImageData data) {

    }

    public void renderPage(CharSequence source)
    {
        List<ImageInfo> info = scanForImageInfo(source);
        info.forEach(imageInfo -> CompletableFuture.supplyAsync(ImageInfo::downloadImage)
                                                   .thenAccept(this::renderImage));

        renderText(source);

    }

    private void renderText(CharSequence source)
    {
        // TODO Auto-generated method stub
        
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
