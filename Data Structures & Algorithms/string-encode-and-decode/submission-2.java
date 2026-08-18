class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs) {

            sb.append(str.length())
              .append('#')
              .append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while(i < s.length()) {

            int j = i;

            // Find delimiter #
            while(s.charAt(j) != '#') {
                j++;
            }

            // Length of string
            int length = Integer.parseInt(s.substring(i, j));

            // Actual string starts after #
            j++;

            String str = s.substring(j, j + length);

            result.add(str);

            // Move to next encoded string
            i = j + length;
        }

        return result;
    }
}