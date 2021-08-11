package com.wu;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

/**
 * @author wuc006
 * @date 2019/12/6 12:01
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
