package leetcode;

public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        int begin1, begin2, v1, v2;
        begin1 = begin2 = 0;
        while (true) {
            int end1 = version1.indexOf('.', begin1);
            int end2 = version2.indexOf('.', begin2);
            if (end1 == -1 && end2 != -1) {
                v1 = Integer.parseInt(version1.substring(begin1));
                v2 = Integer.parseInt(version2.substring(begin2, end2));
                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
                do {
                    begin2 = end2 + 1;
                    end2 = version2.indexOf('.', begin2);
                } while (end2 != -1 && Integer.parseInt(version2.substring(begin2, end2)) == 0);

                if (end2 == -1) {
                    v2 = Integer.parseInt(version2.substring(begin2));
                } else {
                    v2 = Integer.parseInt(version2.substring(begin2, end2));
                }
                return Integer.compare(0, v2);
            } else if (end1 != -1 && end2 == -1) {
                v1 = Integer.parseInt(version1.substring(begin1, end1));
                v2 = Integer.parseInt(version2.substring(begin2));
                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
                do {
                    begin1 = end1 + 1;
                    end1 = version1.indexOf('.', begin1);
                } while (end1 != -1 && Integer.parseInt(version1.substring(begin1, end1)) == 0);

                if (end1 == -1) {
                    v1 = Integer.parseInt(version1.substring(begin1));
                } else {
                    v1 = Integer.parseInt(version1.substring(begin1, end1));
                }
                return Integer.compare(v1, 0);
            } else if (end1 != -1 && end2 != -1){
                v1 = Integer.parseInt(version1.substring(begin1, end1));
                v2 = Integer.parseInt(version2.substring(begin2, end2));
                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                } else {
                    begin1 = end1 + 1;
                    begin2 = end2 + 1;
                }
            } else {
                v1 = Integer.parseInt(version1.substring(begin1));
                v2 = Integer.parseInt(version2.substring(begin2));
                return Integer.compare(v1, v2);
            }
        }
    }
}
