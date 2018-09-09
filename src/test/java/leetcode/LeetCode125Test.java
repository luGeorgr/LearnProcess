package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode125Test {


    @Test
    public void isPalindrome() {
        LeetCode125 leetCode125 = new LeetCode125();
        Assert.assertEquals(true, leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false,  leetCode125.isPalindrome("0P"));
    }
}