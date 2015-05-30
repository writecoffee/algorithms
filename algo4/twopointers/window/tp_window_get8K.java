package window;

import java.util.NoSuchElementException;

/**
 * 有一个文件，每一行是一句话。 现在一个函数get8K的函数可以调用该函数返回8KB的数据，没调用一次返回8K的文件。
 * 现在要求写一个wrapper实现nextline函数。nextline函数可以调用已有的get8K，但是每次调用需要返回下一行的数据。 question:
 * 
 * 1) what's size of a line, how many k could it be. assume within 8k. 需要 一个 8k
 * output buffer, 和一个8k input buffer
 * 
 * 2) new line '\r'
 *
 * 
 */
public abstract class tp_window_get8K
{
    private StringBuilder input = new StringBuilder();
    private StringBuilder output = new StringBuilder();

    public String nextLine()
    {
        if (input.length() == 0) {
            throw new NoSuchElementException();
        }

        int i = 0;
        for (; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\r') {
                break;
            }
        }

        String result = input.substring(0, i + 1);
        input.delete(0, i + 1);
        return result;
    }

    public boolean hasNextLine()
    {
        if (input.length() > 0) {
            return true;
        }

        input = getNext8K();
        return input.length() > 0;
    }

    public abstract StringBuilder getNext8K();

}
