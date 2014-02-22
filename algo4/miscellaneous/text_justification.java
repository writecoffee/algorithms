import java.util.ArrayList;

public class text_justification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();

        int i = 0;
        while (i < words.length) {
            int sumLength = 0;
            ArrayList<String> subStrings = new ArrayList<String>();
            sumLength += words[i].length();
            subStrings.add(words[i++]);

            while (i < words.length && sumLength + 1 + words[i].length() <= L) {
                sumLength += words[i].length() + 1;
                subStrings.add(words[i]);
                ++i;
            }

            if (i != words.length) {
                result.add(padStrings(subStrings, L - sumLength));
            } else {
                result.add(padLastLine(subStrings, L));
            }
        }

        return result;
    }

    private String padLastLine(ArrayList<String> subStrings, int L) {
        StringBuilder sb = new StringBuilder();

        sb.append(subStrings.get(0));
        for (int i = 1; i < subStrings.size(); i++) {
            sb.append(' ');
            sb.append(subStrings.get(i));
        }

        if (sb.length() < L) {
            for (int i = sb.length(); i < L; i++) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private String padStrings(ArrayList<String> subStrings, int spaceLeft) {
        assert subStrings.size() >= 1;

        StringBuilder sb = new StringBuilder();
        if (subStrings.size() == 1) {
            sb.append(subStrings.get(0));
            for (int i = 0; i < spaceLeft; i++) {
                sb.append(' ');
            }

            return sb.toString();
        }

        spaceLeft += subStrings.size() - 1;
        int eachPadding = spaceLeft / (subStrings.size() - 1);
        int extra = spaceLeft % (subStrings.size() - 1);

        sb.append(subStrings.get(0));
        for (int i = 1; i < subStrings.size(); i++) {
            int currentExtra = extra <= 0 ? 0 : 1;
            extra--;

            for (int j = 0; j < eachPadding + currentExtra; j++) {
                sb.append(' ');
            }

            sb.append(subStrings.get(i));
        }

        return sb.toString();
    }
}