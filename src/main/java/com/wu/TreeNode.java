package com.wu;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

/**
 * @author wuc006
 * @date 2019/12/6 12:01
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
