package leetcode;

import java.util.Arrays;

public class LeetCode2424 {
    public static class LUPrefix {
        int[] root;

        public LUPrefix(int n) {
            root = new int[n + 2];
            Arrays.fill(root, 0);
        }

        public void upload(int video) {
            root[video] = video;
            if (root[video - 1] != 0) {
                int iRoot = findRoot(video - 1);
                if (iRoot > video) {
                    root[video] = iRoot;
                } else if (video > iRoot) {
                    root[iRoot] = video;
                }
            }

            if (root[video + 1] != 0) {
                int iRoot = findRoot(video + 1);
                if (iRoot > video) {
                    root[video] = iRoot;
                } else if (video > iRoot) {
                    root[iRoot] = video;
                }
            }
        }

        public int longest() {
            return findRoot(1);
        }

        private int findRoot(int video) {
            if (root[video] == video) {
                return video;
            }
            root[video] = findRoot(root[video]);
            return root[video];
        }
    }
}


