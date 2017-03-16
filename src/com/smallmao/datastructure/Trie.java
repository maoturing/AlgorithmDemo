package com.smallmao.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/3/16 0016.
 */
public class Trie<T> {
    private static int R = 256;     //表示ascii的取值范围
    private Node root;
    private int n;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Trie() {

    }

    public T get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (T) x.val;
    }

    //查找元素
    public Node get(Node x, String key, int d) {
        //
        if (x == null) {
            return null;
        }
        //匹配到字符串key的最后一个字符时返回x
        if (d == key.length()) {
            return x;
        }
        //得到key的第d个字符串,并继续向下搜索
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    //添加元素
    public void put(String key, T val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, T val, int d) {
        //目标节点为空则创建节点
        if (x == null) {
            x = new Node();
        }

        //如果已经查询到了树的第d==length层,那么x.val为空则设置val,
        if (d == key.length()) {
            if (x.val == null) {
                n++;
                x.val = val;
                return x;
            }
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    //前缀匹配搜索

    public Iterator<String> keys() {
        return keysWithPrefix("");
    }

    public Iterator<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<>();
        Node x = get(root,prefix,0);
        collect(x, prefix, q);
        return (Iterator<String>) q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.add(pre);
            for (char c = 0; c < R; c++) {
                collect(x.next[c], pre + c, q);
            }
        }
    }
}
