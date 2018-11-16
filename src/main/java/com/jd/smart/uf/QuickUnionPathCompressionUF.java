/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.uf;

/**
 * <b>描述：连通性检测:压缩路径quick union算法，降低树的高度，减少find所需时间</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-07<br/>
 *
 */
@SuppressWarnings("all")
public class QuickUnionPathCompressionUF extends AbstractUF {


    //初始化触点：N个连通分量，相互都不连通
    public QuickUnionPathCompressionUF(int n) {
        super(n);
    }

    //找到触点p所在的连通分量，查找根节点同时压缩查找的路径：直接连接掉根
    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    //在p q建立连接
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;

        count--;

    }

}